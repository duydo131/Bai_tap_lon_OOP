package gui;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

import Input.Tool;
import Input.InputData;
import Input.STOCK;

public class DataLoad {

	private Date date;
	private STOCK stock;
	private String tag;
	private String stockCode;
	private String exchange;
	private boolean Chart;

	public DataLoad(Date date, String text, String stockCode) {
		this.date = date;
		this.tag = text;
		this.stockCode = stockCode;
		setStock(text, stockCode);
	}

	public void setChart(boolean chart) {
		Chart = chart;
	}

	public boolean getChart() {
		return Chart;
	}
	
	private void setStock(String text, String st) {
		if(testName(text)) {
			this.stock = STOCK.valueOf(text);
		}else if (!(st.equals("") || st.equals("VNINDEX") || st.equals("HASTC"))){
			this.stock = STOCK.valueOf(st);
		}else if (st.equals("")){
			this.exchange = null;
		}else if (st.equals("VNINDEX")){
			this.exchange = st;
		}else if (st.equals("HASTC")){
			this.exchange = st;
		}else {
			this.stock = null;
		}
	}
	
	public STOCK getStock() {
		return this.stock;
	}
	
	public String get() {
		Demo demo = new Demo(date, stock);
		StringBuffer string = new StringBuffer();
		LinkedList<String> listSentence = new LinkedList<>();
		int i = getDay();
		if (this.stock != null) {
			listSentence.add(demo.getSentence("title","oneStock"));
			if (i == 1 || i == 7) {
				listSentence.add(demo.getSentence("oneStock", "week"));
			} else {
				listSentence.add(demo.getSentence("oneStock", "day"));
			}
			if (Tool.testMonth(date)) {
				listSentence.add(demo.getSentence("oneStock", "month"));
			}
			listSentence.add(demo.getSentence("comment", "oneStock"));
			setChart(true);
		}else {
			listSentence.add(demo.getSentence("title"));
			
			if (i == 1 || i == 7) {
				// ngày phải là cuối tuần
				listSentence.add(demo.getSentence("week", this.exchange));
			}if (InputData.testDay(date)) {
				listSentence.add(demo.getSentence("changing", this.exchange));
				
				listSentence.add(demo.getSentence("hot stock", this.exchange));

				listSentence.add(demo.getSentence("comparision", this.exchange));

				listSentence.add(demo.getSentence("comment", this.exchange));

				listSentence.add(demo.getSentence("prediction", this.exchange));
				
			} else {
				listSentence.add("Hôm nay nghỉ lễ không giao dịch.");
			}
		}
		
		listSentence.stream().distinct().collect(Collectors.toList()).forEach(str -> string.append(str + "\n"));
		return string.toString();
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
