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
		
		list.add(new Cau1HNX30(staticDate));
		list.add(new Cau1VN30(staticDate));
		list.add(new Cau2HNX30(staticDate));
		list.add(new Cau2VN30(staticDate));
		list.add(new Cau3GiamHNX30(staticDate));
		list.add(new Cau3TangHNX30(staticDate));
		list.add(new Cau3GiamVN30(staticDate));
		list.add(new Cau3TangVN30(staticDate));
		list.add(new Cau4VN30(staticDate));
		list.add(new Cau4HNX30(staticDate));
		list.add(new DayVN30(staticDate));
		list.add(new DayHNX30(staticDate));
		list.add(new WeekVN30(staticDate));
		list.add(new WeekHNX30(staticDate));
		
		list.forEach(t -> System.out.println(t.getTag()));
	}
}
