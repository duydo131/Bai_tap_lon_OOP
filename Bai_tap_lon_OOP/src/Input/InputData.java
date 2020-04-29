package Input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class InputData {

	private static SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
	private static Map<STOCK, DataOneStock> datashare = new LinkedHashMap<>();

	static {
		for (Map.Entry<STOCK, DataOneStock> item : Data.getDataVN30().entrySet()) {
			datashare.put(item.getKey(), item.getValue());
		}
		for (Map.Entry<STOCK, DataOneStock> item : Data.getDataHNX30().entrySet()) {
			datashare.put(item.getKey(), item.getValue());
		}
	}
	
	public static Set<STOCK> stockVN30(){
		return Data.getDataVN30().keySet();
	}
	
	public static Set<STOCK> stockHNX30(){
		return Data.getDataHNX30().keySet();
	}

	public static boolean testDay(Date date) {
		ArrayList<DataOneDay> dataVNindex = Data.getDataVN30().get(STOCK.VNINDEX).getData();
		for (DataOneDay dataOneDay : dataVNindex) {
			if (date.getTime() == dataOneDay.getDate().getTime()) {
				return true;
			}
		}
		return false;
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

	private static boolean chooseWeek(DataOneDay dataOneDay, Date date) {
		return dataOneDay.getDate().getTime() >= Week(date) && dataOneDay.getDate().getTime() <= date.getTime();
	}

	public static ArrayList<DataOneDay> getDataOneWeekOneStock(STOCK stock, Date date) {
		return datashare.get(stock).getData().stream()
				.filter(DataOneDay -> chooseWeek(DataOneDay, date)).collect(Collectors.toCollection(ArrayList::new));
	}
	

	public static DataOneDay priceMaxOneWeek(STOCK stock, Date date) {
		ArrayList<DataOneDay> data = getDataOneWeekOneStock(stock, date);

		if (data.size() == 0) {
			throw new NullPointerException();
		}

		return data.stream().max(Comparator.comparingDouble(DataOneDay::getGiaDongCua)).get();
	}

	public static DataOneDay priceMinOneWeek(STOCK stock, Date date) {
		ArrayList<DataOneDay> data = getDataOneWeekOneStock(stock, date);

		if (data.size() == 0) {
			throw new NullPointerException();
		}

		return data.stream().min(Comparator.comparingDouble(DataOneDay::getGiaDongCua)).get();
	}

	public static DataOneDay volumeMinOneWeek(STOCK stock, Date date) {
		ArrayList<DataOneDay> data = getDataOneWeekOneStock(stock, date);

		if (data.size() == 0) {
			throw new NullPointerException();
		}

		return data.stream().min(Comparator.comparingDouble(DataOneDay::getKL)).get();
	}

	public static DataOneDay volumeMaxOneWeek(STOCK stock, Date date) {
		ArrayList<DataOneDay> data = getDataOneWeekOneStock(stock, date);

		if (data.size() == 0) {
			throw new NullPointerException();
		}

		return data.stream().max(Comparator.comparingDouble(DataOneDay::getKL)).get();
	}

	public static long volumeSumOneWeek(STOCK stock, Date date) {
		ArrayList<DataOneDay> data = getDataOneWeekOneStock(stock, date);

		long sum = 0L;

		Iterator<DataOneDay> iter = data.iterator();

		while (iter.hasNext()) {
			sum += iter.next().getKL();
		}

		return sum;
	}

	/**
	 * Month
	 * 
	 */
	public static int getMonth(Date date) {
		return Integer.parseInt(formats.format(date).substring(3, 5));
	}

	private static boolean chooseMonth(DataOneDay dataOneDay, int month) {
		return month == (getMonth(dataOneDay.getDate()));
	}

	public static ArrayList<DataOneDay> getDataOneMonthOneStock(STOCK stock, MONTH month) {
		return datashare.get(stock).getData().stream()
				.filter(DataOneDay -> chooseMonth(DataOneDay, month.getMonth())).collect(Collectors.toCollection(ArrayList::new));
	}

	public static DataOneDay priceMaxOneMonth(STOCK stock, MONTH month) {
		ArrayList<DataOneDay> data = getDataOneMonthOneStock(stock, month);

		if (data.size() == 0) {
			throw new NullPointerException();
		}

		return data.stream().max(Comparator.comparingDouble(DataOneDay::getGiaDongCua)).get();
	}

	public static DataOneDay priceMinOneMonth(STOCK stock, MONTH month) {
		ArrayList<DataOneDay> data = getDataOneMonthOneStock(stock, month);

		if (data.size() == 0) {
			throw new NullPointerException();
		}

		return data.stream().min(Comparator.comparingDouble(DataOneDay::getGiaDongCua)).get();
	}

	public static DataOneDay volumeMinOneMonth(STOCK stock, MONTH month) {
		ArrayList<DataOneDay> data = getDataOneMonthOneStock(stock, month);

		if (data.size() == 0) {
			throw new NullPointerException();
		}

		return data.stream().min(Comparator.comparingDouble(DataOneDay::getKL)).get();
	}

	public static DataOneDay volumeMaxOneMonth(STOCK stock, MONTH month) {
		ArrayList<DataOneDay> data = getDataOneMonthOneStock(stock, month);

		if (data.size() == 0) {
			throw new NullPointerException();
		}

		return data.stream().max(Comparator.comparingDouble(DataOneDay::getKL)).get();
	}

	public static long volumeSumOneMonth(STOCK stock, MONTH month) {
		ArrayList<DataOneDay> data = getDataOneMonthOneStock(stock, month);
		long sum = 0L;
		Iterator<DataOneDay> iter = data.iterator();
		while (iter.hasNext()) {
			sum += iter.next().getKL();
		}
		return sum;
	}

	/*
	 * Get Info
	 */

	//	getInfo One Day
	private static Map<STOCK, DataOneDay> getMapOneDay(Date date, Map<STOCK, DataOneStock> map ) {
		Map<STOCK, DataOneDay> data = new LinkedHashMap<>();
		for (Map.Entry<STOCK, DataOneStock> element : map.entrySet()) {
			data.put(element.getKey(), element.getValue().getDataOneDay(date));
		}
		return data;
	}
	
	public static Map<STOCK, DataOneDay>  getToday(Date date){
		return getMapOneDay(date, datashare);
	}
	
	public static Map<STOCK, DataOneDay>  getTodayVN30(Date date){
		return getMapOneDay(date, Data.getDataVN30());
	}
	
	public static Map<STOCK, DataOneDay>  getTodayHNX30(Date date){
		return getMapOneDay(date, Data.getDataHNX30());
	}

	
	// 	getInfo Some Day
	private static Map<STOCK, ArrayList<DataOneDay>> getMap(Date dateBefore, Date dateAfter, Map<STOCK, DataOneStock> map ) {
		long dayBefore = dateBefore.getTime();
		long dayAfter = dateAfter.getTime();
		Map<STOCK, ArrayList<DataOneDay>> data = new LinkedHashMap<>();
		for (Map.Entry<STOCK, DataOneStock> element : map.entrySet()) {
			data.put(element.getKey(), element.getValue().getData().stream()
												.filter(dataOneDay -> {
												long date = dataOneDay.getDate().getTime();
												return (date <= dayAfter && date >= dayBefore);
												}).collect(Collectors.toCollection(ArrayList::new))
					);
		}
		return data;
	}
	
	public static Map<STOCK, ArrayList<DataOneDay>> getInfo(Date dateBefore, Date dateAfter){
		return getMap(dateBefore, dateAfter, datashare);
	}
	
	public static Map<STOCK, ArrayList<DataOneDay>> getInfoVN30(Date dateBefore, Date dateAfter){
		return getMap(dateBefore, dateAfter, Data.getDataVN30());
	}
	
	public static Map<STOCK, ArrayList<DataOneDay>> getInfoHNX30(Date dateBefore, Date dateAfter){
		return getMap(dateBefore, dateAfter, Data.getDataHNX30());
	}

	
	//	28/4
	private static double formatsDouble(double d) {
		return (double)Math.round(d*100)/100;
	}
	
	private static double getDifference(DataOneDay dataOneDay) {
		return formatsDouble(dataOneDay.getGiaDongCua() - dataOneDay.getGiaMoCua());
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
		for (STOCK stock : STOCK.values()) {
			difference.put(stock, getDifferenceOneDayOneStockVN30(stock, date));
		}
		return difference;
	}
	
	public static Map<STOCK, Double> getDifferenceOneDayHNX30(Date date) {
		Map<STOCK, Double> difference = new LinkedHashMap<>();
		for (STOCK stock : STOCK.values()) {
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
				}else {
					break;
				}
			}
		}else {
			while(iterator.hasNext()) {
				DataOneDay dataOneDay= iterator.next();
				if(dataOneDay.getGiaDongCua() > price) {
					price = dataOneDay.getGiaDongCua();
					i++;
					continue;
				}else {
					break;
				}
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
			data.put(stock, Counter(stock, date, true, Data.getDataVN30()));
		}
		return data;
	}
	
	public static Map<STOCK, Integer> increseCounterHNX30(Date date) {
		Map<STOCK, Integer> data = new LinkedHashMap<>();
		for (STOCK stock : stockHNX30()) {
			data.put(stock, Counter(stock, date, true, Data.getDataHNX30()));
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
			data.put(stock, Counter(stock, date, false, Data.getDataVN30()));
		}
		return data;
	}
	
	public static Map<STOCK, Integer> decreseCounterHNX30(Date date) {
		Map<STOCK, Integer> data = new LinkedHashMap<>();
		for (STOCK stock : stockHNX30()) {
			data.put(stock, Counter(stock, date, false, Data.getDataHNX30()));
		}
		return data;
	}
}




