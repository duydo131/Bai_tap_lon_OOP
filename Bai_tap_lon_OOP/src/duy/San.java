package duy;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import Input.DataOneDay;
import Input.STOCK;
import gui.Tag;

public abstract class San implements Tag{
	protected String name;
	protected ArrayList<String> listTag = new ArrayList<>();
	
	public abstract void setInfo(Date date);
	protected abstract void setList(Map<STOCK, DataOneDay> data);
}
