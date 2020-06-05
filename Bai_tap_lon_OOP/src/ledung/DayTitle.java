package ledung;

import java.util.ArrayList;
import java.util.Date;

<<<<<<< HEAD
import Input.InputData;
=======
import Input.*;
>>>>>>> 586f98c58434d2a835765c773c4d04b6fd59ecf0

public class OverAllDayStockCode extends OverAllDay{
		
	private STOCK stock;
	private String adverb;
	
<<<<<<< HEAD
	public DayTitle(Date date) {
		super();
		super.setTag();
		this.date = date;
		this.adverb = "Thị trường chứng khoán ngày " + formats.format(date) + ": ";
=======
	Date yesterday = Format.getDate(date, -1);

	public OverAllDayStockCode(Date date, STOCK stock) {
		super(date);
		this.subject = stock.name();
		this.stock = stock;
>>>>>>> 586f98c58434d2a835765c773c4d04b6fd59ecf0
	}
	
	// Đếm xem cổ phiếu tăng trần/giảm trần trong vòng bao nhiêu 
	public int minmaxDaysCounter() {
		
		ReadFile.loadData();

		double todayPrice = InputData.getToday(date).get(stock).getGiaDongCua();
		double yesterdayPrice = InputData.getToday(yesterday).get(stock).getGiaDongCua();
		double diff =  todayPrice - yesterdayPrice ;
		int stop = 0;
		int counter = 0;
		Date dt = yesterday;

		if (diff > 0) {
			while (stop != 1) {
				dt = Format.getDate(dt, -1);
				double max = InputData.getTodayVN30(dt).get(stock).getGiaMax();
				if (todayPrice > max) {
					counter++;
				}
			}
		}
		else if (diff < 0) {
			while (stop != 1) {
				dt = Format.getDate(dt, -1);
				double min = InputData.getTodayVN30(dt).get(stock).getGiaMin();
				if (todayPrice < min) {
					counter++;
				}
			}
		}
		return counter;
	}
	
	// tạo mệnh đề tăng trần/giảm trần
	public String createMinMaxClause() {
		
		ReadFile.loadData();
		
		String clause = null;
		double diff = InputData.getToday(date).get(stock).getGiaDongCua() - InputData.getToday(yesterday).get(stock).getGiaDongCua();
		int cnt = this.minmaxDaysCounter();

		if (diff > 0) {
			double max = InputData.getToday(date).get(stock).getGiaMax()*1000;
			if (cnt > 0) {
				clause = " đã có thời điểm tăng giá trần trong " + cnt + " ngày trở lại đây, đạt mức " + max + " đồng/cp,";
			}
			else if (cnt == 0) {
				clause = " đã có thời điểm tăng giá trần ở mức " + max + " đồng/cp,";
			}
		}
		else if (diff < 0) {
			double min = InputData.getToday(date).get(stock).getGiaMin()*1000;
			if (cnt > 0) {
				clause = " đã có thời điểm chạm giá trần trong " + cnt + " ngày trở lại đây, xuống mức " + min + " đồng/cp,";
			}
			else if (cnt == 0) {
				clause = " đã có thời điểm chạm giá trần ở mức " + min + " đồng/cp,";
			}
		}
		return clause;
	}
	
	public String createSentence() {

		ReadFile.loadData();
			
		if (InputData.isWeekend(date)) {
			return "Cuối tuần không có giao dịch";
		}
			
		String minmaxClause = this.createMinMaxClause();
		double key = InputData.getToday(Format.getDate(date, -1)).get(stock).getGiaDongCua()*0.03*1000;
		double closedValue = InputData.getToday(date).get(stock).getGiaDongCua()*1000;
		double openValue = InputData.getToday(date).get(stock).getGiaMoCua()*1000;
		double diff = closedValue - openValue;
		long volume = InputData.getToday(date).get(stock).getKL();
		int incCounter = InputData.increaseCounterOneStock(stock, date);
		int decCounter = InputData.decreaseCounterOneStock(stock, date);
		
		if (incCounter > 0) {
			if (diff > 0) {
				this.setAdverb(InputData.getRandom(AdverbStatus.getIncThenInc()));
				if (diff > key) {
					this.setVerb(InputData.getRandom(Verb.getFastIncrease()));
				}
				else if (diff < key) {
					this.setVerb(InputData.getRandom(Verb.getSlowIncrease()));
				}
			}
			else if (diff < 0) {
				this.setAdverb(InputData.getRandom(AdverbStatus.getIncThenDec()));
				if (diff < -key) {
					this.setVerb(InputData.getRandom(Verb.getFastDecrease()));
				}
				else if (diff > -key) {
					this.setVerb(InputData.getRandom(Verb.getSlowDecrease()));
				}
			}
			else {
				this.setVerb(" đứng giá ");
				this.setComplement("tại mốc " + closedValue + " đồng/cổ phiếu," + minmaxClause + " khối lượng giao dịch đạt ở mức " + volume + " đơn vị.");
			}
			if (incCounter == 1) {
				this.setComplement(" lên mức " + closedValue + " đồng/cổ phiếu," + minmaxClause + " khối lượng giao dịch đạt ở mức " + volume + " đơn vị.");
				this.setAdverb(this.getAdverb() + " so với phiên giao dịch ngày hôm qua, ");
			}
			else {
				this.setComplement(" lên mức " + closedValue + " đồng/cổ phiếu," + minmaxClause + " khối lượng giao dịch đạt ở mức " + volume + " đơn vị.");
				this.setAdverb(this.getAdverb() + " sau " + incCounter + " phiên tăng giá, ");
			}
		} 
		else if (decCounter > 0) {
			if (diff > 0) {
				this.setAdverb(InputData.getRandom(AdverbStatus.getDecThenInc())); 
				if (diff > key) {
					this.setVerb(InputData.getRandom(Verb.getFastDecrease()));
				}
				else if (diff < key) {
					this.setVerb(InputData.getRandom(Verb.getSlowDecrease()));
				}
			}
			else if (diff < 0) {
				this.setAdverb(InputData.getRandom(AdverbStatus.getDecThenDec())); 
				if (diff < -key) {
					this.setVerb(InputData.getRandom(Verb.getFastDecrease()));
				}
				else if (diff > -key) {
					this.setVerb(InputData.getRandom(Verb.getSlowDecrease()));
				}
				else {
					this.setVerb(" đứng giá tại mốc ");
					this.setComplement(closedValue + " đồng/cổ phiếu," + minmaxClause + " khối lượng giao dịch đạt ở mức " + volume + " đơn vị.");
				}
			}
			if (decCounter == 1) {
				this.setComplement(" xuống mức " + closedValue + " đồng/cổ phiếu," + minmaxClause + " khối lượng giao dịch đạt ở mức " + volume + " đơn vị.");
				this.setAdverb(this.getAdverb() + " so với phiên giao dịch ngày hôm qua, ");
			}
			else {
				this.setComplement(" xuống mức " + closedValue + " đồng/cổ phiếu," + minmaxClause + " khối lượng giao dịch đạt ở mức " + volume + " đơn vị.");
				this.setAdverb(this.getAdverb() + " sau " + decCounter + " phiên giảm giá, ");
			}
		}
		return null;
	}
	
<<<<<<< HEAD
//	public void printSentence() {
//		this.setLinkWord();
//		this.setVerb();
//		System.out.println(adverb + subject[0] + verb[0] + ", " + subject[1] + linkWord + verb[1]);
//	}

	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}

	@Override
	public String get() {
		this.setLinkWord();
		this.setVerb();
		return adverb + subject[0] + verb[0] + ", " + subject[1] + linkWord + verb[1];
	}

	@Override
	public void setTag() {
		
=======
	public void printSentence() {
		this.createSentence();
		System.out.println(adverb + subject + verb + complement);
	}
	
	public void setAdverb(String adverb) {
		this.adverb = adverb;
	}
	
	public String getAdverb() {
		return this.adverb;
>>>>>>> 586f98c58434d2a835765c773c4d04b6fd59ecf0
	}
}
