package ledung;

import java.util.ArrayList;
import java.util.Date;

import Input.InputData;

public class HotStocksDayVN30 extends HotStocksDay{

	public HotStocksDayVN30(Date date) {
		super(date);
		this.subject = "VN30";
	}

	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}

	@Override
	public String get() {
		
		if (InputData.isWeekend(date)) {
			HotStocksWeekVN30 sentence = new HotStocksWeekVN30(date);
			return sentence.get();
		}
		else {
			return super.getSentence(this.subject);
		}
	}
	
	@Override
	public void setTag() {
		listTag.add("hot stocks");
	}
	
}
