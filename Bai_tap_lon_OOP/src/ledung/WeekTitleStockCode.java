package ledung;

import java.util.ArrayList;
import java.util.Date;

import Input.*;

public class WeekTitleStockCode extends Title{
	
	private STOCK stock;
	private Date date1;
	private Date date2;

	public WeekTitleStockCode(Date date, STOCK stock) {
		super(date);
		this.subject = stock.name();
		this.stock = stock;
		this.date1 = Sentence.getWeek(date)[0];
		this.date2 = Sentence.getWeek(date)[1];
		this.adverb = "Thị trường chứng khoán ngày " + formats.format(date1) + " đến ngày " + formats.format(date2) + ": ";
	}
	
	public void setVerb() {
		
		double diff = InputData.getToday(date2).get(stock).getGiaDongCua() - InputData.getToday(date1).get(stock).getGiaMoCua();
		double ratio = Math.abs(diff/InputData.getToday(date1).get(stock).getGiaMoCua()*100);

		if (diff > 0) {
			if (ratio > 75) {
				this.setVerb(InputData.getRandom(Verb.getFastIncrease()) + " ở mức " + InputData.roundNumber(ratio) + "%");
			}
			else {
				this.setVerb(InputData.getRandom(Verb.getSlowIncrease()) + " ở mức " + InputData.roundNumber(ratio) + "%");
			}
		}
		else {
			if (ratio > 75) {
				this.setVerb(InputData.getRandom(Verb.getFastDecrease()) + " ở mức " + InputData.roundNumber(ratio) + "%");
			}
			else {
				this.setVerb(InputData.getRandom(Verb.getSlowDecrease()) + " ở mức " + InputData.roundNumber(ratio) + "%");
			}
		}
	}
	
	public void setComplement() {
		
		String volume = "khối lượng giao dịch";
		int finalVolume = (int) InputData.getToday(date2).get(stock).getKL();
		int startVolume = (int) InputData.getToday(date1).get(stock).getKL();
		double diff = startVolume - finalVolume;
		
		if (diff < 0) {
			if (-diff > 0.6*startVolume) {
				this.setComplement(volume + " tăng mạnh lên mức " + finalVolume + " đơn vị.");
			}
			else if (-diff < 0.2*startVolume){
				this.setComplement(volume + " tăng nhẹ lên mức " + finalVolume + " đơn vị.");
			}
			else {
				this.setComplement(volume + " tăng lên mức" + finalVolume + " đơn vị.");
			}
		} 
		else if (diff > 0){
			if (diff > 0.6*startVolume) {
				this.setComplement(volume + " giảm mạnh lên mức " + finalVolume + " đơn vị.");
			}
			else if (diff < 0.2*startVolume){
				this.setComplement(volume + " giảm nhẹ lên mức " + finalVolume + " đơn vị.");
			}
			else {
				this.setComplement(volume + " giảm lên mức" + finalVolume + " đơn vị.");
			}
		}
	}

	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}

	@Override
	public String get() {
		this.setVerb();
		this.setComplement();
		return adverb + subject + " " + verb + ", " + complement;
	}

	@Override
	public void setTag() {
		listTag.add("title");
	}
}
