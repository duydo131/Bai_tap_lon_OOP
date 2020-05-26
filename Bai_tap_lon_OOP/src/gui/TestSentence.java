package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Input.ReadFile;
import duy.Cau1HNX30;
import duy.Cau1VN30;
import duy.Cau2HNX30;

public class TestSentence {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formats.parse("20/02/2020");
		
		ArrayList<Tag> listTag = new ArrayList<>();
		listTag.add(new Cau1VN30(date));
		listTag.add(new Cau1HNX30(date));
		
	//	System.out.println(new Cau1VN30(date).get());
		
		ArrayList<String> listTagNew = new ArrayList<>();
		
		for (Tag tag : listTag) {
			tag.getTag().stream().forEach(System.out::println);
		}
		
		
		for (Tag tag : listTag) {
			if(tag instanceof Cau1VN30) {
				Cau1VN30 c = new Cau1VN30(date);
				listTagNew.add(c.get());
			}else if(tag instanceof Cau1HNX30) {
				Cau1HNX30 c = new Cau1HNX30(date);
				listTagNew.add(c.get());
			}
		}
		
//		for (String string : listTagNew) {
//			System.out.println(string);
//		}
	}				
}
