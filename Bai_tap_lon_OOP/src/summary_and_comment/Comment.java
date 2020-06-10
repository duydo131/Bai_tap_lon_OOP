package summary_and_comment;

import java.util.ArrayList;
import java.util.Date;

import gui.Tag;
import input.STOCK;
import stock_code_analization.Status;

public abstract class Comment implements Tag{
	public Status status;
	public String type;
	public String typeStatus;

	public ArrayList<String> listTag;
	
	public Comment(Date date, STOCK stock) {
		status= new Status(date,stock);
		listTag = new ArrayList<String>();
	}
	
	public ArrayList<String> getTag(){
		setTag();
		return listTag;
	}

	@Override
	public void setTag() {
		listTag.add("comment");
		listTag.add("oneStock");
	}
}
