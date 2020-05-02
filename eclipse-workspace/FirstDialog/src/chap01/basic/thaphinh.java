package chap01.basic;
import java.util.Scanner;
public class thaphinh {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Tower's Height: ");
		int h = s.nextInt();
		
		/*
		Thap dang:
	  	*
	  	**
	  	***
	  	****
	  	*****
	  	*/
		
		for (int i = 1 ; i <= h ; i++ ) {
			for (int j = 1 ; j <= i ; j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/*
		Thap dang:
		*****
		****
		***
		**
		*
		*/
		
		for (int i = 1 ; i <= h ; i++ ) {
			for (int j = h ; j >= i ; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/*
		 	  *
		  	 **
		  	***
		   ****
		  *****
		*/
		
		for (int i = 1 ; i <= h ; i++ ) {
			for (int j = 1 ; j <= h-i ; j++ ) {
				System.out.print(" ");
			}
			for (int j = 1 ; j <= i ; j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/*
		 *****
		  ****
		   ***
		    **
		     *
		 */
		
		for (int i = 1 ; i<=h ; i++ ) {
			for (int j = 1 ; j <= i-1 ; j++ ) {
				System.out.print(" ");
			}
			for (int j = 1 ; j <= h-i+1 ; j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/*
		 1
		 1 2
		 1 2 3
		 1 2 3 4
		 1 2 3 4 5 
		*/
		
		for (int i = 1 ; i<=h ; i++ ) {
			for (int j = 1 ; j <= i ; j++ ) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.println();
		/*
		    1
		   212
		  32123
		 4321234
		543212345
		
		*/
		
		for (int i = 1 ; i <= h ; i++ ) {
			for (int j = 1 ; j <= h-i ; j++ ) {
				System.out.print(" ");
			}
			for (int j = i ; j >= 1 ; j-- ) {
				System.out.print(j);
			}
			for (int j = 2 ; j <= i ; j++ ) {
				System.out.print(j);
			}
			System.out.println();
		}
		System.out.println();
		
		/*
		
		     *				8
		   * * *			6
		 * * * * *			4
	   * * * * * * *		2
	 * * * * * * * * * 		0
	 
		*/
		
		for (int i = 1 ; i <= h ; i++ ) {
			for (int j = 1 ; j <= 2*(h-i) ; j++ ) {
				System.out.print(" ");
			}
			for (int j = 1 ; j <= i ; j++ ) {
				System.out.print("* ");
			}
			for (int j = 1 ; j <= i-1 ; j++ ) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
		
		/*
		 * * * * *
		 *   	 *
		 *   	 *
		 *       *
		 * * * * *
		*/
		
		System.out.print("Height size: ");
		int height = s.nextInt();
		System.out.print("Width size: ");
		int width = s.nextInt();
		for (int i = 1 ; i <= height ; i++ ) {
			if ( i == 1 || i == height ) {
				for (int j = 1 ; j <= width ; j++ ) {
					System.out.print("* ");
				}
			}
			else {
				System.out.print("*");
				for (int j = 1 ; j <= ( 2*width - 3 ) ; j++ ) {
					System.out.print(" ");
				}
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
