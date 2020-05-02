package Baitap;

public class NhanVien{
	
	private String tenNhanVien;
	private double heSoLuong;
	public static final double LUONG_CO_BAN = 750000;
	public final double LUONG_MAX = 20000000;
	
	public NhanVien() {
	}
	
	public NhanVien(String name, double coefficent) {
		tenNhanVien = name;
		heSoLuong = coefficent;
	}
	
	public void tinhLuong() {
		
		System.out.println("Luong: " + this.heSoLuong * LUONG_CO_BAN);
		
	}
	
	public boolean tangLuong(double add) {
		
		if(((this.heSoLuong+add)*LUONG_CO_BAN) <= LUONG_MAX) {
			System.out.println("Duoc phep tang luong ");
			this.heSoLuong += add;
			return true;
		}
		else {
			System.out.println("Khong duoc phep tang luong ");
			return false;
		}
		
	}
	
	public void inTTin() {
		
		System.out.println("Ten Nhan Vien: " + this.getName());
		System.out.println("Luong co ban cua nhan vien: " + this.getSalary());
		System.out.println("He so luong cua nhan vien: " + this.getSalaryCoefficent());
		
	}
	
	public String getName() {
		return this.tenNhanVien;
	}
	
	public double getSalary() {
		return (LUONG_CO_BAN*this.heSoLuong);
	}
	
	public double getSalaryCoefficent() {
		return this.heSoLuong;
	}
	
	public void setName(String newName) {
		this.tenNhanVien = newName;
	}
	
	public void setSalaryCoefficent(double newCoefficent) {
		this.heSoLuong = newCoefficent;
	}
}
