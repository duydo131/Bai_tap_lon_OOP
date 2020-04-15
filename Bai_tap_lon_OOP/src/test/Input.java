package test;


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Input {
	private Set<String> arr = new HashSet<String>();
	private String filename;
	
	
	public Input(String filename) {
		this.filename = filename;
	}
	
	public Set<String> Filter(ArrayList<String> keyword, String str) {
		try (Stream<String> stream = Files.lines(Paths.get(filename),StandardCharsets.UTF_8)) {
			stream.forEach(line ->{
				if (Kiemtra.kiemTra(keyword, line) && Kiemtra.kiemTraNgay(str, line)) {
					arr.add(line.split(": ")[1]);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
}
