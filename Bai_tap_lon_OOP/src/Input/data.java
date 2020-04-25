package Input;

import java.util.HashMap;
import java.util.Map;

public class data {
	private static Map<String, data1> data = new HashMap<>();
	
	public static void add(String name, DataNgay dataNgay) {
		if(data.containsKey(name)) {
			data.get(name).add(dataNgay);
		}else {
			data.put(name, new data1());
		}
	}
	
	public static void print() {
		for (Map.Entry<String, data1> dulieu : data.entrySet()) {
			System.out.println();
			System.out.println(dulieu.getKey());
			dulieu.getValue().print();
		}
	}
}
