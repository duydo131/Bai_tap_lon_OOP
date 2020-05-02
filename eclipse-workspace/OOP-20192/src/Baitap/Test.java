package Baitap;

public class Test {
	public static void main(String[] args) {
		NhanVien nv1 = new NhanVien("gla1ve", 1.8);
		NhanVien nv2 = new NhanVien("Magisk", 2.4);
		NhanVien nv3 = new NhanVien("Xyp9x", 1.2);
		NhanVien nv4 = new NhanVien("dupreeh", 1.4);
		NhanVien nv5 = new NhanVien("device", 2.1);
		PhongBan pb1 = new PhongBan("Astralis CSGO", 0);
		pb1.setDSNV(5);
		pb1.themNhanVien(nv1);
		pb1.themNhanVien(nv2);
		pb1.themNhanVien(nv3);
		pb1.themNhanVien(nv4);
		pb1.themNhanVien(nv5);
		pb1.inTTin();
		System.out.println("Tong luong: " + pb1.tongLuong());
	}
}
