package duy;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Input.Format;
import Input.InputData;
import Input.ReadFile;
import Input.STOCK;

public class test2 {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formats.parse("28/12/2020");
//		
//		int i = 0;
//		for (Map.Entry<STOCK, DataOneDay> item : Caculate.sort(InputData.getTodayVN30(date)).entrySet()) {
//			System.out.println(++i + " : " + item.getKey() + " : " + item.getValue().getKL());
//		}
//		//Caculate.sort(InputData.getTodayVN30(date));
		
		System.out.println(formats.format(Format.getDate(date, 7)));
		InputData.getDataOneWeekOneStock(STOCK.VNINDEX, date);
		


		
	}
}
