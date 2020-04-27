package Input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		ReadFile.loadData();


		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		
		try {

			InputData.priceMaxOneWeek(Stock.BID, formats.parse("03/01/2020")).print();
			
			System.out.println(InputData.volumeSumOneWeek(Stock.BID, formats.parse("03/01/2020")));;
		} catch (Exception e) {
			System.out.println("Exception");;
		}
		
//		System.out.println(Stock.BID.name());
//		
//		ReadFile.loadData();
//		
//		Set<String> keyHNX = Data.getDataHNX30().keySet();
//		Set<String> keyVN = Data.getDataVN30().keySet();
//		
//		int i = 0;
//		for (String string : keyVN) {
//			if(string.equals("^HASTC")) {
//				string = "HASTC";
//			}else if(string.equals("^VNINDEX")) {
//				string = "VNINDEX";
//			}
//			
//			System.out.println(++i + " : " + Stock.valueOf(string).getName());
//		}
	}
}
