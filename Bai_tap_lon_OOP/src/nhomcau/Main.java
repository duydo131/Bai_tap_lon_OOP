package nhomcau;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		String key = "tăng";
		
		Input.data();
		
		ArrayList<Nhom> array = Input.Filter(key);
		
		for (Nhom nhom : array) {
			System.out.println(nhom.getTennhom() + " : ");
			for (String string : nhom.getList()) {
				System.out.println(string);
			}
			System.out.println();
		}
				
				
		System.out.println(System.currentTimeMillis() - start);
	}
}
