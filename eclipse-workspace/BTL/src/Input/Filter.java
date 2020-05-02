package Input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Filter {
	public static void main(String[] args) {
		
		String file = "D:\\20192\\OOP\\BaiTapLon";
		
		
		File folderVn30 = new File(file + "\\hnx30");
		
		File[] filename = folderVn30.listFiles();

		for (File file2 : filename) {
			try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file2));
				FileWriter fileWriter = new FileWriter(file + "\\dataHNX30\\" + file2.getName(),true)
						) {
				String line;
				
				for (int i = 0; i < 40; i++) {
					bufferedReader.readLine();
				}
				
				int i = 0;
				
				while((line = bufferedReader.readLine()) != null && i < 103) {
					fileWriter.append(line + "\n");
					i++;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("Success");
			}
			
		}
		
	}
}