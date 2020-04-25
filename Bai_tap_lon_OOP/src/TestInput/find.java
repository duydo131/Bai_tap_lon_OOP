package TestInput;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class find {
	
	public static ArrayList<String> Update(String line, ArrayList<String> arrayline){
		
		Pattern pattern = null;
	 	Matcher matcher = null;
		String regex = "[,]\\d{2}[-]\\d{2}[-]\\d{4}\\s[-]\\s\\d{2}[:]\\d{2}\\s[AP][M][,]";
		pattern = Pattern.compile(regex);
		
		
		ArrayList<String> arrayLineUpdate = new ArrayList<String>();
		
		for (String string : arrayline) {
			if((line.toLowerCase()).contains(string.toLowerCase())) {
				matcher = pattern.matcher(line);
				if(matcher.find()) {
					String str = line.substring(matcher.start() + 1, matcher.end() - 1) + string;
					arrayLineUpdate.add(str);
				}
			}
		}
		if(arrayLineUpdate.size() == 0 ) {
			return null;
		}
		else {
			return arrayLineUpdate;
		}
	}
}











