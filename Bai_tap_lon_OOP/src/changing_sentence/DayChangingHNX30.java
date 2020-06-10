package changing_sentence;

import java.util.ArrayList;
import java.util.Date;

import input.STOCK;

public class DayChangingHNX30 extends DayChanging {
	public DayChangingHNX30(Date date) {
		this.date = date;
		this.stock = STOCK.HASTC;
		setInfo();
		this.setTag();
	}
	
	@Override
	public ArrayList<String> getTag() {
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
