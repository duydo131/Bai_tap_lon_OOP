package duy;

import java.util.LinkedList;

import Input.DataOneDay;
import Input.STOCK;

public abstract class OneStockRoot {
	protected STOCK stock;
	protected LinkedList<DataOneDay> dataOneDay = new LinkedList<>();
	
	public abstract String get();
}
