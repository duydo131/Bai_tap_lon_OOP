package stock_code_analization;

import java.util.Date;

import input.STOCK;

public class ExchangeChangingSentence extends ChangingSentence{
	public ExchangeChangingSentence(Date date, STOCK stock) {
		super(date,stock);
		type="";
		typeStatus=status.exchangeChangingStatus();
	}
  
  
	public void setTag() {
		super.setTag();
		listTag.add("tăng");
		listTag.add("giảm");
		listTag.add("VNINDEX");
		listTag.add("HASTC");
		listTag.add("%");
	}
	public String get() {
		if(status.stock!=STOCK.VNINDEX&&status.stock!=STOCK.HASTC) {
			return typeStatus;
		}else {
			if(status.weekendCheck()) {
				return typeStatus;
			} else {
				return "Trong ngày qua, sàn "+status.stock+" đã "+typeStatus;
			}	
		}
	}  
  
	public void createSentence() {
		if(status.stock!=STOCK.VNINDEX&&status.stock!=STOCK.HASTC) {
			System.out.println(typeStatus);
		}else {
			if(status.weekendCheck()) {
				System.out.println(typeStatus);
			} else {
				System.out.println("Trong ngày qua, sàn "+status.stock+" đã "+typeStatus);
			}	
		}
	}
}
