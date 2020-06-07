package ledung;

import java.util.Date;

import Input.*;

public abstract class WeekTitleStockClass extends Title{
	
	Date date1 = getWeek(date)[0];	
	Date date2 = getWeek(date)[1];
	
	public WeekTitleStockClass(Date date) {
		super(date);
	}
	
	public int increaseStockCounter(String className) {
		
		int counter = 0;
		
		if (className == "VN30") {
			for (STOCK stock: InputData.stockVN30()) {
				if (stock != STOCK.VNINDEX) {
					if (InputData.getToday(date2).get(stock).getGiaDongCua() - InputData.getToday(date1).get(stock).getGiaMoCua() > 0) {
						counter++;
					}
				}
			}
		}
		else if (className == "HNX30") {
			for (STOCK stock: InputData.stockHNX30()) {
				if (stock != STOCK.HASTC) {
					if (InputData.getToday(date2).get(stock).getGiaDongCua() - InputData.getToday(date1).get(stock).getGiaMoCua() > 0) {
						counter++;
					}
				}
			}
		}
		return counter;
	}
	
	public void setAdverb() {
		this.adverb = "Thị trường chứng khoán ngày " + formats.format(date1) + " đến ngày " + formats.format(date2) + ": ";
	}
	
	public void setComplement(String className) {
		
		STOCK stock = STOCK.VNINDEX;
		
		if (className == "HNX30") {
			stock = STOCK.HASTC;
		}
		
		double closedWeekValue = InputData.getToday(date2).get(stock).getGiaDongCua();
		double openWeekValue = InputData.getToday(date1).get(stock).getGiaMoCua();
		double diff = closedWeekValue - openWeekValue;
				
		if (diff > 0) {
			super.setComplement("chỉ số " + className + " tăng " + InputData.roundNumber(diff) + " điểm.");
		} 
		else if (diff < 0) {
			super.setComplement("chỉ số " + className + " giảm " + InputData.roundNumber(Math.abs(diff)) + " điểm.");
		}
		else {
			super.setComplement("chỉ số " + className + " thành công trụ điểm.");
		}
	}
	
	public void setVerb(String className) {
		
		int counter = 1;

		if (counter >= 22) {
			super.setVerb(InputData.getRandom(Verb.getManyIncrease()));
		}
		else if(counter < 8) {
			super.setVerb(InputData.getRandom(Verb.getManyDecrease()));
		}
		else if(counter > 18 && counter < 22) {
			super.setVerb(InputData.getRandom(Verb.getFewIncrease()));
		}
		else if(counter < 12 && counter > 8) {
			super.setVerb(InputData.getRandom(Verb.getFewDecrease()));
		} 
		else {
			super.setVerb(InputData.getRandom(Verb.getLessChanging()));
		}
	}
}
