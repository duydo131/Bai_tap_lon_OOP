package changing_sentence;

import java.util.ArrayList;
import java.util.Date;

import input.*;

public class OverAllWeekStockCode extends OverAllWeek {
	
	private STOCK stock;
	private String adverb;
	
	public OverAllWeekStockCode(Date date, STOCK stock) {
		super(date);
		this.stock = stock;
		this.subject = stock.name();
	}
	
	public int increaseDayCounter() {
		
		int i = 0;
		
		for (DataOneDay data : InputData.getInfo(date1, date2).get(stock)) {
			if (data.getGiaDongCua()-data.getGiaMoCua()>0) {
				i++;
			}
		}
		return i;
	}
	
	public int decreaseDayCounter() {
		
		int i = 0;
		
		for (DataOneDay data : InputData.getInfo(date1, date2).get(stock)) {
			if (data.getGiaDongCua()-data.getGiaMoCua()<0) {
				i++;
			}
		}
		return i;
	}
	
	public long totalVolume() {
		int volume = 0;
		for (DataOneDay data: InputData.getInfo(date1, date2).get(stock)) {
			volume += data.getKL();
		}
		return volume;
	}
	
	public void setAdverb() {
		
		int increaseCounter = this.increaseDayCounter();
		int decreaseCounter = this.decreaseDayCounter();
		
		this.adverb = "Trải qua " + increaseCounter + " phiên tăng giá và " + decreaseCounter + " phiên giảm giá";
	}
	
	public void setVerb() {
		
		double diff = InputData.getToday(date2).get(stock).getGiaDongCua() - InputData.getToday(date1).get(stock).getGiaDongCua();
		double pivot = 0.6*InputData.getToday(date1).get(stock).getGiaDongCua();
		
		if (diff > 0) {
			if (diff >= pivot) {
				this.setVerb(InputData.getRandom(Verb.getFastIncrease()));
			}
			else {
				this.setVerb(InputData.getRandom(Verb.getSlowIncrease()));
			}
		}
		else if (diff < 0) {
			if (Math.abs(diff) > pivot) {
				this.setVerb(InputData.getRandom(Verb.getFastDecrease()));
			}
			else {
				this.setVerb(InputData.getRandom(Verb.getSlowDecrease()));
			}
		}
	}
	
	public void setComplement() {
		
		int closedValue = (int) (InputData.getToday(date2).get(stock).getGiaDongCua()*1000);
		long volume = this.totalVolume();

		this.setComplement("đạt ngưỡng " + closedValue + " đồng/cổ phiếu, tổng khối lượng giao dịch lên đến " + volume + " đơn vị.");
	}
	
	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}

	@Override
	public String get() {
		this.setAdverb();
		this.setComplement();
		this.setVerb();
		return adverb + ", " + subject + " " + verb + ", " + complement;
	}

	@Override
	public void setTag() {
		listTag.add("overall");
	}
}
