package summary_and_comment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import gui.Tag;
import input.ReadFile;
import input.STOCK;

public class TestQuang {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = formats.parse("04/02/2020");
		
		PsychologyOfInvestors test4 = new PsychologyOfInvestors(date1, STOCK.VNM);
		System.out.println(test4.get());
		System.out.println(test4.getTag());
		
		Forecast test5 = new Forecast(date1, STOCK.HASTC);
		System.out.println(test5.get());
		System.out.println(test5.getTag());
		
		CommentStock test6 = new CommentStock(date1, STOCK.VHM);
		System.out.println(test6.get());
		System.out.println(test6.getTag());
		
		CommentMarket test7 = new CommentMarket(date1, STOCK.VNINDEX);
		System.out.println(test7.get());
		System.out.println(test7.getTag());
		
//		overallComment test8 = new overallComment(date1, STOCK.VNM);
//		System.out.println(test8.get());
//		System.out.println(test8.getTag());
		
		Liquidity test9 = new Liquidity(date1, STOCK.L14);
		System.out.println(test9.get());
		System.out.println(test9.getTag());
		
		ArrayList<Tag> li = new ArrayList<>();
		STOCK stock = STOCK.BID;
		li.add(new PsychologyOfInvestors(date1, stock));
		li.add(new Forecast(date1, stock));
		li.add(new CommentMarket(date1, stock));
		li.add(new Liquidity(date1, stock));
		li.add(new CommentStock(date1, stock));
		
		li.forEach(t -> System.out.println(t.getTag()));
	}
}
