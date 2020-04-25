package nhomcau;

import java.util.ArrayList;

public class Nhom {
	private String tennhom;
	
	private ArrayList<String> list = new ArrayList<>();
	
	public Nhom(ArrayList<String> list, String tennhom) {
		setList(list);
		setTennhom(tennhom);
	}
	
	public void setList(ArrayList<String> list) {
		this.list = list;
	}
	
	public void setTennhom(String tennhom) {
		this.tennhom = tennhom;
	}
	
	public ArrayList<String> getList() {
		return list;
	}
	
	public String getTennhom() {
		return tennhom;
	}
	
	public void print() {
		System.out.println(tennhom + " : ");
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println();
	}
}
