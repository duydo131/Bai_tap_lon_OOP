package gui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;


import Input.Tool;
import Input.InputData;
import Input.STOCK;
import duy.Cau1HNX30;
import duy.Cau1VN30;
import duy.Cau2HNX30;
import duy.Cau2VN30;
import duy.Cau3GiamHNX30;
import duy.Cau3GiamVN30;
import duy.Cau3TangHNX30;
import duy.Cau3TangVN30;
import duy.Cau4HNX30;
import duy.Cau4VN30;
import duy.OneStock1;
import duy.OneStock2Month;
import duy.OneStock2Week;
import duy.DayHNX30;
import duy.DayVN30;
import duy.WeekHNX30;
import duy.WeekVN30;

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
	
	private void setStock(String str, String st) {
		if(testName(str)) {
			this.stock = STOCK.valueOf(str);
		}else if (!(st.equals("") || st.equals("VNINDEX") || st.equals("HASTC"))){
			this.stock = STOCK.valueOf(st);
		}else if (st.equals("")){
			this.exchange = null;
		}else if (st.equals("VNINDEX")){
			this.exchange = st;
			System.out.println("vn");
		}else if (st.equals("HASTC")){
			this.exchange = st;
			System.out.println("hn");
		}else {
			this.stock = null;
		}
	}
	
	public STOCK getStock() {
		return this.stock;
	}

	public String get() {
		int i = getDay();
		StringBuffer string = new StringBuffer();
		if (this.stock != null) {
			if (i == 1 || i == 7) {
				string.append((new OneStock2Week(stock, date)).get());
				string.append("\n");
			} else {
				string.append((new OneStock1(stock, date)).get());
				string.append("\n");
			}
			if (Tool.testMonth(date)) {
				string.append((new OneStock2Month(stock, date)).get());
				string.append("\n");
			}
			setChart(true);
		} else {
			if (i == 1 || i == 7) {
				// ngày phải là cuối tuần
				string.append((new WeekVN30(date)).get());
				string.append("\n");
				string.append((new WeekHNX30(date)).get());
				string.append("\n");
			} else {
				if (InputData.testDay(date)) {
					string.append((new DayVN30(date)).get());
					string.append("\n");
					string.append((new DayHNX30(date)).get());
					string.append("\n");

					string.append((new Cau1VN30(date)).get());
					string.append("\n");
					string.append((new Cau1HNX30(date)).get());
					string.append("\n");
					string.append((new Cau2VN30(date)).get());
					string.append("\n");
					string.append((new Cau2HNX30(date)).get());
					string.append("\n");
					
					string.append((new Cau3TangVN30(date)).get());
					string.append("\n");
					string.append((new Cau3TangHNX30(date)).get());
					string.append("\n");
					string.append((new Cau3GiamVN30(date)).get());
					string.append("\n");
					string.append((new Cau3GiamHNX30(date)).get());
					string.append("\n");

					string.append("\n");
					string.append((new Cau4VN30(date)).get());
					string.append("\n");
					string.append((new Cau4HNX30(date)).get());
				} else {
					string.append("Hôm nay nghỉ lễ không giao dịch.");
				}
			}
		}
		return string.toString();
	}
	
	public String get1() {
		Demo demo = new Demo(date, stock);
		StringBuffer string = new StringBuffer();
		int i = getDay();
		if (this.stock != null) {
			string.append(demo.getSentence("title","one stock"));
			string.append("\n");
			if (i == 1 || i == 7) {
				string.append(demo.getSentence("one stock", "week"));
//				string.append((new OneStock2Week(stock, date)).get());
				string.append("\n");
			} else {
				string.append(demo.getSentence("one stock", "day"));
				//string.append((new OneStock1(stock, date)).get());
				string.append("\n");
			}
			if (Tool.testMonth(date)) {
				string.append(demo.getSentence("one stock", "month"));
			//	string.append((new OneStock2Month(stock, date)).get());
				string.append("\n");
			}
			setChart(true);
		}else {
			string.append(demo.getSentence("title","chung"));
			string.append("\n");
			
			System.out.println(this.exchange);
			
			if (i == 1 || i == 7) {
				// ngày phải là cuối tuần
				string.append(demo.getSentence("week","chung", this.exchange));
				string.append("\n");
//				string.append((new WeekVN30(date)).get());
//				string.append("\n");
//				string.append((new WeekHNX30(date)).get());
//				string.append("\n");
			}if (InputData.testDay(date)) {
				string.append(demo.getSentence("biến động","chung", this.exchange));
				string.append("\n");
				
				string.append(demo.getSentence("hot stock","chung", this.exchange));
				string.append("\n");

				string.append(demo.getSentence("so sánh","chung", this.exchange));
				string.append("\n");

				string.append(demo.getSentence("nhận định","chung", this.exchange));
				string.append("\n");

				string.append(demo.getSentence("nhận định","chung", this.exchange));
				string.append("\n");
				
				
//				string.append((new DayVN30(date)).get());
//				string.append("\n");
//				string.append((new DayHNX30(date)).get());
//				string.append("\n");
//
//				string.append((new Cau1VN30(date)).get());
//				string.append("\n");
//				string.append((new Cau1HNX30(date)).get());
//				string.append("\n");
//				string.append((new Cau2VN30(date)).get());
//				string.append("\n");
//				string.append((new Cau2HNX30(date)).get());
//				string.append("\n");
//				
//				string.append((new Cau3TangVN30(date)).get());
//				string.append("\n");
//				string.append((new Cau3TangHNX30(date)).get());
//				string.append("\n");
//				string.append((new Cau3GiamVN30(date)).get());
//				string.append("\n");
//				string.append((new Cau3GiamHNX30(date)).get());
//				string.append("\n");
//
//				string.append("\n");
//				string.append((new Cau4VN30(date)).get());
//				string.append("\n");
//				string.append((new Cau4HNX30(date)).get());
			} else {
				string.append("Hôm nay nghỉ lễ không giao dịch.");
			}
		}
		
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
