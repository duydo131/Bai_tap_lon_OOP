package gui;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import Input.DataOneDay;
import Input.Format;
import Input.InputData;
import Input.MONTH;
import Input.ReadFile;
import Input.STOCK;
import duy.Cau1;
import duy.Cau1VN30;

public class test {
	public static int getDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int i = calendar.get(Calendar.DAY_OF_MONTH);
		int numberOfDays;
		switch (i) {
		case 10:
		case 12:
		case 1:
			numberOfDays = 31;
			break;
		case 11:
			numberOfDays = 30;
			break;
		case 2:
			numberOfDays = 28;
			break;
		default:
			throw new NullPointerException();
		}
		return numberOfDays;
	}
	
	public static boolean testMonth(Date date) {
		boolean test = false;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if(calendar.get(Calendar.DAY_OF_MONTH) == getDayOfMonth(date)) {
			test = true;
		}else {
			ArrayList<DataOneDay> listDataOneDay = InputData.getDatashare().get(STOCK.VNINDEX).getData();
		 	ArrayList<Date> listDate = listDataOneDay.stream()
		 								.map(DataOneDay -> DataOneDay.getDate())
		 								.collect(Collectors.toCollection(ArrayList::new));
		 	int index = listDate.indexOf(date);
		 	Date dateNow = date;
		 	while(index == -1) {
		 		dateNow = Format.getDate(dateNow, -1);
		 		index = listDate.indexOf(dateNow);
		 	}
		 	
		 	
		}
		return test;
	}
	
	public static void main(String[] args) throws ParseException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ReadFile.loadData();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date date = f.parse("24/02/2020");
//		Date date1 = f.parse("28/02/2020");
//		
//		
//		
//		;
////		for (Map.Entry<STOCK, Double> item : InputData.getDifferenceOneDayVN30(date1).entrySet()) {
////			System.out.println(item.getKey().name() + ":" + item.getValue());
////			
////		}
//		
////		for (Map.Entry<STOCK, DataOneDay> element : InputData.getToday(date1).entrySet()) {
////			System.out.println(element.getKey());
////			element.getValue().print();
////		}
		
		ArrayList<Tag> list = new ArrayList<>();
		Tag cau1 = new Cau1VN30(date);
		list.add(cau1);
		list.get(0).getTag();
		
		System.out.println(cau1.getClass());


		Constructor<?> constructor = Cau1VN30.class.getConstructor(Date.class);
		Cau1 c = (Cau1) constructor.newInstance(date);
		System.out.println(c.get());
		
		
	}
}
