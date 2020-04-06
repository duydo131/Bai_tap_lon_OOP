package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kiemtra {
	private static String regex = "\\D*\\d{1,2}[-]\\d{1,2}[-]\\d{1,2}\\D*";


	public static boolean kiemTra(String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		
		return matcher.matches();
	}
}
