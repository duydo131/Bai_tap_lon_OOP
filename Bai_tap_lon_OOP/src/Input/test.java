package Input;

import java.io.File;

public class test {
	public static void main(String[] args) {
		String str = "D:\\20192\\OOP\\BaiTapLon\\data";
		
		File file = new File(str);
		
		File[] arrayfile = file.listFiles();
		
		for (File file2 : arrayfile) {
			System.out.println(file2);
		}
		

	}
}
