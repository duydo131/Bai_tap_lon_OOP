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
		for (Long item : list) {
			temp += item;
		}
		return temp;
	}
	
	public  static <T extends DataOneDay> Map<STOCK, T> sort(Map<STOCK, T> data){
		ArrayList<Map.Entry<STOCK, T>> list = new ArrayList<>(data.entrySet());
		Collections.sort(list, new Comparator<Entry<STOCK, T>>() {
			@Override
			public int compare(Entry<STOCK, T> o1, Entry<STOCK, T> o2) {
				return o1.getValue().getKL() > o2.getValue().getKL() ? -1 : 1;
			}
		});
		Map<STOCK, T> sorted = new LinkedHashMap<>();
		for (Map.Entry<STOCK, T> entry : list) {
			sorted.put(entry.getKey(), entry.getValue());
		}
		return sorted;
	}
	

}
