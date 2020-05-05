package duy;

import java.util.Date;

import Input.InputData;

public class Cau4HNX30 extends Cau4{
	
	public Cau4HNX30(Date date) {
		setInfo(date);
	}

	@Override
	public void setInfo(Date date) {
		setList(InputData.getTodayHNX30(date));
		name = "HNX30";
		this.date = date;
	}

}
