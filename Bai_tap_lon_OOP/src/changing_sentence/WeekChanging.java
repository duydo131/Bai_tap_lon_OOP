package changing_sentence;

import java.util.Date;

import input.DataOneDay;
import input.InputData;
import input.Tool;

public abstract class WeekChanging extends Comment {

	@Override
	public void setInfo() {
		super.setTag();
		this.name = "tuần";
		allVolume = sum(date);
		change = allVolume - sum(Tool.getDate(date, -7));
	}
	
	@Override
	public void setTag() {
		this.listTag.add("tuần");
		this.listTag.add("week");
	}
	
	private long sum(Date date) {
		return InputData.getDataOneWeekOneStock(stock, date)
				.stream().map(DataOneDay::getKL)
				.reduce(0L, (a,b)->a+b);
	}
	
}
