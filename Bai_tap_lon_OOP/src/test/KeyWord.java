package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class KeyWord {

	private static boolean test(String key, String line) {
		if (line.toLowerCase().contains(key.toLowerCase())) {
			return false;
		}else {
			return true;
		}
	}

	public static ArrayList<String> findKeyWord(ArrayList<String> arr) {
		ArrayList<String> key = null;
		
		if (arr.size() >  2) {
			key = new ArrayList<String>(Arrays.asList(arr.get(1).split(" ")));
			for (int i = 2; i < arr.size(); i++) {
				ArrayList<String> keyDelete = new ArrayList<>();
				for (String string : key) {
					if (test(string, arr.get(i))) {
						keyDelete.add(string);
					}
				}
				for (String string : keyDelete) {
					key.remove(String.valueOf(string));
				}
			}
		}
		
		ArrayList<String> array = new ArrayList<>();
		for (String string : key) {
			array.add(string.toLowerCase());
		}	
		
		return (ArrayList<String>) array.stream().distinct().collect(Collectors.toList());
	}
}
