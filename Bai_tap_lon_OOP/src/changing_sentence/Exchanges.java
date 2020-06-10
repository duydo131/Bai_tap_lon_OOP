package changing_sentence;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import gui.Tag;
import input.DataOneDay;
import input.STOCK;

public abstract class Exchanges implements Tag{
	protected String name;
	protected ArrayList<String> listTag = new ArrayList<>();
	
	public abstract void setInfo(Date date);
	protected abstract void setList(Map<STOCK, DataOneDay> data);
}
