package summary_and_comment;

import java.util.ArrayList;
import java.util.Date;

public class TomorrowPredictionHNX30 extends TomorrowPredictionStockClass{
	
	public TomorrowPredictionHNX30(Date date) {
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
		this.setComplement(this.subject);
		return linkWord + verb + complement;
	}

	@Override
	public void setTag() {
		super.setTag();
		listTag.add("HNXINDEX");
		listTag.add("HASTC");
		listTag.add("Hà Nội");	
	}
}
