package gui;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Input.ReadFile;
import Input.STOCK;
import duy.Cau1HNX30;
import duy.Cau1VN30;
import duy.Cau2HNX30;
import duy.Cau2VN30;
import duy.Cau3GiamHNX30;
import duy.Cau3GiamVN30;
import duy.Cau3TangHNX30;
import duy.Cau3TangVN30;
import duy.Cau4HNX30;
import duy.Cau4VN30;
import duy.DayHNX30;
import duy.DayVN30;
import duy.OneStock1;
import duy.OneStock2Month;
import duy.OneStock2Week;
import duy.WeekHNX30;
import duy.WeekVN30;

public class test {
	
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date date = f.parse("20/02/2020");
		
		STOCK stock = STOCK.BID;
		
		ArrayList<Tag> list = new ArrayList<>();
		
		list.add(new Cau1HNX30(date));
		list.add(new Cau1VN30(date));
		list.add(new Cau2HNX30(date));
		list.add(new Cau2VN30(date));
		list.add(new Cau3GiamHNX30(date));
		list.add(new Cau3TangHNX30(date));
		list.add(new Cau3GiamVN30(date));
		list.add(new Cau3TangVN30(date));
		list.add(new Cau4VN30(date));
		list.add(new Cau4HNX30(date));
		list.add(new DayVN30(date));
		list.add(new DayHNX30(date));
		list.add(new WeekVN30(date));
		list.add(new WeekHNX30(date));
		list.add(new OneStock1(stock, date));
		list.add(new OneStock2Month(stock, date));
		list.add(new OneStock2Week(stock, date));
		
		ArrayList<String> listTag = new ArrayList<>();
		for (Tag tag : list) {
			ArrayList<String> li = tag.getTag();
			for (String string : li) {
				if(listTag.contains(string)) continue;
				listTag.add(string);
			}
		}
		for (String string : listTag) {
			System.out.println(string);
		}
	}
}
