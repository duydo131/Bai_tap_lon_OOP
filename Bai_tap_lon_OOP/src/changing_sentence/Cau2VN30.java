package changing_sentence;

import java.util.ArrayList;
import java.util.Date;

import Input.InputData;


public class Cau2VN30 extends Cau2{

	public Cau2VN30(Date date) {
		setInfo(date);
	}
	
	@Override
	public void setInfo(Date date) {
		setList(InputData.getTodayVN30(date));
		this.setTag();
		name = "Thành phố Hố Chí Minh";
	}
	
	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}
	
	@Override
	public void setTag() {
		super.setTag();
		this.listTag.add("HOSE");
		this.listTag.add("VN-INDEX");
		this.listTag.add("Hồ Chí Minh");
	}
}
