package Input;

import java.util.ArrayList;
import java.util.Date;

public class DataOneStock {
	private ArrayList<DataOneDay> data = new ArrayList<>();
	
	public ArrayList<DataOneDay> getData() {
		return data;
	}
	
	public void setData(ArrayList<DataOneDay> data) {
		this.data = data;
	}
	
	public void add(DataOneDay dataNgay) {
		data.add(dataNgay);
	}

	public DataOneDay getDataOneDay(Date date) {
		for (DataOneDay dataOneDay : data) {
			if(date.getTime() == dataOneDay.getDate().getTime()) {
				return dataOneDay;
			}
		}
		return new DataOneDay(null, 0, 0, 0, 0, 0);
	}
	
	public void print() {
		for (DataOneDay dataNgay : data) {
			dataNgay.print();
		}
	}
	
	public int increasedCounter() {
		int count=0;
		
		return count;
	}
	
	
}
