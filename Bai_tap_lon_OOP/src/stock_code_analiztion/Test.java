package stock_code_analiztion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Input.ReadFile;
import Input.STOCK;

public class Test {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formats.parse("20/02/2020");
		STOCK stock = STOCK.BID;
		
		OneStock1 o1 = new OneStock1(stock, date);
		System.out.println(o1.get());
		System.out.println(o1.getTag());
		
		OneStock2Month o2 = new OneStock2Month(stock, date);
		System.out.println(o2.get());
		System.out.println(o2.getTag());
		
		OneStock2Week o3 = new OneStock2Week(stock, date);
		System.out.println(o3.get());
		System.out.println(o3.getTag());
		
		// ledung
		OverAllDayStockCode p15 = new OverAllDayStockCode(date, STOCK.ACB);
		System.out.println(p15.get());
		System.out.println(p15.getTag());
		System.out.println();
		
	}
}
