package test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Input {
	private ArrayList<String> arr = new ArrayList<>();
	private String filename;
	
	
	public Input(String filename) {
		this.filename = filename;
	}
	
	private boolean kiemTra(ArrayList<String> array, String line) {
		for (String string : array) {
			if (line.contains(string)) {
				continue;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public ArrayList<String> Filter(ArrayList<String> array) {
		try (Stream<String> stream = Files.lines(Paths.get(filename),StandardCharsets.UTF_8)) {
			stream.forEach(line ->{
				if (kiemTra(array, line)) {
					arr.add(line);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//to do something
		}
		return arr;
	}
}
