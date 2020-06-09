package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Input.ReadFile;
import Input.STOCK;
import changing_sentence.Cau1ChangingHNX30;
import changing_sentence.Cau1ChangingVN30;
import changing_sentence.Cau2ChangingHNX30;
import changing_sentence.Cau2ChangingVN30;
import changing_sentence.Cau3ChangingDecreaseHNX30;
import changing_sentence.Cau3ChaingingDecreaseVN30;
import changing_sentence.Cau3ChangingIncreaseHNX30;
import changing_sentence.Cau3ChangingIncreaseVN30;
import changing_sentence.Cau4ChangingHNX30;
import changing_sentence.Cau4ChangingVN30;
import changing_sentence.DayChangingHNX30;
import changing_sentence.DayChangingVN30;
import changing_sentence.WeekChangingHNX30;
import changing_sentence.WeekChangingVN30;
import stock_code_analization.AnalizationOneStock1;
import stock_code_analization.AnalizationOneStock2Month;
import stock_code_analization.AnalizationOneStock2Week;

public class test2 {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date staticDate = f.parse("28/02/2020");
		Date staticDateWeekend = f.parse("22/02/2020");
		
		STOCK staticStock = STOCK.BID;
		
		ArrayList<Tag> list = new ArrayList<>();
		
		list.add(new Cau1ChangingHNX30(staticDate));
		list.add(new Cau1ChangingVN30(staticDate));
		list.add(new Cau2ChangingHNX30(staticDate));
		list.add(new Cau2ChangingVN30(staticDate));
		list.add(new Cau3ChangingDecreaseHNX30(staticDate));
		list.add(new Cau3ChangingIncreaseHNX30(staticDate));
		list.add(new Cau3ChaingingDecreaseVN30(staticDate));
		list.add(new Cau3ChangingIncreaseVN30(staticDate));
		list.add(new Cau4ChangingVN30(staticDate));
		list.add(new Cau4ChangingHNX30(staticDate));
		list.add(new DayChangingVN30(staticDate));
		list.add(new DayChangingHNX30(staticDate));
		list.add(new WeekChangingVN30(staticDate));
		list.add(new WeekChangingHNX30(staticDate));
		list.add(new AnalizationOneStock1(staticStock, staticDate));
		list.add(new AnalizationOneStock2Month(staticStock, staticDate));
		list.add(new AnalizationOneStock2Week(staticStock, staticDate));
		
		list.stream().forEach(tag -> System.out.println(tag.get()));
	}
}
