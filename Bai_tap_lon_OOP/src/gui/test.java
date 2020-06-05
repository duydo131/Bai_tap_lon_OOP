package gui;
import Sentence.*;
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
import ledung.DayTitle;

public class test {
	
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date date = f.parse("11/12/2019");
		
		STOCK stock = STOCK.BID;
		
		DayTitleOneStockClass p = new DayTitleOneStockClass(STOCK.ACB.name(), date);
		System.out.println(p.createStockClassClause());
		
		DayTitle dayTitle = new DayTitle(date);
		dayTitle.printSentence();
	}
}
