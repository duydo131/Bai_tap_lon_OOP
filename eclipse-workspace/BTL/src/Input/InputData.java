package Input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

public class InputData {
	private static Map<String, DataOneStock> dataVN30 = Data.getDataVN30();
	private static Map<String, DataOneStock> dataHNX30 = Data.getDataHNX30();
	private static Map<String, DataOneStock> datashare = null;
	private static SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
	
	static {
		 datashare = dataVN30;
		 for (Map.Entry<String, DataOneStock> item : dataHNX30.entrySet()) {
			datashare.put(item.getKey(), item.getValue());
		}
	}
	
	public static boolean testDay(Date date) {
		ArrayList<DataOneDay> dataVNindex = dataVN30.get("^VNINDEX").getData();
		for (DataOneDay dataOneDay : dataVNindex) {
			if(date.getTime() == dataOneDay.getDate().getTime()) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Week
	 * @param date
	 * @return
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
	
	
	private static ArrayList<DataOneDay> createDataOneWeek(Stock stock, Date date){
		String name = stock.name();
		return (ArrayList<DataOneDay>) datashare.get(name).getData()
											.stream()
											.filter(DataOneDay -> chooseWeek(DataOneDay, date))
											.collect(Collectors.toList());
	}
	

	public static DataOneDay priceMaxOneWeek(Stock stock, Date date) {
		ArrayList<DataOneDay> data = createDataOneWeek(stock, date);
		
		if(data.size() == 0) {
			throw new NullPointerException();
		}
		
		return data.stream().max(Comparator.comparingDouble(DataOneDay->DataOneDay.getGiaDongCua())).get();
	}
	
	
	public static DataOneDay priceMinOneWeek(Stock stock, Date date) {
		ArrayList<DataOneDay> data = createDataOneWeek(stock, date);
		
		if(data.size() == 0) {
			throw new NullPointerException();
		}
		
		return data.stream().min(Comparator.comparingDouble(DataOneDay->DataOneDay.getGiaDongCua())).get();
	}
	
	
	public static DataOneDay volumeMinOneWeek(Stock stock, Date date) {
		ArrayList<DataOneDay> data = createDataOneWeek(stock, date);
		
		if(data.size() == 0) {
			throw new NullPointerException();
		}
		
		return data.stream().min(Comparator.comparingDouble(DataOneDay->DataOneDay.getKL())).get();
	}
	
	
	public static DataOneDay volumeMaxOneWeek(Stock stock, Date date) {
		ArrayList<DataOneDay> data = null;
		data = createDataOneWeek(stock, date);
		
		if(data.size() == 0) {
			throw new NullPointerException();
		}
		
		return data.stream().max(Comparator.comparingDouble(DataOneDay->DataOneDay.getKL())).get();
	}
	
	
	public static long volumeSumOneWeek(Stock stock, Date date) {
		ArrayList<DataOneDay> data = createDataOneWeek(stock, date);
		
		long sum = 0L;
		
		Iterator<DataOneDay> iter = data.iterator(); 
		
		while(iter.hasNext()) {
			sum += iter.next().getKL();
		}
		
		return sum;
	}

	
}