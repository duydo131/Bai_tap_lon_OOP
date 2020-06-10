package changing_sentence;

import input.STOCK;

public class StockVolume{
	private STOCK stock;
	private long volume;
	
	public StockVolume(STOCK stock, long volume) {
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