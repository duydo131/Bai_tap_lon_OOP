package duy;

import java.util.Date;
import java.util.Map;

import Input.DataOneDay;
import Input.STOCK;

public abstract class San {
	protected String name;
	
	public abstract void setInfo(Date date);
	public abstract String get();
	protected abstract void setList(Map<STOCK, DataOneDay> data);
}
