package summary_and_comment;

import java.util.ArrayList;
import java.util.Date;

import Input.STOCK;
import quang.Status;

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
