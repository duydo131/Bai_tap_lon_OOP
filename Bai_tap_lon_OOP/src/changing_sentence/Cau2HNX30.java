package changing_sentence;

import java.util.ArrayList;
import java.util.Date;

import Input.InputData;

public class Cau2HNX30 extends Cau2{
	public Cau2HNX30(Date date) {
		setInfo(date);
	}
	
	@Override
	public void setInfo(Date date) {
		setList(InputData.getTodayHNX30(date));
		this.setTag();
		name = "Thành phố Hà Nội";
	}
	
	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}
	
	@Override
	public void setTag() {
		super.setTag();
		this.listTag.add("HNX-INDEX");
		this.listTag.add("HASTC");
		this.listTag.add("Hà Nội");
	}
}
