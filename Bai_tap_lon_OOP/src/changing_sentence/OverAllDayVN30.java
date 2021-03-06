package changing_sentence;

import java.util.ArrayList;
import java.util.Date;

import input.InputData;

public class OverAllDayVN30 extends OverAllDayStockClass{

	public OverAllDayVN30(Date date) {
		super(date, "VN30");
		setTag();
	}
	
	@Override
	public ArrayList<String> getTag() {
		// TODO Auto-generated method stub
		return listTag;
	}

	@Override
	public String get() {
		
		if (InputData.isWeekend(date)) {
			OverAllWeekVN30 sentence = new OverAllWeekVN30(date);
			setTag("week");
			return sentence.get();
		}
		else {
			this.setComplement(this.subject);
			this.setVerb(this.verb);
			setTag("day");
			return "Nhóm cổ phiếu " + subject + " " + verb + complement;
		}
	}

	@Override
	public void setTag() {
		super.setTag();
		listTag.add("overall");
		listTag.add("VN30");
		listTag.add("VNINDEX");
		listTag.add("HOSE");
	}
}