package changing_sentence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Input.ReadFile;
import Input.STOCK;

public class TestDuc {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyy");
		Date date1 = formats.parse("04/02/2020");
		
		PriceChangingDailySentence test = new PriceChangingDailySentence(date1, STOCK.ACB);
		test.createSentence();
		System.out.println(test.getTag());
		
		PriceChangingPercentageDailySentence test1 = new PriceChangingPercentageDailySentence(date1, STOCK.VNM);
		test1.createSentence();
		System.out.println(test1.getTag());
		
		VolumeChangingDailySentence test2 = new VolumeChangingDailySentence(date1, STOCK.VNM);
		test2.createSentence();
		System.out.println(test2.getTag());
		
		VolumePercentageDailyChangingSentence test3 = new VolumePercentageDailyChangingSentence(date1, STOCK.VNM);
		test3.createSentence();
		System.out.println(test3.getTag());
		
		ExchangeChangingSentence t = new ExchangeChangingSentence(date1, STOCK.ACB);
		t.createSentence();
		System.out.println(t.getTag());
		
		DetailPricePercentageChanging t2 = new DetailPricePercentageChanging(date1, STOCK.ACB);
		t2.createSentence();
		System.out.println(t2.getTag());
	}
}
