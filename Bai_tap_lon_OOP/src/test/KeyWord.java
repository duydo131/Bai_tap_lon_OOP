package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class KeyWord {

	private static boolean test(String key, String line) {
		ArrayList<String> words = new ArrayList<String>(Arrays.asList(line.split(" ")));
		for (String string : words) {
			if (string.toLowerCase().equals(key.toLowerCase())) {
				return false;
			} 
		}
		return true;

	}

	private static void delete(LinkedList<Integer> arr, ArrayList<Integer> array) {
		for (int i = 0; i < array.size(); i++) {
			arr.remove(array.get(i) - i);
		}
	}

	private static int saiSo(int size) {
		int saiso;
		switch (size) {
		case 0:
		case 1:
		case 2:
			saiso = 0;
			break;
			
		case 3:
		case 4:
		case 5:
			saiso = 1;
			break;
			
		case 6:
		case 7:
		
			saiso = 2;
			break;
			
		case 8:
		case 9:
			saiso = 3;
			break;
		
		default:
			saiso = 4;
			break;
		}
		return saiso;
	}
	
	
	public static ArrayList<String> findKeyWord(ArrayList<String> arr ) {
		ArrayList<String> key = null;
		int SAISO = saiSo(arr.size());
		
		if (arr.size() > 3 ) {
			key = new ArrayList<String>(Arrays.asList(arr.get(0).split(" ")));
			LinkedList<Integer> size = new LinkedList<>();
			for (int i = 0; i < key.size(); i++) {
				size.add(SAISO);
			}

			for (int i = 1; i < arr.size(); i++) {
				ArrayList<String> keyDelete = new ArrayList<>();
				ArrayList<Integer> indexDelete = new ArrayList<>();
				for (int j = 0; j < key.size(); j++) {
					if (test(key.get(j), arr.get(i))) {
						if (size.get(j) > 0) {
							size.set(j, size.get(j) - 1);
						} else {
							indexDelete.add(j);
							keyDelete.add(key.get(j));
						}
					}
				}

				for (String string : keyDelete) {
					key.remove(String.valueOf(string));
				}
				delete(size, indexDelete);
			}
		}

		ArrayList<String> array = new ArrayList<>();

		if (key == null || key.size() == 0) {
			array.add("không tìm thấy");
		} else {
			for (String string : key) {
				array.add(string.toLowerCase());
			}
		}

		return (ArrayList<String>) array.stream().distinct().collect(Collectors.toList());
	}
}
