package duy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import Input.DataOneDay;
import Input.Format;
import Input.InputData;
import Input.MONTH;
import Input.ReadFile;
import Input.STOCK;

public class test {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formats.parse("24/02/2020");
		Date date1 = Format.getDate(date, -3);
		STOCK stock = STOCK.BID;
		
//		for (Map.Entry<STOCK, Double> item : InputData.getDifferenceOneDayVN30(date1).entrySet()) {
//			System.out.println(item.getKey() + " : " + item.getValue());
//		}
		
//		InputData.priceMaxOneWeek(stock, date1).print();
//		OneStock1 oneStock = new OneStock1(stock, date1);
//		System.out.println(oneStock.get());
//		OneStockRoot oneStock = new OneStock2(stock, date1);
//		System.out.println(oneStock.get());
		
//		OneStockRoot oneStockRoot;
//		oneStockRoot = new OneStock2Week(stock, date1);
//		System.out.println(oneStockRoot.get());
//		oneStockRoot = new OneStock2Month(stock, date1);
//		System.out.println(oneStockRoot.get());
//		int i = 0;
//		for (STOCK stoc : InputData.stockShare()) {
//			System.out.println(++i + " : " + stoc);
//		}
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.get(Calendar.MONTH));
		
		
		//System.out.println(InputData.getDifferenceOneDayOneStock(STOCK.BID, date1));
	}
}
