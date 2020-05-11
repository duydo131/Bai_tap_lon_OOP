package Input;

public enum MONTH {
	JANUARY(1), FEBRUARY(2), OCTOBER(10), NOVEMBER(11), DECEMBER(12);
	private int month;
	
	
	MONTH(int month){
		this.month = month;
	}
	
	public int getMonth() {
		return month;
	}
	
	public static MONTH getName(int i) {
		for (MONTH element : MONTH.values()) {
			if(element.getMonth() == i) {
				return element;
			}
		}
		return null;
	}
	
	public static MONTH monthBefore(MONTH m) {
		if(m == MONTH.JANUARY) {
			return MONTH.DECEMBER;
		}else {
			return MONTH.getName(m.getMonth() - 1);
		}
	}
	
	public static MONTH monthAfter(MONTH m) {
		if(m == MONTH.DECEMBER) {
			return MONTH.JANUARY;
		}else {
			return MONTH.getName(m.getMonth() + 1);
		}
	}
}
