package gui;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Input.ReadFile;
import Input.STOCK;

public class test {
	
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date date = f.parse("11/12/2019");
		
		STOCK stock = STOCK.BID;
		
		
	}
}
