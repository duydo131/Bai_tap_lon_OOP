package test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();
		ArrayList<String> array = new ArrayList<>();
		String str = "D:\\ict\\Java\\test.txt";
		try(Stream<String> stream = Files.lines(Paths.get(str), StandardCharsets.UTF_8)) {
			stream.forEach(line->{
				if(!(line == "")) {
					arr.add(line);
				}else {
					
				}
				
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		array = KeyWord.findKeyWord(arr);
		for (String string : array) {
			System.out.println(string);
		}

	}
}
