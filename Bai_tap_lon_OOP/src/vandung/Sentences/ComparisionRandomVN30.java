package Sentences;

import java.util.ArrayList;
import java.util.Date;
import Input.STOCK;

<<<<<<< HEAD
public class ComparisionRandomVN30 extends ComparisionRandom{
	public ComparisionRandomVN30(Date date){
=======
public class ComparisionRandomVN30 extends ComparisionRandom implements Tag {
	public ComparisionRandomVN30(Date date) {
>>>>>>> 586f98c58434d2a835765c773c4d04b6fd59ecf0
		this.date = date;
		setTag();
	}
<<<<<<< HEAD
	
=======

>>>>>>> 586f98c58434d2a835765c773c4d04b6fd59ecf0
	protected STOCK dataStock(int number) {
		STOCK Stock;
		Stock = Input.InputData.getStockByNumericalVN30(date, number);
		return Stock;
	}
<<<<<<< HEAD
	
=======

>>>>>>> 586f98c58434d2a835765c773c4d04b6fd59ecf0
	@Override
	public ArrayList<String> getTag() {
		setTag();
		return this.listTag;
	}
<<<<<<< HEAD
	
=======

>>>>>>> 586f98c58434d2a835765c773c4d04b6fd59ecf0
	@Override
	public void setTag() {
		super.setTag();
		this.listTag.add("VNX30");
		this.listTag.add("Hồ Chí Minh");
	}

}
