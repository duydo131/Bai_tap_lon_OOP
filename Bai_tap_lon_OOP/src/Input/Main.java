package Input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();


		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formats.parse("26/12/2019");
		
		InputData.priceMaxOneWeek(STOCK.BID, date).print();
			
		System.out.println(InputData.volumeSumOneMonth(STOCK.BID, MONTH.getName(InputData.getMonth(date))));;
		
		InputData.priceMaxOneMonth(STOCK.BID, MONTH.JANUARY).print();
		
		
	}
}
