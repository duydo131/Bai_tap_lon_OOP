package Sentence;

import java.util.Date;
import java.util.Set;

import Input.*;

public class DaysTitleOneStockClass extends DaysTitle {
	private String name;
	
	public DaysTitleOneStockClass(String name, Date date1, Date date2) {
		super(date1,date2);
		this.name = name;
	}
	
	public String rankingNegativeAffect(Date date1, Date date2) {
		
		ReadFile.loadData();
		
		String name = this.name;
		String ranking = "Các cổ phiếu có ảnh hưởng tiêu cực nhất đến " + this.name + " là ";
		String stock[] = {STOCK.ACB.name(), STOCK.BID.name(), STOCK.BVH.name()};
		double value[] = {0.0, 0.0, 0.0};
		Set<STOCK> data = null;
		
		if (name=="VN30") {
			data = InputData.stockVN30();
		} 
		else if (name=="HNX30") {
			data = InputData.stockHNX30();
		}
		for (STOCK i: data) {
			double vle = InputData.getInfo(date1, date2).get(i).get(days).getGiaDongCua() - 
					InputData.getInfo(date1, date2).get(i).get(0).getGiaMoCua();
			for (int j = 0; j < 3 ; j++) {	
				if (vle < value[j]) {
					if (j==0) {
						value[j+2]=value[j+1];
						stock[j+2]=stock[j+1];
						value[j+1]=value[j];
						stock[j+1]=stock[j];
						value[j]=vle;
						stock[j]=i.name();
					} 
					if (j==1) {
						value[j+1]=value[j];
						stock[j+1]=stock[j];
						value[j]=vle;
						stock[j]=i.name();
					}
					if (j==2) {
						value[j]=vle;
						stock[j]=i.name();
					}
					j = 3;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			ranking += stock[i];
			if (i != 2) {
				ranking += ", ";
			}
			else ranking += " khi lấy đi của chỉ số lần lượt ";
		}
		for (int i = 0; i < 3; i++) {
			ranking += String.format("%.2f", value[i]);
			if (i != 2) {
				ranking += ", ";
			}
			else ranking += " điểm. ";
		}
		return ranking;
	}
	
	public String rankingPositiveAffect(Date date1, Date date2) {
		
		ReadFile.loadData();
		
		String ranking = "Ở chiều ngược lại, các cổ phiếu có ảnh hưởng tích cực nhất đến " + name + " hôm nay là ";
		String stock[] = {STOCK.ACB.name(), STOCK.BID.name(), STOCK.BVH.name()};
		String name = this.name;
		double value[] = {0.0, 0.0, 0.0};
		Set<STOCK> data = null;
		
		if (name=="VN30") {
			data = InputData.stockVN30();
		} 
		else if (name=="HNX30") {
			data = InputData.stockHNX30();
		}
		for (STOCK i: data) {
			double vle = InputData.getInfo(date1, date2).get(i).get(days).getGiaDongCua() - 
					InputData.getInfo(date1, date2).get(i).get(0).getGiaMoCua();
			for (int j = 0; j < 3 ; j++) {	
				if (vle > value[j]) {
					if (j==0) {
						value[j+2]=value[j+1];
						stock[j+2]=stock[j+1];
						value[j+1]=value[j];
						stock[j+1]=stock[j];
						value[j]=vle;
						stock[j]=i.name();
					} 
					if (j==1) {
						value[j+1]=value[j];
						stock[j+1]=stock[j];
						value[j]=vle;
						stock[j]=i.name();
					}
					if (j==2) {
						value[j]=vle;
						stock[j]=i.name();
					}
					j = 3;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			ranking += stock[i];
			if (i != 2) {
				ranking += ", ";
			}
			else ranking += " với mức đóng góp vào chỉ số lần lượt là ";
		}
		for (int i = 0; i < 3; i++) {
			ranking += String.format("%.2f", value[i]);
			if (i != 2) {
				ranking += ", ";
			}
			else ranking += " điểm tăng.";
		}
		return ranking;
	}
	
	public String createDaysTitleOneStockClass() {
		
		ReadFile.loadData();
		
		String nega = this.rankingNegativeAffect(date1, date2);
		String posi = this.rankingPositiveAffect(date1, date2);
		
		return "Thị trường chứng khoán ngày " + formats.format(date1) + " đến " + formats.format(date2) + ": " + (nega + posi);
		
	}
}
