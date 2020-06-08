package summary_and_comment;

import java.util.Date;
import java.util.Set;

import Input.InputData;
import Input.STOCK;
import changing_sentence.Verb;

public abstract class TomorrowPredictionStockClass extends TomorrowPrediction{
	
	protected String linkWord;
	protected Date date;
	
	public TomorrowPredictionStockClass(Date date) {
		super();
		this.subject = " phiên giao dịch ngày mai";
		this.verb = " sẽ tiếp tục là một ngày giao dịch chứng kiến sự ";
		this.linkWord = "Nếu diễn biến của ngày giao dịch hôm nay còn tiếp diễn thì";
		this.date = date;
	}
	
	@Override
	public void setTag() {
		listTag.add("prediction");
	}
	
	public int increaseCounter(String className) {
		
		Set<STOCK> stocks = null;
		int counter = 0;
		
		if (className == "VN30") {
			stocks = InputData.stockVN30();
		} else if (className == "HNX30") {
			stocks = InputData.stockHNX30();
		}
		
		for (STOCK i : stocks) {
			if (InputData.getDifferenceOneDayOneStock(i, date)>0) {
				counter++;
			}
		}
		return counter;
	}
	
	public void setComplement(String className) {
		
		int counter = this.increaseCounter(className);
		
		if ( counter >= 20 ) {
			this.complement = InputData.getRandom(Verb.getManyIncrease()) + " của nhóm cổ phiếu " + className + ", các nhà đầu tư có thể bước vào ngày giao dịch mới với tâm lý vô cùng thoải mái.";
		}
		else if (counter >= 17 && counter < 20) {
			this.complement = InputData.getRandom(Verb.getFewIncrease()) + " của nhóm cổ phiếu " + className + ", các nhà đầu tư nên cân nhắc kỹ với những lựa chọn của mình.";
		}
		else if (counter > 13 && counter < 17) {
			this.complement = InputData.getRandom(Verb.getLessChanging()) + " của nhóm cổ phiếu " + className + ", các nhà đầu tư cần tiếp cận thị trường với một tâm lý vô cùng thận trọng.";
		}
		else if (counter <= 13 && counter > 10) {
			this.complement = InputData.getRandom(Verb.getFewDecrease()) + " của nhóm cổ phiếu " + className + ", các nhà đầu tư cần nghe ngóng tình hình trước khi quyết định mua vào hay bán ra cổ phiếu thuộc nhóm này.";
		}
		else {
			this.complement = InputData.getRandom(Verb.getManyDecrease()) + " của nhóm cổ phiếu " + className + ", các nhà đầu tư cần phải có những quyết định chính xác và kịp thời với nhóm cổ phiếu này.";
		}
	}
}
