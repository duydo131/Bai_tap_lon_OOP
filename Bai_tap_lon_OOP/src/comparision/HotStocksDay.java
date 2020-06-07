package comparision;

import java.util.Date;

import Input.*;

public abstract class HotStocksDay extends HotStocks {
	
	Date date;
	
	public HotStocksDay(Date date) {
		super(date);
		this.date = date;
	}

	public String getSentence(String className) {
		ReadFile.loadData();
		
		if (InputData.isWeekend(date)) {
			return "Cuối tuần không có giao dịch. ";
		}
		
		STOCK stock[] = new STOCK[3];
		long volume[] = new long[3];

		Date day = this.date;
		
		if (className == "VN30") {
			for (int i = 1; i <= 3; i++) {
				stock[i-1] = InputData.getStockByNumericalVN30(day, i);
				volume[i-1] = InputData.getTodayVN30(day).get(stock[i-1]).getKL();
			}
		}
		else if (className == "HNX30") {
			for (int i = 1; i <= 3; i++) {
				stock[i-1] = InputData.getStockByNumericalHNX30(day, i);
				volume[i-1] = InputData.getTodayHNX30(day).get(stock[i-1]).getKL();
			}
		}
		String clause = HotStocks.arrayToString(stock, volume, 3);
		return "Top 3 cổ phiếu HOT ngày " + formats.format(day) + " là: " + clause;
	}
}
