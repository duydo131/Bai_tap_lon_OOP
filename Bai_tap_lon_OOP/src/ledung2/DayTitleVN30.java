package ledung;

import java.util.ArrayList;
import java.util.Date;

import Input.*;

public class DayTitleVN30 extends DayTitleStockClass{
	
	public DayTitleVN30(Date date) {
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
			WeekTitleVN30 sentence = new WeekTitleVN30(date);
			return sentence.get();
		}
		else {
			this.setVerb(subject);
			this.setComplement(subject);
			return adverb + subject + " " + verb + ", " + complement;
		}
	}

	@Override
	public void setTag() {
		listTag.add("title");
		listTag.add("VN30");		
	}
	
}
