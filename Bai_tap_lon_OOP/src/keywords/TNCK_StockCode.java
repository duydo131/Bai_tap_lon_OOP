package keywords;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;

import test.KeyWord;
import test.Kiemtra;

public class TNCK_StockCode {
	public static void main(String[] args) {
		long all = 0;
		long notFind = 0;

		long start = System.currentTimeMillis();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\ict\\Java\\test1.txt"));
				//BufferedWriter bufferedWriter = new BufferedWriter(
				//		new FileWriter("D:\\ict\\Java\\test.txt", true))
						) {

			String line;
			String tennhom = "";
			ArrayList<String> arr = new ArrayList<>();

			while ((line = bufferedReader.readLine()) != null) {
				if (Kiemtra.kiemTratennhomXX_XX_XX(line)) {
					tennhom = line;
				} else if (!Kiemtra.kiemTradongtrong(line)) {
					arr.add(line);

				} else {
					if (arr.size() != 0) {
						ArrayList<String> arraykeywords = KeyWord.findKeyWord(arr);
						LinkedList<String> arrList = new LinkedList<String>();
						arrList.addAll(arraykeywords);

						if (arrList.size() == 0) {
							arrList.add("không tìm thấy");
						}

						if (tennhom != "") {
							all++;
							//bufferedWriter.write(tennhom + " : ");
							System.out.print(tennhom + " : ");

							for (String string : arrList) {
								if (string == "không tìm thấy") {
									notFind++;
								}
								System.out.print(string + " ");
								//bufferedWriter.write(string + " ");
							}
							System.out.println();
							//bufferedWriter.write("\n");
						}

						tennhom = "";
						arr = new ArrayList<>();
					}
				}
			}
			//bufferedWriter.write(Math.floor(notFind * 1.0 * 10000 / all) / 100 + "% không tìm thấy");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Success " + (System.currentTimeMillis() - start));
			System.out.println(Math.floor(notFind * 1.0 * 10000 / all) / 100 + "% không tìm thấy");
		}
	}
}
