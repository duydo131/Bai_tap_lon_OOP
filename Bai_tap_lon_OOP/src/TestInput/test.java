package TestInput;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	
	static String string( String str) {
		String s = "\\s";
		String[] chars = str.split("");
		for (String string : chars) {
			s += "[" + string + "]";
		}
		s += "[\\s\\.]";
		return s;
	}
	
	
	static StringBuffer deleteStopWord(ArrayList<String> stopword, StringBuffer line) {
		
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
	
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("Nhưng riêng mua chứng chỉ quỹ PRUBF1 của Quỹ đầu tư cân bằng Prudential thì có thể nói là “mua tiền” với giá rẻ gần một nửa, vì cổ phiếu chỉ chiếm 10% NAV của Quỹ; tiền mặt chiếm 11% và trái phiếu chiếm 79% NAV của Prudential vào thời điểm 28/2/2009, trong đó trái phiếu chính phủ chiếm 49% NAV và trái phiếu doanh nghiệp chiếm 30%.\r\n" );
		
		ArrayList<String> stopword = StopWord.getStopWord();
		
		System.out.println(deleteStopWord(stopword, str));
		
		StringBuffer s = new StringBuffer("không mua đâu ô a âu.");
		ArrayList<String> stop = new ArrayList<>();
		stop.add("a");
		stop.add("ô");
		stop.add("âu");
		
		
		System.out.println(deleteStopWord(stop, s));
	}
}
