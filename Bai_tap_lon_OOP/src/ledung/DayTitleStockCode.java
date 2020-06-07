package ledung;

import java.util.ArrayList;
import java.util.Date;
import Input.*;

public class DayTitleStockCode extends Title {
	
	private STOCK stock;
	
	public DayTitleStockCode(Date date, STOCK stock) {
		super(date);
		this.subject = stock.name();
		this.stock = stock;
	}
	
	public void setVerb() {
		
		double yesterdayPrice = InputData.getToday(getYesterday(date)).get(stock).getGiaDongCua();
		double diff = InputData.getToday(date).get(stock).getThayDoi();
		double ratio = Math.abs(diff/yesterdayPrice*100);
		int minCounter = optimumCounter("min", date, stock);
		int maxCounter = optimumCounter("max", date, stock);
		
		if (diff > 0) {
			if (maxCounter > 1) {
				this.setVerb("tiếp tục tăng trần sau " + maxCounter + " ngày giao dịch");
			}
			else {
				if (ratio > 75) {
					this.setVerb(InputData.getRandom(Verb.getFastIncrease()) + " " + InputData.roundNumber(ratio) + "%");
				}
				else {
					this.setVerb(InputData.getRandom(Verb.getSlowIncrease()) + " " + InputData.roundNumber(ratio) + "%");
				}
			}
		}
		else {
			if (minCounter > 1) {
				this.setVerb("tiếp tục giảm trần sau " + minCounter + " ngày giao dịch");
			}
			else {
				if (ratio > 75) {
					this.setVerb(InputData.getRandom(Verb.getFastDecrease()) + " " + InputData.roundNumber(ratio) + "%");
				}
				else {
					this.setVerb(InputData.getRandom(Verb.getSlowDecrease()) + " " + InputData.roundNumber(ratio) + "%");
				}
			}
		}
	}
	
	public void setCompliment() {
		
		String volume = " khối lượng giao dịch";
		double todayVolume = InputData.getToday(date).get(stock).getKL();
		double yesterdayVolume = InputData.getToday(getYesterday(date)).get(stock).getKL();
		double diff = yesterdayVolume - todayVolume;
		
		if (diff < 0) {
			if (-diff > 0.6*yesterdayVolume) {
				this.setComplement(volume + " tăng mạnh.");
			}
			else if (-diff < 0.2*yesterdayVolume){
				this.setComplement(volume + " tăng nhẹ.");
			}
			else {
				this.setComplement(volume + " tăng");
			}
		} 
		else if (diff > 0){
			if (diff > 0.6*yesterdayVolume) {
				this.setComplement(volume + " giảm mạnh.");
			}
			else if (diff < 0.2*yesterdayVolume){
				this.setComplement(volume + " giảm nhẹ.");
			}
			else {
				this.setComplement(volume + " giảm");
			}
		}
	}

	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}

	@Override
	public String get() {
		if (InputData.isWeekend(date)) {
			WeekTitleStockCode sentence = new WeekTitleStockCode(date, stock);
			return sentence.get();
		}
		this.setVerb();
		this.setCompliment();
		return adverb + subject + " " + verb + "," + complement;
	}

	@Override
	public void setTag() {
		listTag.add("title");
	}
}
