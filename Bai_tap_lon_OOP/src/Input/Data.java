package Input;

import java.util.HashMap;
import java.util.Map;

public class Data {
	private static Map<String, DataOneStock> dataVN30 = new HashMap<>();
	private static Map<String, DataOneStock> dataHNX30 = new HashMap<>();
	
	public static Map<String, DataOneStock> getDataVN30() {
		return dataVN30;
	}
	
	public static Map<String, DataOneStock> getDataHNX30() {
		return dataHNX30;
	}
	

	public static void add(String name, DataOneDay dataNgay, Exchanges exchanges) {
		Map<String,DataOneStock> data = null;	// 	tránh data là null
		
		if(exchanges == Exchanges.HNX30) {
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
