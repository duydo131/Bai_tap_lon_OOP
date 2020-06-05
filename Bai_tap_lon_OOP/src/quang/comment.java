package changeSentence;

public class comment {
	public Status status;
	// Nhận định về thị trường, cổ phiếu
	public void comment1() {
		System.out.println(status.MarketOrStock() + status.stock+ " giao dịch"+ status.statusMarket() + status.timePeriod + " ngày trước. ");
		// Tâm lí nhà đầu tư	
	}
	public void comment2() {
		System.out.println("Các nhà đầu tư" + status.statusInvestor());
	}
	// Dự báo
	public void comment3() {
		System.out.println("Trong những ngày tới, " + status.stock + " sẽ" + status.forecast());
	}
		
	
	public void createComment() {
		System.out.println(status.comment());
	}

}
