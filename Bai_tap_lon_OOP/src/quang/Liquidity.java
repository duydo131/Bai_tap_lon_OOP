package quang;

import java.util.Date;

import Input.STOCK;

public class Liquidity extends comment {
	public Liquidity(Date date, STOCK stock) {
		super(date, stock);
	}

	public void setTag() {
		listTag.add("thanh khoản");
		
	}
	
	public String get() {
		if(status.weekendCheck()) {
			return "Các nhà đầu tư đang chờ tuần giao dịch mới.";
		}else if(status.stock!=STOCK.VNINDEX&&status.stock!=STOCK.HASTC) {
			return "Tính thanh khoản của cổ phiếu " + status.stock + status.Liquidity() + "trong ngày qua.";
		}else return "Hãy thay đổi về mã cổ phiếu cụ thể."; 
		
	}
	
	public void comment() {
		if(status.weekendCheck()) {
			System.out.println("Các nhà đầu tư đang chờ tuần giao dịch mới.");
		}else if(status.stock!=STOCK.VNINDEX&&status.stock!=STOCK.HASTC) {
			System.out.println("Tính thanh khoản của cổ phiếu " + status.stock + status.Liquidity() + "trong ngày qua.");
		}else System.out.println("Hãy thay đổi về mã cổ phiếu cụ thể."); 
		
	}

}
