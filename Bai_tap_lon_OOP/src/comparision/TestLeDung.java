package comparision;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import input.ReadFile;

public class TestLeDung {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		
		Date weekend = formats.parse("14/12/2019");
		Date date = formats.parse("13/12/2019");
		
		HotStocksDayHNX30 p1 = new HotStocksDayHNX30(weekend);
		System.out.println(p1.get());
		System.out.println(p1.getTag());
		
		HotStocksDayHNX30 a1 = new HotStocksDayHNX30(date);
		System.out.println(a1.get());
		System.out.println(a1.getTag());
		
		HotStocksDayVN30 p2 = new HotStocksDayVN30(weekend);
		System.out.println(p2.get());
		System.out.println(p2.getTag());
		
		HotStocksDayVN30 a2 = new HotStocksDayVN30(date);
		System.out.println(a2.get());
		System.out.println(a2.getTag());
		
		System.out.println();
	}
}
