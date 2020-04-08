package test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
	static ArrayList<String> arr = new ArrayList<>();
	static ArrayList<String> array = new ArrayList<>();
	static String tennhom = "";
	static FileWriter fileWriter = null;
	
	static int temp = 0;

	public static void main(String[] args) {
		
		
		//String str = "D:\\ict\\Java\\test1.txt";
		String str = "Cafef.CLASSIFIED.STOCK_CODE.txt";
		try {
			fileWriter = new FileWriter("keywords.txt",true);

			try (Stream<String> stream = Files.lines(Paths.get(str), StandardCharsets.UTF_8)) {
				stream.forEach(line -> {
					
					if (Kiemtra.kiemTratennhom(line)) {
						tennhom = line;
					} else if (!(Kiemtra.kiemTradongtrong(line))) {
						arr.add(line);
					} else {
						if (!(arr.size() == 0)) {
							array = KeyWord.findKeyWord(arr);
							
//							
//							System.out.print(tennhom + " : ");
//							for (String string : array) {
//								if(string.equals("không tìm thấy")) {
//									temp++;
//								}
//								System.out.print(string + "  ");
//							}
//							System.out.println();
							
							
							try {
								fileWriter.write(tennhom + " : ");
								for (String string : array) {
									if(string.equals("không tìm thấy")) {
										temp++;
									}
									fileWriter.write(string + "  ");
								}
								fileWriter.write("\n");
							} catch (IOException e) {
								e.printStackTrace();
							}
							
							
							tennhom = "";
							array = new ArrayList<>();
							arr = new ArrayList<>();
						}
					}

				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				fileWriter.write("\n" + temp*1.0/200 + "% không tìm thấy");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Success");
			//System.out.println(temp*1.0/200 + "% không tìm thấy");
		}

	}
}
