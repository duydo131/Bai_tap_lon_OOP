package changing_sentence;

import java.util.Date;

import Input.DataOneDay;
import Input.Tool;
import Input.InputData;

public abstract class Week extends NhanXet {

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
