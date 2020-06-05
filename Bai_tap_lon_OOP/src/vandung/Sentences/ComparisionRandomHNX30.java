package Sentences;

import java.util.ArrayList;
import java.util.Date;

import Input.STOCK;

<<<<<<< HEAD
public class ComparisionRandomHNX30 extends ComparisionRandom {
	public ComparisionRandomHNX30(Date date){
		setTag();
=======
public class ComparisionRandomHNX30 extends ComparisionRandom implements Tag {
	public ComparisionRandomHNX30(Date date) {
>>>>>>> 586f98c58434d2a835765c773c4d04b6fd59ecf0
		this.date = date;
	}

	@Override
	protected STOCK dataStock(int number) {
		STOCK Stock;
		Stock = Input.InputData.getStockByNumericalHNX30(date, number);
		return Stock;
	}
                                                                                                                                                                                          
	@Override
	public void setTag() {
		super.setTag();
		this.listTag.add("HNX30");
		this.listTag.add("Hà Nội");
	}
	
	@Override
	public ArrayList<String> getTag() {
		setTag();
		return this.listTag;
	}
}
