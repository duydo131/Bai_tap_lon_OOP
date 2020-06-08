package changing_sentence;

import java.util.ArrayList;
import java.util.Date;

import Input.InputData;

public class Cau4VN30 extends Cau4{
	
	public Cau4VN30(Date date) {
		setInfo(date);
	}

	@Override
	public void setInfo(Date date) {
		this.date = date;
		setList(InputData.getTodayVN30(date));
		super.setTag();
		this.setTag();
		name = "VN30";
	}

	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}
	
	@Override
	public void setTag() {
		this.listTag.add("HOSE");
		this.listTag.add("VNINDEX");
		this.listTag.add("Hồ Chí Minh");
	}
}
