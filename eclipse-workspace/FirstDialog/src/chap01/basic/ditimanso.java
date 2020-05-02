package chap01.basic;
import java.util.Scanner;
public class ditimanso {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int count=0;
		int answer=0;
		int mysteriousnumber = (int) (Math.random()*(100-0+1));
		while(answer != mysteriousnumber) {
			System.out.print("Your number(0-100): ");
			answer = s.nextInt();
			if (answer < mysteriousnumber) {
				System.out.println("Your Guess is less than the Mysterious Number! Keep Goin'!");
				++count;
			}
			else if (answer > mysteriousnumber) {
				System.out.println("Your Guess is greater than the Mysterious Number! Keep Goin'!");
				++count;
			}
			else {
				System.out.println("Congrats! You've found it!");
				System.out.println("The Mysterious Number is: " + mysteriousnumber);
				System.out.print("Your Score: " + (100-count*5));
				}
			}
		s.close();
		}
	}