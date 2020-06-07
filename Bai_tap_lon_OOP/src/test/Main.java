package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Input.ReadFile;
import Input.STOCK;
import Input.Tool;
import gui.Demo;
import gui.Tag;

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
		System.out.println(demo.getSentence("HASTC", "chung", "so sánh"));
		
	}
}

