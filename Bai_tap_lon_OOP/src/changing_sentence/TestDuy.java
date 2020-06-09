package changing_sentence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Input.ReadFile;
import gui.Tag;

public class TestDuy {
	public static void main(String[] args) {
		ReadFile.loadData();
		
		ArrayList<Tag> list = new ArrayList<>();
		
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		Date staticDate = null;
		try {
			staticDate = formats.parse("28/02/2020");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//STOCK staticStock = STOCK.BID;
		
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
		
		list.forEach(t -> System.out.println(t.getTag()));
	}
}
