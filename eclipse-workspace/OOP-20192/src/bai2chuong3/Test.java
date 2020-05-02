package bai2chuong3;
import java.util.Scanner;
public class Test {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Nhap so hoc sinh trong lop: ");
		byte number = s.nextByte();
		Student cls[] = new Student[number];
		for (int i = 0; i < number ; i++ ) {
			cls[i] = new Student();
			System.out.print("Nhap ten cua hoc sinh thu " + (i+1) + ": ");
			cls[i].setName(s.next());
			System.out.print("Nhap nam sinh cua hoc sinh thu " + (i+1) + ": ");
			cls[i].setYear(s.nextInt());
		}
		int sum=0;
		System.out.println("Danh Sach Lop: ");
		for (int i = 0; i < number ; i++ ) {
			System.out.println(i+1 + ") " + cls[i].getName());
			sum += (2020-cls[i].getYear());
		}	
		System.out.println("Tong so tuoi cua lop: " + sum);
		s.close();
	}
}
