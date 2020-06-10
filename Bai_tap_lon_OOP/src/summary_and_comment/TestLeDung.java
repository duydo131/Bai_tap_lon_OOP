package summary_and_comment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import input.ReadFile;
import input.STOCK;

public class TestLeDung {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		
		//Date weekend = formats.parse("14/12/2019");
		Date date = formats.parse("13/12/2019");
		
//		DayTitleVN30 p10 = new DayTitleVN30(weekend);
//		System.out.println(p10.get());
//		System.out.println(p10.getTag());
//		
//		DayTitleVN30 p11 = new DayTitleVN30(date);
//		System.out.println(p11.get());
//		System.out.println(p11.getTag());
//		
//		DayTitleHNX30 p12 = new DayTitleHNX30(weekend);
//		System.out.println(p12.get());
//		System.out.println(p12.getTag());
//		
//		DayTitleHNX30 p13 = new DayTitleHNX30(date);
//		System.out.println(p13.get());
//		System.out.println(p13.getTag());
//		
//		System.out.println();
//		
//		TomorrowPredictionVN30 p14 = new TomorrowPredictionVN30(weekend);
//		System.out.println(p14.get());
//		System.out.println(p14.getTag());
		
		DayTitleStockCode d = new DayTitleStockCode(date, STOCK.ACB);
		System.out.println(d.get());
		System.out.println(d.getTag());
	}
}
