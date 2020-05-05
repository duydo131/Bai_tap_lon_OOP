package duy;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import Input.DataOneDay;
import Input.Format;
import Input.STOCK;

public abstract class Cau2 extends San {
	protected LinkedList<StockVolume> list = new LinkedList<>();

	@Override
	public abstract void setInfo(Date date);

	@Override
	public String get() {
		String str  = "";
		if(list.size() <= 1) {
			str = "Trên sàn " + name + " không có giao dịch nào trên 1 triệu cổ phiếu";
		}else {
			str = 	"Toàn sàn " + name
					+ " ghi nhận " + (list.size() - 1)
					+ " mã giao dịch được trên 1 triệu chứng khoán, trong đó "
					+ list.get(1).getStock().name()
					+ " nổi bật nhất với "
					+ Format.formatsDouble(list.get(1).getVolume()*1.0/1000000)
					+ " triệu cổ phiếu được giao dịch.\n" 
					+ "Cụ thể, những cổ phiếu giao dịch trên 1 triệu cổ phiếu trong phiên hôm nay : "
					+ create();
		}
		return str;
	}

	protected void setList(Map<STOCK, DataOneDay> data) {
		LinkedList<Map.Entry<STOCK, DataOneDay>> filter = new LinkedList<>(data.entrySet());
		
		Predicate<Map.Entry<STOCK, DataOneDay>> predicate = new Predicate<Map.Entry<STOCK,DataOneDay>>() {
			
			@Override
			public boolean test(Entry<STOCK, DataOneDay> t) {
				return t.getValue().getKL() > 1000000;
			}
		};
		
		Function<Map.Entry<STOCK, DataOneDay>, StockVolume> mapper = new Function<Map.Entry<STOCK,DataOneDay>, StockVolume>() {
			
			@Override
			public StockVolume apply(Entry<STOCK, DataOneDay> t) {
				return new StockVolume(t.getKey(), t.getValue().getKL());
			}
		};
		
		list = filter.stream().filter(predicate).map(mapper).collect(Collectors.toCollection(LinkedList::new));
		
		Collections.sort(list, new Comparator<StockVolume>() {
			
			@Override
			public int compare(StockVolume o1, StockVolume o2) {
				return o1.getVolume() > o2.getVolume() ? -1 : 1;
			}
		});
	}
	
	private String create() {
		StringBuffer string = new StringBuffer();
		for (int i = 1; i < list.size()-1; i++) {
			string.append(list.get(i).getStock().name() + ", ");
		}
		string.append(list.get(list.size()-1).getStock().name() + ".");
		return string.toString();
	}
}
