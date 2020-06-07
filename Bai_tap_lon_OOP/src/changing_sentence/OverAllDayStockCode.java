package changing_sentence;

import java.util.ArrayList;
import java.util.Date;

import Input.*;

public class OverAllDayStockCode extends OverAllDay{
	
	private STOCK stock;
	private String adverb;
	
	public OverAllDayStockCode(Date date, STOCK stock) {
		super(date);
		this.subject = stock.name();
		this.stock = stock;
		setTag();
	}

	public String createOptimumClause() {
		
		String clause = "";
		double max = InputData.getToday(date).get(stock).getGiaMax()*1000;
		double min = InputData.getToday(date).get(stock).getGiaMin()*1000;
		int maxCounter = optimumCounter("max", date, stock);
		int minCounter = optimumCounter("min", date, stock);

		if (maxCounter > 0 && minCounter == 0) {			
			if (maxCounter > 1) {
				clause = "đã có thời điểm tăng trần trong " + maxCounter + " ngày trở lại đây, đạt mức " + max + " đồng/cp";
			}
			else if (maxCounter == 1) {
				clause = "đã có thời điểm tăng trần ở mức " + max + " đồng/cp";
			}
		}
		else if (minCounter > 0 && maxCounter == 0) {
			if (minCounter > 1) {
				clause = "đã có thời điểm giảm trần trong " + minCounter + " ngày trở lại đây, xuống mức " + min + " đồng/cp";
			}
			else if (minCounter == 0) {
				clause = "đã có thời điểm giảm trần ở mức " + min + " đồng/cp";
			}
		}
		else if (minCounter > 0 && maxCounter > 0) {
			if (minCounter > 1 && maxCounter == 1) {
				clause = "đã có thời điểm giảm trần sau " + minCounter + " ngày, xuống mức " + min + " đồng/cp và cũng đã có lúc tăng trần lên mức" + max + " đồng/cp";
			}
			else if (minCounter == 1 && maxCounter > 1) {
				clause = "đã có thời điểm tăng trần sau " + maxCounter + " ngày, lên mức " + max + " đồng/cp và cũng đã có lúc giảm trần xuống mức" + min + " đồng/cp";
			}
			else if (minCounter > 1 && maxCounter > 1) {
				clause = "đã có thời điểm tăng trần sau " + maxCounter + " ngày, lên mức " + max + " đồng/cp và cũng đã có lúc giảm trần sau " + minCounter + " ngày, xuống mức" + min + " đồng/cp";
			}
			else if (minCounter == 1 && maxCounter == 1) {
				clause = "đã có thời điểm tăng trần lên mức " + max + " đồng/cp và cũng đã có lúc giảm trần xuống mức" + min + " đồng/cp";
			}
		}
		else if (minCounter == 0 && maxCounter == 0) {
			return clause;
		}
		return clause;
	}
	
	public String createVolumeClause() {
		
		long volume = InputData.getToday(date).get(stock).getKL();
		
		return "khối lượng giao dịch đạt ở mức " + volume + " đơn vị."; 
	}
	
	public void setAdverb() {
		
		double diff = InputData.getToday(date).get(stock).getThayDoi();
		int increaseCounter = InputData.increaseCounterOneStock(stock, date);
		int decreaseCounter = InputData.decreaseCounterOneStock(stock, date);
		
		if (increaseCounter > 0) {
			if (diff > 0) {
				if (increaseCounter > 1) {
					this.adverb = InputData.getRandom(AdverbStatus.getIncThenInc()) + "sau " + increaseCounter + " phiên tăng giá liên tiếp";
				}
				else {
					this.adverb = InputData.getRandom(AdverbStatus.getIncThenInc()) + "của phiên giao dịch ngày hôm qua";
				}
			}
			else if (diff < 0) {
				if (increaseCounter > 1) {
					this.adverb = InputData.getRandom(AdverbStatus.getIncThenDec()) + "sau " + increaseCounter + " phiên tăng giá liên tiếp";
				}
				else {
					this.adverb = InputData.getRandom(AdverbStatus.getIncThenDec()) + "sau phiên giao dịch ngày hôm qua";
				}
			}
		} 
		else if (decreaseCounter > 0) {
			if (diff > 0) {
				if (increaseCounter > 1) {
					this.adverb = InputData.getRandom(AdverbStatus.getDecThenInc()) + "sau " + increaseCounter + " phiên giảm giá liên tiếp";
				}
				else {
					this.adverb = InputData.getRandom(AdverbStatus.getDecThenInc()) + "của phiên giao dịch ngày hôm qua";
				}
			}
			else if (diff < 0) {
				if (increaseCounter > 1) {
					this.adverb = InputData.getRandom(AdverbStatus.getDecThenDec()) + "sau " + increaseCounter + " phiên giảm giá liên tiếp";
				}
				else {
					this.adverb = InputData.getRandom(AdverbStatus.getDecThenDec()) + "sau phiên giao dịch ngày hôm qua";
				}
			}
		}
	}
	
	public void setVerb() {
		
		double diff = InputData.getToday(date).get(stock).getThayDoi();
		double closedValue = InputData.getToday(date).get(stock).getGiaDongCua()*1000;
		double openValue = InputData.getToday(date).get(stock).getGiaMoCua()*1000;
		
		if (diff > 0) {
			if (diff > 0.4*openValue) {
				this.setVerb(InputData.getRandom(Verb.getFastIncrease()) + " lên mức " + closedValue + " đồng/cổ phiếu");
			}
			else {
				this.setVerb(InputData.getRandom(Verb.getSlowIncrease()) + " lên mức " + closedValue + " đồng/cổ phiếu");
			}
		}
		else if (diff < 0) {
			if (Math.abs(diff) > 0.4*openValue) {
				this.setVerb(InputData.getRandom(Verb.getFastDecrease()) + " xuống mức " + closedValue + " đồng/cổ phiếu");
			}
			else {
				this.setVerb(InputData.getRandom(Verb.getSlowDecrease()) + " xuống mức " + closedValue + " đồng/cổ phiếu");
			}
		}
		else {
			this.setVerb("đứng giá ở mức " + closedValue + " đồng/cổ phiếu");
		}
	}
	
	public void setComplement() {
		
		String optimumClause = this.createOptimumClause();
		String volumeClause = this.createVolumeClause();
		
		if (optimumClause == "") {
			this.setComplement(volumeClause);
		} 
		else {
		this.setComplement(optimumClause + "; " + volumeClause);
		}
	}

	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}

	@Override
	public String get() {
		
		if(InputData.isWeekend(date)) {
			OverAllWeekStockCode sentence = new OverAllWeekStockCode(date, stock);
			return sentence.get();
		}
		else {
			this.setAdverb();
			this.setVerb();
			this.setComplement();
			return adverb + ", " + subject + " " + verb + ", " + complement;
		}
	}

	@Override
	public void setTag() {		
		listTag.add("overall");
	}
}
