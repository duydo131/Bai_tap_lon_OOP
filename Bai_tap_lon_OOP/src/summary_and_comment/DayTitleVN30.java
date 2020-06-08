package summary_and_comment;

import java.util.ArrayList;
import java.util.Date;

import Input.*;

public class DayTitleVN30 extends DayTitleStockClass{
	
	public DayTitleVN30(Date date) {
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
			WeekTitleVN30 sentence = new WeekTitleVN30(date);
			setTag("weekend");
			return sentence.get();
		}
		else {
			this.setVerb(subject);
			this.setComplement(subject);
			setTag("day");
			return adverb + subject + " " + verb + ", " + complement;
		}
	}

	@Override
	public void setTag() {
		super.setTag();
		listTag.add("VNINDEX");
		listTag.add("HOSE");
		listTag.add("Hồ Chí Minh");		
	}
	
}
