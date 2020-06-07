package ledung;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Input.*;
public class test {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		
		Date weekend = formats.parse("14/12/2019");
		Date date = formats.parse("13/12/2019");
		
		HotStocksDayHNX30 p1 = new HotStocksDayHNX30(weekend);
		System.out.println(p1.get());
		System.out.println();
		HotStocksDayHNX30 a1 = new HotStocksDayHNX30(date);
		System.out.println(a1.get());
		System.out.println();
		HotStocksDayVN30 p2 = new HotStocksDayVN30(weekend);
		System.out.println(p2.get());
		System.out.println();
		HotStocksDayVN30 a2 = new HotStocksDayVN30(date);
		System.out.println(a2.get());
		System.out.println();
		OverAllDayVN30 p3 = new OverAllDayVN30(weekend);
		System.out.println(p3.get());
		System.out.println();
		OverAllDayVN30 p4 = new OverAllDayVN30(date);
		System.out.println(p4.get());
		System.out.println();
		OverAllDayHNX30 p5 = new OverAllDayHNX30(weekend);
		System.out.println(p5.get());
		System.out.println();
		OverAllDayHNX30 p6 = new OverAllDayHNX30(date);
		System.out.println(p6.get());
		System.out.println();
		OverAllDayGeneralComment p7 = new OverAllDayGeneralComment(weekend);
		System.out.println(p7.get());
		System.out.println();
		OverAllDayGeneralComment p8 = new OverAllDayGeneralComment(date);
		System.out.println(p8.get());
		System.out.println();
		DayTitleVN30 p10 = new DayTitleVN30(weekend);
		System.out.println(p10.get());
		System.out.println();
		DayTitleVN30 p11 = new DayTitleVN30(date);
		System.out.println(p11.get());
		System.out.println();
		DayTitleHNX30 p12 = new DayTitleHNX30(weekend);
		System.out.println(p12.get());
		System.out.println();
		DayTitleHNX30 p13 = new DayTitleHNX30(date);
		System.out.println(p13.get());
		System.out.println();
		TomorrowPredictionVN30 p14 = new TomorrowPredictionVN30(weekend);
		System.out.println(p14.get());
		System.out.println();
		OverAllDayStockCode p15 = new OverAllDayStockCode(date, STOCK.ACB);
		System.out.println(p15.get());
	}	
}