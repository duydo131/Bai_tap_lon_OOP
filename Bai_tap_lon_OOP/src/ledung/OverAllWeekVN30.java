package ledung;

import java.util.ArrayList;
import java.util.Date;

public class OverAllWeekVN30 extends OverAllWeekStockClass{

	public OverAllWeekVN30(Date date) {
		super(date);
		this.subject = "VN30";
	}

	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}

	@Override
	public String get() {
		this.setVerb(this.subject);
		this.setComplement(this.subject);
		return subject + " " + verb + complement;
	}

	@Override
	public void setTag() {
		listTag.add("overall");
		listTag.add("VN30");
	}

}
