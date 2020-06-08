package changing_sentence;

import java.util.Date;

import Input.InputData;

public abstract class Cau3HNX30 extends Cau3 {
	
	protected static final double BIEN_DO_DAO_DONG = 0.1d;
	
	public Cau3HNX30(Date date) {
		setInfo(date);
	}

	@Override
	public void setInfo(Date date) {
		setList(InputData.getTodayHNX30(date));
		super.setTag();
		name = "HNX30";
	}

	@Override
	protected abstract boolean testPrice(double giaMoCua, double giaDongCua);
	
	@Override
	public void setTag() {
		this.listTag.add("HASTC");
		this.listTag.add("HNXINDEX");
		this.listTag.add("Hà Nội");
	}
}
