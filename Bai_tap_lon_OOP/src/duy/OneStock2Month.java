package duy;

import java.util.Date;

import Input.Format;
import Input.InputData;
import Input.MONTH;
import Input.STOCK;

public class OneStock2Month extends OneStock2{

	public OneStock2Month(STOCK stock, Date date) {
		super(stock, date);
		this.name = "tháng";
		MONTH month = MONTH.getName(Format.getMonth(date));
		this.dataOneDay.add(InputData.priceMaxOneMonth(stock, month));
		this.dataOneDay.add(InputData.priceMinOneMonth(stock, month));
		this.dataOneDay.add(InputData.volumeMaxOneMonth(stock, month));
		this.dataOneDay.add(InputData.volumeMinOneMonth(stock, month));
		this.sumVolume = InputData.volumeSumOneMonth(stock, month);
		this.numberOfDays = InputData.getDataOneMonthOneStock(stock, month).size();
		MONTH monthBefore = MONTH.monthBefore(month);
		this.averageVolumeBefore = (long)InputData.volumeSumOneMonth(stock, monthBefore)
											/InputData.getDataOneMonthOneStock(stock, monthBefore).size();
	}

}
