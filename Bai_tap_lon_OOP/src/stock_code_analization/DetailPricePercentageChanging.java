package stock_code_analization;

import java.util.Date;

import input.STOCK;

public class DetailPricePercentageChanging extends ChangingSentence {
	public DetailPricePercentageChanging(Date date, STOCK stock) {
		  super(date,stock);
		  type="giá";
		  typeStatus=status.stockPricePercentageStatus();
	  }
	
	
	public void setTag() {
		listTag.add("oneStock");
		listTag.add("day");
		listTag.add("tăng");
		listTag.add("giảm");
		listTag.add("giá");
		listTag.add("%");
	}
	public String get() {
		if(!status.weekendCheck()) {
			if(status.stock!=STOCK.VNINDEX&&status.stock!=STOCK.HASTC) {  
				return "Trong ngày qua, "+type+" cổ phiếu " + status.stock + status.statusDaylyPrice() + status.stockPricePercentageStatus();	
			}
			else return "Hãy thay đổi về mã cổ phiếu cụ thể.";
		}
		else return status.stockPricePercentageStatus();
	}	
	public void createSentence() {
		if(!status.weekendCheck()) {
			if(status.stock!=STOCK.VNINDEX&&status.stock!=STOCK.HASTC) {  
				System.out.println("Trong ngày qua, "+type+" cổ phiếu " + status.stock + status.statusDaylyPrice() + status.stockPricePercentageStatus());	
			}
			else System.out.println("Hãy thay đổi về mã cổ phiếu cụ thể.");
		}
		else System.out.println(status.stockPricePercentageStatus());
	}
}