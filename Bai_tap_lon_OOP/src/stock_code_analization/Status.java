package stock_code_analization;

import java.util.Date;

import input.InputData;
import input.STOCK;
import input.Tool;

public class Status {
	public Date date1;
	public Date date2;
	public STOCK stock;
	public double giaDongCua;
	public double giaDongCuaNgayTruoc;
	public long KL;
	public long KLNgayTruoc;
	public int timePeriod;
	public final static String addition1="";
	public final static String addition2="%";

	public Status(Date date1, STOCK stock) {
		this.date1=date1;
		this.date2=Tool.getDate(date1, -1);
		this.stock=stock;
		this.giaDongCua=InputData.getToday(date1).get(stock).getGiaDongCua();
		this.giaDongCuaNgayTruoc=InputData.getToday(date2).get(stock).getGiaDongCua();
		this.KL=InputData.getToday(date1).get(stock).getKL();
		this.KLNgayTruoc=InputData.getToday(date2).get(stock).getKL();
	}
	   
	public String mainPattern1(double value, double state, String addition) {
		if(this.weekendCheck()) return "Ngày cuối tuần không giao dịch.";
		else {
			if(stock!=STOCK.VNINDEX&&stock!=STOCK.HASTC) { 
				if(value>0) return "tăng "+String.valueOf((double)Math.round(value*10)/10)+addition+" đạt mức "+state+".";
				else if(value<0) 
					return "giảm "+String.valueOf((double)Math.round((0-value)*10)/10)+addition+" xuống còn "+state+".";
				else return " không thay đổi. ";
			}
			else return "Hãy thay đổi về mã cổ phiếu cụ thể.";
		} 
	}
	// Method kiem tra co phai ngay cuoi tuan khong
	public boolean weekendCheck() {
		if(!InputData.testDay(date1)||!InputData.testDay(date2))  return true;
		else return false ;
	}   
	//Method tra ve thay doi ve gia trong ngay
	public double stockPriceChanging() {
		if(!InputData.testDay(date1)||!InputData.testDay(date2)) return -1;
		return giaDongCua-giaDongCuaNgayTruoc;
	}	   
	//Method tra ve phan tram thay doi ve gia trong ngay
	public double stockPriceChangingPercentage() {
		if(!InputData.testDay(date1)||!InputData.testDay(date2)) return -1;
		return (giaDongCua/giaDongCuaNgayTruoc-1)*100;
	}   
	//Method tra ve thay doi ve khoi luong trong ngay
	public long stockVolumeChanging() {
		if(!InputData.testDay(date1)||!InputData.testDay(date2)) return -1;
		return KL-KLNgayTruoc;
	}   
	//Method tra ve thay doi ve khoi luong theo phan tram
	public double stockVolumeChangingPercentage() {
		if(!InputData.testDay(date1)||!InputData.testDay(date2)) return -1;
		return (Double.valueOf(KL)/Double.valueOf(KLNgayTruoc)-1)*100;
	}  
	//Trạng thai thay doi gia
	public String stockPriceStatus() {
		return this.mainPattern1(this.stockPriceChanging(),this.giaDongCua,addition1);
	}  
	//Trang thai thay doi gia theo phan tram
	public String stockPricePercentageStatus() {
		return this.mainPattern1(this.stockPriceChangingPercentage(),this.giaDongCua,addition2);
	}  
	//Trang thai thay doi khoi luong 
	public String stockVolumeStatus() {
		return this.mainPattern1(this.stockVolumeChanging(),this.KL,addition1);
	}  
	//Trang thai thay doi khoi luong theo phan tram
	public String stockVolumePercentageStatus() {
		   return this.mainPattern1(this.stockVolumeChangingPercentage(),this.KL,addition2);
	    }  
	//Trang thai thay doi chi so VN_INDEX
	public String exchangeChangingStatus() {
		if(this.weekendCheck()) return "Ngày cuối tuần không giao dịch.";
		else {
			if(stock==STOCK.VNINDEX||stock==STOCK.HASTC) {	  
				if(this.stockPriceChanging()>0) return "tăng "+String.valueOf((double)Math.round(this.stockPriceChanging()*10)/10)+" điểm đạt mức "+this.giaDongCua+".";
				else if(this.stockPriceChanging()<0) 
					return "giảm "+String.valueOf((double)Math.round((0-this.stockPriceChanging())*10)/10)+" điểm xuống còn "+this.giaDongCua+".";
				else return "không có thay đổi.";
			}
			else return "Hãy thay đổi mã cổ phiếu về VN-INDEX hoặc HASTC.";
		}
	}			 

