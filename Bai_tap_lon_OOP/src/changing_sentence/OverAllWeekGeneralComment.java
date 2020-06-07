package changing_sentence;

import java.util.ArrayList;
import java.util.Date;

import Input.*;

public class OverAllWeekGeneralComment extends OverAllWeek {
	
	private String timeAdverb;
	
	public OverAllWeekGeneralComment(Date date) {
		super(date);
	}
	
	OverAllWeekVN30 VN30 = new OverAllWeekVN30(date);
	OverAllWeekHNX30 HNX30 = new OverAllWeekHNX30(date);
	
	public void setTimeAdverb() {
		
		// 12 - 14 - 16 - 18

		int VN30Counter = VN30.increaseCodeCounter("VN30");
		int HNX30Counter = HNX30.increaseCodeCounter("HNX30");
		
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
