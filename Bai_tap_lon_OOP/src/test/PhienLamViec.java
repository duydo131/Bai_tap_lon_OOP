package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PhienLamViec {
	public static Set<String> Phien(Set<String> array, ArrayList<String> keyword){
		Set<String> ar = new HashSet<String>();
		for (String string : array) {
			if(Kiemtra.kiemTra(keyword, string)) {
				ar.add(string);
			}
		}
		return ar;
	}
}
