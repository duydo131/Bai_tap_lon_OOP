package duy;

import java.util.Date;

public class Cau3TangVN30 extends Cau3VN30{

	public Cau3TangVN30(Date date) {
		super(date);
		status = "tăng";
	}

	@Override
	protected boolean testPrice(double giaMoCua, double giaDongCua) {
		return giaMoCua*(1 + BIEN_DO_DAO_DONG) <= giaDongCua;
	}

}
