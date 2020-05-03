package Input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


public class Main {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();


		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formats.parse("28/2/2020");
		
		
		//	lấy giá đóng cửa của cổ phiếu của ngày được chọn
		Map<STOCK, DataOneDay> info =  InputData.getTodayVN30(date);
		DataOneDay data = info.get(STOCK.BID);
		System.out.println(data.getGiaDongCua());
		
		System.out.println(InputData.priceMaxOneMonth(STOCK.VNINDEX, MONTH.JANUARY).getGiaDongCua());
		
		
//		InputData.priceMaxOneWeek(STOCK.BID, date).print();
//			
//		System.out.println(InputData.volumeSumOneMonth(STOCK.BID, MONTH.getName(InputData.getMonth(date))));;
//		
//		InputData.priceMaxOneMonth(STOCK.BID, MONTH.JANUARY).print();
		
		System.out.println(InputData.getStockByNumericalVN30(date, 1)); 
	}
}
