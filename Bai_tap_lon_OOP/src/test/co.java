package test;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.stream.Collectors;

import Input.Data;
import Input.DataOneDay;
import Input.STOCK;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class co implements Initializable{
	@FXML
	private LineChart<String, Number> LineChart;
	@FXML
	private CategoryAxis xAxis;
	@FXML
	private NumberAxis yAxis;
	@Override
	public void initialize(URL location, ResourceBundle resources){
		ArrayList<DataOneDay> data = Data.getDataVN30().get(STOCK.VNINDEX).getData();
		Collections.reverse(data);
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Function<DataOneDay, String> mapper = new Function<DataOneDay, String>() {
			
			@Override
			public String apply(DataOneDay t) {
				return f.format(t.getDate());
			}
		};
		
		XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
		
//		xAxis.setAutoRanging(false); 
//		ArrayList<String> arr = data.stream().map(mapper).collect(Collectors.toCollection(ArrayList::new)); 
//		String [] categories = new String[arr.size()];
//		categories = arr.toArray(categories);
//		xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(categories))); 
//		xAxis.invalidateRange(Arrays.asList(categories)); 
		
	    Comparator<DataOneDay> comparator = new Comparator<DataOneDay>() {
			
			@Override
			public int compare(DataOneDay o1, DataOneDay o2) {
				return o1.getGiaDongCua() > o2.getGiaDongCua() ? 1 : -1;
			}
		};
		
		int maxPrice = getPrice(data.stream().max(comparator).get().getGiaDongCua(), true);
		int minPrice = getPrice(data.stream().min(comparator).get().getGiaDongCua(), false);

	    yAxis.setAutoRanging(false);
	    yAxis.setLowerBound(minPrice);
	    yAxis.setUpperBound(maxPrice);
	//    yAxis.setTickUnit(getTickUnit(maxPrice - minPrice));
	    
	    Integer i = 0;
	    for (DataOneDay item : data) {
	    	if(i < 360) {
	    		dataSeries.getData().add(new XYChart.Data<>((i++).toString(), item.getGiaMoCua()));
		    	dataSeries.getData().add(new XYChart.Data<>((i++).toString(), item.getGiaMax()));
		    	dataSeries.getData().add(new XYChart.Data<>((i++).toString(), item.getGiaMin()));
		    	dataSeries.getData().add(new XYChart.Data<>((i++).toString(), item.getGiaDongCua()));
	    	}
	    	
		}
	    dataSeries.setName("Biểu đồ " + STOCK.VNINDEX.name());
	    
	    LineChart.getData().add(dataSeries);

		
	}
    private int getPrice(Double price, boolean bool) {
    	int i = (int)Math.ceil(price/5);
    	int Price  = 0;
    	if(bool) {
    		Price = i * 5;
    		if((double)Price <= (price + 2.5d)) {
    			Price += 5;
    		}
    	}else {
    		Price = (i-1) * 5;
    		if((double)Price >= (price - 2.5d)) {
    			Price -= 5;
    		}
    	}
    	return Price;
    }
    
    private int getTickUnit(int difference) {
    	int tickUnit = (int)(difference/10);
    	return tickUnit > 10 ? 20 : (tickUnit < 5 ? 5 :10);
    }
}
