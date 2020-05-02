package oop_chap1;
import java.util.Scanner;
public class Bai7{
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n;
		while(n<3||n>8) {
		System.out.print("Nhap gia tri cua n ");
		n = s.nextInt();
		}
		
	}
}


/*1  2  3  4  5
  16 17 18 19 6
  15 24 25 20 7
  14 23 22 21 8
  13 12 11 10 9
*/