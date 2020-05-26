package duy;

import java.util.ArrayList;
import java.util.LinkedList;

import Input.DataOneDay;
import Input.STOCK;
import gui.Tag;

public abstract class OneStockRoot implements Tag{
	protected STOCK stock;
	protected LinkedList<DataOneDay> dataOneDay = new LinkedList<>();
	
	protected ArrayList<String> listTag = new ArrayList<>();
	
	@Override
	public void setTag() {
		this.listTag.add("nhận xét");
		this.listTag.add("giá trị");
		this.listTag.add("khối lượng");
		this.listTag.add("thanh khoản");
	}
}
