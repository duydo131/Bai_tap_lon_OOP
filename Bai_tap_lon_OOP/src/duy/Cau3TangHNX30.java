package duy;

import java.util.ArrayList;
import java.util.Date;

public class Cau3TangHNX30 extends Cau3HNX30 {

	public Cau3TangHNX30(Date date) {
		super(date);
		status = "tăng";
		this.setTag();
	}

	@Override
	protected boolean testPrice(double giaMoCua, double giaDongCua) {
		return giaMoCua*(1 + BIEN_DO_DAO_DONG) <= giaDongCua;
	}

	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}
	
	@Override
	public void setTag() {
		super.setTag();
		this.listTag.add("tăng trần");
	}
}
