package changing_sentence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import gui.Tag;
import Input.ReadFile;
import Input.STOCK;

public class test {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formats.parse("20/02/2020");
		STOCK stock = STOCK.BID;
		
		ArrayList<Tag> list = new ArrayList<>();
		ArrayList<String> list1 = new ArrayList<>();
		
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
		
		list1.add(new Cau1HNX30(date).get());
		list1.add(new Cau1VN30(date).get());
		list1.add(new Cau2HNX30(date).get());
		list1.add(new Cau2VN30(date).get());
		list1.add(new Cau3GiamHNX30(date).get());
		list1.add(new Cau3TangHNX30(date).get());
		list1.add(new Cau3GiamVN30(date).get());
		list1.add(new Cau3TangVN30(date).get());
		list1.add(new Cau4VN30(date).get());
		list1.add(new Cau4HNX30(date).get());
		list1.add(new DayVN30(date).get());
		list1.add(new DayHNX30(date).get());
		list1.add(new WeekVN30(date).get());
		list1.add(new WeekHNX30(date).get());

		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getClass().getSimpleName() + " : " + list.get(i).getTag());
			System.out.println(list1.get(i));
			System.out.println();
		}
		
	}
}