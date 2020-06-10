package changing_sentence;

import java.util.Date;

import input.InputData;
import input.Tool;

public abstract class DayChanging extends Comment {
	
	@Override
	protected void setInfo() {
		super.setTag();
		this.name = "phiên";
		Date dateBefore = getDateBefore(date);
		this.allVolume = InputData.getToday(this.date).get(this.stock).getKL();
		this.change = this.allVolume - InputData.getToday(dateBefore).get(this.stock).getKL();
	}
	
	private Date getDateBefore(Date date) {
		Date dateYesterday = Tool.getDate(this.date, -1);
		while(!(InputData.testDay(dateYesterday))) {
			dateYesterday = Tool.getDate(dateYesterday, -1);
		}
		return dateYesterday;
	}
	
	@Override
	public void setTag() {
		this.listTag.add("day");
		this.listTag.add("ngày");
		this.listTag.add("phiên");
		this.listTag.add("chung");
	}
}
