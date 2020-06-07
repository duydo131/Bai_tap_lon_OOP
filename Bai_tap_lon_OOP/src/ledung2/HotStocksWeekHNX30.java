package ledung;

import java.util.ArrayList;
import java.util.Date;

public class HotStocksWeekHNX30 extends HotStocksWeek{
	
	public HotStocksWeekHNX30(Date date) {
		super(date);
		this.subject = "HNX30";
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
