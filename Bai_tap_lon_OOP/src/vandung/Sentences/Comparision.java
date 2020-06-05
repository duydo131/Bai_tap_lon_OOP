package vandung.Sentences;

import java.util.ArrayList;
import java.util.Date;

import Input.STOCK;
import gui.Tag;

public abstract class Comparision implements Tag {
	protected Date date;
	protected ArrayList<String> listTag = new ArrayList<>();
	protected String status;
	protected STOCK stock1;
	protected STOCK stock2;
	
	public Comparision() {		
	}
	
	
}