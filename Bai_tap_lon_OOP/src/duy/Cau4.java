package duy;

import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import Input.DataOneDay;
import Input.Tool;
import Input.STOCK;

public abstract class Cau4 extends San{
	protected static final int SIZE = 3;
	protected Map<Boolean, LinkedList<Map.Entry<STOCK, DataOneDay>>> list = new LinkedHashMap<>();
	protected Date date;
	
	@Override
	public abstract void setInfo(Date date);

	@Override
	public String get() {
		String str = "Trong nhóm " + name
					+ " có 1 só cổ phiếu đáng cú ý như :\n"
					+ "- nhóm tăng : \n"
					+ create(list.get(true), true)
					+ "- nhóm giảm : \n"
					+ create(list.get(false), false);
		return str;
	}
	
	@Override
	public void setTag() {
		this.listTag.add("cổ phiếu đáng chú ý");
		this.listTag.add("tăng");
		this.listTag.add("giảm");
		this.listTag.add("khối lượng giao dịch");
		this.listTag.add("thanh khoản");
		this.listTag.add("giá trị");
	}
	
	@Override
	protected void setList(Map<STOCK, DataOneDay> data) {
		if(data.containsKey(STOCK.VNINDEX)) {
			data.remove(STOCK.VNINDEX);
		}else {
			data.remove(STOCK.HASTC);
		}
		
		LinkedList<Map.Entry<STOCK, DataOneDay>> filter = new LinkedList<>(data.entrySet());
		
		Comparator<Map.Entry<STOCK, DataOneDay>> comparatorKL = new Comparator<Map.Entry<STOCK,DataOneDay>>() {
			
			@Override
			public int compare(Entry<STOCK, DataOneDay> o1, Entry<STOCK, DataOneDay> o2) {
				return o1.getValue().getKL() > o2.getValue().getKL() ? 1 : -1;
			}
		};
		
		Comparator<Map.Entry<STOCK, DataOneDay>> comparatorThanhKhoan = new Comparator<Map.Entry<STOCK,DataOneDay>>() {
			
			@Override
			public int compare(Entry<STOCK, DataOneDay> o1, Entry<STOCK, DataOneDay> o2) {
				return o1.getValue().getThanhKhoan() > o2.getValue().getThanhKhoan() ? 1 : -1;
			}
		};
		
		Comparator<Map.Entry<STOCK, DataOneDay>> comparatorThayDoi = new Comparator<Map.Entry<STOCK,DataOneDay>>() {
			
			@Override
			public int compare(Entry<STOCK, DataOneDay> o1, Entry<STOCK, DataOneDay> o2) {
				return o1.getValue().getThayDoi() > o2.getValue().getThayDoi() ? 1 : -1;
			}
		};
		
		Comparator<Map.Entry<STOCK, DataOneDay>> comparatorThayDoiTuongDoi = new Comparator<Map.Entry<STOCK,DataOneDay>>() {
			
			@Override
			public int compare(Entry<STOCK, DataOneDay> o1, Entry<STOCK, DataOneDay> o2) {
				return o1.getValue().getThayDoi()/o1.getValue().getGiaMoCua() > 
						o2.getValue().getThayDoi()/o2.getValue().getGiaMoCua() ? 1 : -1;
			}
		};
		
		LinkedList<Map.Entry<STOCK, DataOneDay>> increase = new LinkedList<>();
		increase.add(filter.stream().max(comparatorKL).get());
		increase.add(filter.stream().max(comparatorThanhKhoan).get());
		increase.add(filter.stream().max(comparatorThayDoi).get() );
		increase.add(filter.stream().max(comparatorThayDoiTuongDoi).get());
		list.put(true, increase);
		
		LinkedList<Map.Entry<STOCK, DataOneDay>> decrease = new LinkedList<>();
		decrease.add(filter.stream().min(comparatorKL).get());
		decrease.add(filter.stream().min(comparatorThanhKhoan).get());
		decrease.add(filter.stream().min(comparatorThayDoi).get());
		decrease.add(filter.stream().min(comparatorThayDoiTuongDoi).get());
		list.put(false, decrease);
	}
	
	private String create(LinkedList<Map.Entry<STOCK, DataOneDay>> data, Boolean bool) {
		String s = "  + Cổ phiếu có khối lượng giao dịch " + (bool ? "cao " : "thấp ")
					+ "nhất :" + " Cổ phiếu " + data.get(0).getKey() + " với " 
							+ Tool.formatLong(data.get(0).getValue().getKL()) + " cổ phiếu.\n"
							
					+ "  + Cổ phiếu có thanh khoản " + (bool ? "cao " : "thấp ")
					+ " nhất :" + " Cổ phiếu " + data.get(1).getKey() + " với " 
						+ (long)(data.get(1).getValue().getThanhKhoan()/10000)*1.0/100 + " tỷ đồng.\n"
					
					+ "  + Cổ phiếu có giá trị " + (bool ? "tăng " : "giảm ")
					+ "nhiều nhất :" 
					+ (test(data.get(2).getValue().getThayDoi(), bool) ?  " Cổ phiếu " + data.get(2).getKey() + " với "
							+ Math.round(data.get(2).getValue().getThayDoi()*10000)/10 + " đồng. "
							: " không có cổ phiếu có giá trị " + (bool ? "tăng " : "giảm ")) + "\n"  
					
					+ "  + Cổ phiếu có giá trị tương đối " + (bool ? "tăng " : "giảm ")
					+ "nhiều nhất :" 
					+ (test(data.get(3).getValue().getThayDoi(), bool) ? " Cổ phiếu " + data.get(3).getKey() + " với " 
							+ (double)(Math.round((data.get(3).getValue().getThayDoi()/data.get(3).getValue().getGiaMoCua()*10000)))/100 
							+ "% . \n"
							: " không có cổ phiếu có giá trị " + (bool ? "tăng " : "giảm ")) + "\n";
		
		return s;
	}
	
	private boolean test(double thayDoi, boolean bool) {
		boolean test = true;
		if(bool) {
			if(thayDoi < 0) {
				test = false;
			}
		}else {
			if(thayDoi > 0) {
				test = false;
			}
		}
		return test;
	}

}
