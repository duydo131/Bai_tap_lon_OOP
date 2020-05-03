package Sentence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Input.*;

// Ngày 24/10: BID có một ngày giao dịch tương đối tích cực khi giá bán đạt xxx đồng/cp so với phiên
// liền trước, khối lượng giao dịch khớp lệnh đạt xxx triệu, tăng y triệu so với phiên trước 
// Chỉ số -> điểm 
// Cổ phiếu -> giá/cp 

public class DayTitleOneStockCode extends DayTitle{
	
	private STOCK stock;
	
	public DayTitleOneStockCode(Date date, STOCK stock) {
		super(date);
		this.stock = stock;
	}
	
	public String createClause() {
		
		if (InputData.weekend(date)) {
			return "Cuối tuần không có giao dịch";
		}
		
		ArrayList<DataOneDay> data = InputData.getInfo(InputData.getYesterday(date), date).get(stock);
		String status = this.status;
		String adverb = null;
		String subject = stock.name();
		String timeAdverb = "Đóng cửa phiên giao dịch ngày " + formats.format(date) + ":";
		double diff = data.get(1).getGiaDongCua() - data.get(0).getGiaDongCua();
		double pivot = data.get(0).getGiaDongCua()*0.03;
		double closedValue = data.get(1).getGiaDongCua()*1000;
		long volume = data.get(1).getKL();
		int incCounter = InputData.increaseCounterOneStock(stock, date);
		int decCounter = InputData.decreaseCounterOneStock(stock, date);
		
		if (incCounter > 0) {
			if (diff > 0) {
				adverb = InputData.getRandom(AdverbStatus.getIncThenInc());
				if (diff > pivot) {
					status = InputData.getRandom(AdjectiveStatus.getFastIncrease());
				}
				else if (diff < pivot) {
					status = InputData.getRandom(AdjectiveStatus.getSlowIncrease());
				}
			}
			else if (diff < 0) {
				adverb = InputData.getRandom(AdverbStatus.getIncThenDec());
				if (diff < -pivot) {
					status = InputData.getRandom(AdjectiveStatus.getFastDecrease());
				}
				else if (diff > -pivot) {
					status = InputData.getRandom(AdjectiveStatus.getSlowIncrease());
				}
			}
			if (incCounter == 1) {
				return timeAdverb + adverb + "so với phiên giao dịch ngày hôm qua, " + subject + status + "lên mức " + 
					   closedValue + " đồng/cổ phiếu, khối lượng giao dịch đạt ở mức " + volume + " đơn vị.";
			}
			else {
				return timeAdverb + adverb + "sau " + incCounter + " phiên tăng giá, " + subject + status + "lên mức " + 
						   closedValue + " đồng/cổ phiếu, khối lượng giao dịch đạt ở mức " + volume + " đơn vị.";
			}
		} 
		else if (decCounter > 0) {
			if (diff > 0) {
				adverb = InputData.getRandom(AdverbStatus.getDecThenInc());
				if (diff > pivot) {
					status = InputData.getRandom(AdjectiveStatus.getFastIncrease());
				}
				else if (diff < pivot) {
					status = InputData.getRandom(AdjectiveStatus.getSlowIncrease());
				}
			}
			else if (diff < 0) {
				adverb = InputData.getRandom(AdverbStatus.getDecThenDec());
				if (diff < -pivot) {
					status = InputData.getRandom(AdjectiveStatus.getFastDecrease());
				}
				else if (diff > -pivot) {
					status = InputData.getRandom(AdjectiveStatus.getSlowIncrease());
				}
			}
		}
		if (decCounter == 1) {
			return timeAdverb + adverb + "so với phiên giao dịch ngày hôm qua, " + subject + status + "xuống mức " + 
				   closedValue + " đồng/cổ phiếu, khối lượng giao dịch đạt ở mức " + volume + " đơn vị.";
		}
		else {
			return timeAdverb + adverb + "sau " + decCounter + " phiên giảm giá, " + subject + status + "xuống mức " + 
					   closedValue + " đồng/cổ phiếu, khối lượng giao dịch đạt ở mức " + volume + " đơn vị.";
		}
	}
}
