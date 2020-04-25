package TestInput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
	   	final long start = System.currentTimeMillis();
	   	
		Pattern pattern = null;
		Matcher matcher = null;
		String regex = "[,]\\d{2}[-]\\d{2}[-]\\d{4}\\s[-]\\s\\d{2}[:]\\d{2}\\s[AP][M][,]";
		pattern = Pattern.compile(regex);
		
    	String keyword = "vn-index";
    	
		String filename = "file/Cafef.CLASSIFIED.STOCK_CODE.txt";
		String csvfile = "D:\\20192\\OOP\\BaiTapLon\\Cafef.Articles.CSV";
		
		ArrayList<String> arrayline = new ArrayList<>();
		Input input = null;
		ArrayList<String> keywords = new ArrayList<>();
		keywords.add(keyword);
		keywords.add("đóng");
		keywords.add("phiên");
		input = new Input(filename);
		
		arrayline = input.Filter(keywords);
		
		for (String string : arrayline) {
			try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvfile));
					BufferedWriter bufferedWriter = new BufferedWriter(
							new FileWriter("D:\\20192\\OOP\\BaiTapLon\\test.txt", true))) {

				bufferedReader.readLine();
				String line;


				String s = string.toLowerCase();
				while ((line = bufferedReader.readLine()) != null) {
					if ((line.toLowerCase()).contains(s)) {
						matcher = pattern.matcher(line);
						if (matcher.find()) {
							bufferedWriter.write(line.substring(matcher.start() + 1, matcher.end() - 1) + " : " + string + "\n");
							break;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Success " + (System.currentTimeMillis() - start));
	}
}
