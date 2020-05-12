package gui;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import Input.InputData;
import Input.STOCK;
import duy.Cau3GiamHNX30;
import duy.Cau3GiamVN30;
import duy.Cau3TangHNX30;
import duy.Cau3TangVN30;
import duy.Cau4HNX30;
import duy.Cau4VN30;
import duy.OneStock1;
import duy.OneStock2Week;
import duy.Phien;
import duy.VolumeHNX30;
import duy.VolumeVN30;
import duy.Week;

public class DataLoad {
	
	private Date date;
	private String text;
	private boolean Chart;
	
	public DataLoad(Date date, String text) {
		this.date = date;
		this.text = text;
	}
	
	public void setChart(boolean chart) {
		Chart = chart;
	}
	public boolean getChart() {
		return Chart;
	}
	
	
	private int getDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	private boolean testName(String str) {
		Set<STOCK> dataVN30 =  InputData.stockVN30();
		dataVN30.remove(STOCK.VNINDEX);
		for (STOCK stock : dataVN30) {
			if(str.equals(stock.name())) {
				return true;
			}
		}
		Set<STOCK> dataHNX30 =  InputData.stockHNX30();
		dataVN30.remove(STOCK.HASTC);
		for (STOCK stock : dataHNX30) {
			if(str.equals(stock.name())) {
				return true;
			}
		}
		return false;
	}
	
	public String get() {
		int i = getDay();
		StringBuffer string = new StringBuffer();
		if(testName(text)) {
			if(i == 1 || i == 7) {
				string.append((new OneStock2Week(STOCK.valueOf(text), date)).get());
			}else {
				string.append((new OneStock1(STOCK.valueOf(text), date)).get());
			}
			setChart(true);
		}else {
			if(i == 1 || i == 7) {
				// ngày phải là cuối tuần
				string.append((new Week()).setInfo(date, STOCK.VNINDEX).get());
				string.append("\n");
				string.append((new Week()).setInfo(date, STOCK.HASTC).get());
				string.append("\n");
			}
			else {
				if(InputData.testDay(date)) {
					string.append((new Phien()).setInfo(date, STOCK.VNINDEX).get());
					string.append("\n");
					string.append((new Phien()).setInfo(date, STOCK.HASTC).get());
					string.append("\n");
					
					string.append((new VolumeVN30(date)).get());
					string.append("\n");
					string.append((new VolumeHNX30(date)).get());
					
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
				}else {
					string.append("Hôm nay nghỉ lễ không giao dịch.");
				}
			}
		}
		return string.toString();
	}
}
