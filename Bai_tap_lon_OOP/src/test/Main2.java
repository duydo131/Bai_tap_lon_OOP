package test;

public class Main2 {
	static int get(int ...is) {
		int sum = 0;
		for (int i : is) {
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(get(1,2,3));
	}
}
