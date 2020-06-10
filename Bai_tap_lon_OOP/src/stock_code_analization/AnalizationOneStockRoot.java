package stock_code_analization;

import java.util.ArrayList;
import java.util.LinkedList;

import gui.Tag;
import input.DataOneDay;
import input.STOCK;

public abstract class AnalizationOneStockRoot implements Tag{
	protected STOCK stock;
	protected LinkedList<DataOneDay> dataOneStock = new LinkedList<>();
	
	protected ArrayList<String> listTag = new ArrayList<>();
	
	@Override
	public void setTag() {
		this.listTag.add("nhận xét");
		this.listTag.add("giá trị");
		this.listTag.add("khối lượng");
		this.listTag.add("thanh khoản");
		this.listTag.add("oneStock");
	}
}
