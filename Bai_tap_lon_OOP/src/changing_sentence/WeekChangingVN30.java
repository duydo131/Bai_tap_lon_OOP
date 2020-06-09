package changing_sentence;

import java.util.ArrayList;
import java.util.Date;

import Input.STOCK;

public class WeekChangingVN30 extends WeekChanging{
	public WeekChangingVN30(Date date) {
		this.date = date;
		this.stock = STOCK.VNINDEX;
		setInfo();
		super.setTag();
		this.setTag();
	}

	@Override
	public ArrayList<String> getTag() {
		return this.listTag;
	}
	
	@Override
	public void setTag() {
		this.listTag.add("HOSE");
		this.listTag.add("VNINDEX");
		this.listTag.add("Hồ Chí Minh");
	}
}
