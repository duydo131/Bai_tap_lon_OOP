package quang;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Input.ReadFile;
import Input.STOCK;

public class Main {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyy");
		Date date1 = formats.parse("04/02/2020");
		
//		PriceChangingDailySentence test = new PriceChangingDailySentence(date1, STOCK.ACB);
//		test.createSentence();
//		System.out.println(test.getTag());
//		
//		PriceChangingPercentageDailySentence test1 = new PriceChangingPercentageDailySentence(date1, STOCK.VNM);
//		test1.createSentence();
//		System.out.println(test1.getTag());
//		
//		VolumeChangingDailySentence test2 = new VolumeChangingDailySentence(date1, STOCK.VNM);
//		test2.createSentence();
//		System.out.println(test2.getTag());
//		
//		VolumePercentageDailyChangingSentence test3 = new VolumePercentageDailyChangingSentence(date1, STOCK.VNM);
//		test3.createSentence();
//		System.out.println(test3.getTag());
		
		PsychologyOfInvestors test4 = new PsychologyOfInvestors(date1, STOCK.VNM);
		test4.comment();
		System.out.println(test4.getTag());
		
		Forecast test5 = new Forecast(date1, STOCK.HASTC);
		test5.comment();
		System.out.println(test5.getTag());
		
		commentStock test6 = new commentStock(date1, STOCK.VHM);
		test6.comment();
		System.out.println(test6.getTag());
		
		commentMarket test7 = new commentMarket(date1, STOCK.VNINDEX);
		test7.comment();
		System.out.println(test7.getTag());
		
		overallComment test8 = new overallComment(date1, STOCK.VNM);
		test8.comment();
		System.out.println(test8.getTag());
		
		Liquidity test9 = new Liquidity(date1, STOCK.L14);
		test9.comment();
		System.out.println(test9.getTag());
		
	}
}
