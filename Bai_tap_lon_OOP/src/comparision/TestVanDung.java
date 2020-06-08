package comparision;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Input.ReadFile;

public class TestVanDung {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();

		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formats.parse("02/02/2020");
		ComparisionStockHot a = new ComparisionStockHot(date);
		ComparisionVN30 b = new ComparisionVN30(date);
		ComparisionRandom c = new ComparisionRandomVN30(date);
		ComparisionRandom e = new ComparisionRandomHNX30(date);
		ComparisionHNX30 d = new ComparisionHNX30(date);
		System.out.println(a.get());
		System.out.println(a.getTag());
		System.out.println(b.get());
		System.out.println(b.getTag());
		System.out.println(c.get());
		System.out.println(c.getTag());
		System.out.println(d.get());
		System.out.println(d.getTag());
		System.out.println(e.get());
		System.out.println(e.getTag());
		
		
	}
}