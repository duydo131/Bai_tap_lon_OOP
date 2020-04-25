
package keywords;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;

import test.KeyWord;
import test.Kiemtra;

public class TNCK_keysVNIdex {
	public static void main(String[] args) {
		long all = 0;
		long notFind = 0;

		long start = System.currentTimeMillis();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("file/TNCK.CLASSIFIED.VNINDEX.txt"));
				BufferedWriter bufferedWriter = new BufferedWriter(
						new FileWriter("filekeywords/TNCK_keywords_VN_index.txt", true))) {

			String line;
			String tennhom = "";
			ArrayList<String> arr = new ArrayList<>();

			while ((line = bufferedReader.readLine()) != null) {
				if (Kiemtra.kiemTratennhomXX_XX(line)) {
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
							bufferedWriter.write(tennhom + " : ");

							for (String string : arrList) {
								if (string == "không tìm thấy") {
									notFind++;
								}
								bufferedWriter.write(string + " ");
							}
							bufferedWriter.write("\n");
						}

						tennhom = "";
						arr = new ArrayList<>();
					}
				}
			}
			bufferedWriter.write(Math.floor(notFind * 1.0 * 10000 / all) / 100 + "% không tìm thấy");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Success " + (System.currentTimeMillis() - start));
			System.out.println(Math.floor(notFind * 1.0 * 10000 / all) / 100 + "% không tìm thấy");
		}
	}
}
