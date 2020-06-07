package quang;

import java.util.Date;

import Input.STOCK;

public class commentMarket extends comment {

	public commentMarket(Date date, STOCK stock) {
		super(date, stock);
		// TODO Auto-generated constructor stub
	}
	
	public void setTag() {
		listTag.add("Thị trường");
		listTag.add("đồng loạt");	
	}
	public void comment() {
		if(status.weekendCheck()) {
			System.out.println("Các nhà đầu tư đang chờ tuần giao dịch mới.");
		}else if(status.stock==STOCK.VNINDEX || status.stock==STOCK.HASTC) {  
			System.out.println("Thị trường " + status.stock+ " giao dịch"+ status.statusMarket() + "ngày trước. ");
			System.out.println("Các mã cổ phiếu cũng đồng loạt biến động theo thị trường.");
		}
		else System.out.println("Hãy thay đổi về mã thị trường. ");
	}


}
