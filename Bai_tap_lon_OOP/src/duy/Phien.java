package duy;

import java.util.Date;

import Input.Format;
import Input.InputData;
import Input.STOCK;

public  class Phien extends NhanXet {
	{
		this.name = "phiên";
	}
	
	@Override
	public NhanXet setInfo(Date date, STOCK stock) {
		Date dateYesterday = Format.getDate(date, -1);
		while(!(InputData.testDay(dateYesterday))) {
			dateYesterday = Format.getDate(dateYesterday, -1);
		}
		this.stock = stock;
		this.allVolume = InputData.getToday(date).get(stock).getKL();
		this.change = this.allVolume - InputData.getToday(dateYesterday).get(stock).getKL();
		return this;
	}
}
