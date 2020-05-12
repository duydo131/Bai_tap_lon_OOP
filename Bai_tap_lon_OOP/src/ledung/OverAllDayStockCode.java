package ledung;

import java.util.Date;

import Input.*;

public class OverAllDayStockCode extends OverAllDay{
	
	private STOCK stock;
	
	public OverAllDayStockCode(Date date, STOCK stock) {
		super(date);
		this.stock = stock;
	}
	
	public int minmaxDaysCounter(String optimum) {
		
		double min = InputData.getToday(date).get(stock).getGiaMin();
		double max = InputData.getToday(date).get(stock).getGiaMax();
		int stop = 0;
		int counter = 0;
	
		if (optimum == "min") {
			while (stop != 1) {
				Date dayBefore = InputData.getYesterday(date);
				if (InputData.getToday(dayBefore).get(stock).getGiaMin() > min) {
					counter++;
					date = InputData.getYesterday(date);
					if (InputData.getToday(dayBefore).get(stock).getGiaMin() == 0) {
						counter--;
					}
				}
				else {
					stop = 1;
				}
			}
		}
		else if (optimum == "max") {
			while (stop != 1) {
				Date dayBefore = InputData.getYesterday(date);
				if (InputData.getToday(dayBefore).get(stock).getGiaMax() < max){
					counter++;
					date = InputData.getYesterday(date);
					if (InputData.getToday(dayBefore).get(stock).getGiaMax() == 0) {
						counter--;
					}
				}
				else {
					stop = 1;
				}
			}
		}
	
			return counter;
	}
	
	public String createMinMaxClause() {

		ReadFile.loadData();
		
		String clause = null;
		double diff = InputData.getToday(date).get(stock).getGiaDongCua() - InputData.getToday(InputData.getYesterday(date)).get(stock).getGiaDongCua();
		
		double min = InputData.getToday(date).get(stock).getGiaMin()*1000;
		double max = InputData.getToday(date).get(stock).getGiaMax()*1000;
		
		if (diff > 0) {
			int cnt = this.minmaxDaysCounter("max");
			if (cnt > 0) {
				clause = " đã có thời điểm tăng giá trần trong " + cnt + " ngày trở lại đây, đạt mức " + max + " đồng/cp,";
			}
			else if (cnt == 0) {
				clause = " đã có thời điểm tăng giá trần ở mức " + max + " đồng/cp,";
			}
		}
		else if (diff < 0) {
			int cnt = this.minmaxDaysCounter("min");
			if (cnt > 0) {
				clause = " đã có thời điểm chạm giá trần trong " + cnt + " ngày trở lại đây, xuống mức " + min + " đồng/cp,";
			}
			else if (cnt == 0) {
				clause = " đã có thời điểm chạm giá trần ở mức " + min + " đồng/cp,";
			}
		}
		return clause;
	}
	
	public String createClause() {
		
		ReadFile.loadData();
		
		if (InputData.isWeekend(date)) {
			return "Cuối tuần không có giao dịch";
		}
		
		String status = null;
		String adverb = null;
		String subject = stock.name();
		String minmax = this.createMinMaxClause();
		double pivot = InputData.getToday(InputData.getYesterday(date)).get(stock).getGiaDongCua()*0.03*1000;
		double closedValue = InputData.getToday(date).get(stock).getGiaDongCua()*1000;
		double diff = InputData.getToday(date).get(stock).getGiaDongCua() - InputData.getToday(InputData.getYesterday(date)).get(stock).getGiaDongCua();
		long volume = InputData.getToday(date).get(stock).getKL();
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
					status = InputData.getRandom(AdjectiveStatus.getSlowDecrease());
				}
			}
			else {
				return subject + " đứng giá tại mốc " + closedValue + " đồng/cổ phiếu," + minmax + " khối lượng giao dịch đạt ở mức " + volume + " đơn vị.";
			}
			if (incCounter == 1) {
				return adverb + "so với phiên giao dịch ngày hôm qua, " + subject + status + "lên mức " + 
					   closedValue + " đồng/cổ phiếu," + minmax + " khối lượng giao dịch đạt ở mức " + volume + " đơn vị.";
			}
			else {
				return adverb + "sau " + incCounter + " phiên tăng giá, " + subject + status + "lên mức " + 
						   closedValue + " đồng/cổ phiếu," + minmax + " khối lượng giao dịch đạt ở mức " + volume + " đơn vị.";
			}
		} 
		else if (decCounter > 0) {
			if (diff > 0) {
				adverb = InputData.getRandom(AdverbStatus.getDecThenInc());
				if (diff > pivot) {
					status = InputData.getRandom(AdjectiveStatus.getFastDecrease());
				}
				else if (diff < pivot) {
					status = InputData.getRandom(AdjectiveStatus.getSlowDecrease());
				}
			}
			else if (diff < 0) {
				adverb = InputData.getRandom(AdverbStatus.getDecThenDec());
				if (diff < -pivot) {
					status = InputData.getRandom(AdjectiveStatus.getFastDecrease());
				}
				else if (diff > -pivot) {
					status = InputData.getRandom(AdjectiveStatus.getSlowDecrease());
				}
			}
			else {
				return subject + " đứng giá tại mốc " + closedValue + " đồng/cổ phiếu," + minmax + " khối lượng giao dịch đạt ở mức " + volume + " đơn vị.";
			}
		}
		else {
			return subject + " đứng giá tại mốc " + closedValue + " đồng/cổ phiếu," + minmax + " khối lượng giao dịch đạt ở mức " + volume + " đơn vị.";
		}
		if (decCounter == 1) {
			return adverb + "so với phiên giao dịch ngày hôm qua, " + subject + status + "xuống mức " + 
				   closedValue + " đồng/cổ phiếu," + minmax + " khối lượng giao dịch đạt ở mức " + volume + " đơn vị.";
		}
		else {
			return adverb + "sau " + decCounter + " phiên giảm giá, " + subject + status + "xuống mức " + 
					   closedValue + " đồng/cổ phiếu," + minmax + " khối lượng giao dịch đạt ở mức " + volume + " đơn vị.";
		}
	}
	
	public void createSentence() {
		System.out.println(createClause());
	}
}
