package stock_code_analization;

import java.util.ArrayList;
import java.util.Date;

import Input.Tool;
import Input.InputData;
import Input.STOCK;

public class AnalizationOneStock2Week extends AnalizationOneStock2{

	public AnalizationOneStock2Week(STOCK stock, Date date) {
		super(stock, date);
		this.name = "tuần";
		this.dataOneDay.add(InputData.priceMaxOneWeek(stock, date));
		this.dataOneDay.add(InputData.priceMinOneWeek(stock, date));
		this.dataOneDay.add(InputData.volumeMaxOneWeek(stock, date));
		this.dataOneDay.add(InputData.volumeMinOneWeek(stock, date));
		this.sumVolume = InputData.volumeSumOneWeek(stock, date);
		this.numberOfDays = InputData.getDataOneWeekOneStock(stock, date).size();
		Date dateBefore = Tool.getDate(date, -7);
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

}
