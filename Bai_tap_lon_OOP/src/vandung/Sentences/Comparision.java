package vandung.Sentences;

import java.util.ArrayList;
import java.util.Date;

import Input.STOCK;

public abstract class Comparision  {
	protected Date date;
	protected ArrayList<String> listTag = new ArrayList<>();
	protected String status;
	protected STOCK stock1;
	protected STOCK stock2;
	
	public Comparision() {		
	}
	
	
}