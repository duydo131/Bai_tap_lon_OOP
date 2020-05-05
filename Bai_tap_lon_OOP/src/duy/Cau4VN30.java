package duy;

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
		name = "VN30";
	}

}
