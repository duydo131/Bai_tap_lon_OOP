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
		
		case "Cau1HNX30":
			newInstance = new Cau1HNX30(date);
			break;
			
		case "Cau1VN30":
			newInstance = new Cau1VN30(date);
			break;
			
		case "Cau2HNX30":
			newInstance = new Cau2HNX30(date);
			break;
			
		case "Cau2VN30":
			newInstance = new Cau2VN30(date);
			break;
			
		case "Cau3GiamHNX30":
			newInstance = new Cau3GiamHNX30(date);
			break;
			
		case "Cau3TangHNX30":
			newInstance = new Cau3TangHNX30(date);
			break;
			
		case "Cau3GiamVN30":
			newInstance = new Cau3GiamVN30(date);
			break;
			
		case "Cau3TangVN30":
			newInstance = new Cau3TangHNX30(date);
			break;
			
		case "Cau4VN30":
			newInstance = new Cau4VN30(date);
			break;
			
		case "Cau4HNX30":
			newInstance = new Cau4HNX30(date);
			break;
			
		case "DayVN30":
			newInstance = new DayVN30(date);
			break;
			
		case "DayHNX30":
			newInstance = new DayHNX30(date);
			break;
			
		case "WeekVN30":
			newInstance = new WeekVN30(date);
			break;
			
		case "WeekHNX30":
			newInstance = new WeekHNX30(date);
			break;
			
		case "OneStock1":
			newInstance = new OneStock1(stock, date);
			break;
			
		case "OneStock2Month":
			newInstance = new OneStock2Month(stock, date);
			break;
			
		case "OneStock2Week":
			newInstance = new OneStock2Week(stock, date);
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
