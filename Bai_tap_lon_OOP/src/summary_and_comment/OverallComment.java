package summary_and_comment;

import java.util.Date;

import input.STOCK;

public class OverallComment extends Comment{

	public OverallComment(Date date, STOCK stock) {
		super(date, stock);
		// TODO Auto-generated constructor stub
	}
	
	public void setTag() {
		super.setTag();
		listTag.add("nhà đầu tư");
			
	}
	
	public String get() {
		if(status.weekendCheck()) {
			return "Các nhà đầu tư đang chờ tuần giao dịch mới.";
		}else if(status.stock!=STOCK.VNINDEX&&status.stock!=STOCK.HASTC) {  
			return status.comment();
		}
		else return "Hãy thay đổi về mã cổ phiếu cụ thể.";
	}
	
	public void comment() {
		if(status.weekendCheck()) {
			System.out.println("Các nhà đầu tư đang chờ tuần giao dịch mới.");
		}else if(status.stock!=STOCK.VNINDEX&&status.stock!=STOCK.HASTC) {  
			System.out.println(status.comment());
		}
		else System.out.println("Hãy thay đổi về mã cổ phiếu cụ thể.");
	}

}
