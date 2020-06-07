package ledung;

import java.util.Date;
import java.util.Set;

import Input.*;

public abstract class OverAllWeekStockClass extends OverAllWeek{
	
	private Date date1;
	private Date date2;
	
	public OverAllWeekStockClass(Date date) {
		super(date);
		this.date1 = Sentence.getWeek(date)[0];
		this.date2 = Sentence.getWeek(date)[1];
	}
	
	public double getRatio(STOCK stock) {
		
		Date firstDay = firstWorkingDayOfWeek(date1);
		Date lastDay = lastWorkingDayOfWeek(date2);
		
		return Math.abs((1-(InputData.getToday(lastDay).get(stock).getGiaDongCua()/InputData.getToday(firstDay).get(stock).getGiaMoCua())))*100;
	
	}
	
	public double getDiff(Date date1, Date date2, STOCK stock) {
		
		Date firstDay = firstWorkingDayOfWeek(date1);
		Date lastDay = lastWorkingDayOfWeek(date2);
		
		return InputData.getToday(lastDay).get(stock).getGiaDongCua() - InputData.getToday(firstDay).get(stock).getGiaMoCua();
		
	}

	public int increaseCodeCounter(String className) {
		
		Set<STOCK> stocks = null;
		Date firstDay = firstWorkingDayOfWeek(date1);
		Date lastDay = lastWorkingDayOfWeek(date2);
		int counter = 0;
		
		if (className == "VN30") {
			stocks = InputData.stockVN30();
		} else {
			stocks = InputData.stockHNX30();
		}
		
		for (STOCK stock : stocks) {
			if (this.getDiff(firstDay, lastDay, stock) > 0) {
				counter++;
			}
		}
		
		return counter;
	}
	
	public int decreaseCodeCounter(String className) {
		
		Set<STOCK> stocks = null;
		Date firstDay = this.firstWorkingDayOfWeek(date1);
		Date lastDay = this.lastWorkingDayOfWeek(date2);
		int counter = 0;
		
		if (className == "VN30") {
			stocks = InputData.stockVN30();
		} else {
			stocks = InputData.stockHNX30();
		}
		
		for (STOCK stock : stocks) {
			if (this.getDiff(firstDay, lastDay, stock) < 0) {
				counter++;
			}
		}
		
		return counter;
	}
	
	public String setIndexClause(String className) {
		
		String indexStatus = "";
		STOCK index = null;
		Date firstDay = firstWorkingDayOfWeek(date1);
		Date lastDay = lastWorkingDayOfWeek(date2);
		
		if (className == "VN30") {
			index = STOCK.VNINDEX;
		} else if (className == "HNX30"){
			index = STOCK.HASTC;
		}
		
		double closedValue = InputData.getToday(lastDay).get(index).getGiaDongCua();
		double openValue = InputData.getToday(firstDay).get(index).getGiaMoCua();
		double diff = closedValue - openValue;
		double ratio = getRatio(index);
		
		if (diff > 0) {
			indexStatus = "Chỉ số " + index.name() + " tăng " + InputData.roundNumber(diff) + " điểm, tương đương với "
						+ InputData.roundNumber(ratio) + "%" + ", đạt mức " + closedValue + " điểm.";
		}
		else if (diff < 0) {
			indexStatus = "Chỉ số " + index.name() + " giảm " + InputData.roundNumber(Math.abs(diff)) + " điểm, tương đương với " 
						+ InputData.roundNumber(ratio) + "%" + ", xuống mức " + closedValue + " điểm.";
		}

		return indexStatus;
	}
	
	public void setComplement(String className) {
		
		String indexClause = this.setIndexClause(className);
		int increaseCodeCounter = this.increaseCodeCounter(className);
		int decreaseCodeCounter = this.decreaseCodeCounter(className);
		
		super.setComplement(" với " + increaseCodeCounter + " mã tăng điểm và " + decreaseCodeCounter + " mã giảm điểm. " + indexClause);
	}
	
	public void setVerb(String className) {
		
		int increaseCodeCounter = this.increaseCodeCounter(className);
		
		if (increaseCodeCounter >= 20) {
			super.setVerb(InputData.getRandom(Verb.getManyIncrease()));
		}
		else if (increaseCodeCounter < 20 && increaseCodeCounter >= 16) {
			super.setVerb(InputData.getRandom(Verb.getFewIncrease()));
		}
		else if (increaseCodeCounter < 16 && increaseCodeCounter >= 14) {
			super.setVerb(InputData.getRandom(Verb.getLessChanging()));
		}
		else if (increaseCodeCounter < 14 && increaseCodeCounter >= 10) {
			super.setVerb(InputData.getRandom(Verb.getFewDecrease()));
		}
		else if (increaseCodeCounter < 10) {
			super.setVerb(InputData.getRandom(Verb.getManyDecrease()));
		}
	}
}
