package Input;

import java.util.ArrayList;

public class data1 {
	ArrayList<DataNgay> data = new ArrayList<>();
	
	public void add(DataNgay dataNgay) {
		data.add(dataNgay);
	}
	
	public void print() {
		for (DataNgay dataNgay : data) {
			dataNgay.print();
		}
	}
}
