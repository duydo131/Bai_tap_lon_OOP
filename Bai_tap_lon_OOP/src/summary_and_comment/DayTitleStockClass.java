package summary_and_comment;

import java.util.Date;

import Input.*;
import changing_sentence.OverAllDayHNX30;
import changing_sentence.OverAllDayStockClass;
import changing_sentence.OverAllDayVN30;
import changing_sentence.Verb;

public abstract class DayTitleStockClass extends Title{
		
	public DayTitleStockClass(Date date) {
		super(date);
	}
	
	@Override
	public void setTag() {
		super.setTag();
	}
	
	protected void setTag(String tag) {
		listTag.add(tag);
	}
	
	public void setVerb(String className) {
		
		OverAllDayStockClass data;
		int counter = 0;
		
		if (className == "VN30") {
			data = new OverAllDayVN30(date);
			counter = data.increaseStockCounter("VN30");
		} 
		else {
			data = new OverAllDayHNX30(date);
			counter = data.increaseStockCounter("HNX30");
		}

		if (counter >= 22) {
			super.setVerb(InputData.getRandom(Verb.getManyIncrease()));
		}
		else if(counter < 8) {
			super.setVerb(InputData.getRandom(Verb.getManyDecrease()));
		}
		else if(counter >= 18 && counter < 22) {
			super.setVerb(InputData.getRandom(Verb.getFewIncrease()));
		}
		else if(counter < 12 && counter >= 8) {
			super.setVerb(InputData.getRandom(Verb.getFewDecrease()));
		} 
		else {
			super.setVerb(InputData.getRandom(Verb.getLessChanging()));
		}
	}
	
	public void setComplement(String className) {
		
		STOCK index = STOCK.HASTC;
		
		if (className == "VN30") {
			index = STOCK.VNINDEX;
		}
		
		double diff = InputData.getToday(date).get(index).getThayDoi();
		
		if (index == STOCK.VNINDEX) {
			if (diff > 0) {
				super.setComplement("chỉ số " + index.name() + " tăng " + InputData.roundNumber(diff) + " điểm.");
			}
			else if (diff < 0) {
				super.setComplement("chỉ số " + index.name() + " giảm " + InputData.roundNumber(Math.abs(diff)) + " điểm.");
			}
			else {
				super.setComplement("chỉ số " + index.name() + " trụ giá thành công");
			}
		}
		else if (index == STOCK.HASTC) {
			if (diff > 0) {
				super.setComplement("chỉ số " + index.name() + " tăng " + InputData.roundNumber(diff) + " điểm.");
			}
			else if (diff < 0) {
				super.setComplement("chỉ số " + index.name() + " giảm " + InputData.roundNumber(Math.abs(diff)) + " điểm.");
			}
			else {
				super.setComplement("chỉ số " + index.name() + " trụ giá thành công");
			}
		}
	}
}
