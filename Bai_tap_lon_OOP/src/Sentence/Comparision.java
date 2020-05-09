package Sentences;


public abstract class Comparision {

	public String[] tag;
	protected String status;
	
	public Comparision() {		
	}
	
	protected abstract String getStatus();
	public void printStatus() {
		System.out.println(status);
	}
	
}