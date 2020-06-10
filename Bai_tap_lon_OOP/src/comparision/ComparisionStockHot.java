package comparision;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import input.DataOneDay;
import input.InputData;
import input.STOCK;

public class ComparisionStockHot extends Comparision {
	private double giaDongCuaStockVN30;
	private double giaDongCuaStockHNX30;

	public ComparisionStockHot(Date date) {
		this.date = date;
	}

	@Override
	public String get() {
		if (getGiaDongCuaStockHNX30() > getGiaDongCuaStockVN30())

			status = list1() + getStockHNX30() + " và " + getStockVN30() + list2() + " HNX30 và VN30, nhưng "
					+ getStockHNX30() + Connect() + getStockVN30() + " với giá bán ra "
					+ (int) ((getGiaDongCuaStockHNX30() - getGiaDongCuaStockVN30()) * 1000) + " VNĐ. ";
		else
			status = list1() + getStockHNX30() + " và " + getStockVN30() + list2() + " HNX30 và VN30. Nhưng "
					+ getStockVN30() + Connect() + getStockHNX30() + " với giá bán ra "
					+ (int) ((getGiaDongCuaStockVN30() - getGiaDongCuaStockHNX30()) * 1000) + " VNĐ. ";
		return status;
	}

	@Override
	public void setTag() {
		this.listTag.add("general");
		this.listTag.add("comparision");
		this.listTag.add("stockHot");
		this.listTag.add("HNX30");
		this.listTag.add("VN30");
	}

	@Override
	public ArrayList<String> getTag() {
		setTag();
		return this.listTag;
	}

	private String Connect() {
		String a;
		if (getGiaDongCuaStockHNX30() - getGiaDongCuaStockVN30() > 50)
			a = " bỏ xa ";
		else
			a = " nhỉnh hơn ";
		return a;
	}

	private String list1() {
		String[] list = { "đóng cửa phiên giao dịch,", "hết ngày,", };
		Random a = new Random();
		int random = a.nextInt(2);
		return list[random];
	}

	private String list2() {
		String[] list = { " vẫn đang lần lượt đứng đầu trong hai họ", " áp đảo trên bảng xanh của hai họ", };
		Random a = new Random();
		int random = a.nextInt(2);
		return list[random];
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
		stock1 = DataStockVN30(1);
		return stock1;
	}

	private STOCK getStockHNX30() {
		stock2 = DataStockHNX30(1);
		return stock2;
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

}
