package Sentence;

import java.text.SimpleDateFormat;
import java.util.Date;

import Input.*;

public class HotStocksDay extends HotStocks {
	
	private Date date;
	
	public HotStocksDay(int number, String name, Date date) {
		super(number,name);
		this.date = date;
	}
	
	public String createClause() {
		ReadFile.loadData();
		
		STOCK stock[] = this.stock;
		String name = this.name;
		Date day = this.date;
		int num = this.numberStock;
		long volume[] = new long[num];
		
		if (name == "VN30") {
			for (int i = 1; i <= num; i++) {
				stock[i-1] = InputData.getStockByNumericalVN30(day, i);
				volume[i-1] = InputData.getTodayVN30(day).get(stock[i-1]).getKL();
			}
		}
		else if (name == "HNX30") {
			for (int i = 1; i <= num; i++) {
				stock[i-1] = InputData.getStockByNumericalHNX30(day, i);
				volume[i-1] = InputData.getTodayHNX30(day).get(stock[i-1]).getKL();
			}
		}
		String clause = HotStocks.arrayToString(stock, volume, num);
		if (num == 1) {
			return "Cổ phiếu HOT nhất ngày " + formats.format(day) + " là: " + clause;
		}
		else {
		return "Top " + num + " cổ phiếu HOT ngày " + formats.format(day) + " là: " + clause;
		}
	}
}
