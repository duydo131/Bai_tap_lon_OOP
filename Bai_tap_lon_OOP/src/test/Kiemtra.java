package test;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kiemtra {
	private static String regex3x = "\\D*\\d{1,2}[-]\\d{1,2}[-]\\d{1,2}\\D*";
	private static String regex2x = "\\D*\\d{1,2}[-]\\d{1,2}\\D*";
	private static String regex2 = "^\\s*";
	private static String regex3 = ".*\\D{1}[.]*\\d*\\d{3}[,]*\\d*\\D{1}.*";
	//		,01-01-2000 - 00:00 AM,
	
	private static Pattern pattern = null;
	private static Matcher matcher = null;
	
	

	
	//	kiểm tra tên nhóm
	public static boolean kiemTratennhomXX_XX_XX(String str) {
		pattern = Pattern.compile(regex3x);
		matcher = pattern.matcher(str);
		
		return matcher.matches();
	}
	
	public static boolean kiemTratennhomXX_XX(String str) {
		pattern = Pattern.compile(regex2x);
		matcher = pattern.matcher(str);
		
		return matcher.matches();
	}
	
	
	//	kiểm tra dòng trống
	public static boolean kiemTradongtrong(String str) {
		pattern = Pattern.compile(regex2);
		matcher = pattern.matcher(str);
		
		return matcher.matches();
	}
	
	
	//	kiểm tra điểm hợp lệ
	public static boolean kiemtraDiem(String str) {
		pattern = Pattern.compile(regex3);
		matcher = pattern.matcher(str);
		
		return matcher.matches();
	}
	

	private static String string(String before, String str, String after ) {
		String[] chars = str.split("");
		for (String string : chars) {
			before += "[" + string + "]";
		}
		before += after;
		return before;
	}
	
	
	//	kiểm tra ngày
	public static boolean kiemTraNgay(String str, String line) {
		
		String regex = string(".*\\D{1}", str, "\\D{1}.*"); 
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(line);
		
		return matcher.matches();
	}
	
	
	//	kiểm tra keyword
	public static boolean kiemTra(ArrayList<String> keyword, String line) {
		for (String string : keyword) {
			if (line.toLowerCase().contains(string.toLowerCase())) {
				continue;
			} else {
				return false;
			}
		}
		return true;

	}
	
	
}
