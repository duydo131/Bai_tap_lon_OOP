package changing_sentence;

import java.util.Date;

import Input.STOCK;

public class VolumePercentageDailyChangingSentence extends changingSentence {

	public VolumePercentageDailyChangingSentence(Date date, STOCK stock) {
		super(date, stock);
		typeStatus=status.stockVolumePercentageStatus();
		type = "khối lượng";
	}
	@Override
	public void setTag() {
		listTag.add("tăng");
		listTag.add("giảm");
		listTag.add("khối lượng");
		listTag.add("%");
	}
	
	public String get() {
		return "Trong ngày qua, giá cổ phiếu "+status.stock+" đã "+status.stockVolumePercentageStatus();
	}
}
