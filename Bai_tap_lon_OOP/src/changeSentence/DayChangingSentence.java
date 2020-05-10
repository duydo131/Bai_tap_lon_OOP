package changeSentence;
import java.util.Date;

import Input.DataOneDay;
import Input.InputData;
import Input.ReadFile;
import Input.STOCK;
import Input.EXCHANGES;
import Input.Format;
import Input.Data;

public class DayChangingSentence {
	public Status status;
	public final static String detail1 ="giá";
	public final static String detail2 ="khối lượng";
  
  
	public DayChangingSentence(Date date1,STOCK stock,int time) {
		this.status= new Status(date1,stock,time);
	}
  
  
	public String mainPattern(String detail) {
		if(status.timePeriod!=1 && status.timePeriod!=7 && status.timePeriod!=28) {
			return "";
		}else {
			if(!status.weekendCheck()) {
				if(status.stock!=STOCK.VNINDEX&&status.stock!=STOCK.HASTC) {
					return "Trong" + status.statusCycle() + "qua, " + detail + " cổ phiếu "+status.stock+" đã ";
				}
				else return "";
			}
			else return "";}
	} 
	public void createDayPriceChangingSentence() {
		System.out.println(this.mainPattern(detail1)+status.stockPriceStatus());
	}
	public void createDayPricePercentageChangingSentence() {
		System.out.println(this.mainPattern(detail1)+status.stockPricePercentageStatus());
	}
	public void createDayVolumeChangingSentence() {
	 System.out.println(this.mainPattern(detail2)+status.stockVolumeStatus());
	}
	public void createDayVolumePercentageChangingSentence() {
		System.out.println(this.mainPattern(detail2)+status.stockVolumePercentageStatus());
	}
	public void createDayExchangeChangingSentence() {
		if(status.timePeriod!=1&& status.timePeriod!=7 && status.timePeriod!=28) {
			System.out.println("Nhap lai time.");
		}else { 
			if(!status.weekendCheck()) {
				if(status.stock==STOCK.VNINDEX||status.stock==STOCK.HASTC) {
					System.out.println("Trong"+status.statusCycle()+ "qua, "+status.stock+" da "+status.exchangeChangingStatus());
				}
				else System.out.println(status.exchangeChangingStatus());
			}
			else System.out.println(status.exchangeChangingStatus());
		}
	} 
	
	public void createDetailPricePercenatgeSentence() {
		if(status.timePeriod!=1&& status.timePeriod!=7 && status.timePeriod!=28) {
			System.out.println("Nhap lai time.");
		}else
			if(!status.weekendCheck()) {
				if(status.stock!=STOCK.VNINDEX&&status.stock!=STOCK.HASTC) {  
					if(status.stockPriceChangingPercentage()<0) {
						if(status.stockPriceChangingPercentage()>-0.5) {
							System.out.println("Trong"+status.statusCycle()+ "qua, giá cổ phiếu "+status.stock+" đã có biến động nhẹ, "+status.stockPricePercentageStatus() );
						}
						else if(status.stockPriceChangingPercentage()>-2&&status.stockPriceChangingPercentage()<=-0.5) { 
							System.out.println("Trong"+status.statusCycle()+ "qua, giá cổ phiếu "+status.stock+" đã có dấu hiệu đi xuống, "+status.stockPricePercentageStatus());
						}
						else if(status.stockPriceChangingPercentage()>-4&&status.stockPriceChangingPercentage()<=-2) {
							System.out.println("Trong"+status.statusCycle()+ "qua, giá cổ phiếu "+status.stock+" đang trên đà đi xuống, "+status.stockPricePercentageStatus());
						}
						else if(status.stockPriceChangingPercentage()>-7&&(0-status.stockPriceChangingPercentage())<=-4) {
							System.out.println("Trong"+status.statusCycle()+ "qua, giá cổ phiếu "+status.stock+"đang giảm rất nhanh, "+status.stockPricePercentageStatus());
						}
						else {
							System.out.println("Trong"+status.statusCycle()+ "qua, giá cổ phiếu "+status.stock+" đã giảm kịch trần, "+status.stockPricePercentageStatus());
						}
					}
					else if(status.stockPriceChangingPercentage()>0) {
						if(status.stockPriceChangingPercentage()<0.5) {
							System.out.println("Trong"+status.statusCycle()+ "qua, giá cổ phiếu "+status.stock+" đã có biến động nhẹ, "+status.stockPricePercentageStatus());
						}
						else if(status.stockPriceChangingPercentage()<2&&status.stockPriceChangingPercentage()>=0.5) { 
							System.out.println("Trong"+status.statusCycle()+ "qua, giá cổ phiếu "+status.stock+" đã có dấu hiệu khởi sắc, "+status.stockPricePercentageStatus());
						}
						else if(status.stockPriceChangingPercentage()<4&&status.stockPriceChangingPercentage()>=2) {
							System.out.println("Trong"+status.statusCycle()+ "qua, giá cổ phiếu "+status.stock+" đang trên đà đi lên, "+status.stockPricePercentageStatus());
						}
						else if(status.stockPriceChangingPercentage()<7&&status.stockPriceChangingPercentage()>=4) {
							System.out.println("Trong"+status.statusCycle()+ "qua, giá cổ phiếu "+status.stock+" đang tăng rất nhanh, "+status.stockPricePercentageStatus());
						}
						else {
							System.out.println("Trong"+status.statusCycle()+ "qua, giá cổ phiếu "+status.stock+" đã tăng kịch trần, "+status.stockPricePercentageStatus());
						}
					}
					else {
						System.out.println("Trong"+status.statusCycle()+ "qua, giá cổ phiếu "+status.stock+" "+status.stockPricePercentageStatus());
					}
				}
			}
			else {
				System.out.println(status.stockPricePercentageStatus());
			}
	}
}
