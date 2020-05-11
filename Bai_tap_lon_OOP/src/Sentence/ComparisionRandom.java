package Sentence;

import Input.DataOneDay;
import Input.InputData;
import Input.STOCK;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class ComparisionRandom extends Comparision {
	public ComparisionRandom(Date date) {
		this.date = date;
	}

	private Date date;
	private STOCK stock1;
	private STOCK stock2;

	private int number() {
		Random number = new Random();
		int numberRandom = number.nextInt(27) + 2;
		return numberRandom;
	}

	private STOCK dataStock(int number) {
		STOCK stock;
		stock = InputData.getStockByNumericalVN30(date, number);
		return stock;
	}

	private STOCK getStock1() {
		stock1 = dataStock(number());
		return stock1;
	}

	private STOCK getStock2() {
		stock2 = dataStock(number() + 1);
		return stock2;
	}

	private DataOneDay data(STOCK stock) {
		ArrayList<DataOneDay> data = InputData.getDataOneWeekOneStock(stock, date);
		return data.get(0);
	}

	public String getStatus() {
		status = getStock1() + " và " + getStock2()
				+ " bám sát nhau trên bảng điện tử và khối lượng bán ra lần lượt là " + data(getStock1()).getKL() + ", "
				+ data(getStock2()).getKL();
		;
		return status;
	}

}
