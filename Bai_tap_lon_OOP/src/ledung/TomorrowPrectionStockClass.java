package ledung;

import java.util.Date;

import Input.InputData;
import Input.STOCK;

public class TomorrowPrectionStockClass {
	
	private String stockClass;
	private Date date;
	
	public TomorrowPrectionStockClass(Date date, String name) {
		this.stockClass = name;
		this.date = date;
	}
	
	public int increaseCounter() {
		
		int cnt = 0;
		
		if (stockClass == "VN30") {
			for (STOCK i : InputData.stockVN30()) {
				if (InputData.getDifferenceOneDayOneStock(i, date)>0) {
					cnt++;
				}
			}
		}
		else if (stockClass == "HNX30") {
			for (STOCK i : InputData.stockHNX30()) {
				if (InputData.getDifferenceOneDayOneStock(i, date)>0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public String createClause() {
		int cnt = this.increaseCounter();
		String prediction = "Nếu diễn biến còn tiếp tục như ngày hôm nay thì phiên giao dịch ngày mai sẽ tiếp tục là một phiên giao dịch";
		String status = null;
		if ( cnt >= 20 ) {
			status = InputData.getRandom(AdjectiveStatus.getManyIncrease()) + "của nhóm cổ phiếu " + stockClass + ", các nhà đầu tư có thể bước vào ngày giao dịch mới với tâm lý vô cùng thoải mái.";
		}
		else if (cnt >= 17 && cnt < 20) {
			status = InputData.getRandom(AdjectiveStatus.getFewIncrease()) + "của nhóm cổ phiếu " + stockClass + ", các nhà đầu tư nên cân nhắc kỹ với những lựa chọn của mình.";
		}
		else if (cnt > 13 && cnt < 17) {
			status = InputData.getRandom(AdjectiveStatus.getLessChanging()) + "của nhóm cổ phiếu " + stockClass + ", các nhà đầu tư cần tiếp cận thị trường với một tâm lý vô cùng thận trọng.";
		}
		else if (cnt <= 13 && cnt > 10) {
			status = InputData.getRandom(AdjectiveStatus.getFewDecrease()) + "của nhóm cổ phiếu " + stockClass + ", các nhà đầu tư cần nghe ngóng tình hình trước khi quyết định mua vào hay bán ra cổ phiếu thuộc nhóm này.";
		}
		else {
			status = InputData.getRandom(AdjectiveStatus.getManyDecrease()) + "của nhóm cổ phiếu " + stockClass + ", các nhà đầu tư cần phải có những quyết định chính xác và kịp thời với nhóm cổ phiếu này.";
		}
		return prediction + status;
	}
	
	public void createSentence() {
		System.out.println(this.createClause());
	}
}
