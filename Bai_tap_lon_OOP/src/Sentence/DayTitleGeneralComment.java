package Sentence;

import java.text.ParseException;
import java.util.Date;

import Input.InputData;
import Input.ReadFile;
import Input.STOCK;

public class DayTitleGeneralComment extends DayTitle {
	
	public DayTitleGeneralComment(Date date) {
		super(date);
	}
	
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
	
	public String createClause(String name) {
		int cnt = 0;
		if (name == "VN30") {
			cnt = this.increaseCounter(name);
			if (cnt >= 22) {
				status = "đồng loạt tăng điểm ";
			}
			else if(cnt < 8) {
				status = "chìm trong sắc đỏ";
			}
			else if(cnt > 18 && cnt < 22) {
				status = "có diễn biến khá khả quan";
			}
			else if(cnt < 12 && cnt > 8) {
				status = "có chiều hướng giảm sút";
			} 
			else {
				status = "có một ngày giao dịch tương đối ổn định";
			}
		}
		else if (name == "HNX30") {
			cnt = this.increaseCounter("HNX30");
			if (cnt >= 22) {
				status = "ngập tràn trong sắc xanh";
			}
			else if(cnt < 8) {
				status = "đang trong đà tụt dốc";
			}
			else if(cnt > 18 && cnt < 22) {
				status = "ghi nhận sự tăng trưởng tích cực";
			}
			else if(cnt < 12 && cnt > 8) {
				status = "ghi nhận sắc đỏ là màu chủ đạo";
			} 
			else {
				status = "duy trì diễn biến giằng co";
			}
		}
		return status;
	}
	
	public String createGeneralComment() {
		ReadFile.loadData();
		
		Date date = this.date;
		String linkWord = "";
		String day = formats.format(date);
		String VN30status = this.createClause("VN30");
		String HNX30status = this.createClause("HNX30");
		int VN30cnt = this.increaseCounter("VN30");
		int HNX30cnt = this.increaseCounter("HNX30");
		
		if (date.getDay()==6 || date.getDay()==0) {
			return "Ngày cuối tuần không có giao dịch";
		}
		
		if ((VN30cnt >= 18) && (HNX30cnt >= 18) ||
				(VN30cnt < 12) && (HNX30cnt < 12 ) ||
				(VN30cnt < 18 && VN30cnt >= 12) && (HNX30cnt < 18 && HNX30cnt >= 12)){
					linkWord = "cũng ";
			}
			else 
			if ((VN30cnt >= 18) && (HNX30cnt < 12) ||
				(VN30cnt < 12) && (HNX30cnt >= 18 ) ||
				(VN30cnt < 18 && VN30cnt >= 12) && (HNX30cnt >= 18 || HNX30cnt < 12)){
					linkWord = "lại ";
				}

		return "Phiên giao dịch ngày " + day + ": VN30 "+ VN30status + " với " + VN30cnt + " mã tăng điểm và " + (30 - VN30cnt) + " mã giảm điểm" 
				+ ". Trong khi  đó, HNX30 " + linkWord + HNX30status + " với " + HNX30cnt + " mã tăng điểm và " + (30 - HNX30cnt) + " mã giảm điểm";
	}
}
