package Sentences;

import java.util.ArrayList;
import java.util.Date;
import Input.STOCK;

<<<<<<< HEAD
public class ComparisionVN30 extends ComparisionEXCHANGES{
=======
public class ComparisionVN30 extends ComparisionEXCHANGES implements Tag {
>>>>>>> 586f98c58434d2a835765c773c4d04b6fd59ecf0
	public ComparisionVN30(Date date) {
		this.date = date;
		setTag();
	}

	@Override
	protected STOCK DataStock(int numberrical) {
		STOCK Stock;
		Stock = Input.InputData.getStockByNumericalVN30(date, numberrical);
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
		this.listTag.add("VN30");
		this.listTag.add("Hà Nội");
	}

}
