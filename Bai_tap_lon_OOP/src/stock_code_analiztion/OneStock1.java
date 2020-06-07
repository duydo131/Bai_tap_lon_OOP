package stock_code_analiztion;

import java.util.ArrayList;
import java.util.Date;

import Input.Tool;
import Input.InputData;
import Input.STOCK;

public class OneStock1 extends OneStockRoot{
	private String status;
	
	public OneStock1(STOCK stock, Date date) {
		this.stock = stock;
		this.dataOneDay.add(InputData.getToday(date).get(stock));
		status = setStatus();
		super.setTag();
		this.setTag();
	}
	
	@Override
	public void setTag() {
		this.listTag.add("phiên");
		this.listTag.add("ngày");
		this.listTag.add("day");
	}
	
	@Override
	public ArrayList<String> getTag() {
		return this.listTag;
	}
	
	@Override
	public String get() {
		String str =  "Trong phiên giao dịch cổ phiếu " + stock.name()
					+ status
					+ Math.abs(Math.round(dataOneDay.get(0).getThayDoi()*10000)/10) 
					+ " đồng thành " + Tool.formatMoney(dataOneDay.get(0).getGiaDongCua())
					+ " đồng" 
					+ " (" + (double)(Math.round((dataOneDay.get(0).getThayDoi()/dataOneDay.get(0).getGiaMoCua()*10000)))/100 + "%)"
					+ " với tổng khối lượng giao dịch đạt gần " + Tool.formatLong(dataOneDay.get(0).getKL())
					+ " cổ phiếu và thanh khoản đạt " + (long)(dataOneDay.get(0).getThanhKhoan()/10000)*1.0/100
					+ " tỷ đồng.";
		return str;
	}
	
	private String setStatus() {
		String s = "";
		double thayDoi = this.dataOneDay.get(0).getThayDoi()/this.dataOneDay.get(0).getGiaMoCua();
		if(thayDoi >= 0.07d) {
			s = " tăng trần ";
		}else if(thayDoi < 0.07d && thayDoi >= 0.04d ) {
			s = " tăng rất nhanh ";
		}else if(thayDoi < 0.04d && thayDoi >= 0.02d ) {
			s = " tăng nhanh ";
		}else if(thayDoi < 0.02d && thayDoi >= 0.005d ) {
			s = " tăng chậm ";
		}else if(thayDoi < 0.005d && thayDoi >= -0.005d ) {
			s = " giao dịch quanh mức tham chiếu " + (thayDoi > 0 ? " tăng " : " giảm ");
		}else if(thayDoi < -0.005d && thayDoi >= -0.02d ) {
			s = " giảm nhẹ ";
		}else if(thayDoi < -0.02d && thayDoi >= -0.04d ) {
			s = " giảm mạnh ";
		}else if(thayDoi < -0.04d && thayDoi >= -0.07d ) {
			s = " giảm sâu ";
		}else {
			s = "giảm trần";
		}
		return s;
	}
}
