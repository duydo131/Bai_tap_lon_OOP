package changing_sentence;

import java.util.Date;

import Input.*;

public abstract class OverAllDayStockClass extends OverAllDay {
		
	public OverAllDayStockClass (Date date, String className) {
		super(date);
		this.subject = className;
	}
	
	@Override
	public void setTag() {
		super.setTag();
	}
	
	protected void setTag(String tag) {
		listTag.add(tag);
	}
	
	public int increaseStockCounter(String className) {
		
		int counter = 0;
		
		if (className == "VN30") {
			for (STOCK i : InputData.stockVN30()) {
				if (InputData.getDifferenceOneDayOneStock(i, date)>0) {
					counter++;
				}
			}
			return counter;
		}
		else if (className == "HNX30") {
			for (STOCK i : InputData.stockHNX30()) {
				if (InputData.getDifferenceOneDayOneStock(i, date)>0) {
					counter++;
				}
			}
			return counter;
		}
		return 0;
	}
	
	public void setVerb(String className) {
		// 6 - 14 - 16 - 24
		int counter = increaseStockCounter(className);
		
		if (counter >= 16) {
			super.setVerb(InputData.getRandom(Verb.getManyIncrease()));
		}
		else if(counter < 6) {
			super.setVerb(InputData.getRandom(Verb.getManyDecrease()));
		}
		else if(counter > 16 && counter < 24) {
			super.setVerb(InputData.getRandom(Verb.getFewIncrease()));
		}
		else if(counter < 14 && counter > 6) {
			super.setVerb(InputData.getRandom(Verb.getFewDecrease()));
		} 
		else {
			super.setVerb(InputData.getRandom(Verb.getLessChanging()));
		}
	}

	public void setComplement(String className) {
		
		STOCK index;
		int counter = increaseStockCounter(className);

		if (className == "VN30") {
			index = STOCK.VNINDEX;
		} else {
			index = STOCK.HASTC;
		}
		
		double todayIndexValue = InputData.getToday(date).get(index).getGiaDongCua();
		double yesterdayIndexValue = InputData.getToday(Tool.getDate(date, -1)).get(index).getGiaMoCua();
		double diff = todayIndexValue - yesterdayIndexValue;
		double ratio = Math.abs(1 - todayIndexValue/yesterdayIndexValue)*100;
		
		if (diff > 0) {
			super.setComplement(" với " + counter + " mã tăng điểm và " + (30-counter) + " mã giảm điểm. Chỉ số " + index.name() + 
							   " tăng " + InputData.roundNumber(diff) + " điểm, tương đương với " + InputData.roundNumber(ratio) + 
							   "%, đạt mốc " + todayIndexValue + " điểm.");
		}
		else if (diff < 0) {
			super.setComplement(" với " + counter + " mã tăng điểm và " + (30-counter) + " mã giảm điểm. Chỉ số " + index.name() + 
							   " giảm " + InputData.roundNumber(Math.abs(diff)) + " điểm, tương đương với " + InputData.roundNumber(ratio) + 
							   "%, xuống mốc " + todayIndexValue + " điểm.");
		}
		else {
			super.setComplement(" với " + counter + " mã tăng điểm và " + (30-counter) + " mã giảm điểm. Chỉ số " + index.name() + 
							   " trụ điểm thành công, đạt mức " + todayIndexValue + " điểm.");
		}
	}
}
