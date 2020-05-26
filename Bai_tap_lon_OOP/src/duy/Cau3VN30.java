package duy;

import java.util.Date;

import Input.InputData;

public abstract class Cau3VN30 extends Cau3 {
	protected static final double BIEN_DO_DAO_DONG = 0.07d;

	public Cau3VN30(Date date) {
		setInfo(date);
	}
	
	@Override
	public void setInfo(Date date) {
		setList(InputData.getTodayVN30(date));
		super.setTag();
		name = "VN30";
	}

	@Override
	protected abstract boolean testPrice(double giaMoCua, double giaDongCua);
	
	@Override
	public void setTag() {
		this.listTag.add("HOSE");
		this.listTag.add("VN-INDEX");
		this.listTag.add("Hồ Chí Minh");
	}

}
