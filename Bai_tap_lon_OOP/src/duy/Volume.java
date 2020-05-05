package duy;


public class Volume {
	protected Cau1 cau1;
	protected Cau2 cau2;
	
	public String get() {
		return cau2.get() + "\nĐặc biệt, " + cau1.get() ;
	}
	
}
