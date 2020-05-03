package duy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import Input.Caculate;
import Input.DataOneDay;
import Input.InputData;
import Input.ReadFile;
import Input.STOCK;

public class test2 {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formats.parse("20/02/2020");
		
		int i = 0;
//		for (Map.Entry<STOCK, DataOneDay> item : Caculate.sort(InputData.getTodayVN30(date)).entrySet()) {
//			System.out.println(++i + " : " + item.getKey() + " : " + item.getValue().getKL());
//		}
		Caculate.sort(InputData.getTodayVN30(date));
	}
}
