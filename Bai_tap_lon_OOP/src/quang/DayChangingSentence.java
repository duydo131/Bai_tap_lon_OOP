package changeSentence;

import java.util.Date;


import Input.STOCK;
//import Input.EXCHANGES;
//import Input.Format;
//import Input.Data;
//import Input.DataOneDay;
//import Input.InputData;
//import Input.ReadFile;

public class DayChangingSentence {
	public Status status;
	public final static String detail1 ="giá";
	public final static String detail2 ="khối lượng";
	public final static String moDau ="Trong ngày qua, giá cổ phiếu ";
  
	public DayChangingSentence(Date date1, STOCK stock, int time) {
		this.status= new Status(date1, stock, time);
	}
  
	public String mainPattern(String detail) {
		if(status.stock==STOCK.VNINDEX||status.stock==STOCK.HASTC) {
			return "";
		} else {
			if(!status.weekendCheck()) {
				if(status.timePeriod!=1 && status.timePeriod!=7 && status.timePeriod!=28) {
					return "Trong "+status.timePeriod+" ngày qua, "+detail+" cổ phiếu "+status.stock+" đã ";
				} else {
					if(status.stock!=STOCK.VNINDEX&&status.stock!=STOCK.HASTC) {
						return "Trong" + status.statusCycle() + "qua, " + detail + " cổ phiếu "+status.stock+" đã ";
					}
					else return "";
					}
			}
			else return "";
		}
	} 
	public void createDayPriceChangingSentence() {
		System.out.println(this.mainPattern(detail1) + status.stockPriceStatus());
	}
	public void createDayPricePercentageChangingSentence() {
		System.out.println(this.mainPattern(detail1) + status.stockPricePercentageStatus());
	}
	public void createDayVolumeChangingSentence() {
		System.out.println(this.mainPattern(detail2) + status.stockVolumeStatus());
	}
	public void createDayVolumePercentageChangingSentence() {
		System.out.println(this.mainPattern(detail2)+status.stockVolumePercentageStatus());
	}
	public void createDayExchangeChangingSentence() {
		if(status.stock!=STOCK.VNINDEX&&status.stock!=STOCK.HASTC) {
			System.out.println(status.exchangeChangingStatus());
		}else {
			if(status.weekendCheck()) {
				System.out.println(status.exchangeChangingStatus());
			} else {
				if(status.timePeriod!=1&& status.timePeriod!=7 && status.timePeriod!=28) {
					System.out.println("Trong " + status.timePeriod + " ngày qua, "+status.stock+" đã " + status.exchangeChangingStatus());
				}else { 
					System.out.println("Trong" + status.statusCycle() + "qua, "+status.stock + " đã " + status.exchangeChangingStatus());
				}			
			}	
		}
	}
	public void createDetailPricePercenatgeSentence() {
		if(status.timePeriod!=1) {
			System.out.println("Nhập lại thời gian. Mẫu câu này chỉ dành cho ngày.");
		}else
			if(!status.weekendCheck()) {
				if(status.stock!=STOCK.VNINDEX&&status.stock!=STOCK.HASTC) {  
					System.out.println(moDau + status.stock + status.statusDaylyPrice() + status.stockPricePercentageStatus());	
				}
				else System.out.println("Hãy thay đổi về mã cổ phiếu cụ thể.");
			}
			else System.out.println(status.stockPricePercentageStatus());	
	}
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
		System.out.println(status.comment1());
	}
}
