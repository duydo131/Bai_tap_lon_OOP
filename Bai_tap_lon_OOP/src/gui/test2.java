package gui;


public class test2 {
	public static String get() {
		StringBuffer string = new StringBuffer();
		return string.toString();
	}
	
	public static void main(String[] args) {

		StringBuffer string = new StringBuffer();
		
		System.out.println(string.toString().equals(""));
	}
}
