package Sentences;

import Input.STOCK;
import gui.Tag;

import java.util.ArrayList;
import java.util.Date;

<<<<<<< HEAD
public class ComparisionHNX30 extends ComparisionEXCHANGES{
=======
public class ComparisionHNX30 extends ComparisionEXCHANGES implements Tag {
>>>>>>> 586f98c58434d2a835765c773c4d04b6fd59ecf0
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
		setTag();
		return this.listTag;
	}

	@Override
	public void setTag() {
		super.setTag();
		this.listTag.add("HNX30");
		this.listTag.add("Hà Nội");
	}

}
