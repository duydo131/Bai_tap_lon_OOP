package changeSentence;

import java.util.Date;

import Input.Tool;
import Input.InputData;
import Input.STOCK;

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
	     
	public Status(Date date1,STOCK stock,int time) {
		this.timePeriod=time;
		this.date1=date1;
		this.date2=Tool.getDate(date1,0-timePeriod);
		this.stock=stock;
		this.giaDongCua=InputData.getToday(date1).get(stock).getGiaDongCua();
		this.giaDongCuaNgayTruoc=InputData.getToday(date2).get(stock).getGiaDongCua();
		this.KL=InputData.getToday(date1).get(stock).getKL();
		this.KLNgayTruoc=InputData.getToday(date2).get(stock).getKL();
	}
	   
	public String mainPattern1(double value, double state,String addition) {
		if(timePeriod!=1 && timePeriod!=7 && timePeriod!=28) {
			return "Nhap lai time ";
		} else {
			if(this.weekendCheck()) return "Ngày cuối tuần không giao dịch.";
			else {
				if(stock!=STOCK.VNINDEX&&stock!=STOCK.HASTC) { 
					if(this.stockPriceChanging()>0) return "tăng "+String.valueOf((double)Math.round(value*10)/10)+addition+" đạt mức "+state+".";
					else if(this.stockPriceChanging()<0) 
						return "giảm "+String.valueOf((double)Math.round((0-value)*10)/10)+addition+" xuống còn "+state+".";
					else return " không thay đổi. ";
				}
				else return "Hãy thay đổi về mã cổ phiếu cụ thể.";
			}
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
		if(timePeriod!=1 && timePeriod!=7 && timePeriod!=28) {
			return "Nhap lai time ";
		} else { 
			if(this.weekendCheck()) return "Ngày cuối tuần không giao dịch.";
			else {
				if(stock==STOCK.VNINDEX||stock==STOCK.HASTC) {	  
					if(this.stockPriceChanging()>0) return "tăng "+String.valueOf((double)Math.round(this.stockPriceChanging()*10)/10)+" điểm đạt mứcc "+this.giaDongCua+".";
					else if(this.stockPriceChanging()<0) 
						return "giảm "+String.valueOf((double)Math.round((0-this.stockPriceChanging())*10)/10)+" điểm xuống còn "+this.giaDongCua+".";
					else return "không có thay đổi.";
				}
				else return "Hãy thay đổi mã cổ phiếu về VN-INDEX hoặc HASTC.";
			}
		}
	}
	public String statusCycle() {
		String cycle = "nhập lại ngày";
		if(timePeriod==1) return cycle =  " ngày ";
		if(timePeriod==7) return cycle =  " tuần ";
		if(timePeriod==28) return cycle =  " tháng ";
		return cycle;
	}
	   
}

