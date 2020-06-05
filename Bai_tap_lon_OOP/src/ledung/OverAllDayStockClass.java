package ledung;

import java.text.ParseException;
import java.util.Date;

import Input.*;

public class OverAllDayStockClass extends OverAllDay {
	
	private String stockClass;
	
	public OverAllDayStockClass (Date date, String name) {
		super(date);
		this.stockClass = name;
	}
	

	// class 
	public int increaseCounter(String name) {
		
		int cnt = 0;
		
		if (name == "VN30") {
			for (STOCK i : InputData.stockVN30()) {
				if (InputData.getDifferenceOneDayOneStock(i, date)>0) {
					cnt++;
				}
			}
		}
		else if (name == "HNX30") {
			for (STOCK i : InputData.stockHNX30()) {
				if (InputData.getDifferenceOneDayOneStock(i, date)>0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public String setClause(String name) {
		int cnt = 0;
		String INDEXStatus = "";
		String adjectiveStatus = "";
		if (name == "VN30") {
			cnt = increaseCounter(name);
			INDEXStatus = setIndexClause(name);
			if (cnt >= 22) {
				adjectiveStatus = InputData.getRandom(Verb.getManyIncrease());
			}
			else if(cnt < 8) {
				adjectiveStatus = InputData.getRandom(Verb.getManyDecrease());
			}
			else if(cnt > 18 && cnt < 22) {
				adjectiveStatus = InputData.getRandom(Verb.getFewIncrease());
			}
			else if(cnt < 12 && cnt > 8) {
				adjectiveStatus = InputData.getRandom(Verb.getFewDecrease());
			} 
			else {
				adjectiveStatus = InputData.getRandom(Verb.getLessChanging());
			}
			return "Nhóm cổ phiếu VN30"+ adjectiveStatus + "với " + cnt + " mã tăng điểm và " + (30 - cnt) + " mã giảm điểm. " + INDEXStatus;
		}
		else if (name == "HNX30") {
			cnt = increaseCounter("HNX30");
			INDEXStatus = setIndexClause(name);
			if (cnt >= 22) {
				adjectiveStatus = InputData.getRandom(Verb.getManyIncrease());
			}
			else if(cnt < 8) {
				adjectiveStatus = InputData.getRandom(Verb.getManyDecrease());
			}
			else if(cnt > 18 && cnt < 22) {
				adjectiveStatus = InputData.getRandom(Verb.getFewIncrease());
			}
			else if(cnt < 12 && cnt > 8) {
				adjectiveStatus = InputData.getRandom(Verb.getFewDecrease());
			} 
			else {
				adjectiveStatus = InputData.getRandom(Verb.getLessChanging());
			}
			return "nhóm cổ phiếu HNX30"+ adjectiveStatus + "với " + cnt + " mã tăng điểm và " + (30 - cnt) + " mã giảm điểm. " + INDEXStatus;
		}
		return null;
	}
	// stock class sentence
	public String setIndexClause(String name) {
		String index = "";
		double diff = 0.0;
		double yesterdayIndex = 0.0;
		double todayIndex = 0.0;
		double ratio = 0.0;
		if (name == "VN30") {
			yesterdayIndex = InputData.getTodayVN30(InputData.getYesterday(date)).get(STOCK.VNINDEX).getGiaDongCua();
			todayIndex = InputData.getTodayVN30(date).get(STOCK.VNINDEX).getGiaDongCua();
			diff = Math.abs(todayIndex - yesterdayIndex);
			ratio = Math.abs(1 - todayIndex/yesterdayIndex)*100;
			if (diff > 0) {
				index = "Chỉ số VN-INDEX tăng " + InputData.roundNumber(diff) + " điểm tương đương với " 
						+ InputData.roundNumber(ratio) + "%, đạt mốc " + todayIndex + " điểm.";			}
			else if (diff < 0) {
				index = "Chỉ số VN-INDEX tăng " + InputData.roundNumber(diff) + " điểm tương đương với " 
						+ InputData.roundNumber(ratio) + "%, đạt mốc " + todayIndex + " điểm.";			}
		}
		else if (name == "HNX30") {
			yesterdayIndex = InputData.getTodayHNX30(InputData.getYesterday(date)).get(STOCK.HASTC).getGiaDongCua();
			todayIndex = InputData.getTodayHNX30(date).get(STOCK.HASTC).getGiaDongCua();
			diff = Math.abs(todayIndex - yesterdayIndex);
			ratio = Math.abs(1 - todayIndex/yesterdayIndex)*100;
			if (diff > 0) {
				index = "Chỉ số HNX-INDEX tăng " + InputData.roundNumber(diff) + " điểm tương đương với " 
						+ InputData.roundNumber(ratio) + "%, đạt mốc " + todayIndex + " điểm.";
			}
			else if (diff < 0) {
				index = "Chỉ số HNX-INDEX giảm " + InputData.roundNumber(Math.abs(diff)) + " điểm tương đương với " 
						+ InputData.roundNumber(ratio) + "%, xuống mốc " + todayIndex + " điểm.";
			}
		}
		return index;
	}
	
	
	
	public String createClause() {
		
		ReadFile.loadData();
		
		String name = this.stockClass;
		
		if (InputData.isWeekend(date)) {
			return "Ngày cuối tuần không có giao dịch";
		}
		
		return setClause(name);
	}
	
	public String getStockClass() {
		return stockClass;
	}	
	
	public void createSentence() throws ParseException {
		System.out.println(this.createClause());
	}
}
