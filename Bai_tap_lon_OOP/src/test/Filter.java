package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Filter {

	public static void main(String[] args) {
		
		String str = "vn-index";
		
		ArrayList<String> keywords = new ArrayList<>();
		keywords.add(str);
		
		Set<String> arrayline = new HashSet<String>();
		Set<String> arraydong = null;
		Input input = null;
		
		ArrayList<String> close = new ArrayList<>();
//		close.add("đóng");
//		close.add("phiên");
		
		ArrayList<String> filename = new ArrayList<>();
		
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
			input = new Input(string);
			arrayline.addAll(input.Filter(keywords, "7/5"));
			input = null;
		}
		
		arraydong = PhienLamViec.Phien(arrayline, close);
		
		for (String string : arraydong) {
			System.out.println(string);
		}
	}
}
