package oop_chap1;
import java.util.Scanner;
public class Bai5{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Nhap vao nam ");
		int i = s.nextInt();
		System.out.print("Nhap vao thang ");
		int j = s.nextInt();
		switch (j) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.print("Co 31 ngay"); break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.print("Co 30 ngay"); break;
		case 2:
			if ((i%400)==0) {
				System.out.print("Co 29 ngay"); break;}
			else {
				System.out.print("Co 28 ngay"); break;}
			}
		}
	}