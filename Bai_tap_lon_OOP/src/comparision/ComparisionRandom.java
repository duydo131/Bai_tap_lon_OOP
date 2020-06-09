package comparision;

import Input.DataOneDay;
import Input.InputData;
import Input.STOCK;
import gui.Tag;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public abstract class ComparisionRandom extends Comparision implements Tag {
	public ComparisionRandom() {
	}

	public ComparisionRandom(Date date) {
		this.date = date;
	}

	@Override
	public String get() {
		status = getStock1() + " và " + getStock2() + list() + " khối lượng bán ra lần lượt là "
				+ data(getStock1()).getKL() + ", " + data(getStock2()).getKL();
		return status;
	}

	@Override
	public void setTag() {
		this.listTag.add("comparision");
	}
	@Override
	public ArrayList<String> getTag() {
		return this.listTag;
	}

	private String list() {
		String[] list = { 
				" bám sát nhau trên bảng điện tử với",
				" cạnh tranh khốc liệt trên bảng với",
				" rượt đuổi nhau trên bảng điện tử"
        };
		Random a = new Random();
		int random = a.nextInt(3);
		return list[random];
	}

	private int number() {
		Random number = new Random();
		int numberRandom = number.nextInt(24) + 2;
		return numberRandom;
	}

	protected abstract STOCK dataStock(int number);

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

}
