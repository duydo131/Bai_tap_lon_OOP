package Input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InputData {

	private static SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
	private static Map<STOCK, DataOneStock> datashare = new LinkedHashMap<>();

	static {
		for (Map.Entry<STOCK, DataOneStock> item : getDataVN30().entrySet()) {
			datashare.put(item.getKey(), item.getValue());
		}
		for (Map.Entry<STOCK, DataOneStock> item : getDataHNX30().entrySet()) {
			datashare.put(item.getKey(), item.getValue());
		}
	}
	
	public static Set<STOCK> stockShare(){
		Set<STOCK> stock = new HashSet<>();
		Set<STOCK> dataVN30 = getDataVN30().keySet();
		for (STOCK item : dataVN30) {
			if(!(item.equals(STOCK.VNINDEX))){
				stock.add(item);
			}
			
		}
		Set<STOCK> dataHNX30 = getDataHNX30().keySet();
		for (STOCK item : dataHNX30) {
			if(!(item.equals(STOCK.HASTC))){
				stock.add(item);
			}
		}
		return stock;
	}
	
	public static Set<STOCK> stockVN30(){
		Set<STOCK> stock = new HashSet<>();
		Set<STOCK> data = getDataVN30().keySet();
		for (STOCK item : data) {
			stock.add(item);
		}
		return stock;
	}
	
	public static Set<STOCK> stockHNX30(){
		Set<STOCK> stock = new HashSet<>();
		Set<STOCK> data = getDataHNX30().keySet();
		for (STOCK item : data) {
			stock.add(item);
		}
		return stock;
	}

	public static boolean testDay(Date date) {
		ArrayList<DataOneDay> dataVNindex = getDataVN30().get(STOCK.VNINDEX).getData();
		for (DataOneDay dataOneDay : dataVNindex) {
			if (date.getTime() == dataOneDay.getDate().getTime()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * phương thức bổ trợ
	 * 
	 */
	private static DataOneDay priceMax(STOCK stock, ArrayList<DataOneDay> data) {
		if (data.size() == 0) {
			throw new NullPointerException();
		}
		return data.stream().max(Comparator.comparingDouble(DataOneDay::getGiaDongCua)).get();
	}

	private static DataOneDay priceMin(STOCK stock, ArrayList<DataOneDay> data) {
		if (data.size() == 0) {
			throw new NullPointerException();
		}
		return data.stream().min(Comparator.comparingDouble(DataOneDay::getGiaDongCua)).get();
	}

	private static DataOneDay volumeMin(STOCK stock, ArrayList<DataOneDay> data) {
		if (data.size() == 0) {
			throw new NullPointerException();
		}
		return data.stream().min(Comparator.comparingDouble(DataOneDay::getKL)).get();
	}

	private static DataOneDay volumeMax(STOCK stock, ArrayList<DataOneDay> data) {
		if (data.size() == 0) {
			throw new NullPointerException();
		}
		return data.stream().max(Comparator.comparingDouble(DataOneDay::getKL)).get();
	}

	private static long volumeSum(STOCK stock, ArrayList<DataOneDay> data) {
		Function<DataOneDay, Long> mapper = new Function<DataOneDay, Long>() {
			
			@Override
			public Long apply(DataOneDay dataOneDay) {
				return dataOneDay.getKL();
			}
		};
		ArrayList<Long> dataVolume = data.stream()
									.map(mapper)
									.collect(Collectors.toCollection(ArrayList::new));
		
		return Caculate.sum(dataVolume);
	}

	/**
	 * Week
	 * 
	 */
	private static long Week(Date date) {
		try {
			final long aWeek = 604800000;
			long Ngay = formats.parse("30/09/2019").getTime();
			long today = date.getTime();
			return (today - Ngay) / aWeek * aWeek + Ngay;
		} catch (ParseException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static ArrayList<DataOneDay> getDataOneWeekOneStock(STOCK stock, Date date) {
		long addTime = Week(date);
		Predicate<DataOneDay> predicate = new Predicate<DataOneDay>() {
			
			@Override
			public boolean test(DataOneDay dataOneDay) {
				long time = dataOneDay.getDate().getTime();
				return (time >= addTime && time <= date.getTime());
			}
		};
		return datashare.get(stock).getData().stream()
				.filter(predicate)
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public static DataOneDay priceMaxOneWeek(STOCK stock, Date date) {
		return priceMax(stock, getDataOneWeekOneStock(stock, date));
	}

	public static DataOneDay priceMinOneWeek(STOCK stock, Date date) {
		return priceMin(stock, getDataOneWeekOneStock(stock, date));
	}

	public static DataOneDay volumeMinOneWeek(STOCK stock, Date date) {
		return volumeMin(stock, getDataOneWeekOneStock(stock, date));
	}

	public static DataOneDay volumeMaxOneWeek(STOCK stock, Date date) {
		return volumeMax(stock, getDataOneWeekOneStock(stock, date));
	}

	public static long volumeSumOneWeek(STOCK stock, Date date) {
		return volumeSum(stock, getDataOneWeekOneStock(stock, date));
	}

	/**
	 * Month
	 * 
	 */
	public static ArrayList<DataOneDay> getDataOneMonthOneStock(STOCK stock, MONTH month) {
		Predicate<DataOneDay> predicate = new Predicate<DataOneDay>() {
			
			@Override
			public boolean test(DataOneDay dataOneDay) {
				return month.getMonth() == Format.getMonth(dataOneDay.getDate());
			}
		};
		return datashare.get(stock).getData().stream()
				.filter(predicate)
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public static DataOneDay priceMaxOneMonth(STOCK stock, MONTH month) {
		return priceMax(stock, getDataOneMonthOneStock(stock, month));
	}

	public static DataOneDay priceMinOneMonth(STOCK stock, MONTH month) {
		return priceMin(stock, getDataOneMonthOneStock(stock, month));
	}

	public static DataOneDay volumeMinOneMonth(STOCK stock, MONTH month) {
		return volumeMin(stock, getDataOneMonthOneStock(stock, month));
	}

	public static DataOneDay volumeMaxOneMonth(STOCK stock, MONTH month) {
		return volumeMax(stock, getDataOneMonthOneStock(stock, month));
	}

	public static long volumeSumOneMonth(STOCK stock, MONTH month) {
		return volumeSum(stock, getDataOneMonthOneStock(stock, month));
	}

	/*
	 * Get Info
	 */

	//	getInfo One Day
	private static Map<STOCK, DataOneDay> getMapOneDay(Date date, Map<STOCK, DataOneStock> map ) {
		Map<STOCK, DataOneDay> data = new LinkedHashMap<>();
		Set<Map.Entry<STOCK, DataOneStock>> dataSet = map.entrySet();
		for (Map.Entry<STOCK, DataOneStock> element : dataSet) {
			data.put(element.getKey(), element.getValue().getDataOneDay(date));
		}
		return data;
	}
	
	public static Map<STOCK, DataOneDay>  getToday(Date date){
		return getMapOneDay(date, datashare);
	}
	
	public static Map<STOCK, DataOneDay>  getTodayVN30(Date date){
		return getMapOneDay(date, getDataVN30());
	}
	
	public static Map<STOCK, DataOneDay>  getTodayHNX30(Date date){
		return getMapOneDay(date, getDataHNX30());
	}
	
	
	// 	getInfo Some Day
	private static Map<STOCK, ArrayList<DataOneDay>> getMap(Date dateBefore, Date dateAfter, Map<STOCK, DataOneStock> map ) {
		long dayBefore = dateBefore.getTime();
		long dayAfter = dateAfter.getTime();
		Map<STOCK, ArrayList<DataOneDay>> data = new LinkedHashMap<>();
		Set<Map.Entry<STOCK, DataOneStock>> dataSet = map.entrySet();
		Predicate<DataOneDay> predicate = new Predicate<DataOneDay>() {
			
			@Override
			public boolean test(DataOneDay dataOneDay) {
				long date = dataOneDay.getDate().getTime();
				return (date <= dayAfter && date >= dayBefore);
			}
		};
		for (Map.Entry<STOCK, DataOneStock> element : dataSet) {
			data.put(element.getKey(), element.getValue().getData().stream()
												.filter(predicate)
												.collect(Collectors.toCollection(ArrayList::new))
					);
		}
		return data;
	}
	
	public static Map<STOCK, ArrayList<DataOneDay>> getInfo(Date dateBefore, Date dateAfter){
		return getMap(dateBefore, dateAfter, datashare);
	}
	
	public static Map<STOCK, ArrayList<DataOneDay>> getInfoVN30(Date dateBefore, Date dateAfter){
		return getMap(dateBefore, dateAfter, getDataVN30());
	}
	
	public static Map<STOCK, ArrayList<DataOneDay>> getInfoHNX30(Date dateBefore, Date dateAfter){
		return getMap(dateBefore, dateAfter, getDataHNX30());
	}

	
	//	28/4
	
	private static double getDifference(DataOneDay dataOneDay) {
		return Format.formatsDouble(dataOneDay.getGiaDongCua() - dataOneDay.getGiaMoCua());
	}
	
	
	// 	Difference One Day
	public static double getDifferenceOneDayOneStock(STOCK stock, Date date) {
		DataOneDay dataOneDay = getToday(date).get(stock);
		return getDifference(dataOneDay);
	}
	

	private static double getDifferenceOneDayOneStockVN30(STOCK stock, Date date) {
		DataOneDay dataOneDay = getTodayVN30(date).get(stock);
		return getDifference(dataOneDay);
	}
	
	private static double getDifferenceOneDayOneStockHNX30(STOCK stock, Date date) {
		DataOneDay dataOneDay = getTodayHNX30(date).get(stock);
		return getDifference(dataOneDay);
	}
	
	public static Map<STOCK, Double> getDifferenceOneDay(Date date) {
		Map<STOCK, Double> difference = new LinkedHashMap<>();
		for (STOCK stock : STOCK.values()) {
			difference.put(stock, getDifferenceOneDayOneStock(stock, date));
		}
		return difference;
	}
	
	public static Map<STOCK, Double> getDifferenceOneDayVN30(Date date) {
		Map<STOCK, Double> difference = new LinkedHashMap<>();
		Set<STOCK> dataStock = stockVN30();
		for (STOCK stock : dataStock) {
			difference.put(stock, getDifferenceOneDayOneStockVN30(stock, date));
		}
		return difference;
	}
	
	public static Map<STOCK, Double> getDifferenceOneDayHNX30(Date date) {
		Map<STOCK, Double> difference = new LinkedHashMap<>();
		Set<STOCK> dataStock = stockHNX30();
		for (STOCK stock : dataStock) {
			difference.put(stock, getDifferenceOneDayOneStockHNX30(stock, date));
		}
		return difference;
	}
	
	
	// 	Difference One Week
	public static Map<Date, Double> getDifferenceOneWeekOneStock(STOCK stock, Date date) {
		Map<Date, Double> difference = new LinkedHashMap<>();
		ArrayList<DataOneDay> data = getDataOneWeekOneStock(stock, date);
		for (DataOneDay dataOneDay : data) {
			difference.put(dataOneDay.getDate(), getDifference(dataOneDay));
		}
		return difference;
	}
	
	public static Map<STOCK, Map<Date, Double>> getDifferenceOneWeek(Date date) {
		Map<STOCK, Map<Date, Double>> difference = new LinkedHashMap<>();
		for (STOCK stock : STOCK.values()) {
			difference.put(stock, getDifferenceOneWeekOneStock(stock, date));
		}
		return difference;
	}
	
	
	// 	Difference One Month
	public static Map<Date, Double> getDifferenceOneMonthOneStock(STOCK stock, MONTH month) {
		Map<Date, Double> difference = new LinkedHashMap<>();
		ArrayList<DataOneDay> data = getDataOneMonthOneStock(stock, month);
		for (DataOneDay dataOneDay : data) {
			difference.put(dataOneDay.getDate(), getDifference(dataOneDay));
		}
		return difference;
	}
	
	public static Map<STOCK, Map<Date, Double>> getDifferenceOneMonth(MONTH month) {
		Map<STOCK, Map<Date, Double>> difference = new LinkedHashMap<>();
		for (STOCK stock : STOCK.values()) {
			difference.put(stock, getDifferenceOneMonthOneStock(stock, month));
		}
		return difference;
	}

	
	//	Counter
	private static int Counter(STOCK stock, Date date, boolean change, Map<STOCK, DataOneStock> map) {
		long dateLong = date.getTime();
		LinkedList<DataOneDay> data = map.get(stock).getData().stream()
												.filter(x -> x.getDate().getTime() <= dateLong)
												.collect(Collectors.toCollection(LinkedList::new));
		
		double price = data.getFirst().getGiaDongCua();
		data.removeFirst();
		Iterator<DataOneDay> iterator = data.iterator();
		int i = 0;
		if(change) {
			while(iterator.hasNext()) {
				DataOneDay dataOneDay= iterator.next();
				if(dataOneDay.getGiaDongCua() < price) {
					price = dataOneDay.getGiaDongCua();
					i++;
					continue;
				}else 
					break;
			}
		}else {
			while(iterator.hasNext()) {
				DataOneDay dataOneDay= iterator.next();
				if(dataOneDay.getGiaDongCua() > price) {
					price = dataOneDay.getGiaDongCua();
					i++;
					continue;
				}else 
					break;
			}
		}
		return i;
	}
	
	//	increase
	public static int increseCounterOneStock(STOCK stock, Date date) {
		return Counter(stock, date, true, datashare);
	}
	
	public static Map<STOCK, Integer> increseCounter(Date date) {
		Map<STOCK, Integer> data = new LinkedHashMap<>();
		for (STOCK stock : STOCK.values()) {
			data.put(stock, increseCounterOneStock(stock, date));
		}
		return data;
	}
	
	public static Map<STOCK, Integer> increseCounterVN30(Date date) {
		Map<STOCK, Integer> data = new LinkedHashMap<>();
		for (STOCK stock : stockVN30()) {
			data.put(stock, Counter(stock, date, true, getDataVN30()));
		}
		return data;
	}
	
	public static Map<STOCK, Integer> increseCounterHNX30(Date date) {
		Map<STOCK, Integer> data = new LinkedHashMap<>();
		for (STOCK stock : stockHNX30()) {
			data.put(stock, Counter(stock, date, true, getDataHNX30()));
		}
		return data;
	}
	
	//	decrease
	public static int decreseCounterOneStock(STOCK stock, Date date) {
		return Counter(stock, date, false, datashare);
	}
	
	public static Map<STOCK, Integer> decreseCounter(Date date) {
		Map<STOCK, Integer> data = new LinkedHashMap<>();
		for (STOCK stock : STOCK.values()) {
			data.put(stock, decreseCounterOneStock(stock, date));
		}
		return data;
	}
	
	public static Map<STOCK, Integer> decreseCounterVN30(Date date) {
		Map<STOCK, Integer> data = new LinkedHashMap<>();
		for (STOCK stock : stockVN30()) {
			data.put(stock, Counter(stock, date, false, getDataVN30()));
		}
		return data;
	}
	
	public static Map<STOCK, Integer> decreseCounterHNX30(Date date) {
		Map<STOCK, Integer> data = new LinkedHashMap<>();
		for (STOCK stock : stockHNX30()) {
			data.put(stock, Counter(stock, date, false, getDataHNX30()));
		}
		return data;
	}
	
	
	// 30/04
	
	private static STOCK getStockByNumerical(int numerical, Map<STOCK, DataOneDay> data) {
		ArrayList<Map.Entry<STOCK, DataOneDay>> list = new ArrayList<>(Caculate.sort(data).entrySet());
		LinkedList<STOCK> sortedListStock = new LinkedList<>();
		for (Map.Entry<STOCK, DataOneDay> entry : list) {
			sortedListStock.add(entry.getKey());
		}
		return sortedListStock.get(numerical-1);
	}
	
	public static STOCK getStockByNumericalVN30(Date date, int numerical) {
		Map<STOCK, DataOneDay> data = getTodayVN30(date);
		data.remove(STOCK.VNINDEX);
		return getStockByNumerical(numerical, data);
	}
	
	public static STOCK getStockByNumericalHNX30(Date date, int numerical) {
		Map<STOCK, DataOneDay> data = getTodayHNX30(date);
		data.remove(STOCK.HASTC);
		return getStockByNumerical(numerical, data);
	}
	
	// 	09/05
	public static Map<STOCK, DataOneStock> getDatashare() {
		return datashare;
	}
	public static Map<STOCK, DataOneStock> getDataVN30() {
		return Data.getDataVN30();
	}
	public static Map<STOCK, DataOneStock> getDataHNX30() {
		return Data.getDataHNX30();
	}
}




