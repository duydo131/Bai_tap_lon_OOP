package duy;

import Input.STOCK;

public class Stock{
	private STOCK stock;
	private long volume;
	
	public Stock(STOCK stock, long volume) {
		this.stock = stock;
		this.volume = volume;
	}
	
	public STOCK getStock() {
		return stock;
	}
	
	public Long getVolume() {
		return volume;
	}
}