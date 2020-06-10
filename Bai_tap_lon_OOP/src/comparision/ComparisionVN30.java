package comparision;

import java.util.ArrayList;
import java.util.Date;

import input.STOCK;

public class ComparisionVN30 extends ComparisionEXCHANGES  {
	public ComparisionVN30(Date date) {
		this.date = date;
	}

	@Override
	protected STOCK DataStock(int numberrical) {
		STOCK Stock;
		Stock = input.InputData.getStockByNumericalVN30(date, numberrical);
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
		this.listTag.add("HOSE");
		this.listTag.add("VNINDEX");
		this.listTag.add("Hà Nội");
	}

}
