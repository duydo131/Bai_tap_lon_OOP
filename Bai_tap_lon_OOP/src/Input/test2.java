package Input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class test2 {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		
		Date date = formats.parse("15/12/2019");
		ArrayList<DataOneDay> array = InputData.getDataOneWeekOneStock(STOCK.BID, date);
		
		for (DataOneDay dataOneDay : array) {
			dataOneDay.print();
		}
	}
}

