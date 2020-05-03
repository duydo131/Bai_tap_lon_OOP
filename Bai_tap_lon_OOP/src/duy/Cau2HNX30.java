package duy;

import java.util.Date;

import Input.InputData;

public class Cau2HNX30 extends Cau2{
	public Cau2HNX30(Date date) {
		setInfo(date);
	}
	
	@Override
	public void setInfo(Date date) {
		setList(InputData.getTodayHNX30(date));
		name = "Thành phố Hà Nội";
	}
}
