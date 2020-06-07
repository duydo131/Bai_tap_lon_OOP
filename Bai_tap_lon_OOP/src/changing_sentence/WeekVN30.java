package changing_sentence;

import java.util.ArrayList;
import java.util.Date;

import Input.STOCK;

public class WeekVN30 extends Week{
	public WeekVN30(Date date) {
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
		this.listTag.add("VN-INDEX");
		this.listTag.add("Hồ Chí Minh");
	}
}
