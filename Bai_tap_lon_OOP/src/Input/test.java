package Input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class test {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		
		Date date = formats.parse("24/02/2020");
		Date date1 = formats.parse("25/02/2020");
		
		int i = 0;
		
		for (Map.Entry<String, DataOneDay> item : InputData.getTodayVN30(date).entrySet() ) {
			System.out.println(++i + " : " + item.getKey());
			item.getValue().print();
		}
		
	}
}
