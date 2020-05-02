package oop_chap1;
import java.util.Scanner;
public class Bai8{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n=-1;
		while (n<=0) {
			System.out.print("Nhap so phan tu cua day ");
			n = s.nextInt();
		}
		int a[] = new int[n];
		for (int i = 0 ; i <= n-1 ; i++ ) {
			System.out.print("Nhap phan tu thu " + (i+1) + ": " );
			a[i] = s.nextInt();
		}
		int temp;
		
		/* Quick sort */
		
		
		
		/* Bubble sort */
		
		int i,j;
		for (i=n-1;i>=0;i--) {
			for (j=1;j<=i;j++) {
				if (a[j]<a[j-1]) {
					temp=a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
				}
			}
		}
		
		/* Merge sort */
		
		
		
		/* Selection sort 
		
		int i,j,key;
		for ( i = 0 ; i <= n-1 ; i++ ) {
			key = a[i];
			for ( j = i + 1 ; j <= n-1 ; j++ ) {
				if (a[j]<key) {
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		*/
		
		/* Insertion sort 
		
		int k,j,last;
		for (k=1;k<n;k++) {
			last = a[k];
			j=k;
			while ((j>0)&&a[j-1]>last) {
				a[j]=a[j-1];
				j=j-1;
			}
			a[j]=last;
		}
		
		*/
		
		/* Heap sort */
		
		
		
		for (int o = 0 ; o <= n-1 ; o++ ) {
			System.out.print(a[o]+" ");
		}
	}
}