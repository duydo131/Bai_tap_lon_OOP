package gui;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Input.InputData;
import Input.STOCK;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller implements Initializable{
	private SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
	
	@FXML
	private ComboBox<STOCK> stock;
	
	@FXML
	private ComboBox<String> tag;
	
	@FXML
	private Label codeStock;
	
	@FXML
	private LineChart<String, Number> lineChart1;
	
	@FXML
	private CategoryAxis xAxis1;
	
	@FXML
	private NumberAxis yAxis1;
	
	@FXML
	private LineChart<String, Number> lineChart2;
	
	@FXML
	private CategoryAxis xAxis2;
	
	@FXML
	private NumberAxis yAxis2;
	
	@FXML
	private LineChart<String, Number> lineChart3;
	
	@FXML
	private CategoryAxis xAxis3;
	
	@FXML
	private NumberAxis yAxis3;
	
	@FXML
	private ComboBox<String> day;
	
	@FXML
	private ComboBox<String> month;
	
	@FXML
	private ComboBox<String> year;
	
	@FXML
	private TextArea textArea;
	
	@FXML
	private TextField textField;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Date date;
		try {
			date = formats.parse("28/02/2020");
			lineChart1.getData()
			.add(CreateLineChart.create(xAxis1, yAxis1, 
					InputData.getDataVN30().get(STOCK.VNINDEX).getData(), STOCK.VNINDEX, date));

			lineChart2.getData()
			.add(CreateLineChart.create(xAxis2, yAxis2, 
					InputData.getDataHNX30().get(STOCK.HASTC).getData(), STOCK.HASTC, date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		lineChart3.setVisible(false);
		lineChart1.setLegendVisible(false);
		lineChart2.setLegendVisible(false);
		lineChart3.setLegendVisible(false);
		
		day.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
								"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", 
								"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
		day.getSelectionModel().select("28");
		
		month.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
		month.getSelectionModel().select("02");
		
		year.getItems().addAll("2019", "2020");
		year.getSelectionModel().select("2020");
		
		Set<STOCK> listStock = new HashSet<>();
		stock.getItems().add(STOCK.VNINDEX);
		stock.getItems().add(STOCK.HASTC);
		Set<STOCK> listStockVN30 = InputData.stockVN30();
		listStockVN30.remove(STOCK.VNINDEX);
		listStock.addAll(listStockVN30);
		Set<STOCK> listStockHNX30 = InputData.stockHNX30();
		listStockVN30.remove(STOCK.HASTC);
		listStock.addAll(listStockHNX30);
		stock.getItems().addAll(listStock);
		stock.getSelectionModel().select(STOCK.VNINDEX);
	}
	
	public void search() {
		lineChart3.setVisible(false);
		lineChart3.getData().clear();
		lineChart1.getData().clear();
		lineChart2.getData().clear();
		codeStock.setText("");
		
		String text = createText(textField.getText().toUpperCase());
		String ngay = day.getValue();
		String thang = month.getValue();
		String nam = year.getValue();
		String stringDate = ngay + "/" + thang + "/" + nam;
        
		DataLoad dataLoad;
        Date date;
        textArea.clear();
		try {
			date = formats.parse(stringDate);
			if(TestDay.testDay(date)) {
	             dataLoad = new DataLoad(date, text);
	             textArea.appendText(dataLoad.get());
	             if(dataLoad.getChart()) {
	            	 STOCK stock = STOCK.valueOf(text);
	            	 lineChart3.getData()
						.add(CreateLineChart.create(xAxis3, yAxis3, 
								InputData.getDatashare().get(stock).getData(), stock , date));
	            	 codeStock.setText(stock.name());
		             lineChart3.setVisible(true);
	             }
	     		 lineChart1.getData()
	     			.add(CreateLineChart.create(xAxis1, yAxis1, 
						InputData.getDataVN30().get(STOCK.VNINDEX).getData(), STOCK.VNINDEX, date));
	
	     		 lineChart2.getData()
	     			.add(CreateLineChart.create(xAxis2, yAxis2, 
						InputData.getDataHNX30().get(STOCK.HASTC).getData(), STOCK.HASTC, date));
	        }else {
	        	 textArea.appendText("Không có dữ liệu ngày " + formats.format(date));
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String createText(String str) {
		if(str == "") {
			return " ";
		}
		String regex = "\\s+";
		Pattern pattern = Pattern.compile(regex);
		Matcher macher = pattern.matcher(str);
		String s = macher.replaceAll(" ");
		return s.trim();
	}
}
