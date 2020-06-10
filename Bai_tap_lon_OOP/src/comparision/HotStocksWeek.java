package comparision;

import java.util.Date;
import java.util.Set;

import input.*;

public abstract class HotStocksWeek extends HotStocks{
	
	private Date date1;
	private Date date2;
	
	public HotStocksWeek(Date date) {
		super(date);
		this.date1 = Sentence.getWeek(date)[0];
		this.date2 = Sentence.getWeek(date)[1];
	}
	
	public String createClause(String className) {

		Set<STOCK> stocks = null;
		STOCK[] stock = new STOCK[3];
		STOCK[] temp = null;
		long volume[] = new long[3];
		Date firstDate = Sentence.firstWorkingDayOfWeek(date1);
		Date lastDate = Sentence.firstWorkingDayOfWeek(date2);
		int index = 0;
		
		if (className == "VN30") {
			stocks = InputData.stockVN30();
			temp = new STOCK[30];
		}
		else if (className == "HNX30") {
			stocks = InputData.stockHNX30();
			temp = new STOCK[26];
		}
		
		for (STOCK j: stocks) {
			if (j != STOCK.VNINDEX && j != STOCK.HASTC) {
				temp[index] = j;
				index++;
			}
		}
		temp = HotStocks.selectionSorting(temp, firstDate, lastDate);
		for (int i = 0; i < 3; i++) {
			stock[i] = temp[i];
			volume[i] = HotStocks.totalVolume(stock[i], firstDate, lastDate);
		}

		String clause = HotStocks.arrayToString(stock, volume, 3);
		
		return "Top 3 cổ phiếu HOT của " + className + " ngày " + formats.format(date1) + " đến ngày " + formats.format(date2) + " là: " + clause;
	}
}
