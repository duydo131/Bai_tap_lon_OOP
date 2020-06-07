package ledung;

import java.util.ArrayList;
import java.util.Date;

public class WeekTitleVN30 extends WeekTitleStockClass{
		
	public WeekTitleVN30(Date date) {
		super(date);
		this.subject = "VN30";
	}
	
	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}

	@Override
	public String get() {
		this.setVerb(subject);
		this.setComplement(subject);
		this.setAdverb();
		return adverb + subject + " " + verb + ", " + complement;
	}
	
	@Override
	public void setTag() {
		listTag.add("title");
		listTag.add("VN30");
	}
}
