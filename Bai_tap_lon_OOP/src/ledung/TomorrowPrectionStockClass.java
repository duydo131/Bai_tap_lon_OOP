package Sentence;

import java.util.Date;

import Input.InputData;
import Input.STOCK;

public class TomorrowPredictionStockClass extends TomorrowPrediction{
	
	private String stockClass;
	private String linkWord;
	private Date date;
	
	public TomorrowPredictionStockClass(Date date, String name) {
		super();
		this.subject = " phiên giao dịch ngày mai";
		this.verb = " sẽ tiếp tục là một ngày giao dịch chứng kiến sự";
		this.linkWord = "Nếu diễn biến của ngày giao dịch hôm nay còn tiếp diễn thì";
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
	
	public void setComplement() {
		
		int cnt = this.increaseCounter();
		
		if ( cnt >= 20 ) {
			this.complement = InputData.getRandom(Verb.getManyIncrease()) + " của nhóm cổ phiếu " + stockClass + ", các nhà đầu tư có thể bước vào ngày giao dịch mới với tâm lý vô cùng thoải mái.";
		}
		else if (cnt >= 17 && cnt < 20) {
			this.complement = InputData.getRandom(Verb.getFewIncrease()) + " của nhóm cổ phiếu " + stockClass + ", các nhà đầu tư nên cân nhắc kỹ với những lựa chọn của mình.";
		}
		else if (cnt > 13 && cnt < 17) {
			this.complement = InputData.getRandom(Verb.getLessChanging()) + " của nhóm cổ phiếu " + stockClass + ", các nhà đầu tư cần tiếp cận thị trường với một tâm lý vô cùng thận trọng.";
		}
		else if (cnt <= 13 && cnt > 10) {
			this.complement = InputData.getRandom(Verb.getFewDecrease()) + " của nhóm cổ phiếu " + stockClass + ", các nhà đầu tư cần nghe ngóng tình hình trước khi quyết định mua vào hay bán ra cổ phiếu thuộc nhóm này.";
		}
		else {
			this.complement = InputData.getRandom(Verb.getManyDecrease()) + " của nhóm cổ phiếu " + stockClass + ", các nhà đầu tư cần phải có những quyết định chính xác và kịp thời với nhóm cổ phiếu này.";
		}
		
	}
	
	public void createSentence() {
		this.setComplement();
		System.out.println(linkWord + subject + verb + complement);
	}
}
