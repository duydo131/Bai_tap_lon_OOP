package duy;

import java.util.Date;

import Input.Format;
import Input.InputData;
import Input.STOCK;

public class OneStock2Week extends OneStock2{

	public OneStock2Week(STOCK stock, Date date) {
		super(stock, date);
		this.name = "tuần";
		this.dataOneDay.add(InputData.priceMaxOneWeek(stock, date));
		this.dataOneDay.add(InputData.priceMinOneWeek(stock, date));
		this.dataOneDay.add(InputData.volumeMaxOneWeek(stock, date));
		this.dataOneDay.add(InputData.volumeMinOneWeek(stock, date));
		this.sumVolume = InputData.volumeSumOneWeek(stock, date);
		this.numberOfDays = InputData.getDataOneWeekOneStock(stock, date).size();
		Date dateBefore = Format.getDate(date, -7);
		this.averageVolumeBefore = (long)InputData.volumeSumOneWeek(stock, dateBefore)
											/InputData.getDataOneWeekOneStock(stock, dateBefore).size();
	}

}
