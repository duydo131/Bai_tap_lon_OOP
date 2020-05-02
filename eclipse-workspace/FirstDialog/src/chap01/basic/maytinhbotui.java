package chap01.basic;
import java.util.Scanner;
public class maytinhbotui {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int number1,number2;
		String cal;
		System.out.print("First Number: ");
		number1 = s.nextInt();
		System.out.print("Second Number: ");
		number2 = s.nextInt();
		System.out.print("Calculus: ");
		cal = s.next();
		s.close();
		switch(cal) {
		case "+": System.out.print("Result = " + (number1+number2)); break;
		case "-": System.out.print("Result = " + (number1-number2)); break;
		case "x":
		case "*": System.out.print("Result = " + (number1*number2)); break;
		case "/":
		case ":": System.out.print("Result = " + (number1/number2)); break;
		case "%": System.out.print("Result = " + (number1%number2)); break;
		}
	}
}
