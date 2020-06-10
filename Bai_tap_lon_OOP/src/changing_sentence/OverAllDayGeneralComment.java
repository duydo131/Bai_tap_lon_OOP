package changing_sentence;

import java.util.ArrayList;
import java.util.Date;

import input.InputData;

public class OverAllDayGeneralComment extends OverAllDay {
	
	private String timeAdverb;
	
	public OverAllDayGeneralComment(Date date) {
		super(date);
		setTag();
	}
	
	OverAllDayVN30 VN30 = new OverAllDayVN30(date);
	OverAllDayHNX30 HNX30 = new OverAllDayHNX30(date);

	public void setTimeAdverb() {
		
		// 12 - 14 - 16 - 18

		int VN30Counter = VN30.increaseStockCounter("VN30");
		int HNX30Counter = HNX30.increaseStockCounter("HNX30");
		
		if ((VN30Counter >= 16) && (HNX30Counter >= 16) ||
			(VN30Counter <= 14) && (HNX30Counter <= 14) ||
			(VN30Counter <= 16 && VN30Counter >= 14) && (HNX30Counter <= 16 && HNX30Counter >= 14)) {
			this.timeAdverb  = InputData.getRandom(AdverbTime.getProgressiveTimeAdverb());
		}
		else if ((VN30Counter >= 18) && (HNX30Counter <= 12) ||
				(VN30Counter <= 12) && (HNX30Counter >= 18) ||
				(VN30Counter <= 16 && VN30Counter >= 14) && (HNX30Counter >= 16 || HNX30Counter <= 14) ||
				((VN30Counter >= 16 || VN30Counter <= 14) && (HNX30Counter >= 14 && HNX30Counter <= 16))) {
			this.timeAdverb = InputData.getRandom(AdverbTime.getOpposingTimeAdverb());
		}
	}

	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}

	@Override
	public String get() {
		
		this.setTimeAdverb();

		return VN30.get() + timeAdverb + HNX30.get();
	}

	@Override
	public void setTag() {
		listTag.add("overall");
		listTag.add("general comment");
	}
}
