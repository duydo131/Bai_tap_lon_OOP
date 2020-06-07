package quang;

import java.util.Date;

import Input.STOCK;

public class PriceChangingPercentageDailySentence extends changingSentence {
	
	public PriceChangingPercentageDailySentence(Date date, STOCK stock) {
		super(date,stock);
		typeStatus=status.stockPricePercentageStatus();
		type = "giá";
	}
	public void setTag() {
		listTag.add("tăng");
		listTag.add("giảm");
		listTag.add("giá");
		listTag.add("%");
	}
	public String get() {
		return "Trong ngày qua, giá cổ phiếu "+status.stock+" đã "+status.stockPricePercentageStatus();
	}
	
	
}
