package comparision;

import java.util.ArrayList;
import java.util.Date;
import Input.STOCK;
import gui.Tag;

public class ComparisionVN30 extends ComparisionEXCHANGES implements Tag {
	public ComparisionVN30(Date date) {
		this.date = date;
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
		this.listTag.add("HOSE");
		this.listTag.add("VNINDEX");
		this.listTag.add("Hà Nội");
	}

}
