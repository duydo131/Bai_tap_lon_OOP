package quang;

import java.util.Date;

import Input.STOCK;

public class Forecast extends comment {
	public Forecast(Date date, STOCK stock) {
		super(date,stock);
	}
	
	public void setTag() {
		listTag.add("dự báo");
		listTag.add("những ngày tới");	
	}
	public void comment() {
		if(status.weekendCheck()) {
			System.out.println("Các nhà đầu tư đang chờ tuần giao dịch mới.");
		}else
			System.out.println("Trong những ngày tới, dự báo " + status.stock + " sẽ" + status.forecast());
	}

}
