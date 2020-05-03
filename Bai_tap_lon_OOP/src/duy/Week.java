package duy;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import Input.DataOneDay;
import Input.Format;
import Input.InputData;
import Input.STOCK;
import Input.Caculate;

public class Week extends NhanXet {
	
	{
		this.name = "tuần";
	}
	
	private long sum(Date date) {
		return Caculate.sum(InputData.getDataOneWeekOneStock(stock, date)
				.stream().map(DataOneDay::getKL)
				.collect(Collectors.toCollection(ArrayList::new)));
	}

	@Override
	public NhanXet setInfo(Date date, STOCK stock) {
		this.stock = stock;
		allVolume = sum(date);
		change = allVolume - sum(Format.getDate(date, -7));
		return this;
	}
	
}
