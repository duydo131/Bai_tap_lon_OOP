package test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;


public class ReadFile {

	public ArrayList<String> split(String filename){
		ArrayList<String> arr = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(filename),StandardCharsets.UTF_8)) {
			stream.forEach(line -> {
				if(Kiemtra.kiemTra(line)) {
					
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		ReadFile read = new ReadFile();
		ArrayList<String> array = new ArrayList<>();
		array = read.split("Cafef.CLASSIFIED.STOCK_CODE.txt");
        
	}

}





