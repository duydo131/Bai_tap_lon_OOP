package duy;

import java.util.Date;

import Input.DataOneDay;
import Input.Format;
import Input.InputData;
import Input.STOCK;

public class OneStock {
	private STOCK stock;
	private DataOneDay dataOneDay;
	private String status;
	
	public OneStock(STOCK stock, Date date) {
		this.stock = stock;
		dataOneDay = InputData.getToday(date).get(stock);
		status = setStatus();
	}
	
	public String get() {
		String str =  "Trong phiến giao dịch cổ phiếu " + stock.name()
					+ " " + status + " " 
					+ Math.round(dataOneDay.getThayDoi()*10000)/10
					+ " đồng"
					+ " (" + (double)(Math.round((dataOneDay.getThayDoi()/dataOneDay.getGiaMoCua()*10000)))/100 + "%)"
					+ " với tổng khối lượng giao dịch đạt gần " + Format.formatLong(dataOneDay.getKL())
					+ " triệu"
					+ " cổ phiếu và thanh khoản đạt " + (long)(dataOneDay.getThanhKhoan()/10000)*1.0/100
					+ " tỷ đồng.";
		return str;
	}
	
	private String setStatus() {
		String s = "";
		double thayDoi = this.dataOneDay.getThayDoi()/this.dataOneDay.getGiaMoCua();
		if(thayDoi >= 0.07d) {
			s = "tăng trần";
		}else if(thayDoi < 0.07d && thayDoi >= 0.04d ) {
			s = "tăng rất nhanh";
		}else if(thayDoi < 0.04d && thayDoi >= 0.02d ) {
			s = "tăng nhanh";
		}else if(thayDoi < 0.02d && thayDoi >= 0.005d ) {
			s = "tăng chậm";
		}else if(thayDoi < 0.005d && thayDoi >= -0.005d ) {
			s = "giao dịch quanh mức tham chiếu tại";
		}else if(thayDoi < -0.005d && thayDoi >= -0.02d ) {
			s = "giảm nhẹ";
		}else if(thayDoi < -0.02d && thayDoi >= -0.04d ) {
			s = "giảm mạnh";
		}else if(thayDoi < -0.04d && thayDoi >= -0.07d ) {
			s = "giảm sâu";
		}else {
			s = "giảm trần";
		}
		return s;
	}
}
