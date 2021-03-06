package changing_sentence;

import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import input.DataOneDay;
import input.STOCK;
import input.Tool;

public abstract class Cau1Changing extends Exchanges{
	protected final int SIZE = 2;
	protected LinkedList<StockVolume> list = new LinkedList<>();
	
	@Override
	public String get() {
		return list.get(1).getStock().name() + " và " + list.get(2).getStock().name()
				+ " là những cổ phiếu được chuyển nhượng nhiều nhất trên sàn "
				+ name 
				+ " với lượng khớp trong ngày lần lượt đạt "
				+  Tool.formatLong(list.get(1).getVolume()) 
				+ " và "
				+ Tool.formatLong(list.get(2).getVolume()) 
				+ " chứng khoán.";
	}

	@Override
	public abstract void setInfo(Date date);
	
	@Override
	protected void setList(Map<STOCK, DataOneDay> data){
		Map<STOCK, DataOneDay> sort = Tool.sort(data);
		Function<Map.Entry<STOCK, DataOneDay>, StockVolume> mapper = new Function<Map.Entry<STOCK,DataOneDay>, StockVolume>() {
			
			@Override
			public StockVolume apply(Map.Entry<STOCK, DataOneDay> t) {
				return new StockVolume(t.getKey(), t.getValue().getKL());
			}
		};
		this.list = sort.entrySet().stream().map(mapper).limit(SIZE+1).collect(Collectors.toCollection(LinkedList::new));
	}
	
	@Override
	public void setTag() {
		this.listTag.add("giao dịch nhiều nhất");
		this.listTag.add("day");
		listTag.add("changing");
	}
}







