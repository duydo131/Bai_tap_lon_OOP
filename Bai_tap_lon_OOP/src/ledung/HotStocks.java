package ledung;

import java.text.SimpleDateFormat;
import java.util.Date;

import Input.*;

public class HotStocks extends Sentence {
	protected static SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
	
	int numberStock;
	STOCK stock[];
	String name;
	
	public HotStocks(int number, String name) {
		this.numberStock = number;
		this.stock = new STOCK[number];
		this.name = name;
	}
	
	protected static STOCK[] selectionSorting(STOCK[] stock, Date date1, Date date2) {
		int max;
		STOCK temp;
		
		for (int i = 0; i < (stock.length-1); i++) {
			max = i;
			for (int j = i+1; j < stock.length; j++) {
				if (HotStocks.totalVolume(stock[j], date1, date2) > HotStocks.totalVolume(stock[max], date1, date2)) {
					max = j;
				}
				temp = stock[i];
				stock[i] = stock[j];
				stock[j] = temp;
			}
		}
		
		return stock;
	}
	
	public static long totalVolume(STOCK stock, Date date1, Date date2) throws IndexOutOfBoundsException {
		
		long total = 0;;
		
		int days = InputData.getDays(date1, date2);
		
		try {
			for (int i = 0; i < days; i++) {
				total += InputData.getInfo(date1, date2).get(stock).get(i).getKL();
			}
		} 
		catch (IndexOutOfBoundsException e) {
		}
		
		return total;
	}
	
	public static String arrayToString(STOCK[] stock, long[] volume, int num) {
		
		String clause = "";
		
		for (int i = 0; i < num; i++) {
			clause += stock[i].name();
			if (i != num - 1) {
				clause += ", ";
			}
			if (i == (num - 1) && i == 0) {
				clause += " đạt khối lượng giao dịch lên đến ";
			}
			if (i == (num - 1) && i != 0){
				clause += " lần lượt đạt khối lượng giao dịch lên đến ";
			}
		}
		for (int i = 0; i < num; i++) {
			clause += volume[i];
			if (i != (num - 1) ) {
				clause += ", ";
			}
			else {
				clause += " cổ phiếu.";
			}
		}
		return clause;
	}
}
