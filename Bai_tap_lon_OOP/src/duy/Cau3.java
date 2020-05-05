package duy;

import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import Input.DataOneDay;
import Input.STOCK;

public abstract class Cau3 extends San{
	protected LinkedList<STOCK> list = new LinkedList<>();
	protected String status; 

	@Override
	public abstract void setInfo(Date date);

	@Override
	public String get() {
		String str1 = "Rổ " + name 
					+ " ghi nhận " + create()
					+ status
					+ " trần.";
		String str2 = "Rổ " + name 
					+ " không ghi nhận cổ phiếu nào "
					+ status
					+ " trần.";
		return list.size() == 0 ? str2 : str1;
	}
	
	protected void setList(Map<STOCK, DataOneDay> data) {
		LinkedList<Map.Entry<STOCK, DataOneDay>> filter = new LinkedList<>(data.entrySet());
		Function<Map.Entry<STOCK, DataOneDay>, STOCK> function = new Function<Map.Entry<STOCK,DataOneDay>, STOCK>() {
			
			@Override
			public STOCK apply(Entry<STOCK, DataOneDay> t) {
				return t.getKey();
			}
		};
		
		list = filter.stream().filter(x -> testPrice(x.getValue().getGiaMoCua(), x.getValue().getGiaDongCua()))
						.map(function).collect(Collectors.toCollection(LinkedList::new));
		
		if(list.contains(STOCK.VNINDEX)) {
			list.remove(STOCK.VNINDEX);
		}else if(list.contains(STOCK.HASTC)) {
			list.remove(STOCK.HASTC);
		}
	}
	
	protected abstract boolean testPrice(double giaMoCua, double giaDongCua);

	private String create() {
		StringBuffer string = new StringBuffer("");
		if(list.size() > 0) {
			for (int i = 0; i < list.size() -1; i++) {
				string.append(list.get(i).name() + ", ");
			}
			string.append(list.get(list.size()-1) + " ");
		}
		return string.toString();
	}
}





