package summary_and_comment;

import java.util.ArrayList;
import java.util.Date;

import Input.*;

public class DayTitleHNX30 extends DayTitleStockClass{
	
	public DayTitleHNX30(Date date) {
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
			WeekTitleHNX30 sentence = new WeekTitleHNX30(date);
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
		listTag.add("HNXINDEX");
		listTag.add("HASTC");
		listTag.add("Hà Nội");	
	}
	
}
