package Input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class test {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		
		Date date2 = formats.parse("28/03/2020");
		
		

//		for (STOCK item : InputData.stockVN30()) {
//			System.out.println(item);
//		}

//		for (STOCK item : InputData.stockHNX30()) {
//			System.out.println(item);
//		}
		
//		System.out.println(InputData.testDay(date));
//		System.out.println(InputData.testDay(date2));

//		for (STOCK item : InputData.stockVN30()) {
//			for (DataOneDay dataOneDay : InputData.getDataOneWeekOneStock(item, date)) {
//				System.out.println(dataOneDay.getGiaDongCua());
//			}
//		}
//		for (STOCK item : InputData.stockHNX30()) {
//			for (DataOneDay dataOneDay : InputData.getDataOneWeekOneStock(item, date)) {
//				System.out.println(dataOneDay.getGiaDongCua());
//			}
//		}
		Date date = formats.parse("18/12/2019");
		Date date1 = formats.parse("20/12/2019");
		int i = 0;
		for (DataOneDay item : InputData.getInfoVN30(date, date1).get(STOCK.BVH)) {
			if(item.getGiaDongCua() - item.getGiaMoCua() > 0) {
				i++;
			}
		}
		System.out.println(i); ;
		
	}
}
