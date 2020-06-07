package ledung;

import java.util.ArrayList;
import java.util.Date;

public class HotStocksWeekVN30 extends HotStocksWeek{
	
	public HotStocksWeekVN30(Date date) {
		super(date);
		this.subject = "VN30";
	}

	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}

	@Override
	public String get() {
		return super.createClause(this.subject);
	}
	
	public void setTag() {
		
	}
	
}
