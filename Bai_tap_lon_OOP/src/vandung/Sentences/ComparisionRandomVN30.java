package vandung.Sentences;

import java.util.ArrayList;
import java.util.Date;
import Input.STOCK;

public class ComparisionRandomVN30 extends ComparisionRandom{
	public ComparisionRandomVN30(Date date){
		this.date = date;
		setTag();
	}
	
	protected STOCK dataStock(int number) {
		STOCK Stock;
		Stock = Input.InputData.getStockByNumericalVN30(date, number);
		return Stock;
	}
	
	@Override
	public ArrayList<String> getTag() {
		return this.listTag;
	}
	
	@Override
	public void setTag() {
		super.setTag();
		this.listTag.add("VNX30");
		this.listTag.add("Hồ Chí Minh");
	}

}
