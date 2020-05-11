package gui;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Input.DataOneDay;
import Input.InputData;
import Input.MONTH;
import Input.ReadFile;
import Input.STOCK;

public class test {
	
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date date = f.parse("27/02/2020");
		Date date1 = f.parse("28/02/2020");
		
		
		
		;
//		for (Map.Entry<STOCK, Double> item : InputData.getDifferenceOneDayVN30(date1).entrySet()) {
//			System.out.println(item.getKey().name() + ":" + item.getValue());
//			
//		}
		
//		for (Map.Entry<STOCK, DataOneDay> element : InputData.getToday(date1).entrySet()) {
//			System.out.println(element.getKey());
//			element.getValue().print();
//		}
		
		
	}
}
