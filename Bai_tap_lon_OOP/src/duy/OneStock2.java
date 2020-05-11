package duy;

import java.text.SimpleDateFormat;
import java.util.Date;

import Input.DataOneDay;
import Input.Format;
import Input.STOCK;

public class OneStock2 extends OneStockRoot{
	protected SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
	protected long sumVolume;
	protected int numberOfDays;
	protected long averageVolumeBefore;
	protected String name;
	public OneStock2(STOCK stock, Date date) {
		this.stock = stock;
	}
	
	@Override
	public String get() {
		DataOneDay dayPriceMax = this.dataOneDay.get(0);
		DataOneDay dayPriceMin = this.dataOneDay.get(1);
		DataOneDay dayVolumeeMax = this.dataOneDay.get(2);
		DataOneDay dayVolumeMin = this.dataOneDay.get(3);
		long averageVolume = (long)this.sumVolume/this.numberOfDays;
		String str = this.name + " vừa qua, xét về giá trị, cổ phiếu " + stock.name()
				+ " có giá chốt phiên lớn nhất ngày " + formats.format(dayPriceMax.getDate()) 
				+ " với giá trị cổ phiếu là " + Format.formatMoney(dayPriceMax.getGiaDongCua()) 
				+ " đồng, bên cạnh đó " + stock.name()
				+ " cũng ghi nhận giá đóng phiên thấp nhất là " + Format.formatMoney(dayPriceMin.getGiaDongCua()) 
				+ " đồng vào ngày " + formats.format(dayPriceMin.getDate())
				+ ". Nếu xét về khối lượng giao dịch, ngày " + formats.format(dayVolumeeMax.getDate())
				+ " giao dịch cao nhất " + Format.formatLong(dayVolumeeMax.getKL())
				+ " cổ phiếu và ngày " + formats.format(dayVolumeMin.getDate())
				+ " giao dịch thấp nhất " + Format.formatLong(dayVolumeMin.getKL())
				+ " cổ phiếu. Tính cả " + this.name
				+ " tổng khối lượng giao dịch của " + stock.name()
				+ " là " + Format.formatLong(this.sumVolume)
				+ " cổ phiếu trung bình " + Format.formatLong(averageVolume) 
				+ " cổ phiếu " + (averageVolume > this.averageVolumeBefore ? "tăng" : "giảm")
				+ " so với tuần trước";
		return str;
	}
}
