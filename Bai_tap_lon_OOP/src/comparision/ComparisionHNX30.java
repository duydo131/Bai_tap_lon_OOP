package comparision;

import java.util.ArrayList;
import java.util.Date;

import input.STOCK;

public class ComparisionHNX30 extends ComparisionEXCHANGES{
	public ComparisionHNX30(Date date) {
		this.date = date;
	}

	@Override
	protected STOCK DataStock(int numberrical) {
		STOCK Stock;
		Stock = input.InputData.getStockByNumericalHNX30(date, numberrical);
		return Stock;
	}

	@Override
	public ArrayList<String> getTag() {
		setTag();
		return this.listTag;
	}

	@Override
	public void setTag() {
		super.setTag();
		this.listTag.add("HASTC");
		this.listTag.add("HNXINDEX");
		this.listTag.add("Hà Nội");
	}

}
