package changing_sentence;

import java.util.ArrayList;
import java.util.Date;

import Input.STOCK;

public class DayVN30 extends Day{
	public DayVN30(Date date) {
		this.date = date;
		this.stock = STOCK.VNINDEX;
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
		this.listTag.add("HOSE");
		this.listTag.add("VN-INDEX");
		this.listTag.add("Hồ Chí Minh");
	}
}
