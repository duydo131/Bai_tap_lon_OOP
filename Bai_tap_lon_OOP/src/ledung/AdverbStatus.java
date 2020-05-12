package Sentence;

public class AdverbStatus {

	private static String[] incThenDec = {"Quay đầu giảm giá ", "Quay đầu đảo chiều ", "Đánh mất đà tăng điểm "};
	private static String[] decThenInc = {"Có tín hiệu phục hồi ", "Tăng bật trở lại ", "Ngược dòng thành công ", "Quay đầu đảo chiều ",
								   		  "Quay đầu tăng giá ", "Bắt đầu giao dịch khởi sắc trở lại ", "Lấy lại sắc xanh "};
	private static String[] incThenInc = {"Tiếp nối đà đi lên ", "Thừa thắng xông lên ", "Tiếp nối chuỗi phiên tăng điểm "};
	private static String[] decThenDec = {"Tiếp tục tụt dốc ", "Tiếp tục đi xuống ", "Nối tiếp chuỗi phiên giảm điểm "};

	public static String[] getIncThenDec() {
		return incThenDec;
	}
	public static String[] getDecThenInc() {
		return decThenInc;
	}
	public static String[] getIncThenInc() {
		return incThenInc;
	}
	public static String[] getDecThenDec() {
		return decThenDec;
	}
	
}