	//Trạng thái biến động giá trong ngày
	public String statusDaylyPrice() {
		String daylyPrice = " đã có biến động nhẹ ";
		if(stockPriceChangingPercentage()<0) {
			if(stockPriceChangingPercentage()>-0.5) {
				return daylyPrice = " đã có biến động nhẹ, ";
			}
			else if(stockPriceChangingPercentage()>-2 && stockPriceChangingPercentage()<=-0.5) { 
				return daylyPrice = " đã có dấu hiệu đi xuống, ";
			}
			else if(stockPriceChangingPercentage()>-4 && stockPriceChangingPercentage()<=-2) {
				return daylyPrice = " đang trên đà đi xuống, ";
			}
			else if(stockPriceChangingPercentage()>-7 && (0-stockPriceChangingPercentage())<=-4) {
				return daylyPrice = " đang giảm rất nhanh, ";
			}
			else {
				return daylyPrice = " đã giảm kịch sàn, ";
			}
		}
		else if(stockPriceChangingPercentage()>0) {
			if(stockPriceChangingPercentage()<0.5) {
				return daylyPrice = " đã có biến động nhẹ, ";
			}
			else if(stockPriceChangingPercentage()<2 && stockPriceChangingPercentage()>=0.5) { 
				return daylyPrice = " đã có dấu hiệu khởi sắc, ";
			}
			else if(stockPriceChangingPercentage()<4 && stockPriceChangingPercentage()>=2) {
				return daylyPrice = " đang trên đà đi lên, ";
			}
			else if(stockPriceChangingPercentage()<7 && stockPriceChangingPercentage()>=4) {
				return daylyPrice = " đang tăng rất nhanh, ";
			}
			else {
				return daylyPrice = " đã tăng kịch trần, ";
			}
		}
		return daylyPrice;
	}
	
	public String statusInvestor() {
		String status = " đang lưỡng lự. ";
		if(stockPriceChangingPercentage() > 1 && stockVolumeChangingPercentage() > 5) 
			return status = " lạc quan, đẩy giá cổ phiếu tăng lên.";
		
		if(stockPriceChangingPercentage() > 1 && stockVolumeChangingPercentage() < -5) 
			return status = " vẫn lạc quan, mặc dù giao dịch cổ phiếu kém sôi động so với ngày trước.";
		
		if(stockPriceChangingPercentage() < -1 && stockVolumeChangingPercentage() < -5)
				return status = " bi quan, kéo giá cổ phiếu đi xuống.";
		
		if(stockPriceChangingPercentage() < -1 && stockVolumeChangingPercentage() > 5)
			return status = " vẫn bi quan, mặc dù giao dịch cổ phiếu sôi động hơn so với ngày trước.";
		
		if(KL<20000) return " không mặn mà với " + stock ;
		return status;	
	}
	
	public String statusMarket() {
		String status = " vẫn ổn định so với ";
		if(stockVolumeChangingPercentage() > 3) return status = " sôi động hơn so với ";
		if(stockVolumeChangingPercentage() < -3) return status = " kém sôi động hơn so với ";
		return status;	
	}
	
	public String forecast() {
		String status = null;
		if(stockPriceChangingPercentage()<0) {
			if(stockPriceChangingPercentage()>-2) {
				return status = " ở mức ổn định. ";
			}
			else if(stockPriceChangingPercentage()>-4 && stockPriceChangingPercentage()<=-2) { 
				return status = " tiếp tục giảm.";
			}
			else {
				return status = " tăng trở lại. ";
			}
		}
		else if(stockPriceChangingPercentage()>0) {
			if(stockPriceChangingPercentage()<2) {
				return status = " ở mức ổn định. ";
			}
			else if(stockPriceChangingPercentage()<4 && stockPriceChangingPercentage()>=2) { 
				return status = " tiếp tục đà tăng. ";
			}
			else {
				return status = " giảm trở lại. ";
			}
		}
		return status;
		
	}
	
	public String Liquidity() {
		if(KL>=2000000) {
			return " cực kỳ cao ";
		}
		else if(KL<2000000 && KL>=1000000) {
			return " rất cao ";
		}
		else if(KL<1000000 && KL>=500000) {
			return " cao ";
		}
		else if(KL<500000 && KL>=100000) {
			return " tương đối cao ";
		}
		else if(KL<100000 && KL>=80000) {
			return " tương đối thấp ";
		}
		else if(KL<80000 && KL>=20000) {
			return " thấp ";
		}
		else if(KL<20000 && KL>=10000) {
			return " rất thấp ";
		} 
		else {
			return " cực kỳ thấp ";
		}
	}
		
	public String comment() {
		if(this.stockPriceChangingPercentage()>2&&this.stockVolumeChangingPercentage()>2) {
			return "sự lạc quan của các nhà đầu tư đã đẩy giá cổ phiếu "+stock+" lên cao.";
		}
		else if(this.stockPriceChangingPercentage()<-2&&this.stockVolumeChangingPercentage()>2) {
			return "do lo ngại cổ phiếu "+stock+"sẽ giảm mạnh nên các nhà đầu tư liên tục bán tháo.";
		}
		else if((this.stockPriceChangingPercentage()<2&&this.stockPriceChangingPercentage()>0)&&((this.stockVolumeChangingPercentage()>0)&&(stockVolumeChangingPercentage()<2))) { 
			return "các nhà đầu tư đã không còn mặn mà với cổ phiếu"+stock+".";
		}
		else if((this.stockPriceChangingPercentage()<2&&this.stockPriceChangingPercentage()>0)&&((this.stockVolumeChangingPercentage()>0.5)&&(this.stockVolumeChangingPercentage()<2))) {
			return "giá cổ phiếu "+stock+"vẫn đang ở mức ổn định mặc dù khối lượng giao dịch tăng. Báo hiệu giá cổ phiếu "+stock+" sẽ có biến động lớn trong thời gian tới";
		}
		else return "Chưa có mẫu câu nhận định cho sự biến động trong thời gian này";
	}
	
}

