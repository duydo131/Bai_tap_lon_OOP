package stock_code_analization;

import java.util.ArrayList;
import java.util.Date;

import gui.Tag;
import input.STOCK;

public class ChangingSentence implements Tag {
	public Status status;
	public String type;
	public String typeStatus;
	public ArrayList<String> listTag;
	
	
	public ChangingSentence(Date date, STOCK stock) {
		status= new Status(date,stock);
		listTag = new ArrayList<String>();
		typeStatus= status.stockPriceStatus();
		type="giá";
	}
	
	
	public ArrayList<String> getTag(){
		setTag();
		return listTag;
	}
	public void setTag() {
		listTag.add("oneStock");
		listTag.add("day");
		listTag.add("tăng");
		listTag.add("giảm");
		listTag.add("giá");
	}
	public String get() {
		if(!status.weekendCheck()) {
			if(status.stock!=STOCK.VNINDEX&&status.stock!=STOCK.HASTC) {
				return "Trong ngày qua, "+type+" cổ phiếu "+status.stock+" đã "+typeStatus;
			}
			else  return status.stockPriceStatus();
		  }
		  else return status.stockPriceStatus();
	}
	public void createSentence() {
	  if(!status.weekendCheck()) {
		if(status.stock!=STOCK.VNINDEX&&status.stock!=STOCK.HASTC) {
			System.out.println("Trong ngày qua, "+type+" cổ phiếu "+status.stock+" đã "+typeStatus);
		}
		else  System.out.println(status.stockPriceStatus());
	  }
	  else System.out.println(status.stockPriceStatus());
	}
}

