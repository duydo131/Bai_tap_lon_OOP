package ledung;

import java.util.Date;

import Input.InputData;
import Input.ReadFile;

public class DayTitle extends Title{
	
	private Date date;
	
	public DayTitle(Date date) {
		super();
		this.date = date;
	}
	
	public String createClause(String name) {
		ReadFile.loadData();
		
		String clause = name;
		OverAllDayStockClass p = new OverAllDayStockClass(date, name);
		int cnt = 0;
		
		if (name == "VN30") {
			cnt = p.increaseCounter(name);
			if (cnt >= 22) {
				clause += InputData.getRandom(AdjectiveStatus.getManyIncrease());
			}
			else if(cnt < 8) {
				clause += InputData.getRandom(AdjectiveStatus.getManyDecrease());
			}
			else if(cnt > 18 && cnt < 22) {
				clause += InputData.getRandom(AdjectiveStatus.getFewIncrease());
			}
			else if(cnt < 12 && cnt > 8) {
				clause += InputData.getRandom(AdjectiveStatus.getFewDecrease());
			} 
			else {
				clause += InputData.getRandom(AdjectiveStatus.getLessChanging());
			}
		}
		else if (name == "HNX30") {
			cnt = p.increaseCounter("HNX30");
			if (cnt >= 22) {
				clause += InputData.getRandom(AdjectiveStatus.getManyIncrease());
			}
			else if(cnt < 8) {
				clause += InputData.getRandom(AdjectiveStatus.getManyDecrease());
			}
			else if(cnt > 18 && cnt < 22) {
				clause += InputData.getRandom(AdjectiveStatus.getFewIncrease());
			}
			else if(cnt < 12 && cnt > 8) {
				clause += InputData.getRandom(AdjectiveStatus.getFewDecrease());
			} 
			else {
				clause += InputData.getRandom(AdjectiveStatus.getLessChanging());
			}
		}
		return clause;
	}
	
	public void createSentence() {
		System.out.println("Thị trường chứng khoán ngày " + formats.format(date) + ": " + this.createClause("VN30") + ", " + this.createClause("HNX30")); 
	}
}
