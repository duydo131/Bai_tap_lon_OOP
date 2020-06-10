package stock_code_analization;

import java.util.Date;

import input.STOCK;

public class VolumePercentageDailyChangingSentence extends ChangingSentence {
	public VolumePercentageDailyChangingSentence(Date date, STOCK stock) {
		super(date,stock);
		type="khối lượng";
		typeStatus=status.stockVolumePercentageStatus();
	}
	
	
	public void setTag() {
		listTag.add("oneStock");
		listTag.add("day");
		listTag.add("tăng");
		listTag.add("giảm");
		listTag.add("khối lượng");
		listTag.add("%");
	}
	
	
}
