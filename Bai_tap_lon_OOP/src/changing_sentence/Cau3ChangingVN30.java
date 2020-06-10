package changing_sentence;

import java.util.Date;

import input.InputData;

public abstract class Cau3ChangingVN30 extends Cau3Changing {
	protected static final double BIEN_DO_DAO_DONG = 0.07d;

	public Cau3ChangingVN30(Date date) {
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
		this.listTag.add("VNINDEX");
		this.listTag.add("Hồ Chí Minh");
	}

}
