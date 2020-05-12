package Sentence;

import java.util.Date;

import Input.*;

public class OverAllDaysGeneralComment extends OverAllDays {
	
	private int days = InputData.getDays(date1, date2);
	
	// constructor
	
	public OverAllDaysGeneralComment(Date date1, Date date2) {
		super(date1,date2);
	}
	
	// Đếm số mã cổ phiếu tăng/giảm trong rổ cổ phiếu "name"
	
	public int increaseCodeCounter(String name) {
		
		ReadFile.loadData();
		
		int counter=0;																						//biến đếm
		double closedValue;																				//giá đóng cửa ngày cuối
		double openValue;																				//giá mở cửa ngày đầu tiên
		double diff;																					//hiệu số giá đóng - mở
		
		if (name == "VN30") {
			for (STOCK i : InputData.stockVN30()) {
				closedValue = InputData.getInfoVN30(date1, date2).get(i).get(days).getGiaDongCua();
				openValue = InputData.getInfoVN30(date1, date2).get(i).get(0).getGiaDongCua();
				diff = closedValue - openValue;
				if (diff > 0) {
					counter++;
				}
			}
		}
		else if (name == "HNX30") {
			for (STOCK i : InputData.stockHNX30()) {
				closedValue = InputData.getInfoHNX30(date1, date2).get(i).get(days).getGiaDongCua();
				openValue = InputData.getInfoHNX30(date1, date2).get(i).get(0).getGiaDongCua();
				diff = closedValue - openValue;
				if (diff > 0) {
					counter++;
				}
			}
		}
		return counter;
	}
	
	//Tạo mệnh đề
	
	public String createClause(String name) {
		
		String status = "";
		int cnt = this.increaseCodeCounter(name);
		
		//Nếu số cổ phiếu tăng theo thứ tự => tăng nhiều/ tăng vừa/ ngang ngửa/ giảm vừa/ giảm nhiều
		
		if (name == "VN30") {
			if (cnt >= 20) {
				status = InputData.getRandom(AdjectiveStatus.getManyIncrease());
			}
			else if (cnt < 20 && cnt >= 16) {
				status = InputData.getRandom(AdjectiveStatus.getFewIncrease());
			}
			else if (cnt < 16 && cnt >= 14) {
				status = InputData.getRandom(AdjectiveStatus.getLessChanging());
			}
			else if (cnt < 14 && cnt >= 10) {
				status = InputData.getRandom(AdjectiveStatus.getFewDecrease());
			}
			else if (cnt < 10) {
				status = InputData.getRandom(AdjectiveStatus.getManyDecrease());
			}
		}
		if (name == "HNX30") {
			String linkWord = this.getLinkWord();
			if (cnt >= 20) {
				status = " " +linkWord + InputData.getRandom(AdjectiveStatus.getManyIncrease());
			}
			else if (cnt < 20 && cnt >= 16) {
				status = " " +linkWord + InputData.getRandom(AdjectiveStatus.getFewIncrease());
			}
			else if (cnt < 16 && cnt >= 14) {
				status = " " +linkWord + InputData.getRandom(AdjectiveStatus.getLessChanging());
			}
			else if (cnt < 14 && cnt >= 10) {
				status = " " +linkWord + InputData.getRandom(AdjectiveStatus.getFewDecrease());
			}
			else if (cnt < 10) {
				status = " " + linkWord + InputData.getRandom(AdjectiveStatus.getManyDecrease());
			}
		}
		return "Nhóm cổ phiếu " + name + status + "với " + cnt + " mã tăng giá và " + (30-cnt) + " mã giảm giá.";
	}
	
	// Sinh ra quan hệ từ
	
	public String getLinkWord() {
		
		String linkWord = "";
		int VN30cnt = this.increaseCodeCounter("VN30");
		int HNX30cnt = this.increaseCodeCounter("HNX30");
		
		// nếu số mã cổ phiếu cùng trạng thái => quan hệ tăng tiến
		
		if ((VN30cnt >= 20) && (HNX30cnt >= 20) ||
			(VN30cnt < 10) && (HNX30cnt < 10 ) ||
			(VN30cnt < 20 && VN30cnt >= 10) && (HNX30cnt < 20 && HNX30cnt >= 10)){
			linkWord = InputData.getRandom(LinkWord.getProgressiveLinkWord());
		}
		
		// nếu số mã cổ phiếu khác trạng thái => quan hệ đối lập
		
		else 
		if ((VN30cnt >= 20) && (HNX30cnt < 10) ||
			(VN30cnt < 10) && (HNX30cnt >= 20 ) ||
			(VN30cnt < 20 && VN30cnt >= 10) && (HNX30cnt >= 20 || HNX30cnt < 10)){
			linkWord = InputData.getRandom(LinkWord.getOpposingLinkWord());
		}
		return linkWord;
	}
	
	// Sinh trạng từ thời gian
	
	public String getTimeAdverb() {
		
		String timeAdverb = "";
		int VN30cnt = this.increaseCodeCounter("VN30");
		int HNX30cnt = this.increaseCodeCounter("HNX30");
		
		// nếu trạng thái giống nhau => trạng từ thời gian tăng tiến
		
		if ((VN30cnt >= 18) && (HNX30cnt >= 18) ||
			(VN30cnt < 12) && (HNX30cnt < 12 ) ||
			(VN30cnt < 18 && VN30cnt >= 12) && (HNX30cnt < 18 && HNX30cnt >= 12)){
				timeAdverb = InputData.getRandom(AdverbTime.getProgressiveTimeAdverb());
		}
		
		// nếu trạng thái khác nhau => trạng từ thời gian đối nghịch
		
		else 
		if ((VN30cnt >= 18) && (HNX30cnt < 12) ||
			(VN30cnt < 12) && (HNX30cnt >= 18 ) ||
			(VN30cnt < 18 && VN30cnt >= 12) && (HNX30cnt >= 18 || HNX30cnt < 12)){
				timeAdverb = InputData.getRandom(AdverbTime.getOpposingTimeAdverb());
		}
		return timeAdverb;
	}
	
	// Sinh câu
	
	public void createSentence() {
		String VN30status = this.createClause("VN30");
		String HNX30status = this.createClause("HNX30");
		String timeAdverb = this.getTimeAdverb();
		System.out.println(VN30status + timeAdverb + HNX30status);
	}
}
