package duy;

import java.util.Date;

import Input.InputData;

public class Cau2VN30 extends Cau2{

	public Cau2VN30(Date date) {
		setInfo(date);
	}
	
	@Override
	public void setInfo(Date date) {
		setList(InputData.getTodayVN30(date));
		name = "Thành phố Hố Chí Minh";
	}

}
