package comparision;

import java.util.ArrayList;
import java.util.Date;

import input.STOCK;

public class ComparisionRandomVN30 extends ComparisionRandom {
	public ComparisionRandomVN30(Date date) {
		this.date = date;
	}

	protected STOCK dataStock(int number) {
		STOCK Stock;
		Stock = input.InputData.getStockByNumericalVN30(date, number);
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
		this.listTag.add("VNINDEX");
		this.listTag.add("HOSE");
		this.listTag.add("Hồ Chí Minh");
	}

}
