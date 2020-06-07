package quang;

import java.util.ArrayList;
import java.util.Date;

import Input.STOCK;
import gui.Tag;

public class changingSentence implements Tag {
	public Status status;
	public String type;
	public String typeStatus;

	public ArrayList<String> listTag;
	public changingSentence(Date date, STOCK stock) {
		status= new Status(date,stock);
		listTag = new ArrayList<String>();
	}
	
	public ArrayList<String> getTag(){
		setTag();
		return listTag;
	}

	public String get() {
		return "Trong ngày qua, giá cổ phiếu "+status.stock+" đã "+status.stockPriceStatus();
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

	@Override
	public void setTag() {
		// TODO Auto-generated method stub
		
	}
}
