package Sentences;

import Input.InputData;
import Input.STOCK;
import Input.DataOneDay;
import java.util.ArrayList;
import java.util.Date;

public class ComparisionStockHot extends Comparision {
	public Date date;
	private STOCK stockVN30;
	private STOCK stockHNX30;
	private double giaDongCuaStockVN30;
	private double giaDongCuaStockHNX30;

	public ComparisionStockHot(Date date) {
		this.date = date;
	}

	private STOCK DataStockVN30(int numberrical) {
		STOCK Name;
		Name = InputData.getStockByNumericalVN30(date, numberrical);
		return Name;
	}

	private STOCK DataStockHNX30(int numberrical) {
		STOCK Name;
		Name = InputData.getStockByNumericalHNX30(date, numberrical);
		return Name;
	}

	private STOCK getStockVN30() {
		stockVN30 = DataStockVN30(1);
		return stockVN30;
	}

	private STOCK getStockHNX30() {
		stockHNX30 = DataStockHNX30(1);
		return stockHNX30;
	}

	private DataOneDay DataDay(STOCK stock) {
		ArrayList<DataOneDay> data = InputData.getDataOneWeekOneStock(stock, date);
		return data.get(0);
	}

	private double getGiaDongCuaStockVN30() {
		giaDongCuaStockVN30 = DataDay(getStockVN30()).getGiaDongCua();
		return giaDongCuaStockVN30;
	}

	private double getGiaDongCuaStockHNX30() {
		giaDongCuaStockHNX30 = DataDay(getStockHNX30()).getGiaDongCua();
		return giaDongCuaStockHNX30;
	}

	private String Connect() {
		String a;
		if (getGiaDongCuaStockHNX30() - getGiaDongCuaStockVN30() > 50)
			a = " bỏ xa ";
		else
			a = " nhỉnh hơn ";
		return a;
	}

	@Override
	public String getStatus() {
		if (getGiaDongCuaStockHNX30() > getGiaDongCuaStockVN30())

			status = "Đóng cửa phiên giao dịch, " + getStockHNX30() + " và " + getStockVN30()
					+ " vẫn đang lần lượt đứng đầu trong hai họ HNX30 và VN30, nhưng " + getStockHNX30() + Connect()
					+ getStockVN30() + " với giá bán ra "
					+ (int) ((getGiaDongCuaStockHNX30() - getGiaDongCuaStockVN30()) * 1000) + " VNĐ. ";
		else
			status = "Đóng cửa phiên giao dịch, " + getStockHNX30() + " và " + getStockVN30()
					+ " vẫn đang lần lượt đứng đầu trong hai họ HNX30 và VN30. Nhưng " + getStockVN30() + Connect()
					+ getStockHNX30() + " với giá bán ra "
					+ (int) ((getGiaDongCuaStockVN30() - getGiaDongCuaStockHNX30()) * 1000) + " VNĐ. ";
		return status;
	}

}
