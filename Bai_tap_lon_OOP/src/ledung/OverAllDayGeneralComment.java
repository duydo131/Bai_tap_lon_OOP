package ledung;

import java.util.Date;

import Input.InputData;
import Input.ReadFile;

public class OverAllDayGeneralComment extends OverAllDay {
	
	public OverAllDayGeneralComment(Date date) {
		super(date);
	}
	
	OverAllDayStockClass VN30 = new OverAllDayStockClass(date,"VN30");
	OverAllDayStockClass HNX30 = new OverAllDayStockClass(date,"HNX30");

	
	public String setTimeAdverb() {
		String timeAdverb = "";
		int VN30cnt = VN30.increaseCounter("VN30");
		int HNX30cnt = HNX30.increaseCounter("HNX30");
		if ((VN30cnt >= 20) && (HNX30cnt >= 20) ||
				(VN30cnt <= 10) && (HNX30cnt <= 10 ) ||
				(VN30cnt <= 20 && VN30cnt >= 10) && (HNX30cnt <= 20 && HNX30cnt >= 10)){
					timeAdverb = InputData.getRandom(AdverbTime.getProgressiveTimeAdverb());
					return timeAdverb;
				}
		else if ((VN30cnt >= 20) && (HNX30cnt <= 10) ||
				(VN30cnt <= 10) && (HNX30cnt >= 20 ) ||
				(VN30cnt <= 20 && VN30cnt >= 10) && (HNX30cnt >= 20 || HNX30cnt <= 10)){
					timeAdverb = InputData.getRandom(AdverbTime.getOpposingTimeAdverb());
					return timeAdverb;
		}
		return null;
	}
	
	public String setLinkWord() {
		String linkWord = "";
		int VN30cnt = VN30.increaseCounter("VN30");
		int HNX30cnt = HNX30.increaseCounter("HNX30");
		if ((VN30cnt >= 20) && (HNX30cnt >= 20) ||
				(VN30cnt <= 10) && (HNX30cnt <= 10 ) ||
				(VN30cnt <= 20 && VN30cnt >= 10) && (HNX30cnt < 20 && HNX30cnt >= 10)){
				linkWord = InputData.getRandom(LinkWord.getProgressiveLinkWord());
					return linkWord;
				}
		else if ((VN30cnt >= 20) && (HNX30cnt <= 10) ||
				(VN30cnt <= 10) && (HNX30cnt >= 20 ) ||
				(VN30cnt <= 20 && VN30cnt >= 10) && (HNX30cnt >= 20 || HNX30cnt < 10)){
				linkWord = InputData.getRandom(LinkWord.getOpposingLinkWord());
					return linkWord;
		}
		return null;
	}
	
	public String createClause() {
		
		ReadFile.loadData();
				
		String timeAdverb = this.setTimeAdverb();
		
		if (InputData.isWeekend(date)) {
			return "Ngày cuối tuần không có giao dịch";
		}

		return VN30.setClause("VN30") + timeAdverb + HNX30.setClause("HNX30");
		
	}
	
	public void createSentence() {
		
		System.out.println(this.createClause());
		
	}
}
