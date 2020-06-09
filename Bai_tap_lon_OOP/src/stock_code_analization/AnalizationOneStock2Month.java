package stock_code_analization;

import java.util.ArrayList;
import java.util.Date;

import Input.Tool;
import Input.InputData;
import Input.MONTH;
import Input.STOCK;

public class AnalizationOneStock2Month extends AnalizationOneStock2{

	public AnalizationOneStock2Month(STOCK stock, Date date) {
		super(stock, date);
		this.name = "tháng";
		MONTH month = MONTH.getName(Tool.getMonth(date));
		this.dataOneDay.add(InputData.priceMaxOneMonth(stock, month));
		this.dataOneDay.add(InputData.priceMinOneMonth(stock, month));
		this.dataOneDay.add(InputData.volumeMaxOneMonth(stock, month));
		this.dataOneDay.add(InputData.volumeMinOneMonth(stock, month));
		this.sumVolume = InputData.volumeSumOneMonth(stock, month);
		this.numberOfDays = InputData.getDataOneMonthOneStock(stock, month).size();
		MONTH monthBefore = MONTH.monthBefore(month);
		this.averageVolumeBefore = (long)InputData.volumeSumOneMonth(stock, monthBefore)
											/InputData.getDataOneMonthOneStock(stock, monthBefore).size();
		
		this.setTag();
	}

	@Override
	public ArrayList<String> getTag() {
		return this.listTag;
	}
	
	@Override
	public void setTag() {
		super.setTag();
		this.listTag.add("tháng");
		this.listTag.add("month");
	}

}
