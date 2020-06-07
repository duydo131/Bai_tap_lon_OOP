package changing_sentence;

import java.util.ArrayList;
import java.util.Date;

public class OverAllWeekHNX30 extends OverAllWeekStockClass{
	
	public OverAllWeekHNX30(Date date) {
		super(date);
		this.subject = "HNX30";
	}

	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}

	@Override
	public String get() {
		this.setComplement(this.subject);
		this.setVerb(this.subject);
		return subject + " " + verb + complement;
	}

	@Override
	public void setTag() {
		listTag.add("overall");
		listTag.add("HNX30");	
	}
}
