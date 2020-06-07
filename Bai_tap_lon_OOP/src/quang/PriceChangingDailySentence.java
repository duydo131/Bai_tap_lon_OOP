package quang;

import java.util.Date;

import Input.STOCK;


public class PriceChangingDailySentence extends changingSentence {


	public PriceChangingDailySentence(Date date, STOCK stock) {
		super(date,stock);
		typeStatus= status.stockPriceStatus();
		type="giá";
	}
	
	public void setTag() {
		listTag.add("tăng");
		listTag.add("giảm");
		listTag.add("giá");
	}
	public String get() {
		return "Trong ngày qua, giá cổ phiếu "+status.stock+" đã "+status.stockPriceStatus();
	}

}
