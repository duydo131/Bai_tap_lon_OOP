package stock_code_analization;

import java.util.Date;

import input.STOCK;

public class PriceChangingPercentageDailySentence extends ChangingSentence {
	
	public PriceChangingPercentageDailySentence(Date date, STOCK stock) {
		super(date,stock);
		typeStatus=status.stockPricePercentageStatus();
	}
	
	
	public void setTag() {
		listTag.add("oneStock");
		listTag.add("day");
		listTag.add("tăng");
		listTag.add("giảm");
		listTag.add("giá");
		listTag.add("%");
	}
	
	
	
}
