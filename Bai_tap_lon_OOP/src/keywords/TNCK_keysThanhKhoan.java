package keywords;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import test.KeyWord;
import test.Kiemtra;

public class TNCK_keysThanhKhoan {
	static FileWriter fileWriter = null;

	static ArrayList<String> arr = new ArrayList<>();
	
	static String tennhom= "";
	
	static long temp = 0;
	
	static long all = 0;
	
	public static void main(String[] args) {
		
		try {
			fileWriter = new FileWriter("filekeywords/TNCK_keywords_Thanh_khoan.txt",true);
			
			try(Stream<String> stream = Files.lines(Paths.get("file/TNCK.CLASSIFIED.THANHKHOAN.txt"),StandardCharsets.UTF_8)) {
				stream.forEach(line->{

					if(Kiemtra.kiemTratennhomXX_XX(line)) {
						tennhom = line;
					}
					else if (!Kiemtra.kiemTradongtrong(line) ) { 
						arr.add(line);

					}else {
						if(arr.size() != 0) {
							all++;
							
							ArrayList<String> arraykeywords = null;
							
							arraykeywords = KeyWord.findKeyWord(arr);

							try {
								fileWriter.write(tennhom + " : ");
								for (String string : arraykeywords) {
									if(string == "không tìm thấy") {
										temp++;
									}
									fileWriter.write(string + " ");
								}
								fileWriter.write("\n");
								
							} catch (IOException e) {
								e.printStackTrace();
							}
							arr = new ArrayList<>();
							tennhom = "";
						}
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				fileWriter.write("\n" + Math.floor((temp*1.0/all)*10000)/100 + "% không tìm thấy");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		System.out.println("Success");
	}
}
