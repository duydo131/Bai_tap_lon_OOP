package test;

import java.util.ArrayList;
import java.util.Date;

import duy.*;

public enum Test {
	Cau1(new Cau1VN30(getDate()).getTag());
	
	private ArrayList<String> tag;
	
	Test(ArrayList<String> tag){
		this.tag = tag;
	}
	
	public ArrayList<String> getTag(){
		return this.tag;
	}
	
	private static Date getDate() {
		long ngay = 1582822800;
		return new Date(ngay*1000);
	}
	
	public void getInstance() {
		
	}
	
}


