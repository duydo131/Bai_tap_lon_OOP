package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import changing_sentence.WeekHNX30;
import changing_sentence.WeekVN30;
import stock_code_analiztion.OneStock1;
import stock_code_analiztion.OneStock2Month;
import stock_code_analiztion.OneStock2Week;

public class Demo {
	private Date date;
	private STOCK stock;
	private static ArrayList<Tag> list = new ArrayList<>();
	
	static {
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		Date staticDate = null;
		try {
			staticDate = formats.parse("28/02/2020");
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
		
		//list.add(new ComparisionStockHot(staticDate));
		//list.add(new ComparisionVN30(staticDate));
		//list.add(new ComparisionRandomVN30(staticDate));
		//list.add(new ComparisionHNX30(staticDate));
		//list.add(new ComparisionRandomHNX30(staticDate));
		
		//list.add(new DayTitle(staticDate));
		//list.add(new TomorrowPredictionStockClass(staticDate));
		//list.add(new HotStocksDay(staticDate, ""));
		
	}
	
	public Demo(Date date) {
		this.date = date;
	}
	
	public Demo(Date date, STOCK stock) {
		this(date);
		this.stock = stock;
	}
	
	public String getSentence(String ...list) {
		StringBuffer string = new StringBuffer();
		ArrayList<String> listTag = new ArrayList<>();
		listTag.addAll(Arrays.asList(list));
		ArrayList<Tag> listTagFilter = getListTag(listTag);
		for (Tag tag : listTagFilter) {
			string.append(getInstance(tag).get());
			string.append("\n");
		}
		
		return string.toString();
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

//		case "ComparisionStockHot":
//			newInstance = new ComparisionStockHot(date);
//			break;
			
//		case "ComparisionVN30":
//			newInstance = new ComparisionVN30(date);
//			break;
			
//		case "ComparisionRandomVN30":
//			newInstance = new ComparisionRandomVN30(date);
//			break;
			
//		case "ComparisionHNX30":
//			newInstance = new ComparisionHNX30(date);
//			break;
			
//		case "ComparisionRandomHNX30":
//			newInstance = new ComparisionRandomHNX30(date);
//			break;
//		
//		case "DayTitle":
//			newInstance = new DayTitle(date);
//			break;
			
			
		default:
			newInstance = null;
			break;
		}
		
		return newInstance;
	}
}
