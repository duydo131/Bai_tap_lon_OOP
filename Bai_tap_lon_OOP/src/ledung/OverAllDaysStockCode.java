package Sentence;

import java.util.Date;

import Input.*;

public class OverAllDaysStockCode extends OverAllDays {
	
	private STOCK stock;
	
	public OverAllDaysStockCode(STOCK stock, Date date1, Date date2) {
		super(date1, date2);
		this.stock = stock;
	}
	
	public int increaseDayCounter() {
		int i = 0;
		for (DataOneDay data : InputData.getInfo(date1, date2).get(stock)) {
			if (data.getGiaDongCua()-data.getGiaMoCua()>0) {
				i++;
			}
		}
		return i;
	}
	
	public int decreaseDayCounter() {
		int i = 0;
		for (DataOneDay data : InputData.getInfo(date1, date2).get(stock)) {
			if (data.getGiaDongCua()-data.getGiaMoCua()<0) {
				i++;
			}
		}
		return i;
	}
	
	public long totalVolume() {
		int volume = 0;
		for (DataOneDay data: InputData.getInfo(date1, date2).get(stock)) {
			volume += data.getKL();
		}
		return volume;
	}
	
	public String setAdjective() {
		String adj = "";
		double diff = InputData.getToday(date2).get(stock).getGiaDongCua() - InputData.getToday(date1).get(stock).getGiaDongCua();
		double pivot = 0.03*InputData.getToday(date1).get(stock).getGiaDongCua();
		if (diff > 0) {
			if (diff >= pivot) {
				adj = InputData.getRandom(AdjectiveStatus.getFastIncrease());
			}
			else {
				adj = InputData.getRandom(AdjectiveStatus.getSlowIncrease());
			}
		}
		else if (diff < 0) {
			if (Math.abs(diff) > pivot) {
				adj = InputData.getRandom(AdjectiveStatus.getFastDecrease());
			}
			else {
				adj = InputData.getRandom(AdjectiveStatus.getSlowDecrease());
			}
		}
		return adj;
	}
	
	public void createSentence() {
		
		ReadFile.loadData();
		
		String name = stock.name();
		String adj = this.setAdjective();
		int incCnt = this.increaseDayCounter();
		int decCnt = this.decreaseDayCounter();
		long volume = this.totalVolume();
		double closedValue = InputData.getToday(date2).get(stock).getGiaDongCua()*1000;
		
		System.out.println(name + " trải qua " + incCnt + " phiên tăng giá và " + decCnt + " phiên giảm giá," + adj + 
							"lên ngưỡng " + closedValue + " đồng/cp, tổng khối lượng giao dịch lên đến " + volume + " đơn vị."); 
	}
}
