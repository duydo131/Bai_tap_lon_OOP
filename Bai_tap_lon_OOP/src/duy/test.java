package duy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import Input.DataOneDay;
import Input.Format;
import Input.InputData;
import Input.ReadFile;
import Input.STOCK;

public class test {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formats.parse("23/02/2020");
		Date date1 = Format.getDate(date, -6);
		
		
		
		System.out.println((new Phien()).setInfo(date1, STOCK.VNINDEX).get());
		System.out.println((new Phien()).setInfo(date1, STOCK.HASTC).get());
		
		// ngày phải là cuối tuần
		System.out.println((new Week()).setInfo(date, STOCK.VNINDEX).get());
		System.out.println((new Week()).setInfo(date, STOCK.HASTC).get());
		

		
		System.out.println((new Cau1VN30(date1)).get());
		System.out.println((new Cau1HNX30(date1)).get());
		
		System.out.println((new Cau2VN30(date1)).get());
		System.out.println((new Cau2HNX30(date1)).get());
		
	}
}
