package gui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

import Input.Tool;
import Input.InputData;
import Input.STOCK;

public class DataLoad {

	private Date date = null;
	private STOCK stock = null;
	private String text = null;
	private String exchange = null;
	private boolean Chart;

	public DataLoad(Date date, String text, String stockCode) {
		this.date = date;
		setInfo(text, stockCode);
	}

	public void setChart(boolean chart) {
		Chart = chart;
	}

	public boolean getChart() {
		return Chart;
	}
	
	private void setInfo(String text, String st) {
		if(testName(text)) {
			this.stock = STOCK.valueOf(text);
		}else if(text.equals("VNINDEX")) {
			this.exchange = "VNINDEX";
		}else if(text.equals("HNXINDEX")) {
			this.exchange = "HNXINDEX";
		}else if (!(st.equals("") || st.equals("VNINDEX") || st.equals("HASTC"))){
			this.stock = STOCK.valueOf(st);
			if(!(text.equals(""))) {
				this.text = text;
			}
		}else if (st.equals("VNINDEX")){
			this.exchange = "VNINDEX";
		}else if (st.equals("HASTC")){
			this.exchange = st;
		}else if (st.equals("")){
			if(!(text.equals(""))) {
				this.text = text;
			}
		}
	}
	
	public STOCK getStock() {
		return this.stock;
	}
	
	public String get() {
		Demo demo = new Demo(date, stock);
		StringBuffer string = new StringBuffer();
		ArrayList<String> listSentence = new ArrayList<>();
		int i = getDay();
		if (this.stock != null && this.text == null) {
			listSentence.addAll(getOneStock(demo, i, this.text));
			setChart(true);
		}else if (this.stock != null && this.text != null) {
			listSentence.addAll(getOneStock(demo, i, this.text));
			setChart(true);
		}else {
			if(this.exchange != null) {
				listSentence.addAll(getExchange(demo, i));
			}else if(this.text != null) {
				listSentence.addAll(Demo.getListString().stream()
												.filter(str -> str.contains(text))
												.collect(Collectors.toCollection(ArrayList::new)));
			}
			else if(this.stock == null && this.text == null) {
				listSentence.addAll(Demo.getListString());
			}
			else {
				listSentence.add("Hôm nay nghỉ lễ không giao dịch.");
			}
		}
		
		listSentence.stream().distinct().forEach(str -> string.append(str + "\n"));
		String textArea = string.toString();
		return textArea.equals("") ? "Không có dữ liệu" : textArea;
	}
	
	private ArrayList<String> getOneStock(Demo demo, int i, String text) {
		ArrayList<String> listSentence = new ArrayList<>();
		listSentence.addAll(demo.getSentence("title","oneStock"));
		if (i == 1 || i == 7) {
			listSentence.addAll(demo.getSentence("oneStock", "week"));
		} else {
			listSentence.addAll(demo.getSentence("oneStock", "day"));
		}
		if (Tool.testMonth(date)) {
			listSentence.addAll(demo.getSentence("oneStock", "month"));
		}
		listSentence.addAll(demo.getSentence("comment", "oneStock"));
		
		if(text != null) {
			return listSentence.stream().filter(str -> str.contains(text)).collect(Collectors.toCollection(ArrayList::new));
		}
		return listSentence;
	}
	
	private LinkedList<String> getExchange(Demo demo, int i) {
		LinkedList<String> listSentence = new LinkedList<>();
		
		listSentence.addAll(demo.getSentence("title", this.exchange));
		
		if (i == 1 || i == 7) {
			// ngày phải là cuối tuần
			listSentence.addAll(demo.getSentence("week", this.exchange));
		}else if (InputData.testDay(date)) {
			listSentence.addAll(demo.getSentence("changing", "day", this.exchange));
			
			listSentence.addAll(demo.getSentence("hot stock", "day", this.exchange));

			listSentence.addAll(demo.getSentence("comparision", "day", this.exchange));

			listSentence.addAll(demo.getSentence("comment", "day", this.exchange));

			listSentence.addAll(demo.getSentence("prediction", "day", this.exchange));
			
		}
		
		return listSentence;
	}
	

	private int getDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	private boolean testName(String str) {
		Set<STOCK> dataVN30 = InputData.stockVN30();
		dataVN30.remove(STOCK.VNINDEX);
		for (STOCK stock : dataVN30) {
			if (str.equals(stock.name())) {
				return true;
			}
		}
		Set<STOCK> dataHNX30 = InputData.stockHNX30();
		dataVN30.remove(STOCK.HASTC);
		for (STOCK stock : dataHNX30) {
			if (str.equals(stock.name())) {
				return true;
			}
		}
		return false;
	}
}
