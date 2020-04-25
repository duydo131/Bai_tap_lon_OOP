package TestInput;

import java.util.ArrayList;

public class Main2 {
 
    public static void main(String[] args) {
    	String keyword = "vn-index";
    	
		String filename = "file/Cafef.CLASSIFIED.STOCK_CODE.txt";
		
		ArrayList<String> arrayline = new ArrayList<>();
		Input input = null;
		ArrayList<String> keywords = new ArrayList<>();
		keywords.add(keyword);
		keywords.add("đóng");
		keywords.add("phiên");
		input = new Input(filename);
		
		arrayline = input.Filter(keywords);
		
		System.out.println(Math.floor(arrayline.size()*1.0* 10000/20000 )/100 + "% update");
    }
}