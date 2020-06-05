package Sentences;

import java.util.ArrayList;
import java.util.Date;

import Input.STOCK;
import gui.Tag;

<<<<<<< HEAD
public abstract class Comparision implements Tag {
=======
public abstract class Comparision {
	public Comparision() {
	}

>>>>>>> 586f98c58434d2a835765c773c4d04b6fd59ecf0
	protected Date date;
	protected ArrayList<String> listTag = new ArrayList<String>();
	protected String status;
	protected STOCK stock1;
	protected STOCK stock2;

}