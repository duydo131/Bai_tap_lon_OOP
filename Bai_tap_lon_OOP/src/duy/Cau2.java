package duy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

import Input.DataOneDay;
import Input.Format;
import Input.STOCK;

public abstract class Cau2 extends San {
	protected LinkedList<Stock> list = new LinkedList<>();

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
					+ " mã giao dịch được trên một triệu chứng khoán, trong đó "
					+ list.get(1).getStock().name()
					+ " nổi bật nhất với "
					+ Format.formatsDouble(list.get(1).getVolume()*1.0/1000000)
					+ " triệu cổ phiếu được giao dịch.";
		}
		return str;
	}

	protected void setList(Map<STOCK, DataOneDay> data) {
		ArrayList<Stock> filter = new ArrayList<>();
		for (Map.Entry<STOCK, DataOneDay> item : data.entrySet()) {
			filter.add(new Stock(item.getKey(), item.getValue().getKL()));
		}
		list =  filter.stream().filter(x -> x.getVolume()>1000000)
							.collect(Collectors.toCollection(LinkedList::new));
		
		Collections.sort(list, new Comparator<Stock>() {

			@Override
			public int compare(Stock o1, Stock o2) {
				return o1.getVolume() > o2.getVolume() ? -1 : 1;
			}
		});
	}
	
}
