package Sentences;

import Input.STOCK;
import Input.DataOneDay;
import Input.InputData;
import java.util.ArrayList;
import java.util.Date;

public class ComparisionExchanges extends Comparision {
	private Date date;
	private STOCK Stock1;
	private STOCK Stock2;

	public ComparisionExchanges(Date date) {
		this.date = date;
	}

	private STOCK DataStock(int numberrical) {
		STOCK Stock;
		Stock = Input.InputData.getStockByNumericalVN30(date, numberrical);
		return Stock;
	}

	private STOCK getStock1() {
		Stock1 = DataStock(1);
		return Stock1;
	}

	private STOCK getStock2() {
		Stock2 = DataStock(2);
		return Stock2;
	}

	private DataOneDay DataDay(STOCK stock) {
		ArrayList<DataOneDay> data = InputData.getDataOneWeekOneStock(stock, date);
		return data.get(0);
	}

	private double GiaMaxStock(STOCK stock) {
		return DataDay(stock).getGiaMax();
	}

	private String Connect() {
		String a;
		if (GiaMaxStock(getStock1()) - GiaMaxStock(Stock2) > 50)
			a = "bỏ xa ";
		else
			a = "cao hơn ";
		return a;
	}

	public String getStatus() {
		if (GiaMaxStock(getStock1()) < GiaMaxStock(getStock2()))
			status = getStock2() + " có lúc đã đạt đỉnh sàn với " + GiaMaxStock(getStock2())
					+ " VNĐ/Điểm Nhưng nhanh chóng hạ nhiệt về mức " + DataDay(getStock2()).getGiaDongCua()
					+ ", vẫn kém " + getStock1() + " "
					+ (DataDay(getStock1()).getGiaDongCua() - DataDay(getStock2()).getGiaDongCua()) + " VNĐ. ";
		else
			status = getStock1() + " vẫn đứng đầu trên bảng trên bảng, lúc đạt đỉnh  " + Connect() + getStock2() + " "
					+ (long)((GiaMaxStock(getStock1()) - GiaMaxStock(getStock2())) * 1000) + " VNĐ. ";
		return status;
	}

}
