package Sentence;

public class AdjectiveStatus {
	
	private static String[] fastIncrease = {" tăng biến động ", " tăng bùng nổ ", "tăng đột biến", " tăng bứt phá ", " tăng ấn tượng ", 
							 		 		" tăng bật ", " tăng mạnh ", " tăng giá mạnh "};
	private static String[] slowIncrease = {" tăng nhẹ ", " nhích thêm ", " nhích nhẹ ", " tăng giá nhẹ "};
	private static String[] fastDecrease = {" giảm mạnh ", " tụt dốc ", " giảm sâu ", " giảm giá mạnh "};
	private static String[] slowDecrease = {" giảm nhẹ ", " mất giá nhẹ ", " giảm khá nhẹ nhàng "};
	
	public static String[] getFastIncrease() {
		return fastIncrease;
	}
	public static String[] getSlowIncrease() {
		return slowIncrease;
	}
	public static String[] getFastDecrease() {
		return fastDecrease;
	}
	public static String[] getSlowDecrease() {
		return slowDecrease;
	}
}
