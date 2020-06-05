package Sentences;

import Input.STOCK;
import gui.Tag;
import Input.DataOneDay;
import Input.InputData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

<<<<<<< HEAD
public abstract class ComparisionEXCHANGES extends Comparision implements Tag{
=======
public abstract class ComparisionEXCHANGES extends Comparision implements Tag {
>>>>>>> 586f98c58434d2a835765c773c4d04b6fd59ecf0

	public ComparisionEXCHANGES() {
	}

	public ComparisionEXCHANGES(Date date) {
		this.date = date;
	}

	protected abstract STOCK DataStock(int numberrical);

	@Override
	public String get() {
		if (GiaMaxStock(getStock1()) < GiaMaxStock(getStock2()))
			status = getStock2() + " có lúc đã đạt đỉnh sàn với " + GiaMaxStock(getStock2())
					+ " VNĐ/Điểm Nhưng nhanh chóng hạ nhiệt về mức " + DataDay(getStock2()).getGiaDongCua()
					+ ", vẫn kém " + getStock1() + " "
					+ (int) ((DataDay(getStock2()).getGiaDongCua() - DataDay(getStock1()).getGiaDongCua()) * 1000)
					+ " VNĐ. ";
		else
			status = getStock1() + list() + ", lúc đạt đỉnh  " + Connect() + getStock2() + " "
					+ (long) ((GiaMaxStock(getStock1()) - GiaMaxStock(getStock2())) * 1000) + " VNĐ. ";
		return status;
	}

	@Override
	public void setTag() {
		this.listTag.add("Comparision");
		this.listTag.add("StockHot");
	}

	private String Connect() {
		String a;
		if (GiaMaxStock(getStock1()) - GiaMaxStock(stock2) > 50)
			a = "bỏ xa ";
		else
			a = "cao hơn ";
		return a;
	}

	private String list() {
		String[] list = { " vẫn đứng đầu trên bảng", " áp đảo đảo trên bảng xanh",
				" dường như không có đối thủ cạnh tranh" };
		Random a = new Random();
		int random = a.nextInt(3);
		return list[random];
	}

	private STOCK getStock1() {
		stock1 = DataStock(1);
		return stock1;
	}

	protected STOCK getStock2() {
		stock2 = DataStock(2);
		return stock2;
	}

	private DataOneDay DataDay(STOCK stock) {
		ArrayList<DataOneDay> data = InputData.getDataOneWeekOneStock(stock, date);
		return data.get(0);
	}

	private double GiaMaxStock(STOCK stock) {
		return DataDay(stock).getGiaMax();
	}

}
