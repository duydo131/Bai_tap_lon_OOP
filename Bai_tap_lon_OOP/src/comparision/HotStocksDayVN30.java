package comparision;

import java.util.ArrayList;
import java.util.Date;

import Input.InputData;

public class HotStocksDayVN30 extends HotStocksDay{

	public HotStocksDayVN30(Date date) {
		super(date);
		this.subject = "VN30";
		setTag();
	}

	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}

	@Override
	public String get() {
		
		if (InputData.isWeekend(date)) {
			HotStocksWeekVN30 sentence = new HotStocksWeekVN30(date);
			setTag("weekend");
			return sentence.get();
		}
		else {
			setTag("day");
			return super.getSentence(this.subject);
		}
	}
	
	@Override
	public void setTag() {
		super.setTag();
		listTag.add("VNINDEX");
		this.listTag.add("HOSE");
		this.listTag.add("Thành phố Hồ Chí Minh");
	}
	
}
