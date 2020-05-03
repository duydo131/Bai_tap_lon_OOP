package duy;

import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import Input.Caculate;
import Input.DataOneDay;
import Input.Format;
import Input.STOCK;

public abstract class Cau1 extends San{

	protected final int SIZE = 2;
	protected LinkedList<Stock> list = new LinkedList<>();
	
	@Override
	public String get() {
		return list.get(1).getStock().name() + " và " + list.get(2).getStock().name()
				+ " là những cổ phiếu được chuyển nhượng nhiều nhất trên sàn "
				+ name 
				+ " với lượng khớp trong ngày lần lượt đạt "
				+  Format.formatLong(list.get(1).getVolume()) 
				+ " và "
				+ Format.formatLong(list.get(2).getVolume()) 
				+ " chứng khoán.";
	}

	@Override
	public abstract void setInfo(Date date);
	
	protected void setList(Map<STOCK, DataOneDay> data){
		Map<STOCK, DataOneDay> sort = Caculate.sort(data);
		
		int i = 0; 
		for (Entry<STOCK, DataOneDay> entry : sort.entrySet()) {
			if(i <= SIZE) {
				i++;
				list.add(new Stock(entry.getKey(), entry.getValue().getKL()));
			}else {
				break;
			}
		}
	}
}







