package changing_sentence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import gui.Tag;
import input.*;

public abstract class Sentence implements Tag {
	
	protected String subject;
	protected String complement;
	protected String verb;
	protected ArrayList<String> listTag = new ArrayList<>();
	
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}
	
	public void setVerb(String verb) {
		this.verb = verb;
	}
	
	
	public static Date[] getWeek(Date date) {
		
		Date[] week = new Date[2];
		Calendar temp = Calendar.getInstance();
		
		temp.setTime(date);
		if (temp.get(Calendar.DAY_OF_WEEK) == 1) {
			week[1] = Tool.getDate(date, -2);
			week[0] = Tool.getDate(date, -6);
		}
		else if (temp.get(Calendar.DAY_OF_WEEK) == 7) {
			week[1] = Tool.getDate(date, -1);
			week[0] = Tool.getDate(date, -5);
		}
		return week;
	}
	
	
	public static Date firstWorkingDayOfWeek(Date date) {
		
		Date search = date;
		
		while (InputData.getToday(search).get(STOCK.ACB).getGiaDongCua() == 0) {
			search = Tool.getDate(search, 1);
		}
		
		return search;
	}
	
	public static Date lastWorkingDayOfWeek(Date date) {
		
		Date search = date;
		
		while (InputData.getToday(search).get(STOCK.ACB).getGiaDongCua() == 0) {
			search = Tool.getDate(search, -1);
		}
		
		return search;
	}
	
	
	public static int workingDayCounterAWeek(Date date1, Date date2) {
		
		Date temp = Tool.getDate(date2, -1);
		int counter = 0;

		while(temp.getTime() != date1.getTime()) {
			if (InputData.getToday(temp).get(STOCK.ACB).getGiaDongCua() != 0) {
				counter++;
			}
			temp = Tool.getDate(temp, -1);
		}
		counter++;
		return counter;
	}
	
	public static int optimumCounter(String optimum, Date date, STOCK stock) {
		
		Date yesterday = getYesterday(date);
		int counter = 0;
		
		if (optimum == "max") {
			double max = InputData.getToday(date).get(stock).getGiaMax();
			while (max > InputData.getToday(yesterday).get(stock).getGiaMax()) {
					counter++;
					yesterday = getYesterday(yesterday);
			}
		}
		else if (optimum == "min") {
			double min = InputData.getToday(date).get(stock).getGiaMin();
			while (min < InputData.getToday(yesterday).get(stock).getGiaMin()) {
					counter++;
					yesterday = getYesterday(yesterday);
			}
		}
		return counter;
	}
	
	public static Date getYesterday(Date date) {
		
		Date yesterday = Tool.getDate(date, -1);
		
		while (InputData.getToday(yesterday).get(STOCK.ACB).getGiaDongCua() == 0) {
			yesterday = Tool.getDate(yesterday, -1);
		}
		
		return yesterday;
	}
	
	public void printSentence() {
		System.out.println(subject + verb + complement);
	}
	
}
