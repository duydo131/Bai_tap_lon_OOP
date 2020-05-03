package Sentence;

import java.util.Date;

import Input.*;

public class HotStocksDays extends HotStocks{
	
	private Date date1;
	private Date date2;
	
	public HotStocksDays(int number, String name, Date date1, Date date2) {
		super(number,name);
		this.date1 = date1;
		this.date2 = date2;
	}
	
	public String createClause() {
		ReadFile.loadData();
		
		STOCK[] stock = this.stock;
		STOCK[] temp = new STOCK[31];
		String name = this.name;
		Date date1 = this.date1;
		Date date2 = this.date2;
		int num = this.numberStock;
		long volume[] = new long[num];
		
		if (name == "VN30") {
			int index = 0;
			for (STOCK j: InputData.stockVN30()) {
				temp[index] = j;
				index++;
			}
			temp = HotStocks.selectionSorting(temp, date1, date2);
			for (int i = 0; i < num; i++) {
				stock[i] = temp[i];
				volume[i] = HotStocks.totalVolume(stock[i], date1, date2);
			}
		}
		if (name == "HNX30") {
			int index = 0;
			for (STOCK j: InputData.stockHNX30()) {
				temp[index] = j;
				index++;
			}
			temp = HotStocks.selectionSorting(temp, date1, date2);
			for (int i = 0; i < num; i++) {
				stock[i] = temp[i];
				volume[i] = HotStocks.totalVolume(stock[i], date1, date2);
			}
		}
		String clause = HotStocks.arrayToString(stock, volume, num);
		if (num == 1) {
			return "Cổ phiếu HOT nhất từ ngày " + formats.format(date1) + " đến ngày " + formats.format(date2) + " là: " + clause;
		}
		else {
		return "Top " + num + " cổ phiếu HOT ngày " + formats.format(date1) + " đến ngày " + formats.format(date2) + " là: " + clause;
		}
	}
}
