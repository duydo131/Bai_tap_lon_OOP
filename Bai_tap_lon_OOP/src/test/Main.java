package test;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		String filename = "Cafef.CLASSIFIED.STOCK_CODE.txt";
		ArrayList<String> arrayline = null;
		Input input = null;
		ArrayList<String> arraykeywords = new ArrayList<>();
		
		arraykeywords.add("VN-index");
		arraykeywords.add("giảm");
		
		input = new Input(filename);
		arrayline = input.Filter(arraykeywords);
		
		String str = "";
		for (String string : arrayline) {
			str += string + "\n";
		}
		System.out.println(str);
	}
}
