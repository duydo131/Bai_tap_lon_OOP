package input;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Tool {
	public static double formatsDouble(double d) {
		return (double)Math.round(d*100)/100;
	}
	
	public static Date getDate(Date date, int number) {
		long oneDay = 24*60*60*1000;
		return new Date(date.getTime() + number*oneDay);
	}
	
	public static String formatLong(Long number) {
		return number > 1000000 ? Tool.formatsDouble(number*1.0/1000000) + " triệu" : String.valueOf(number);
	}
	
	public static long formatMoney(double money) {
		return 10*(long)(Tool.formatsDouble(money)*100) ;
	}
	
	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}
	
	public static boolean testMonth(Date date) {
		boolean test = false;
		ArrayList<DataOneDay> listDataOneDay = InputData.getDatashare().get(STOCK.VNINDEX).getData();
		ArrayList<Date> listDate = listDataOneDay.stream().map(DataOneDay -> DataOneDay.getDate())
				.collect(Collectors.toCollection(ArrayList::new));
		int index = listDate.indexOf(date);
		Date dateNow = new Date(date.getTime());
		while (index == -1) {
			dateNow = Tool.getDate(dateNow, -1);
			index = listDate.indexOf(dateNow);
		}
		if (Tool.getMonth(dateNow) == Tool.getMonth(date)) {
			if (index == 0) {
				test = true;
			} else if (Tool.getMonth(dateNow) != Tool.getMonth(listDate.get(index - 1))) {
				test = true;
			}
		}
		return test;
	}
	
	public static Map<STOCK, DataOneDay> sort(Map<STOCK, DataOneDay> data){
		ArrayList<Map.Entry<STOCK, DataOneDay>> list = new ArrayList<>(data.entrySet());
		Collections.sort(list, new Comparator<Entry<STOCK, DataOneDay>>() {
			@Override
			public int compare(Entry<STOCK, DataOneDay> o1, Entry<STOCK, DataOneDay> o2) {
				return o1.getValue().getKL() > o2.getValue().getKL() ? -1 : 1;
			}
		});
		Map<STOCK, DataOneDay> sorted = new LinkedHashMap<>();
		for (Map.Entry<STOCK, DataOneDay> entry : list) {
			sorted.put(entry.getKey(), entry.getValue());
		}
		return sorted;
	}
}
