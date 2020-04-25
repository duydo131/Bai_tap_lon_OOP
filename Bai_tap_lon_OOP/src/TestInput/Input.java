package TestInput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import test.Kiemtra;


public class Input {
	private ArrayList<String> arr = new ArrayList<String>();
	private String filename;
	
	
	public Input(String filename) {
		this.filename = filename;
	}
	
	public ArrayList<String> Filter(ArrayList<String> keyword) {

		long all = 0;
		try(BufferedReader bufferedReader = new BufferedReader( new FileReader(filename))) {
			String line;
			while((line = bufferedReader.readLine()) != null) {
				all++;
				if (Kiemtra.kiemTra(keyword, line)) {
					arr.add(line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("All : " + all);
		}
		return arr;
	}
	
}
