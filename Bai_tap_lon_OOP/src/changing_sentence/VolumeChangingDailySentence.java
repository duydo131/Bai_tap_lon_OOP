package changing_sentence;

import java.util.Date;

import Input.STOCK;

public class VolumeChangingDailySentence extends changingSentence {

	public VolumeChangingDailySentence(Date date, STOCK stock) {
		super(date, stock);
		typeStatus=status.stockVolumeStatus();
		type = "khối lượng";
	}
	
	public void setTag() {
		listTag.add("tăng");
		listTag.add("giảm");
		listTag.add("khối lượng");
	}
	
	public String get() {
		return "Trong ngày qua, khối lượng cổ phiếu "+status.stock+" đã "+status.stockVolumeStatus();
	}

}
