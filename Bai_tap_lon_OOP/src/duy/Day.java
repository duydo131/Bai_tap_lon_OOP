package duy;

import java.util.Date;

import Input.Tool;
import Input.InputData;

public abstract class Day extends NhanXet {
	
	public Day() {
		this.name = "phiên";
	}
	
	@Override
	protected void setInfo() {
		super.setTag();
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
		this.listTag.add("ngày");
		this.listTag.add("phiên");
	}
}
