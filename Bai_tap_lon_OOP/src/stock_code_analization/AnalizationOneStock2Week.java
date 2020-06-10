package stock_code_analization;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import input.InputData;
import input.STOCK;
import input.Tool;

public class AnalizationOneStock2Week extends AnalizationOneStock2{

	public AnalizationOneStock2Week(STOCK stock, Date date) {
		super(stock, date);
		this.name = "tuần";
		this.dataOneStock.add(InputData.priceMaxOneWeek(stock, date));
		this.dataOneStock.add(InputData.priceMinOneWeek(stock, date));
		this.dataOneStock.add(InputData.volumeMaxOneWeek(stock, date));
		this.dataOneStock.add(InputData.volumeMinOneWeek(stock, date));
		this.sumVolume = InputData.volumeSumOneWeek(stock, date);
		this.numberOfDays = InputData.getDataOneWeekOneStock(stock, date).size();
		Date dateBefore = getWeekBefore(date);
		this.averageVolumeBefore = (long)InputData.volumeSumOneWeek(stock, dateBefore)
											/InputData.getDataOneWeekOneStock(stock, dateBefore).size();
		
		this.setTag();
	}

	@Override
	public ArrayList<String> getTag() {
		return this.listTag;
	}
	
	@Override
	public void setTag() {
		super.setTag();
		this.listTag.add("tuần");
		this.listTag.add("week");
	}

	private Date getWeekBefore(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return Tool.getDate(date, - calendar.get(Calendar.DAY_OF_WEEK));
	}
}
