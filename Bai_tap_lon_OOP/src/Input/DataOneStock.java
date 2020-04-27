package Input;

import java.util.ArrayList;

public class DataOneStock {
	private ArrayList<DataOneDay> data = new ArrayList<>();
	
	public ArrayList<DataOneDay> getData() {
		return data;
	}
	
	public void add(DataOneDay dataNgay) {
		data.add(dataNgay);
	}
	
	public void print() {
		for (DataOneDay dataNgay : data) {
			dataNgay.print();
		}
	}
	
	
}
