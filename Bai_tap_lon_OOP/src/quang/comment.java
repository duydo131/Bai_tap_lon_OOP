package quang;

import java.util.ArrayList;
import java.util.Date;

import Input.STOCK;

public class comment {
	public Status status;
	public String type;
	public String typeStatus;

	public ArrayList<String> listTag;
	public comment(Date date, STOCK stock) {
		status= new Status(date,stock);
		listTag = new ArrayList<String>();
	}
	
	public ArrayList<String> getTag(){
		setTag();
		return listTag;
	}

	public void setTag() {
		
	}
}
