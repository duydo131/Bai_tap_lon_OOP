package nhomcau;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import test.Kiemtra;

public class Input {
	private static String filename = "D:\\20192\\OOP\\BaiTapLon\\baitap.txt";
	private static ArrayList<Nhom> list = new ArrayList<>();
	
	public static ArrayList<Nhom> getList() {
		return list;
	}
	
	public static void data() {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
			String line = "" ;
			String tennhom = "";
			
			ArrayList<String> arr = new ArrayList<>();
			while((line = bufferedReader.readLine()) != null) {
				
				if (Kiemtra.kiemTratennhomXX_XX(line)) {
					tennhom = line;
				} else if (!Kiemtra.kiemTradongtrong(line)) {
					arr.add(line);
				} else {
					if(arr.size() > 0) {

						list.add(new Nhom(arr, tennhom));
						
						tennhom = "";
						arr = new ArrayList<>();
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void print() {
		for (Nhom nhom : list) {
			nhom.print();
		}
	}
	
	public static ArrayList<Nhom> Filter(String key){
		ArrayList<Nhom> filter = new ArrayList<>();
		for (Nhom nhom : list) {
			ArrayList<String> arrayLineHaveKey = new ArrayList<>();
			int temp = 0;
			int all = 0;
			for (String line : nhom.getList()) {
				all++;
				if((line.toLowerCase().contains(key.toLowerCase()))) {
					temp++;
					arrayLineHaveKey.add(line);
				}
			}
			arrayLineHaveKey.add("số câu : " + temp + "/" + all);
			filter.add( new Nhom(arrayLineHaveKey, nhom.getTennhom()));
		}
		
		return filter;
	}
}











