package TestInput;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeleteStopWord {
	private static String string( String str) {
		String s = "\\s";
		String[] chars = str.split("");
		for (String string : chars) {
			s += "[" + string + "]";
		}
		s += "[\\s\\.]";
		return s;
	}
	
	
	public static StringBuffer deleteStopWord(ArrayList<String> stopword, StringBuffer line) {
		
		Pattern pattern = null;
		Matcher matcher = null;
		
		for (String string : stopword) {
			pattern = Pattern.compile(string(string));
			matcher = pattern.matcher(line);
			while(matcher.find()) {
				int start = matcher.start();
				int end = matcher.end()-1;
				line.delete(start, end);
				matcher = pattern.matcher(line);
			}
		}
		
		return line;
	}
}
