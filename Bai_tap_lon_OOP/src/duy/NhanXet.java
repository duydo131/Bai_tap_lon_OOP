package duy;

import java.util.Date;

import Input.Format;
import Input.STOCK;

public abstract class NhanXet {
	protected String name;
	protected long allVolume;
	protected long change;
	protected STOCK stock;
	
	public abstract NhanXet setInfo(Date date, STOCK stock);
	
	public String get() {
		return 	"Cả " + name + " sàn " 
				+ (stock == STOCK.VNINDEX ? "HOSE" : "Hà Nội") 
				+ " có "  
				+ Math.round(allVolume*1.0/1000000)  
				+ " triệu chứng khoán khớp lệnh, " 
				+ (change > 0 ? "tăng " : "giảm ")
				+ (Math.abs(change) > 1000000 ? Math.abs(change)/1000000 + " triệu" : Math.abs(change))
				+ (name.equals("tuần") ? " (" 
				+ Format.formatsDouble(change*1.0/(allVolume-change)*100) + "%)" : "")
				+ " so với " + name + " trước.";
	}
}
