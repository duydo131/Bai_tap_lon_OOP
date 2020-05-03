package Input;

import java.util.LinkedHashMap;
import java.util.Map;

public class Data {
	private static Map<STOCK, DataOneStock> dataVN30 = new LinkedHashMap<>();
	private static Map<STOCK, DataOneStock> dataHNX30 = new LinkedHashMap<>();
	
	private static boolean isEmty = true;
	
	public static Map<STOCK, DataOneStock> getDataVN30() {
		return dataVN30;
	}
	
	public static Map<STOCK, DataOneStock> getDataHNX30() {
		return dataHNX30;
	}
	
	public static void loaded() {
		isEmty = false;
	}
	
	public static boolean getEmty() {
		return isEmty;
	}
	

	public static void add(STOCK stock, DataOneDay dataNgay, EXCHANGES exchanges) {
		Map<STOCK,DataOneStock> data = null;	// 	tránh data là null
		
		if(exchanges == EXCHANGES.HNX30) {
			data = dataHNX30;
		}else {
			data = dataVN30;
		}
		
		if(data.containsKey(stock)) {
			data.get(stock).add(dataNgay);
		}else {
			data.put(stock, new DataOneStock());
			data.get(stock).add(dataNgay);
		}
	}
	
	
	public static void print() {
		System.out.println("VN30 : ");
		for (Map.Entry<STOCK, DataOneStock> dulieu : dataVN30.entrySet()) {
			System.out.println();
			System.out.println(dulieu.getKey());
			dulieu.getValue().print();
		}
		
		System.out.println("\nHNX30 : ");
		for (Map.Entry<STOCK, DataOneStock> dulieu : dataHNX30.entrySet()) {
			System.out.println();
			System.out.println(dulieu.getKey());
			dulieu.getValue().print();
		}
	}
	
	
}
