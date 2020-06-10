package summary_and_comment;

import java.util.Date;

import input.STOCK;

public class CommentMarket extends Comment {

	public CommentMarket(Date date, STOCK stock) {
		super(date, stock);
		// TODO Auto-generated constructor stub
	}
	
	public void setTag() {
		super.setTag();
		listTag.add("Thị trường");
		listTag.add("đồng loạt");	
	}
	
	public String get() {
		if(status.weekendCheck()) {
			return "Các nhà đầu tư đang chờ tuần giao dịch mới.";
		}else if(status.stock==STOCK.VNINDEX || status.stock==STOCK.HASTC) {  
			return "Thị trường " + status.stock+ " giao dịch"+ status.statusMarket() + "ngày trước."
					+ " Các mã cổ phiếu cũng đồng loạt biến động theo thị trường. ";
		}
		else return "Hãy thay đổi về mã thị trường. ";
	}
	
	public void comment() {
		if(status.weekendCheck()) {
			System.out.println("Các nhà đầu tư đang chờ tuần giao dịch mới.");
		}else if(status.stock==STOCK.VNINDEX || status.stock==STOCK.HASTC) {  
			System.out.println("Thị trường " + status.stock+ " giao dịch"+ status.statusMarket() + "ngày trước."
					+ " Các mã cổ phiếu cũng đồng loạt biến động theo thị trường.");
		}
		else System.out.println("Hãy thay đổi về mã thị trường. ");
	}

}
