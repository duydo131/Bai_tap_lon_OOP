package stock_code_analization;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import input.ReadFile;
import input.STOCK;

public class Test {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formats.parse("20/02/2020");
		STOCK stock = STOCK.BID;
		
		AnalizationOneStock1 o1 = new AnalizationOneStock1(stock, date);
		System.out.println(o1.get());
		System.out.println(o1.getTag());
		
		AnalizationOneStock2Month o2 = new AnalizationOneStock2Month(stock, date);
		System.out.println(o2.get());
		System.out.println(o2.getTag());
		
		AnalizationOneStock2Week o3 = new AnalizationOneStock2Week(stock, date);
		System.out.println(o3.get());
		System.out.println(o3.getTag());
		
		// ledung
		OverAllDayStockCode p15 = new OverAllDayStockCode(date, STOCK.ACB);
		System.out.println(p15.get());
		System.out.println(p15.getTag());
		System.out.println();
		
	}
}


