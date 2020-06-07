package ledung;

import java.util.ArrayList;
import java.util.Date;

import Input.InputData;

public class OverAllDayHNX30 extends OverAllDayStockClass{

	public OverAllDayHNX30(Date date) {
		super(date, "HNX30");
	}
	
	@Override
	public ArrayList<String> getTag() {
		// TODO Auto-generated method stub
		return listTag;
	}

	@Override
	public String get() {
		
		if (InputData.isWeekend(date)) {
			OverAllWeekHNX30 sentence = new OverAllWeekHNX30(date);
			return sentence.get();
		}
		else {
			this.setComplement(this.subject);
			this.setVerb(this.verb);
			return "Nhóm cổ phiếu " + subject + " " + verb + complement;
		}
	}

	@Override
	public void setTag() {
		listTag.add("overall");
		listTag.add("HNX30");
	}

}