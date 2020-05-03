package duy;

import java.util.Date;

import Input.InputData;

public class Cau1VN30 extends Cau1{

	public Cau1VN30(Date date) {
		setInfo(date);
	}
	
	@Override
	public void setInfo(Date date) {
		setList(InputData.getTodayVN30(date));
		name = "HOSE";
	}
}
