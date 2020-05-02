package chap01.basic;

public class p02_variable {
	public static void main(String[] args) {
//		int		var1	=	12;
//		double	var2	=	1.23;
//		int 	var3	= 	var1 + (int)var2;
//		double	var4	=	var1 + var2;
//		System.out.println(var3);
//		System.out.print(var4);
//		byte number = 10;
//		System.out.println("Start = " + number);
//		number %= 4;
//		System.out.println("End = " + number);
//		byte numberStart	= 10;
//		byte numberEnd;
//		numberEnd = --numberStart;
//		System.out.println("numberStart = " + numberStart);
//		System.out.println("numberEnd = " + numberEnd);
		int min		=	5;
		int max		=	12;
		int rand	=	(max-min)+1;
		System.out.println(Math.round((Math.random()*rand+min)));
		
	}
}
