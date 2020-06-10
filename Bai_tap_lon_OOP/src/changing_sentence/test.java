package changing_sentence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import gui.Tag;
import input.ReadFile;
import input.STOCK;

public class test {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formats.parse("20/02/2020");
		STOCK stock = STOCK.BID;
		System.out.println(stock);
		ArrayList<Tag> list = new ArrayList<>();
		ArrayList<String> list1 = new ArrayList<>();
		
		list.add(new Cau1ChangingHNX30(date));
		list.add(new Cau1ChangingVN30(date));
		list.add(new Cau2ChangingHNX30(date));
		list.add(new Cau2ChangingVN30(date));
		list.add(new Cau3ChangingDecreaseHNX30(date));
		list.add(new Cau3ChangingIncreaseHNX30(date));
		list.add(new Cau3ChaingingDecreaseVN30(date));
		list.add(new Cau3ChangingIncreaseVN30(date));
		list.add(new Cau4ChangingVN30(date));
		list.add(new Cau4ChangingHNX30(date));
		list.add(new DayChangingVN30(date));
		list.add(new DayChangingHNX30(date));
		list.add(new WeekChangingVN30(date));
		list.add(new WeekChangingHNX30(date));
		
		list1.add(new Cau1ChangingHNX30(date).get());
		list1.add(new Cau1ChangingVN30(date).get());
		list1.add(new Cau2ChangingHNX30(date).get());
		list1.add(new Cau2ChangingVN30(date).get());
		list1.add(new Cau3ChangingDecreaseHNX30(date).get());
		list1.add(new Cau3ChangingIncreaseHNX30(date).get());
		list1.add(new Cau3ChaingingDecreaseVN30(date).get());
		list1.add(new Cau3ChangingIncreaseVN30(date).get());
		list1.add(new Cau4ChangingVN30(date).get());
		list1.add(new Cau4ChangingHNX30(date).get());
		list1.add(new DayChangingVN30(date).get());
		list1.add(new DayChangingHNX30(date).get());
		list1.add(new WeekChangingVN30(date).get());
		list1.add(new WeekChangingHNX30(date).get());

		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getClass().getSimpleName() + " : " + list.get(i).getTag());
			System.out.println(list1.get(i));
			System.out.println();
		}
		
	}
}