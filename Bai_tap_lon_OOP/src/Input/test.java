package Input;

import java.io.DataInput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class test {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		
		Date date = formats.parse("18/02/2020");
		Date date1 = formats.parse("28/02/2020");
		
//		System.out.println(InputData.getDifferenceOneDayOneStock(STOCK.ACB, date));

//		System.out.println(InputData.getDifferenceOneDay(date));
		
		System.out.println(InputData.increseCounterOneStock(STOCK.BID, date));
		System.out.println(InputData.decreseCounterOneStock(STOCK.BID, date1));
		
		int i = 0;
		for (Map.Entry<STOCK, Integer> item : InputData.increseCounterVN30(date).entrySet()) {
			System.out.println(++i + " : " + item.getKey() + " : " + item.getValue());
		}
		
//		Data.print();
		
	}
}
