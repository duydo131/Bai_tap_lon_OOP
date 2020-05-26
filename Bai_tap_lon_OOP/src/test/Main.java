package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Input.ReadFile;
import Input.STOCK;
import Input.Tool;
import duy.OneStock1;
import duy.OneStock2Week;

public class Main {
	
	public static void main(String[] args) throws ParseException{
		ReadFile.loadData();
		
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat formats = new SimpleDateFormat(pattern);
		Date date = formats.parse("20/02/2020");
		//System.out.println(date);
		Date date1 = Tool.getDate(date, 2);
		STOCK stock = STOCK.BID;
		
		OneStock1 one1 = new OneStock1(stock, date);
		System.out.println(one1.get());

		OneStock2Week one = new OneStock2Week(stock, date);
		System.out.println(one.get());
		
	}
}


