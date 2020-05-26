package duy;

import java.util.ArrayList;
import java.util.Date;

import Input.Tool;
import gui.Tag;
import Input.STOCK;

public abstract class NhanXet implements Tag{
	protected String name;
	protected long allVolume;
	protected long change;
	protected STOCK stock;
	protected Date date;
	
	protected ArrayList<String> listTag = new ArrayList<>();
	
	protected abstract void setInfo();
	
	@Override
	public String get() {
		return 	"Cả " + name + " sàn " 
				+ (stock == STOCK.VNINDEX ? "HOSE" : "Hà Nội") 
				+ " có "  
				+ Math.round(allVolume*1.0/1000000)  
				+ " triệu chứng khoán khớp lệnh, " 
				+ (change > 0 ? "tăng " : "giảm ")
				+ (Math.abs(change) > 1000000 ? Math.abs(change)/1000000 + " triệu" : Math.abs(change))
				+ (name.equals("tuần") ? " (" + Tool.formatsDouble(change*1.0/(allVolume-change)*100) + "%)" : "")
				+ " so với " + name + " trước.";
	}
	
	@Override
	public void setTag() {
		this.listTag.add("nhận xét");
	}
}
