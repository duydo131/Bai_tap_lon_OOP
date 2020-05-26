package gui;

import java.util.Date;

import Input.STOCK;
import duy.Cau1HNX30;
import duy.Cau1VN30;
import duy.Cau2HNX30;
import duy.Cau2VN30;
import duy.Cau3GiamHNX30;
import duy.Cau3GiamVN30;
import duy.Cau3TangHNX30;
import duy.Cau4HNX30;
import duy.Cau4VN30;
import duy.DayHNX30;
import duy.DayVN30;
import duy.OneStock1;
import duy.OneStock2Month;
import duy.OneStock2Week;
import duy.WeekHNX30;
import duy.WeekVN30;

public class Demo {
	public static Tag getInstance(Tag instance, Date date, STOCK stock) {
		Tag newInstance;
		switch (instance.getClass().getSimpleName()) {
		
		case "Cau1HNX30":
			newInstance = new Cau1HNX30(date);
			break;
			
		case "Cau1VN30":
			newInstance = new Cau1VN30(date);
			break;
			
		case "Cau2HNX30":
			newInstance = new Cau2HNX30(date);
			break;
			
		case "Cau2VN30":
			newInstance = new Cau2VN30(date);
			break;
			
		case "Cau3GiamHNX30":
			newInstance = new Cau3GiamHNX30(date);
			break;
			
		case "Cau3TangHNX30":
			newInstance = new Cau3TangHNX30(date);
			break;
			
		case "Cau3GiamVN30":
			newInstance = new Cau3GiamVN30(date);
			break;
			
		case "Cau3TangVN30":
			newInstance = new Cau3TangHNX30(date);
			break;
			
		case "Cau4VN30":
			newInstance = new Cau4VN30(date);
			break;
			
		case "Cau4HNX30":
			newInstance = new Cau4HNX30(date);
			break;
			
		case "DayVN30":
			newInstance = new DayVN30(date);
			break;
			
		case "DayHNX30":
			newInstance = new DayHNX30(date);
			break;
			
		case "WeekVN30":
			newInstance = new WeekVN30(date);
			break;
			
		case "WeekHNX30":
			newInstance = new WeekHNX30(date);
			break;
			
		case "OneStock1":
			newInstance = new OneStock1(stock, date);
			break;
			
		case "OneStock2Month":
			newInstance = new OneStock2Month(stock, date);
			break;
			
		case "OneStock2Week":
			newInstance = new OneStock2Week(stock, date);
			break;
			
		default:
			newInstance = null;
			break;
		}
		
		return newInstance;
	}
}
