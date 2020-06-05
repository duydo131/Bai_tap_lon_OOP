package vandung.Sentences;

import Input.STOCK;
import gui.Tag;

import java.util.ArrayList;
import java.util.Date;

public class ComparisionHNX30 extends ComparisionEXCHANGES{
	public ComparisionHNX30(Date date) {
		this.date = date;
		setTag();
	}
	@Override
	protected STOCK DataStock(int numberrical) {
		STOCK Stock;
		Stock = Input.InputData.getStockByNumericalHNX30(date, numberrical);
		return Stock;
	}
	@Override
	public ArrayList<String> getTag() {
		return this.listTag;
	}
	@Override
	public void setTag() {
		super.setTag();
		this.listTag.add("HNX30");
		this.listTag.add("Hà Nội");
	}

}
