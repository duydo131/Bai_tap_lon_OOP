package summary_and_comment;

import java.util.Date;

import Input.STOCK;

public class commentStock extends comment {

	public commentStock(Date date, STOCK stock) {
		super(date, stock);
	}
	
	public void setTag() {
		listTag.add("Cổ phiếu");
			
	}
	
	public String get() {
		if(status.weekendCheck()) {
			return "Các nhà đầu tư đang chờ tuần giao dịch mới.";
		}else if(status.stock!=STOCK.VNINDEX&&status.stock!=STOCK.HASTC) {  
			return "Cổ phiếu " + status.stock+ " giao dịch"+ status.statusMarket() + "ngày trước. ";
		}
		else return "Hãy thay đổi về mã cổ phiếu cụ thể.";
	}
	
	public void comment() {
		if(status.weekendCheck()) {
			System.out.println("Các nhà đầu tư đang chờ tuần giao dịch mới.");
		}else if(status.stock!=STOCK.VNINDEX&&status.stock!=STOCK.HASTC) {  
			System.out.println("Cổ phiếu " + status.stock+ " giao dịch"+ status.statusMarket() + "ngày trước. ");
		}
		else System.out.println("Hãy thay đổi về mã cổ phiếu cụ thể.");
	}


}
