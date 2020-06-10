package stock_code_analization;

import java.text.SimpleDateFormat;
import java.util.Date;

import input.DataOneDay;
import input.STOCK;
import input.Tool;

public abstract class AnalizationOneStock2 extends AnalizationOneStockRoot{
	protected SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
	protected long sumVolume;
	protected int numberOfDays;
	protected long averageVolumeBefore;
	protected String name;
	
	protected AnalizationOneStock2(STOCK stock, Date date) {
		this.stock = stock;
	}
	
	@Override
	public void setTag() {
		super.setTag();
	}
	
	@Override
	public String get() {
		DataOneDay dayPriceMax = this.dataOneStock.get(0);
		DataOneDay dayPriceMin = this.dataOneStock.get(1);
		DataOneDay dayVolumeeMax = this.dataOneStock.get(2);
		DataOneDay dayVolumeMin = this.dataOneStock.get(3);
		long averageVolume = (long)this.sumVolume/this.numberOfDays;
		String str = this.name + " vừa qua, xét về giá trị, cổ phiếu " + stock.name()
				+ " có giá chốt phiên lớn nhất ngày " + formats.format(dayPriceMax.getDate()) 
				+ " với giá trị cổ phiếu là " + Tool.formatMoney(dayPriceMax.getGiaDongCua()) 
				+ " đồng, bên cạnh đó " + stock.name()
				+ " cũng ghi nhận giá đóng phiên thấp nhất là " + Tool.formatMoney(dayPriceMin.getGiaDongCua()) 
				+ " đồng vào ngày " + formats.format(dayPriceMin.getDate())
				+ ". Nếu xét về khối lượng giao dịch, ngày " + formats.format(dayVolumeeMax.getDate())
				+ " giao dịch cao nhất " + Tool.formatLong(dayVolumeeMax.getKL())
				+ " cổ phiếu và ngày " + formats.format(dayVolumeMin.getDate())
				+ " giao dịch thấp nhất " + Tool.formatLong(dayVolumeMin.getKL())
				+ " cổ phiếu. Tính cả " + this.name
				+ " tổng khối lượng giao dịch của " + stock.name()
				+ " là " + Tool.formatLong(this.sumVolume)
				+ " cổ phiếu trung bình " + Tool.formatLong(averageVolume) 
				+ " cổ phiếu " + (averageVolume > this.averageVolumeBefore ? "tăng" : "giảm")
				+ " so với tuần trước";
		return str;
	}
}
