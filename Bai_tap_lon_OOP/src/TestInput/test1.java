package TestInput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class test1 {
	public static void main(String[] args) {
		ArrayList<String> filename = new ArrayList<String>();
		
		long start = System.currentTimeMillis();
		
		String str1 = "giao dịch thỏa thuận tuần này chỉ chiếm 9% trong khi tuần trước là hơn 40%";
		String str2 = "So với tuần trước, khối lượng giao dịch tăng 15%";
		String str3 = "MBB vẫn được giao dịch nhộn nhịp"; 
		String str4 = "Cổ phiếu HBB của ngân hàng";
		
		filename.add("file/Cafef.CLASSIFIED.STOCK_CODE.txt");
		filename.add("file/Cafef.CLASSIFIED.THANHKHOAN.txt");
		filename.add("file/Cafef.CLASSIFIED.VNINDEX.txt");
		filename.add("file/TNCK.CLASSIFIED.THANHKHOAN.txt");
		filename.add("file/TNCK.CLASSIFIED.VNINDEX.txt");
		filename.add("file/Vnexpress.CLASSIFIED.ALL.txt");
		filename.add("file/Vnexpress.CLASSIFIED.STOCK_CODE.txt");
		filename.add("file/Vnexpress.CLASSIFIED.THANHKHOAN.txt");
		filename.add("file/Vnexpress.CLASSIFIED.VNINDEX.txt");
		
		for (String string : filename) {
			try (BufferedReader bufferedReader = new BufferedReader(new FileReader(string))){
				String line = "";
				while((line = bufferedReader.readLine()) != null) {
					if((line.toLowerCase()).contains(str4.toLowerCase())) {
						System.out.println(line);
						System.out.println(string);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println(System.currentTimeMillis()-start);
			}
		}

	}
}
