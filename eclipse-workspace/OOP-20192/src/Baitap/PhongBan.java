package Baitap;

public class PhongBan {
	private String tenPhongBan;
	private int soNhanVien;
	public static final byte SO_NV_MAX = 100;
	
	private NhanVien danhsach[];
	
	public PhongBan(String name, int total) {
		this.tenPhongBan = name;
		this.soNhanVien = total;
	}
	
	
	public boolean themNhanVien(NhanVien nv) {
		if (soNhanVien < SO_NV_MAX) {
			danhsach[soNhanVien] = nv;
			soNhanVien++;
			return true;
		}
		else return false;
	}
	
	public NhanVien xoaNhanVien() {
		if (soNhanVien > 0) {
			NhanVien tempt = danhsach[soNhanVien-1];
			danhsach[soNhanVien-1] = null;
			soNhanVien--;
			return tempt;
		}
		else return null;
	}
	
	public double tongLuong() {
		double tongluong = 0.0;
		for (NhanVien nv: danhsach) {
			tongluong+= nv.getSalary();
		}
		return tongluong;
	}
	
	public void inTTin() {
		System.out.println("Ten phong ban: " + tenPhongBan);
		System.out.println("So nhan vien: " + soNhanVien);
		System.out.println("Thong tin cac nhan vien: ");
		for (NhanVien nv: danhsach) {
			nv.inTTin();
		}
	}
	
	public void setDSNV(int total) {
		this.danhsach = new NhanVien[total];
	}
}
