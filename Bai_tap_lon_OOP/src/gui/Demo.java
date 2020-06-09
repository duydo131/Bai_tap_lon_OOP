package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

public class Demo {
	private Date date;
	private STOCK stock;
	private static ArrayList<Tag> list = new ArrayList<>();
	private static ArrayList<String> listString = new ArrayList<>();
	
	static {
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		Date staticDate = null;
		Date staticDateWeekend = null;
		try {
			staticDate = formats.parse("28/02/2020");
			staticDateWeekend = formats.parse("22/02/2020");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		STOCK staticStock = STOCK.BID;
		
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
		
		list.forEach(tag -> listString.add(tag.get()));
	}
	
	public Demo(Date date) {
		this.date = date;
	}
	
	public Demo(Date date, STOCK stock) {
		this(date);
		this.stock = stock;
	}
	
	public static ArrayList<String> getListString(){
		return listString;
	}
	
	public List<String> getSentence(String ...list) {
		ArrayList<String> listTag = new ArrayList<>();
		listTag.addAll(Arrays.asList(list));
		ArrayList<String> array = new ArrayList<>();
		
		for (Tag tag : getListTag(listTag)) {
			array.add(tag.get());
		}
		
		return array.stream().distinct().collect(Collectors.toList());
		
	}
	
	private ArrayList<Tag> getListTag(ArrayList<String> listTag){
		Predicate<Tag> predicate = new Predicate<Tag>() {
			
			@Override
			public boolean test(Tag t) {
				boolean bool = true;
				ArrayList<String> listTagOfOneSentence = t.getTag();
				for (String tag : listTag) {
					if(tag != null) {
						if(listTagOfOneSentence.contains(tag)) {
							continue;
						}else {
							bool = false;
							break;
						}
					}
				}
				return bool;
			}
		};
		
		return list.stream().filter(predicate).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public Tag getInstance(Tag instance) {
		Tag newInstance;
		switch (instance.getClass().getSimpleName()) {
		
		case "Cau1ChangingHNX30":
			newInstance = new Cau1ChangingHNX30(date);
			break;
			
		case "Cau1ChangingVN30":
			newInstance = new Cau1ChangingVN30(date);
			break;
			
		case "Cau2ChangingHNX30":
			newInstance = new Cau2ChangingHNX30(date);
			break;
			
		case "Cau2ChangingVN30":
			newInstance = new Cau2ChangingVN30(date);
			break;
			
		case "Cau3ChangingDecreaseHNX30":
			newInstance = new Cau3ChangingDecreaseHNX30(date);
			break;
			
		case "Cau3ChangingIncreaseHNX30":
			newInstance = new Cau3ChangingIncreaseHNX30(date);
			break;
			
		case "Cau3ChaingingDecreaseVN30":
			newInstance = new Cau3ChaingingDecreaseVN30(date);
			break;
			
		case "Cau3ChangingIncreaseVN30":
			newInstance = new Cau3ChangingIncreaseVN30(date);
			break;
			
		case "Cau4ChangingVN30":
			newInstance = new Cau4ChangingVN30(date);
			break;
			
		case "Cau4ChangingHNX30":
			newInstance = new Cau4ChangingHNX30(date);
			break;
			
		case "DayChangingVN30":
			newInstance = new DayChangingVN30(date);
			break;
			
		case "DayChangingHNX30":
			newInstance = new DayChangingHNX30(date);
			break;
			
		case "WeekChangingVN30":
			newInstance = new WeekChangingVN30(date);
			break;
			
		case "WeekChangingHNX30":
			newInstance = new WeekChangingHNX30(date);
			break;
			
		case "AnalizationOneStock1":
			newInstance = new AnalizationOneStock1(stock, date);
			break;
			
		case "AnalizationOneStock2Month":
			newInstance = new AnalizationOneStock2Month(stock, date);
			break;
			
		case "AnalizationOneStock2Week":
			newInstance = new AnalizationOneStock2Week(stock, date);
			break;

		case "ComparisionStockHot":
			newInstance = new ComparisionStockHot(date);
			break;
			
		case "ComparisionVN30":
			newInstance = new ComparisionVN30(date);
			break;
			
		case "ComparisionRandomVN30":
			newInstance = new ComparisionRandomVN30(date);
			break;
			
		case "ComparisionHNX30":
			newInstance = new ComparisionHNX30(date);
			break;
			
		case "ComparisionRandomHNX30":
			newInstance = new ComparisionRandomHNX30(date);
			break;
			
		case "PriceChangingDailySentence":
			newInstance = new PriceChangingDailySentence(date, stock);
			break;
			
		case "PriceChangingPercentageDailySentence":
			newInstance = new PriceChangingPercentageDailySentence(date, stock);
			break;
			
		case "VolumeChangingDailySentence":
			newInstance = new VolumeChangingDailySentence(date, stock);
			break;
			
		case "VolumePercentageDailyChangingSentence":
			newInstance = new VolumePercentageDailyChangingSentence(date, stock);
			break;
			
		case "DetailPricePercentageChanging":
			newInstance = new DetailPricePercentageChanging(date, stock);
			break;
			
		case "OverAllDayVN30":
			newInstance = new OverAllDayVN30(date);
			break;
			
		case "OverAllDayHNX30":
			newInstance = new OverAllDayHNX30(date);
			break;
			
		case "OverAllDayStockCode":
			newInstance = new OverAllDayStockCode(date, stock);
			break;
			
		case "HotStocksDayHNX30":
			newInstance = new HotStocksDayHNX30(date);
			break;
			
		case "HotStocksDayVN30":
			newInstance = new HotStocksDayVN30(date);
			break;
			
		case "DayTitleVN30":
			newInstance = new DayTitleVN30(date);
			break;
			
		case "DayTitleHNX30":
			newInstance = new DayTitleHNX30(date);
			break;
			
		case "TomorrowPredictionVN30":
			newInstance = new TomorrowPredictionVN30(date);
			break;
			
		case "TomorrowPredictionHNX30":
			newInstance = new TomorrowPredictionHNX30(date);
			break;
			
		case "PsychologyOfInvestors":
			newInstance = new PsychologyOfInvestors(date, stock);
			break;
			
		case "Forecast":
			newInstance = new Forecast(date, stock);
			break;
			
		case "commentMarket":
			newInstance = new commentMarket(date, stock);
			break;
			
		case "Liquidity":
			newInstance = new Liquidity(date, stock);
			break;
			
		case "commentStock":
			newInstance = new commentStock(date, stock);
			break;
			
		default:
			newInstance = null;
			break;
		}
		
		return newInstance;
	}
}
