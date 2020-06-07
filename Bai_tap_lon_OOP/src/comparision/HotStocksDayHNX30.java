package comparision;
import java.util.ArrayList;
import java.util.Date;

import Input.InputData;

public class HotStocksDayHNX30 extends HotStocksDay{

	public HotStocksDayHNX30(Date date) {
		super(date);
		this.subject = "HNX30";
		setTag();
	}

	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}

	@Override
	public String get() {
		
		if (InputData.isWeekend(date)) {
			HotStocksWeekHNX30 sentence = new HotStocksWeekHNX30(date);
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
