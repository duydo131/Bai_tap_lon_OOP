package Input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class InputData {

	private static SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
	private static Map<String, DataOneStock> datashare = new LinkedHashMap<>();

	static {
		for (Map.Entry<String, DataOneStock> item : Data.getDataVN30().entrySet()) {
			datashare.put(item.getKey(), item.getValue());
		}
		for (Map.Entry<String, DataOneStock> item : Data.getDataHNX30().entrySet()) {
			datashare.put(item.getKey(), item.getValue());
		}
	}

	public static boolean testDay(Date date) {
		ArrayList<DataOneDay> dataVNindex = Data.getDataVN30().get("^VNINDEX").getData();
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

	public static ArrayList<DataOneDay> getDataOneWeek(STOCK stock, Date date) {
		String name = stock.name();
		return datashare.get(name).getData().stream()
				.filter(DataOneDay -> chooseWeek(DataOneDay, date)).collect(Collectors.toCollection(ArrayList::new));
	}

	public static DataOneDay priceMaxOneWeek(STOCK stock, Date date) {
		ArrayList<DataOneDay> data = getDataOneWeek(stock, date);

		if (data.size() == 0) {
			throw new NullPointerException();
		}

		return data.stream().max(Comparator.comparingDouble(DataOneDay::getGiaDongCua)).get();
	}

	public static DataOneDay priceMinOneWeek(STOCK stock, Date date) {
		ArrayList<DataOneDay> data = getDataOneWeek(stock, date);

		if (data.size() == 0) {
			throw new NullPointerException();
		}

		return data.stream().min(Comparator.comparingDouble(DataOneDay::getGiaDongCua)).get();
	}

	public static DataOneDay volumeMinOneWeek(STOCK stock, Date date) {
		ArrayList<DataOneDay> data = getDataOneWeek(stock, date);

		if (data.size() == 0) {
			throw new NullPointerException();
		}

		return data.stream().min(Comparator.comparingDouble(DataOneDay::getKL)).get();
	}

	public static DataOneDay volumeMaxOneWeek(STOCK stock, Date date) {
		ArrayList<DataOneDay> data = getDataOneWeek(stock, date);

		if (data.size() == 0) {
			throw new NullPointerException();
		}

		return data.stream().max(Comparator.comparingDouble(DataOneDay::getKL)).get();
	}

	public static long volumeSumOneWeek(STOCK stock, Date date) {
		ArrayList<DataOneDay> data = getDataOneWeek(stock, date);

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

	public static ArrayList<DataOneDay> getDataOneMonth(STOCK stock, MONTH month) {
		String name = stock.name();
		return datashare.get(name).getData().stream()
				.filter(DataOneDay -> chooseMonth(DataOneDay, month.getMonth())).collect(Collectors.toCollection(ArrayList::new));
	}

	public static DataOneDay priceMaxOneMonth(STOCK stock, MONTH month) {
		ArrayList<DataOneDay> data = getDataOneMonth(stock, month);

		if (data.size() == 0) {
			throw new NullPointerException();
		}

		return data.stream().max(Comparator.comparingDouble(DataOneDay::getGiaDongCua)).get();
	}

	public static DataOneDay priceMinOneMonth(STOCK stock, MONTH month) {
		ArrayList<DataOneDay> data = getDataOneMonth(stock, month);

		if (data.size() == 0) {
			throw new NullPointerException();
		}

		return data.stream().min(Comparator.comparingDouble(DataOneDay::getGiaDongCua)).get();
	}

	public static DataOneDay volumeMinOneMonth(STOCK stock, MONTH month) {
		ArrayList<DataOneDay> data = getDataOneMonth(stock, month);

		if (data.size() == 0) {
			throw new NullPointerException();
		}

		return data.stream().min(Comparator.comparingDouble(DataOneDay::getKL)).get();
	}

	public static DataOneDay volumeMaxOneMonth(STOCK stock, MONTH month) {
		ArrayList<DataOneDay> data = getDataOneMonth(stock, month);

		if (data.size() == 0) {
			throw new NullPointerException();
		}

		return data.stream().max(Comparator.comparingDouble(DataOneDay::getKL)).get();
	}

	public static long volumeSumOneMonth(STOCK stock, MONTH month) {
		ArrayList<DataOneDay> data = getDataOneMonth(stock, month);

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

	private static Map<String, DataOneDay> getMapOneDay(Date date, Map<String, DataOneStock> map ) {
		Map<String, DataOneDay> data = new LinkedHashMap<>();
		for (Map.Entry<String, DataOneStock> element : map.entrySet()) {
			data.put(element.getKey(), element.getValue().getDataOneDay(date));
		}
		return data;
	}
	
	public static Map<String, DataOneDay>  getToday(Date date){
		return getMapOneDay(date, datashare);
	}
	
	public static Map<String, DataOneDay>  getTodayVN30(Date date){
		return getMapOneDay(date, Data.getDataVN30());
	}
	
	public static Map<String, DataOneDay>  getTodayHNX30(Date date){
		return getMapOneDay(date, Data.getDataHNX30());
	}

	
	private static Map<String, DataOneStock> getMap(Date dateBefore, Date dateAfter, Map<String, DataOneStock> map ) {
		long dayBefore = dateBefore.getTime();
		long dayAfter = dateAfter.getTime();
		
		Map<String, DataOneStock> data = new LinkedHashMap<>();

		for (Map.Entry<String, DataOneStock> element : map.entrySet()) {
			DataOneStock dataOneStock = new DataOneStock();
			dataOneStock.setData(element.getValue().getData().stream().filter(dataOneDay -> {
				long date = dataOneDay.getDate().getTime();
				return (date <= dayAfter && date >= dayBefore);
			}).collect(Collectors.toCollection(ArrayList::new)));
			
			data.put(element.getKey(), dataOneStock);
		}
		
		return data;
	}
	
	public static Map<String, DataOneStock> getInfo(Date dateBefore, Date dateAfter){
		return getMap(dateBefore, dateAfter, datashare);
	}
	
	public static Map<String, DataOneStock> getInfoVN30(Date dateBefore, Date dateAfter){
		return getMap(dateBefore, dateAfter, Data.getDataVN30());
	}
	
	public static Map<String, DataOneStock> getInfoHNX30(Date dateBefore, Date dateAfter){
		return getMap(dateBefore, dateAfter, Data.getDataHNX30());
	}
}




