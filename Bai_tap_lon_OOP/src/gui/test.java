package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Input.ReadFile;
import Input.STOCK;
import changing_sentence.Cau1HNX30;
import changing_sentence.Cau1VN30;
import changing_sentence.Cau2HNX30;
import changing_sentence.Cau2VN30;
import changing_sentence.Cau3GiamHNX30;
import changing_sentence.Cau3GiamVN30;
import changing_sentence.Cau3TangHNX30;
import changing_sentence.Cau3TangVN30;
import changing_sentence.Cau4HNX30;
import changing_sentence.Cau4VN30;
import changing_sentence.DayHNX30;
import changing_sentence.DayVN30;
import changing_sentence.OverAllDayHNX30;
import changing_sentence.OverAllDayVN30;
import changing_sentence.WeekHNX30;
import changing_sentence.WeekVN30;
import comparision.ComparisionHNX30;
import comparision.ComparisionRandomHNX30;
import comparision.ComparisionRandomVN30;
import comparision.ComparisionStockHot;
import comparision.ComparisionVN30;
import comparision.HotStocksDayHNX30;
import comparision.HotStocksDayVN30;
import stock_code_analiztion.DetailPricePercentageChanging;
import stock_code_analiztion.OneStock1;
import stock_code_analiztion.OneStock2Month;
import stock_code_analiztion.OneStock2Week;
import stock_code_analiztion.OverAllDayStockCode;
import stock_code_analiztion.PriceChangingDailySentence;
import stock_code_analiztion.PriceChangingPercentageDailySentence;
import stock_code_analiztion.VolumeChangingDailySentence;
import stock_code_analiztion.VolumePercentageDailyChangingSentence;
import summary_and_comment.DayTitleHNX30;
import summary_and_comment.DayTitleVN30;
import summary_and_comment.Forecast;
import summary_and_comment.Liquidity;
import summary_and_comment.PsychologyOfInvestors;
import summary_and_comment.TomorrowPredictionHNX30;
import summary_and_comment.TomorrowPredictionVN30;
import summary_and_comment.commentMarket;
import summary_and_comment.commentStock;

public class test {
	
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date staticDate = f.parse("28/02/2020");
		Date staticDateWeekend = f.parse("22/02/2020");
		
		STOCK staticStock = STOCK.BID;
		
		ArrayList<Tag> list = new ArrayList<>();
		
		list.add(new Cau1HNX30(staticDate));
		list.add(new Cau1VN30(staticDate));
		list.add(new Cau2HNX30(staticDate));
		list.add(new Cau2VN30(staticDate));
		list.add(new Cau3GiamHNX30(staticDate));
		list.add(new Cau3TangHNX30(staticDate));
		list.add(new Cau3GiamVN30(staticDate));
		list.add(new Cau3TangVN30(staticDate));
		list.add(new Cau4VN30(staticDate));
		list.add(new Cau4HNX30(staticDate));
		list.add(new DayVN30(staticDate));
		list.add(new DayHNX30(staticDate));
		list.add(new WeekVN30(staticDate));
		list.add(new WeekHNX30(staticDate));
		list.add(new OneStock1(staticStock, staticDate));
		list.add(new OneStock2Month(staticStock, staticDate));
		list.add(new OneStock2Week(staticStock, staticDate));
		
		// vandung
		list.add(new ComparisionStockHot(staticDate));
		list.add(new ComparisionVN30(staticDate));
		list.add(new ComparisionRandomVN30(staticDate));
		list.add(new ComparisionHNX30(staticDate));
		list.add(new ComparisionRandomHNX30(staticDate));
		
		// duc
		list.add(new PriceChangingDailySentence(staticDate, staticStock));
		list.add(new PriceChangingPercentageDailySentence(staticDate, staticStock));
		list.add(new VolumeChangingDailySentence(staticDate, staticStock));
		list.add(new VolumePercentageDailyChangingSentence(staticDate, staticStock));
		list.add(new DetailPricePercentageChanging(staticDate, staticStock));
		
		// ledung
		list.add(new OverAllDayVN30(staticDateWeekend));
		list.add(new OverAllDayVN30(staticDate));
		list.add(new OverAllDayHNX30(staticDateWeekend));
		list.add(new OverAllDayHNX30(staticDate));
		list.add(new OverAllDayStockCode(staticDate, staticStock));
		list.add(new HotStocksDayVN30(staticDateWeekend));
		list.add(new HotStocksDayVN30(staticDate));
		list.add(new HotStocksDayHNX30(staticDateWeekend));
		list.add(new HotStocksDayHNX30(staticDate));
		list.add(new DayTitleVN30(staticDateWeekend));
		list.add(new DayTitleVN30(staticDate));
		list.add(new DayTitleHNX30(staticDateWeekend));
		list.add(new DayTitleHNX30(staticDate));
		list.add(new TomorrowPredictionHNX30(staticDate));
		list.add(new TomorrowPredictionVN30(staticDate));
		
		// quang
		list.add(new PsychologyOfInvestors(staticDate, staticStock));
		list.add(new Forecast(staticDate, staticStock));
		list.add(new commentMarket(staticDate, staticStock));
		list.add(new Liquidity(staticDate, staticStock));
		list.add(new commentStock(staticDate, staticStock));
		
		list.forEach(tag -> tag.get());
		list.forEach(t->System.out.println(t.getClass().getSimpleName() + " : " + t.getTag()));
		System.out.println(list.size());
		
		//Demo demo = new Demo(staticDate, staticStock);
		
	}
}
