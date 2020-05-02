package oop_chap1;
import java.util.Scanner;
public class Bai6{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int h=1;
		while(h<2||h>10) {
			System.out.print("Nhap 2<=h<=10 ");
			h = s.nextInt();
		}
		int line=1;
		while(line <= h){
			
			for(int i=1 ; i <= h-line ; i++ ) {
				System.out.print(" ");									/* ve~ ra dau' cach */
			}
			
			for(int i=1 ; i<= 2*line-1 ; i++) {
			System.out.print("*");										/* ve~ ra dau' * */
			}
			
			System.out.println();										/* ve~ ra dau' * */
			
			line++;
		}
	}
}

