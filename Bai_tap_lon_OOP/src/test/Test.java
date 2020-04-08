package test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();
		arr.add("do the duy");
		arr.add("DO THE DUY");
		arr.add("đang học");
		
		FileWriter fileWriter = null;
		
		try {
			fileWriter = new FileWriter("D:\\ict\\Java\\test1.txt",true);
			
			for (String string : arr) {
				int i = 1; 
				if(i < arr.size()) {
					fileWriter.write(string + "\n");
					i++;
				}else {
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
