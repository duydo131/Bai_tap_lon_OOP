package Sentence;

import java.util.Date;

import Input.*;

public class DaysTitleGeneralComment extends DaysTitle {
	public DaysTitleGeneralComment(Date date1, Date date2) {
		super(date1,date2);
	}
	
	public int increaseCodeCounter(String name) {
		
		ReadFile.loadData();
		
		int counter=0;
		double closedValueDate2 = 0.0;
		double openValueDate1 = 0.0;
		double diff = 0.0;
		
		if (name == "VN30") {
			for (STOCK i : InputData.stockVN30()) {
				closedValueDate2 = InputData.getInfoVN30(date1, date2).get(i).get(days).getGiaDongCua();
				openValueDate1 = InputData.getInfoVN30(date1, date2).get(i).get(0).getGiaDongCua();
				diff = closedValueDate2 - openValueDate1;
				if (diff > 0) {
					counter++;
				}
			}
		}
		else if (name == "HNX30") {
			for (STOCK i : InputData.stockHNX30()) {
				closedValueDate2 = InputData.getInfoHNX30(date1, date2).get(i).get(days).getGiaDongCua();
				openValueDate1 = InputData.getInfoHNX30(date1, date2).get(i).get(0).getGiaDongCua();
				diff = closedValueDate2 - openValueDate1;
				if (diff > 0) {
					counter++;
				}
			}
		}
		return counter;
	}
	
	public String createClause(String name) {
		String status = "";
		int cnt = 0;
		if (name == "VN30") {
			cnt = this.increaseCodeCounter(name);
			if (cnt >= 24) {
				status = "Nhóm cổ phiếu VN30 giao dịch sôi động, các cổ phiếu đồng loạt tăng giá";
			}
			else if (cnt < 24 && cnt >= 18) {
				status = "Nhóm cổ phiếu VN30 có những tín hiệu tăng trưởng tích cực";
			}
			else if (cnt < 18 && cnt >= 12) {
				status = "Nhóm cổ phiếu VN30 không không có quá nhiều biến động với diễn biến giằng co của các mã cổ phiếu thành phần";
			}
			else if (cnt < 12 && cnt >= 6) {
				status = "Nhóm VN30 giữ màu đỏ là chủ đạo";
			}
			else if (cnt < 6) {
				status = "Nhóm VN30 ngập chìm trong sắc đỏ, các cổ phiếu đồng loạt giảm giá";
			}
		}
		if (name == "HNX30") {
			cnt = this.increaseCodeCounter(name);
			if (cnt >= 24) {
				status = "chứng kiến sự giao dịch vô cùng lạc quan của nhóm cổ phiếu HNX30";
			}
			else if (cnt < 24 && cnt >= 18) {
				status = "ghi nhận diễn biến có sắc xanh là chủ đạo của nhóm cổ phiếu HNX30";
			}
			else if (cnt < 18 && cnt >= 12) {
				status = "ghi nhận diễn biến giằng co của nhóm cổ phiếu HNX30";
			}
			else if (cnt < 12 && cnt >= 6) {
				status = "ghi nhận sắc màu đỏ chủ đạo của nhóm cổ phiếu HNX30";
			}
			else if (cnt < 6) {
				status = "chứng kiến HNX30 ngập tràn trong sắc đỏ";
			}
		}
		return status;
	}
	
	public String createDaysTitleGeneralComment() {
		
		int VN30cnt = this.increaseCodeCounter("VN30");
		int HNX30cnt = this.increaseCodeCounter("HNX30");
		String linkWord = "";
		String VN30status = this.createClause("VN30") + " với " + VN30cnt + " mã tăng điểm và " + (30-VN30cnt) + " mã giảm điểm.";
		String HNX30status = this.createClause("HNX30") + " với " + HNX30cnt + " mã tăng điểm và " + (30-HNX30cnt) + " mã giảm điểm.";
		
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
		return "Thị trường chứng khoán ngày " + formats.format(date1) + " đến " + formats.format(date2) + ": " + VN30status + " Trong khi đó, thị trường " + linkWord + HNX30status;
	}
}
