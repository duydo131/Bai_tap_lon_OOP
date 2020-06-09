package Input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		
		Date date = formats.parse("20/02/2020");
		STOCK stock = STOCK.BID;
//		int j = 0;
//		for (Map.Entry<STOCK, DataOneStock> item : InputData.getDatashare().entrySet()) {
//			ArrayList<DataOneDay> data = item.getValue().getData();
//			System.out.print(++j + " : " + item.getKey() + " : " + (data.get(data.size()-1).getDate().getTime() == date2.getTime()) + "\n");
//		}
		
		System.out.println(InputData.volumeSumOneWeek(stock, date));
		
//2668220

		
	}
}
