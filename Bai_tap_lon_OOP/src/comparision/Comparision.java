package comparision;

import java.util.ArrayList;
import java.util.Date;

import gui.Tag;
import input.STOCK;

public abstract class Comparision implements Tag{
	public Comparision() {
	}

	protected Date date;
	protected ArrayList<String> listTag = new ArrayList<String>();
	protected String status;
	protected STOCK stock1;
	protected STOCK stock2;
}