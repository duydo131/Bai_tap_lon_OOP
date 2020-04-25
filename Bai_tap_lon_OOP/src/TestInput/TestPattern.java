package TestInput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import test.KeyWord;
import test.Kiemtra;

public class TestPattern {
	
	static boolean kiemTra(ArrayList<String> array) {
		for (String string : array) {
			if(string == "không tìm thấy") {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\20192\\OOP\\BaiTapLon\\baitap.txt"));
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\20192\\OOP\\BaiTapLon\\pattern.txt"))) {
			
			ArrayList<String> arr = new ArrayList<>();
			String line ;
			String tennhom = "";
			while((line = bufferedReader.readLine()) != null ) {
				if(Kiemtra.kiemTratennhomXX_XX(line)) {
					tennhom = line;
				}else if(!Kiemtra.kiemTradongtrong(line)) {
					arr.add(line);
				} else {
					if (arr.size() != 0) {
						ArrayList<String> arraykeywords = KeyWord.findKeyWord(arr);

						if(kiemTra(arraykeywords)) {
							ArrayList<String> pattern = KeyWord.pattern(arr, arraykeywords);
								
							bufferedWriter.write(tennhom + " : ");
							for (String string : arraykeywords) {
								bufferedWriter.write(string + " ");
							}
							bufferedWriter.write("\n");
							for (String string : pattern) {
								bufferedWriter.write(string + "\n");
							}
							
							
//							System.out.print(tennhom + " : ");
//							for (String string : arraykeywords) {
//								System.out.print(string + " ");
//							}
//							System.out.println();
//							for (String string : pattern) {
//								System.out.println(string);
//							}
//
//							System.out.println();
							
						}
						tennhom = "";
						arr = new ArrayList<>();
					}
				}
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			System.out.println(System.currentTimeMillis()-start);
		}
	}
}
