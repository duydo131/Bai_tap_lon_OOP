package comparision;

import java.util.ArrayList;
import java.util.Date;

import Input.STOCK;

public class ComparisionRandomHNX30 extends ComparisionRandom{
	public ComparisionRandomHNX30(Date date) {
		this.date = date;
	}

	@Override
	protected STOCK dataStock(int number) {
		STOCK Stock;
		Stock = Input.InputData.getStockByNumericalHNX30(date, number);
		return Stock;
	}
                                                                                                                                                                                          
	@Override
	public void setTag() {
		super.setTag();
		this.listTag.add("HASTC");
		this.listTag.add("HNXINDEX");
		this.listTag.add("Hà Nội");
	}
	
	@Override
	public ArrayList<String> getTag() {
		setTag();
		return this.listTag;
	}
}
