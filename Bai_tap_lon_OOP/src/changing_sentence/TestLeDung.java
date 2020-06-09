package changing_sentence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Input.ReadFile;

public class TestLeDung {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		
		Date weekend = formats.parse("14/12/2019");
		Date date = formats.parse("13/12/2019");
		

		OverAllDayVN30 p3 = new OverAllDayVN30(weekend);
		System.out.println(p3.get());
		System.out.println(p3.getTag());
		System.out.println();
		
		OverAllDayVN30 p4 = new OverAllDayVN30(date);
		System.out.println(p4.get());
		System.out.println(p4.getTag());
		System.out.println();
		
		OverAllDayHNX30 p5 = new OverAllDayHNX30(weekend);
		System.out.println(p5.get());
		System.out.println(p5.getTag());
		System.out.println();
		
		OverAllDayHNX30 p6 = new OverAllDayHNX30(date);
		System.out.println(p6.get());
		System.out.println(p6.getTag());
		System.out.println();
		
//		OverAllDayGeneralComment p7 = new OverAllDayGeneralComment(weekend);
//		System.out.println(p7.get());
//		System.out.println(p7.getTag());
//		System.out.println();
//		
//		OverAllDayGeneralComment p8 = new OverAllDayGeneralComment(date);
//		System.out.println(p8.get());
//		System.out.println(p8.getTag());
//		System.out.println();
		

		
	}
}
