package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kiemtra {
	private static String regex1 = "\\D*\\d{1,2}[-]\\d{1,2}[-]\\d{1,2}\\D*";
	private static String regex2 = "^\\s*";
	
	private static Pattern pattern = null;
	private static Matcher matcher = null;
	
	public static boolean kiemTratennhom(String str) {
		pattern = Pattern.compile(regex1);
		matcher = pattern.matcher(str);
		
		return matcher.matches();
	}
	
	public static boolean kiemTradongtrong(String str) {
		pattern = Pattern.compile(regex2);
		matcher = pattern.matcher(str);
		
		return matcher.matches();
	}
}
