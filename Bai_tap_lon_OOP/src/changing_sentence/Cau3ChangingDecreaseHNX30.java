package changing_sentence;

import java.util.ArrayList;
import java.util.Date;

public class Cau3ChangingDecreaseHNX30 extends Cau3ChangingHNX30{

	public Cau3ChangingDecreaseHNX30(Date date) {
		super(date);
		status = "giảm";
		this.setTag();
	}

	@Override
	protected boolean testPrice(double giaMoCua, double giaDongCua) {
		return giaDongCua <= giaMoCua*(1 - BIEN_DO_DAO_DONG) ;
	}

	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}
	
	@Override
	public void setTag() {
		super.setTag();
		this.listTag.add("giảm trần");
	}
}
