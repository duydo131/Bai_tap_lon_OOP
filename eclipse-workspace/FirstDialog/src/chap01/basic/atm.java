package chap01.basic;
import java.util.Scanner;
import java.text.DecimalFormat;
public class atm{
	public static void main(String[] args) {
		DecimalFormat formatter = new DecimalFormat("#,###");
		int k500=0,k200=0,k100=0,k50=0,k20=0,k10=0;
		int money=1;
		Scanner s = new Scanner(System.in);
		while(money!=0) {
		System.out.print("Nhap so tien ban muon rut: ");
		money = s.nextInt();
		System.out.println("--------------------------");
			if (money >= 500000) {
				k500 = (money / 500000);
				money -= 500000*k500;
			}
			if (money >= 200000) {
				k200 = (money / 200000);
				money -= 200000*k200;
			}
			if (money >= 100000) {
				k100 = (money / 100000);
				money -= 100000*k100;
			}
			if (money >= 50000) {
				k50 = (money / 50000);
				money -= 50000*k50;
			}
			if (money >= 20000) {
				k20 = (money / 20000);
				money -= 20000*k20;
			}
			if (money >= 10000) {
				k10 = (money / 10000);
				money -= 10000*k10;
			}
			if (money > 0) {
				System.out.printf("ATM chi co tien menh gia tren %s.\nXin moi nhap lai \n", formatter.format(10000));
				money = 1;
			}
			if (money == 0) {
				if ( k500>0 ) System.out.printf("Menh gia %s: %d %n", formatter.format(500000) , k500);
				if ( k200>0 ) System.out.printf("Menh gia %s: %d %n", formatter.format(200000) , k200);
				if ( k100>0 ) System.out.printf("Menh gia %s: %d %n", formatter.format(100000) , k100);
				if ( k50>0 ) System.out.printf("Menh gia %s: %d %n", formatter.format(50000) , k50);
				if ( k20>0 ) System.out.printf("Menh gia %s: %d %n", formatter.format(20000) , k20);
				if ( k10>0 ) System.out.printf("Menh gia %s: %d %n", formatter.format(10000) , k10);
			}
		}
		System.out.print("Giao dich thanh cong. Chuc quy khach mot ngay tot lanh!");
	}
}