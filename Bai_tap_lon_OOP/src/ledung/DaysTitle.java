package Sentence;

import java.util.Date;

import Input.InputData;

public class DaysTitle extends Title{
	
	private Date date1;
	private Date date2;
	
	public DaysTitle(Date date1, Date date2) {
		super();
		this.date1 = date1;
		this.date2 = date2;
	}
	
	public String createClause(String name) {
		
		String clause = name;
		OverAllDaysStockClass p = new OverAllDaysStockClass(name, date1, date2);
		int cnt = p.increaseCodeCounter();
		
		if (name == "VN30") {
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
		System.out.println("Thị trường chứng khoán ngày " + formats.format(date1) + " đến ngày " + formats.format(date2) + ": " + createClause("VN30") + ", " + createClause("HNX30"));
	}
}
