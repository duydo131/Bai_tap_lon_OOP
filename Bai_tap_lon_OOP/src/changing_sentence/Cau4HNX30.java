package changing_sentence;

import java.util.ArrayList;
import java.util.Date;

import Input.InputData;

public class Cau4HNX30 extends Cau4{
	
	public Cau4HNX30(Date date) {
		setInfo(date);
	}

	@Override
	public void setInfo(Date date) {
		this.date = date;
		setList(InputData.getTodayHNX30(date));
		name = "HNX30";
		super.setTag();
		this.setTag();
	}

	@Override
	public ArrayList<String> getTag() {
		return this.listTag;
	}

	@Override
	public void setTag() {
		this.listTag.add("HNXINDEX");
		this.listTag.add("HASTC");
		this.listTag.add("Hà Nội");
	}
}
