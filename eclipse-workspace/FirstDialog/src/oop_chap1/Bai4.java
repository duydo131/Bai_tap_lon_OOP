package oop_chap1;
import java.util.Scanner;
public class Bai4{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Nhap gia tri cua i ");
		int i = s.nextInt();
		System.out.print("Nhap gia tri cua j ");
		int j = s.nextInt();
		int S = i+j; int P = i*j;
		System.out.println("Tong cua i va j la " + S);
		System.out.println("Tich cua i va j la " + P);
		s.close();
	}
}