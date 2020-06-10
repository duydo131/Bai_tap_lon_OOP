package changing_sentence;

import java.util.ArrayList;
import java.util.Date;

import input.InputData;

public class Cau1ChangingHNX30 extends Cau1Changing{

	public Cau1ChangingHNX30(Date date) {
		setInfo(date);
	}
	
	@Override
	public void setInfo(Date date) {
		setList(InputData.getTodayHNX30(date));
		this.setTag();
		name = "Hà Nội";
	}

	@Override
	public ArrayList<String> getTag() {
		return this.listTag;
	}

	@Override
	public void setTag() {
		super.setTag();
		this.listTag.add("HNXINDEX");
		this.listTag.add("HASTC");
		this.listTag.add("Hà Nội");
	}
}
