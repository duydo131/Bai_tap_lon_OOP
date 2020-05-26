package Input;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DataOneDay {
	private Date date;
	private double giaMoCua;
	private double giaMax;
	private double giaMin;
	private double giaDongCua;
	private long KL;
	private long thanhKhoan;
	private double thayDoi;
	
	
	public DataOneDay(Date date, double giaMoCua, double giaMax, double giaMin, double giaDongCua, long kL) {
		this.date = date;
		this.giaMoCua = giaMoCua;
		this.giaMax = giaMax;
		this.giaMin = giaMin;
		this.giaDongCua = giaDongCua;
		KL = kL;
		this.thanhKhoan = (long)(this.KL*(this.giaMoCua + this.giaDongCua)/2);
		this.thayDoi = this.giaDongCua - this.giaMoCua;
		
	}
	
	public double getThayDoi() {
		return thayDoi;
	}
	
	public long getThanhKhoan() {
		return thanhKhoan;
	}

	public Date getDate() {
		return date;
	}


	public double getGiaMoCua() {
		return giaMoCua;
	}


	public double getGiaMax() {
		return giaMax;
	}


	public double getGiaMin() {
		return giaMin;
	}


	public double getGiaDongCua() {
		return giaDongCua;
	}


	public long getKL() {
		return KL;
	}
	
	public void print() {
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Ngày : " + formats.format(this.getDate()) + " - "
							+ " giá mở cửa : " + this.getGiaMoCua() + " - "  
							+ " giá lớn nhất : " + this.getGiaMax() + " - " 
							+ " giá nhỏ nhất : " + this.getGiaMin() + " - " 
							+ " giá đóng cửa : " + this.getGiaDongCua() + " - " 
							+ " khối lượng : " + this.getKL() + " - " 
							+ " thanh khoản : " + this.getThanhKhoan()+ " - " 
							+ " thay đổi : " + Tool.formatsDouble(this.getThayDoi()));
	}
}
