package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

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
		
		LinkedList<String> li = new LinkedList<>(); 
		li.add("abc");
		li.add("a");
		li.add("ab");
		li.add("abc");
		li.add("ab");
		li.add("abc");
		
		StringBuffer string = new StringBuffer();
		li.stream().distinct().forEach(str -> string.append(str + "\n"));
		System.out.println(string.toString());
	}
}

