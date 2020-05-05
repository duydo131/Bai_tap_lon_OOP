package GUI;

import java.util.Calendar;
import java.util.Date;

import Input.InputData;
import Input.STOCK;
import duy.Cau3GiamHNX30;
import duy.Cau3GiamVN30;
import duy.Cau3TangHNX30;
import duy.Cau3TangVN30;
import duy.Cau4HNX30;
import duy.Cau4VN30;
import duy.Phien;
import duy.VolumeHNX30;
import duy.VolumeVN30;
import duy.Week;

public class DataLoad {
	private Date date;
	
	public DataLoad(Date date) {
		this.date = date;
	}
	
	private int getDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
		
	}
	
	public String get() {
		StringBuffer string = new StringBuffer();
		int i = getDay();
		if(i == 1 || i == 7) {
			// ngày phải là cuối tuần
			string.append((new Week()).setInfo(date, STOCK.VNINDEX).get());
			string.append("\n");
			string.append((new Week()).setInfo(date, STOCK.HASTC).get());
		}
		else {
			if(InputData.testDay(date)) {
				string.append((new Phien()).setInfo(date, STOCK.VNINDEX).get());
				string.append("\n");
				string.append((new Phien()).setInfo(date, STOCK.HASTC).get());
				string.append("\n");
				
				string.append((new VolumeVN30(date)).get());
				string.append("\n");
				string.append((new VolumeHNX30(date)).get());
				
				string.append("\n");
				string.append((new Cau3TangVN30(date)).get());
				string.append("\n");
				string.append((new Cau3TangHNX30(date)).get());
				string.append("\n");
				string.append((new Cau3GiamVN30(date)).get());
				string.append("\n");
				string.append((new Cau3GiamHNX30(date)).get());
				string.append("\n");
				
				string.append("\n");
				string.append((new Cau4VN30(date)).get());
				string.append("\n");
				string.append((new Cau4HNX30(date)).get());
			}else {
				string.append("Hôm nay nghỉ lễ không giao dịch.");
			}
			
		}
		return string.toString();
	}
	

}
