package quang;

import java.util.Date;

import Input.STOCK;

public class PsychologyOfInvestors extends comment {

	public PsychologyOfInvestors(Date date, STOCK stock) {
		super(date,stock);
	}
	
	public void setTag() {
		listTag.add("nhà đầu tư");
		listTag.add("lạc quan");
		listTag.add("bị quan");
		listTag.add("lưỡng lự");
	}
	public void comment() {
		if(status.weekendCheck()) {
			System.out.println("Các nhà đầu tư đang chờ tuần giao dịch mới.");
		}else if(status.stock!=STOCK.VNINDEX&&status.stock!=STOCK.HASTC) {
			System.out.println("Các nhà đầu tư" + status.statusInvestor());
		}else System.out.println("Hãy thay đổi về mã cổ phiếu cụ thể."); 
		
	}
	
}
