package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Input.ReadFile;
import Input.STOCK;
import changing_sentence.Cau1ChangingHNX30;
import changing_sentence.Cau1ChangingVN30;
import changing_sentence.Cau2ChangingHNX30;
import changing_sentence.Cau2ChangingVN30;
import changing_sentence.Cau3ChangingDecreaseHNX30;
import changing_sentence.Cau3ChaingingDecreaseVN30;
import changing_sentence.Cau3ChangingIncreaseHNX30;
import changing_sentence.Cau3ChangingIncreaseVN30;
import changing_sentence.Cau4ChangingHNX30;
import changing_sentence.Cau4ChangingVN30;
import changing_sentence.DayChangingHNX30;
import changing_sentence.DayChangingVN30;
import changing_sentence.OverAllDayHNX30;
import changing_sentence.OverAllDayVN30;
import changing_sentence.WeekChangingHNX30;
import changing_sentence.WeekChangingVN30;
import comparision.ComparisionHNX30;
import comparision.ComparisionRandomHNX30;
import comparision.ComparisionRandomVN30;
import comparision.ComparisionStockHot;
import comparision.ComparisionVN30;
import comparision.HotStocksDayHNX30;
import comparision.HotStocksDayVN30;
import stock_code_analization.AnalizationOneStock1;
import stock_code_analization.AnalizationOneStock2Month;
import stock_code_analization.AnalizationOneStock2Week;
import stock_code_analization.DetailPricePercentageChanging;
import stock_code_analization.OverAllDayStockCode;
import stock_code_analization.PriceChangingDailySentence;
import stock_code_analization.PriceChangingPercentageDailySentence;
import stock_code_analization.VolumeChangingDailySentence;
import stock_code_analization.VolumePercentageDailyChangingSentence;
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
		
		list.add(new Cau1ChangingHNX30(staticDate));
		list.add(new Cau1ChangingVN30(staticDate));
		list.add(new Cau2ChangingHNX30(staticDate));
		list.add(new Cau2ChangingVN30(staticDate));
		list.add(new Cau3ChangingDecreaseHNX30(staticDate));
		list.add(new Cau3ChangingIncreaseHNX30(staticDate));
		list.add(new Cau3ChaingingDecreaseVN30(staticDate));
		list.add(new Cau3ChangingIncreaseVN30(staticDate));
		list.add(new Cau4ChangingVN30(staticDate));
		list.add(new Cau4ChangingHNX30(staticDate));
		list.add(new DayChangingVN30(staticDate));
		list.add(new DayChangingHNX30(staticDate));
		list.add(new WeekChangingVN30(staticDate));
		list.add(new WeekChangingHNX30(staticDate));
		list.add(new AnalizationOneStock1(staticStock, staticDate));
		list.add(new AnalizationOneStock2Month(staticStock, staticDate));
		list.add(new AnalizationOneStock2Week(staticStock, staticDate));
		
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
