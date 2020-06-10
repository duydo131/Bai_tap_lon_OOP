package stock_code_analization;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import input.ReadFile;
import input.STOCK;

public class TestDuc {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyy");
		Date date1 = formats.parse("04/02/2020");
		STOCK stock = STOCK.BID;
		
		ChangingSentence test = new ChangingSentence(date1, STOCK.ACB);
		System.out.println(test.get());
		System.out.println(test.getTag());
		System.out.println();
		
		PriceChangingPercentageDailySentence test1 = new PriceChangingPercentageDailySentence(date1, STOCK.VNM);
		System.out.println(test1.get());
		System.out.println(test1.getTag());
		System.out.println();
		
		VolumeChangingDailySentence test2 = new VolumeChangingDailySentence(date1, STOCK.VNM);
		System.out.println(test2.get());
		System.out.println(test2.getTag());
		System.out.println();
		
		VolumePercentageDailyChangingSentence test3 = new VolumePercentageDailyChangingSentence(date1, STOCK.VNM);
		System.out.println(test3.get());
		System.out.println(test3.getTag());
		System.out.println();
		
//		ExchangeChangingSentence t = new ExchangeChangingSentence(date1, STOCK.ACB);
//		System.out.println(t.get());
//		System.out.println(t.getTag());
		
		DetailPricePercentageChanging t2 = new DetailPricePercentageChanging(date1, STOCK.ACB);
		System.out.println(t2.get());
		System.out.println(t2.getTag());
		
		TestNew t = new TestNew(date1, stock);
		System.out.println(t.get());
		System.out.println(t.getTag());
	}
}
