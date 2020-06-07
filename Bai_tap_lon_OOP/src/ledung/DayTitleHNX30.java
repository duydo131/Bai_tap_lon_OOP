package ledung;

import java.util.ArrayList;
import java.util.Date;

import Input.*;

public class DayTitleHNX30 extends DayTitleStockClass{
	
	public DayTitleHNX30(Date date) {
		super(date);
		this.subject = "HNX30";
	}
	
	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}

	@Override
	public String get() {
		
		if (InputData.isWeekend(date)) {
			WeekTitleHNX30 sentence = new WeekTitleHNX30(date);
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
		listTag.add("HNX30");
	}
	
}
