package Input;

import java.util.LinkedHashMap;
import java.util.Map;

public class Data {
	private static Map<String, DataOneStock> dataVN30 = new LinkedHashMap<>();
	private static Map<String, DataOneStock> dataHNX30 = new LinkedHashMap<>();
	
	public static Map<String, DataOneStock> getDataVN30() {
		return dataVN30;
	}
	
	public static Map<String, DataOneStock> getDataHNX30() {
		return dataHNX30;
	}
	

	public static void add(String name, DataOneDay dataNgay, EXCHANGES exchanges) {
		Map<String,DataOneStock> data = null;	// 	tránh data là null
		
		if(exchanges == EXCHANGES.HNX30) {
			data = dataHNX30;
		}else {
			data = dataVN30;
		}
		
		if(data.containsKey(name)) {
			data.get(name).add(dataNgay);
		}else {
			data.put(name, new DataOneStock());
			data.get(name).add(dataNgay);
		}
	}
	
	
	//	bỏ sau
	public static void print() {
		System.out.println("VN30 : ");
		for (Map.Entry<String, DataOneStock> dulieu : dataVN30.entrySet()) {
			System.out.println();
			System.out.println(dulieu.getKey());
			dulieu.getValue().print();
		}
		
		System.out.println("HNX30 : ");
		for (Map.Entry<String, DataOneStock> dulieu : dataHNX30.entrySet()) {
			System.out.println();
			System.out.println(dulieu.getKey());
			dulieu.getValue().print();
		}
	}
}
