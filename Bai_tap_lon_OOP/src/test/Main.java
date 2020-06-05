package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Input.ReadFile;
import Input.STOCK;
import Input.Tool;
import duy.Cau1VN30;
import duy.DayHNX30;
import duy.OneStock1;
import duy.WeekHNX30;
import gui.Demo;
import ledung.DayTitle;

public class Main {
	
	public static void main(String[] args) throws ParseException{
		ReadFile.loadData();
		
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat formats = new SimpleDateFormat(pattern);
		Date date = formats.parse("20/02/2020");
		//System.out.println(date);
		Date date1 = Tool.getDate(date, 2);
		STOCK stock = STOCK.BID;
		
		Demo demo = new Demo(date, stock);
		
		ArrayList<String> listTag1 = new ArrayList<>();
		
		listTag1.add("title");
		
		ArrayList<String> listTag2 = new ArrayList<>();
		
		listTag2.add("HNX30");
		
		System.out.println(demo.getSentence(listTag1));
		
		System.out.println(demo.getSentence(listTag2));
//		
//		DayTitle dayTitle = new DayTitle(date);
//		System.out.println(dayTitle.get());
//		System.out.println(dayTitle.getTag());
		
//		Cau1VN30 cau = new Cau1VN30(date1);
//		System.out.println(cau.getTag());
		
		OneStock1 oneStock1 = new OneStock1(stock, date1);
		System.out.println(oneStock1.get());
	}
}

