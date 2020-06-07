package ledung;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import Input.*;

public class OverAllWeekStockClass2 extends OverAllWeek {
	
	private String name;
	
	// constructor
	
	public OverAllWeekStockClass2(String name, Date date) {
		super(date);
		this.name = name;
		this.date1 = Sentence.getWeek(date)[0];
		this.date2 = Sentence.getWeek(date)[1];
	}
	
	// tính mức tăng/giảm
	
	public double getDiff(STOCK stock) {
		
		// mức tăng giảm = giá đóng cửa ngày cuối - giá mở cửa ngày đâu tiên
		
		return InputData.getToday(date2).get(stock).getGiaDongCua() - InputData.getToday(date1).get(stock).getGiaMoCua();
	}
	
	// tính tỉ lệ tăng/giảm
	
	public double getRatio(STOCK stock) {
		
		// tỉ lệ tăng/giảm = |1 - (giá đóng cửa ngày cuối / giá mở cửa ngày đầu)|*100%
		
		return Math.abs((1-InputData.getToday(date2).get(stock).getGiaDongCua()/InputData.getToday(date1).get(stock).getGiaMoCua()))*100;
	}
	
	// sắp xếp Selection Sorting
	
	public STOCK[] sortArray(STOCK[] array) {
		int max;
		STOCK temp;
		
		if (array == null) return null;
		for (int i = 0; i < (array.length-1); i++) {
			max = i;
			for (int j = i+1; j < array.length; j++) {
				if (getDiff(array[j]) > getDiff(array[max])) {
					max = j;
				}
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		
		return array;
	}
	
	// đếm số mã tăng
	
	public int increaseCodeCounter() {
		
		int count = 0;
		int days = InputData.getDays(date1, date2);
		
		if(this.name == "VN30") {
			for (STOCK i: InputData.stockVN30()) {
				if (i != STOCK.VNINDEX) {
					if (InputData.getInfoVN30(date1, date2).get(i).get(days).getGiaDongCua() - InputData.getInfoVN30(date1,date2).get(i).get(0).getGiaMoCua() > 0) {
						count++;
					}
				}
			}
		}
		else if (name == "HNX30") {
			for (STOCK i: InputData.stockHNX30()) {
				if (i != STOCK.HASTC) {
					if (InputData.getInfoHNX30(date1, date2).get(i).get(days).getGiaDongCua() - InputData.getInfoHNX30(date1,date2).get(i).get(0).getGiaMoCua() > 0) {
						count++;
					}
				}
			}
		}
		return count;
	}
	
	// đếm số mã giảm
	
	public int decreaseCodeCounter() {
		
		int count = 0;
		int days = InputData.getDays(date1, date2);
		int weekends = this.weekendCounter();
		
		days -= weekends;

		if (this.name == "VN30") {
			for (STOCK i: InputData.stockVN30()) {
				if (i != STOCK.VNINDEX) {
					if (InputData.getInfoVN30(date1,date2).get(i).get(days).getGiaDongCua() - InputData.getInfoVN30(date1,date2).get(i).get(0).getGiaMoCua() < 0) {
						count++;
					}
				}
			}
		}
		else if (this.name == "HNX30") {
			for (STOCK i: InputData.stockHNX30()) {
				if (i != STOCK.HASTC) {
					if (InputData.getInfoVN30(date1,date2).get(i).get(days).getGiaDongCua() - InputData.getInfoVN30(date1,date2).get(i).get(0).getGiaMoCua() < 0) {
					count++;
					}
				}
			}
		}
		return count;
	}
	
	// lọc ra các cổ phiếu tăng
	
	public STOCK[] increaseClassify() {
		
		ReadFile.loadData();
		int days = InputData.getDays(date1, date2);
		STOCK[] array = new STOCK[this.increaseCodeCounter()];
		int index = 0;
		
		if (InputData.isWeekend(date2) && InputData.isWeekend(date1) && days == 1) {
			return null;
		}
		
		while (InputData.isWeekend(date2)) {
			date2 = Tool.getDate(date2, -1);;
		}
		
		while (InputData.isWeekend(date1)) {
			date1 = Tool.getDate(date1, 1);;
		}
		
		if (this.name == "VN30") {
			for (STOCK i: InputData.stockVN30()) {
				if (i != STOCK.VNINDEX) {
					if (InputData.getInfoVN30(date1, date2).get(i).get(days).getGiaDongCua() - InputData.getInfoVN30(date1,date2).get(i).get(0).getGiaMoCua() > 0) {
						array[index] = i;
						index++;
					}
				}
			}
		}
		else if (this.name == "HNX30") {
			for (STOCK i: InputData.stockHNX30()) {
				if (i != STOCK.HASTC) {
					if (InputData.getInfoHNX30(date1, date2).get(i).get(days).getGiaDongCua() - InputData.getInfoHNX30(date1,date2).get(i).get(0).getGiaMoCua() > 0) {
						array[index] = i;
						index++;
					}
				}
			}
		}
		return array;
	}
	
	// lọc ra các cổ phiếu giảm
	
	public STOCK[] decreaseClassify() {
		
		ReadFile.loadData();
		
		int days = InputData.getDays(date1, date2);
		STOCK[] array = new STOCK[decreaseCodeCounter()];;
		int index = 0;
		
		if (InputData.isWeekend(date2) && InputData.isWeekend(date1) && days == 1) {
			return null;
		}
		
		while (InputData.isWeekend(date2)) {
			date2 = Tool.getDate(date2, -1);
		}
		
		while (InputData.isWeekend(date1)) {
			date1 = Tool.getDate(date1, 1);
		}
		
		if (this.name == "VN30") {
			for (STOCK i: InputData.stockVN30()) {
				if (i != STOCK.VNINDEX) {
					if (InputData.getInfoVN30(date1, date2).get(i).get(days).getGiaDongCua() - InputData.getInfoVN30(date1,date2).get(i).get(0).getGiaMoCua() < 0) {
						array[index] = i;
						index++;
					}
				}
			}
		}
		else if (this.name == "HNX30") {
			for (STOCK i: InputData.stockHNX30()) {
				if (i != STOCK.HASTC) {
					if (InputData.getTodayHNX30(date2).get(i).getGiaDongCua() - InputData.getTodayHNX30(date1).get(i).getGiaMoCua() < 0 ) {
						array[index] = i;
						index++;
					}
				}
			}
		}
		return array;
	}
	
	// xếp hạng các cổ phiếu tăng
	// nếu chỉ có 3 hoặc ít hơn cổ phiếu tăng -> lấy hết
	// nếu có nhiều hơn 3 cổ phiếu tăng -> lấy top 3
	
	public String rankingNegativeAffect() {
		
		ReadFile.loadData();
		String ranking = "Các cổ phiếu tác động tiêu cực nhất tới " + this.name + " là ";
		STOCK[] stock = this.sortArray(decreaseClassify());
		
		if (stock == null) {
			return "Cuối tuần không có giao dịch.";
		}
		else if (this.name == "VN30") {
			
			if (stock.length <= 3) {
				for (int i = 0; i < stock.length; i++) {
					ranking += stock[i].name();
					if (i != 2) {
						ranking += ", ";
					}
					else ranking += " với các mức tăng lần lượt là ";
				}
				for (int i = 0; i < 3; i++) {
					ranking += String.format("%.2f", getRatio(stock[i]));
					if (i != 2) {
						ranking += "%, ";
					}
					else if (i == 2) {
						ranking += "%. ";
					}
				}
			}
			else {
				for (int i = 0; i < 3; i++) {
					ranking += stock[i].name();
					if (i != 2) {
						ranking += ", ";
					}
					else ranking += " với các mức tăng lần lượt là ";
				}
				for (int i = 0; i < 3; i++) {
					ranking += String.format("%.2f", getRatio(stock[i]));
					if (i != 2) {
						ranking += "%, ";
					}
					else if (i == 2) {
						ranking += "%. ";
					}
				}
			}
		}
		else if (this.name == "HNX30") {
			
			if (stock.length <= 3) {
				for (int i = 0; i < stock.length; i++) {
					ranking += stock[i].name();
					if (i != 2) {
						ranking += ", ";
					}
					else ranking += " với các mức tăng lần lượt là ";
				}
				for (int i = 0; i < 3; i++) {
					ranking += String.format("%.2f", getRatio(stock[i]));
					if (i != 2) {
						ranking += "%, ";
					}
					else if (i == 2) {
						ranking += "%. ";
					}
				}
			}
			else {
				for (int i = 0; i < 3; i++) {
					ranking += stock[i].name();
					if (i != 2) {
						ranking += ", ";
					}
					else ranking += " với các mức tăng lần lượt là ";
				}
				for (int i = 0; i < 3; i++) {
					ranking += String.format("%.2f", getRatio(stock[i]));
					if (i != 2) {
						ranking += "%, ";
					}
					else if (i == 2) {
						ranking += "%. ";
					}
				}
			}
		}
		return ranking;
	}
	
	// xếp hạng các cổ phiếu giảm
	// nếu chỉ có 3 hoặc ít hơn cổ phiếu giảm -> lấy hết
	// nếu có nhiều hơn 3 cổ phiếu giảm -> lấy top 3
	
	public String rankingPositiveAffect() {
		
		ReadFile.loadData();
		String ranking = "Các cổ phiếu tác động tích cực nhất tới " + this.name + " là ";
		if (this.name == "VN30") {
			STOCK[] stock = this.sortArray(increaseClassify());
			
			if (stock == null) {
				return "Cuối tuần không có giao dịch.";
			}
			if (stock.length <= 3) {
				for (int i = 0; i < stock.length; i++) {
					ranking += stock[i].name();
					if (i != 2) {
						ranking += ", ";
					}
					else ranking += " với các mức tăng lần lượt là ";
				}
				for (int i = 0; i < 3; i++) {
					ranking += String.format("%.2f", getRatio(stock[i]));
					if (i != 2) {
						ranking += "%, ";
					}
					else if (i == 2) {
						ranking += "%. ";
					}
				}
			}
			else {
				for (int i = 0; i < 3; i++) {
					ranking += stock[i].name();
					if (i != 2) {
						ranking += ", ";
					}
					else ranking += " với các mức tăng lần lượt là ";
				}
				for (int i = 0; i < 3; i++) {
					ranking += String.format("%.2f", getRatio(stock[i]));
					if (i != 2) {
						ranking += "%, ";
					}
					else if (i == 2) {
						ranking += "%. ";
					}
				}
			}
		}
		else if (this.name == "HNX30") {
			STOCK[] stock = increaseClassify();

			if (stock.length <= 3) {
				for (int i = 0; i < stock.length; i++) {
					ranking += stock[i].name();
					if (i != 2) {
						ranking += ", ";
					}
					else ranking += " với các mức tăng lần lượt là ";
				}
				for (int i = 0; i < 3; i++) {
					ranking += String.format("%.2f", getRatio(stock[i]));
					if (i != 2) {
						ranking += "%, ";
					}
					else if (i == 2) {
						ranking += "%. ";
					}
				}
			}
			else {
				for (int i = 0; i < 3; i++) {
					ranking += stock[i].name();
					if (i != 2) {
						ranking += ", ";
					}
					else ranking += " với các mức tăng lần lượt là ";
				}
				for (int i = 0; i < 3; i++) {
					ranking += String.format("%.2f", getRatio(stock[i]));
					if (i != 2) {
						ranking += "%, ";
					}
					else if (i == 2) {
						ranking += "%. ";
					}
				}
			}
		}
		return ranking;
	}
	
	// xét mệnh đề về chỉ số INDEX (VNINDEX/HNXINDEX)
	
	public String setIndexClause() {
		
		String indexStatus = "";
		double closedValue;
		double openValue;
		double diff;
		double ratio;
		
		if (this.name == "VN30") {
			closedValue = InputData.getTodayVN30(date2).get(STOCK.VNINDEX).getGiaDongCua();
			openValue = InputData.getTodayVN30(date1).get(STOCK.VNINDEX).getGiaMoCua();
			diff = closedValue - openValue;
			ratio = getRatio(STOCK.VNINDEX);
			if (diff > 0) {
				indexStatus = "Chỉ số VNINDEX tăng " + String.format("%.2f", diff) + " điểm, tương đương với " + String.format("%.2f", ratio) + " đạt mức " + closedValue + " điểm. ";
			}
			else if (diff < 0) {
				indexStatus = "Chỉ số VNINDEX giảm " + String.format("%.2f", diff) + " điểm, tương đương với " + String.format("%.2f", ratio) + " xuống mức " + closedValue + " điểm. ";
			}
		}
		if (this.name == "HNX30") {
			closedValue = InputData.getTodayHNX30(date2).get(STOCK.HASTC).getGiaDongCua();
			openValue = InputData.getTodayHNX30(date1).get(STOCK.HASTC).getGiaMoCua();
			diff = closedValue - openValue;
			ratio = getRatio(STOCK.HASTC);
			if (diff > 0) {
				indexStatus = "Chỉ số HNX-INDEX tăng " + String.format("%.2f", Math.abs(diff)) + " điểm, tương đương với " + String.format("%.2f", Math.abs(ratio)) + "% đạt mức " + closedValue + " điểm. ";
			}
			else if (diff < 0) {
				indexStatus = "Chỉ số HNX-INDEX giảm " + String.format("%.2f", Math.abs(diff)) + " điểm, tương đương với " + String.format("%.2f", Math.abs(ratio)) + "% xuống mức " + closedValue + " điểm. ";
			}
		}
		return indexStatus;
	}
	
	// đếm số cổ phiếu tăng của 1 nhóm cổ phiếu (VN30/HNX30) trong tgian từ date1 -> date2
	
	public int increaseCodeCounter(String name) {
		
		ReadFile.loadData();
		
		int counter = 0;

		Set<STOCK> stocks = null;
		
		if (name == "VN30") {
			 stocks = InputData.stockVN30();
		} else if (name == "HNX30"){
			stocks = InputData.stockHNX30();
		}
		
		for (STOCK i : stocks) {
			double closedValue = InputData.getToday(date2).get(i).getGiaDongCua();
			double openValue = InputData.getToday(date1).get(i).getGiaMoCua();
			double diff = closedValue - openValue;
			if (diff > 0) {
				counter++;
			}
		}
		return counter;
	}
	
	// Sinh mệnh đề
	
	public String createStockCodesClause() {
		String status = "";
		int cnt = this.increaseCodeCounter(name);
		if (name == "VN30") {
			if (cnt >= 20) {
				status = InputData.getRandom(Verb.getManyIncrease());
			}
			else if (cnt < 20 && cnt >= 16) {
				status = InputData.getRandom(Verb.getFewIncrease());
			}
			else if (cnt < 16 && cnt >= 14) {
				status = InputData.getRandom(Verb.getLessChanging());
			}
			else if (cnt < 14 && cnt >= 10) {
				status = InputData.getRandom(Verb.getFewDecrease());
			}
			else if (cnt < 10) {
				status = InputData.getRandom(Verb.getManyDecrease());
			}
		}
		if (name == "HNX30") {
			if (cnt >= 20) {
				status = InputData.getRandom(Verb.getManyIncrease());
			}
			else if (cnt < 20 && cnt >= 16) {
				status = InputData.getRandom(Verb.getFewIncrease());
			}
			else if (cnt < 16 && cnt >= 14) {
				status = InputData.getRandom(Verb.getLessChanging());
			}
			else if (cnt < 14 && cnt >= 10) {
				status = InputData.getRandom(Verb.getFewDecrease());
			}
			else if (cnt < 10) {
				status = InputData.getRandom(Verb.getManyDecrease());
			}
		}
		return "Nhóm cổ phiếu " + name + status + "với " + cnt + " mã tăng giá và " + (30-cnt) + " mã giảm giá. ";
	}
	
	// Sinh câu 

	public void createSentence() {
		
		ReadFile.loadData();
		
		String stocks = this.createStockCodesClause();
		String nega = this.rankingNegativeAffect();
		String posi = this.rankingPositiveAffect();
		String index = this.setIndexClause();
		
		if (nega == posi) {
			System.out.println(nega);
		}
		else {
		System.out.println(index + stocks + nega + posi);
		}
	}

	@Override
	public ArrayList<String> getTag() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTag() {
		// TODO Auto-generated method stub
		
	}
}
