package duy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import gui.Demo;
import gui.Tag;
import Input.ReadFile;
import Input.STOCK;

public class test {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formats.parse("20/02/2020");
		STOCK stock = STOCK.BID;
		
		String tag = "HASTC";
		
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
		
		
//		for (Tag tag123 : list) {
//			System.out.println(tag123.getClass().getSimpleName() + " : " + tag123.getTag());
//		}
		
//		System.out.println("\nafter\n");
		
		ArrayList<Tag> li = list.stream()
								.filter(t->t.getTag().contains(tag))
								.map(t -> Demo.getInstance(t, date, stock))
								.collect(Collectors.toCollection(ArrayList::new));
		
		
		for (Tag tag123 : li) {
			System.out.println(tag123.getClass().getSimpleName() + " : " + tag123.getTag());
		}
		
		System.out.println();
		
		for (Tag tag2 : li) {
			System.out.println(tag2.get());
		}

	}
}