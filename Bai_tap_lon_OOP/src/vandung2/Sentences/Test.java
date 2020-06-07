package Sentences;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Input.ReadFile;

public class Test {
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
		System.out.println(b.get());
		System.out.println(c.get());
		System.out.println(d.get());
		System.out.println(e.get());
		for (int i = 1; i <= 4; i++) {
			System.out.println(a.getTag().get(i));
			System.out.println(b.getTag().get(i));
			System.out.println(c.getTag().get(i));
			System.out.println(d.getTag().get(i));
			System.out.println(e.getTag().get(i));

		}
	}
}