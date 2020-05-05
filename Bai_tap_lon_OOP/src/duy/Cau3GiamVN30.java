package duy;

import java.util.Date;

public class Cau3GiamVN30 extends Cau3VN30{

	public Cau3GiamVN30(Date date) {
		super(date);
		status = "giảm";
	}

	@Override
	protected boolean testPrice(double giaMoCua, double giaDongCua) {
		return giaDongCua <= giaMoCua*(1-BIEN_DO_DAO_DONG);
	}

}
