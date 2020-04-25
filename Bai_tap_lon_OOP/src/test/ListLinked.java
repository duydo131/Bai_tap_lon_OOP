package test;

public class ListLinked {
	private String line;
	private int temp = 0;
	
	public ListLinked(String line, int temp) {
		setLine(line);
		setTemp(temp);
	}
	
	public void setLine(String line) {
		this.line = line;
	}
	
	public void setTemp(int temp) {
		this.temp = temp;
	}
	
	public String getLine() {
		return line;
	}
	
	public int getTemp() {
		return temp;
	}
	
	@Override
	public String toString() {
		return line + "["+ temp +"]";
	}
}
