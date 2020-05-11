package Input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Caculate {
	public static long sum(List<Long> list) {
		long temp = 0L;
		for (Long d : list) {
			temp += d;
		}
		return temp;
	}
	
	public  static Map<STOCK, DataOneDay> sort(Map<STOCK, DataOneDay> data){
		ArrayList<Map.Entry<STOCK, DataOneDay>> list = new ArrayList<>(data.entrySet());
		Collections.sort(list, new Comparator<Entry<STOCK, DataOneDay>>() {
			@Override
			public int compare(Entry<STOCK, DataOneDay> o1, Entry<STOCK, DataOneDay> o2) {
				return o1.getValue().getKL() > o2.getValue().getKL() ? -1 : 1;
			}
		});
		Map<STOCK, DataOneDay> sorted = new LinkedHashMap<>();
		for (Map.Entry<STOCK, DataOneDay> entry : list) {
			sorted.put(entry.getKey(), entry.getValue());
		}
		return sorted;
	}
	

}
