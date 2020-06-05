package Sentence;

import java.util.Date;

import Input.*;

public class DaysTitleOneStockCode extends DaysTitle {
	private STOCK stock;
	public DaysTitleOneStockCode(STOCK stock, Date date1, Date date2) {
		super(date1,date2);
		this.stock = stock;
	}
	
	public int increaseDayCounter() {
		int increaseCounter=0;
		for (DataOneDay data : InputData.getInfo(date1, date2).get(stock)) {
			if (InputData.getDifference(data) > 0) {
				increaseCounter++;
			}
		}
		return increaseCounter;
	}
	
	public String createStockCodeClause() {
		
		ReadFile.loadData();
		
		int icc = this.increaseDayCounter();
		int dcc = days - icc;
		String name = this.stock.name();
		String status = this.status;
		if (icc >= ((int) 3*days/4)) {
			status = "co chieu huong kha quan";
		}
		else if (icc <= ((int) days/4)) {
			status = "chim dam trong sac do";
		}
		else {
			status = "khong co dien bien nao bat ngo";
		}
		return "Thi truong chung khoan ngay " + formats.format(date1) + " den ngay " + formats.format(date2) + ": " + 
		name + " " + status + " voi " + icc + " phien tang diem va " + dcc + " phien giam diem";
	}
}
