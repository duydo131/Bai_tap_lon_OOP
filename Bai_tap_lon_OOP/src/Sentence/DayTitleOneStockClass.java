package Sentence;

import java.text.ParseException;
import java.util.Date;

import Input.InputData;
import Input.ReadFile;
import Input.STOCK;
import Sentence.DayTitleGeneralComment;

public class DayTitleOneStockClass extends DayTitle {
	
	private String stockClass;
	
	public DayTitleOneStockClass(String name, Date date) {
		super(date);
		this.stockClass = name;
	}
	
	public String createStockClassClause() throws ParseException {
		
		ReadFile.loadData();
		
		DayTitleGeneralComment p = new DayTitleGeneralComment(date);
		
		String name = this.stockClass;
		String clause = "";
		int cnt = 0;
		
		if (date.getDay()==6 || date.getDay()==0) {
			return "Ngày cuối tuần không có giao dịch";
		}
		if (name == "VN30") {
			clause = p.createClause(name);
			cnt = p.increaseCounter(name);
		}
		else if (name == "HNX30") {
			clause = p.createClause(name);
			cnt = p.increaseCounter(name);
		}
		return "Kết thúc phiên giao dịch ngày " + formats.format(date) + ": " + name + " " + clause + " với " + cnt + " mã tăng điểm và " + (30-cnt) + " mã giảm điểm ";
	}
	
}
