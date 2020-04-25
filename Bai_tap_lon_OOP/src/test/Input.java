package test;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Input {
	private Set<String> arr = new HashSet<String>();
	private String filename;
	
	
	public Input(String filename) {
		this.filename = filename;
	}
	
	public Set<String> Filter(ArrayList<String> keyword, String str) {
		try(BufferedReader bufferedReader = new BufferedReader( new FileReader(filename))) {
			String line;
			while((line = bufferedReader.readLine()) != null) {
				if (Kiemtra.kiemTra(keyword, line)) {
					arr.add(line.split(": ")[1]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
}
