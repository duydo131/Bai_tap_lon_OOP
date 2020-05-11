package duy;

import java.util.ArrayList;
import java.util.Date;

import Input.InputData;

public class Cau1HNX30 extends Cau1{

	public Cau1HNX30(Date date) {
		setInfo(date);
	}
	
	@Override
	public void setInfo(Date date) {
		setList(InputData.getTodayHNX30(date));
		name = "Hà Nội";
	}

	
}
