package TestInput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class client {
	public static void main(String[] args) {
		final long start = System.currentTimeMillis();
		
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\20192\\OOP\\BaiTapLon\\Cafef.Articles.CSV"));
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\20192\\OOP\\BaiTapLon\\test.txt"))) {
			
			String str = "Nhưng riêng mua chứng chỉ quỹ PRUBF1 của Quỹ đầu tư cân bằng Prudential thì có thể nói là “mua tiền” với giá rẻ gần một nửa, vì cổ phiếu chỉ chiếm 10% NAV của Quỹ; tiền mặt chiếm 11% và trái phiếu chiếm 79% NAV của Prudential vào thời điểm 28/2/2009, trong đó trái phiếu chính phủ chiếm 49% NAV và trái phiếu doanh nghiệp chiếm 30%.";
			
			String line ;
			
			String s = str.toLowerCase();

			Pattern pattern = null;
		 	Matcher matcher = null;
			String regex = "[,]\\d{2}[-]\\d{2}[-]\\d{4}\\s[-]\\s\\d{2}[:]\\d{2}\\s[AP][M][,]";
			pattern = Pattern.compile(regex);
			while((line = bufferedReader.readLine()) != null ){
				if((line.toLowerCase()).contains(s)) {
					matcher = pattern.matcher(line);
					if(matcher.find()) {
						System.out.println(line.substring(matcher.start() + 1, matcher.end() - 1) + " : " + str);
						break;
					}
				}
			}



			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Success " + (System.currentTimeMillis() - start));
		}
	}
}
