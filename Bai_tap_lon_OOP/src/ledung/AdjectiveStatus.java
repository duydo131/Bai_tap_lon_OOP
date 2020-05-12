package Sentence;

public class AdjectiveStatus {
	
	private static String[] fastIncrease = {" tăng biến động ", " tăng bùng nổ ", "tăng đột biến", " tăng bứt phá ", " tăng ấn tượng ", 
							 		 		" tăng bật ", " tăng mạnh ", " tăng giá mạnh "};
	private static String[] slowIncrease = {" tăng nhẹ ", " nhích thêm ", " nhích nhẹ ", " tăng giá nhẹ "};
	private static String[] fastDecrease = {" giảm mạnh ", " tụt dốc ", " giảm sâu ", " giảm giá mạnh "};
	private static String[] slowDecrease = {" giảm nhẹ ", " mất giá nhẹ ", " giảm khá nhẹ nhàng "};
	private static String[] manyIncrease = {" đồng loạt tăng ", " tràn ngập trong sắc xanh ", " đồng loạt bứt phá "};
	private static String[] fewIncrease = {" ghi nhận sắc xanh chiếm ưu thế hơn ", " chứng kiến sắc xanh chiếm ưu thế "};
	private static String[] manyDecrease = {" ngập chìm trong sắc đỏ ", " đồng loạt giảm điểm ", " đồng loạt tụt dốc "};
	private static String[] fewDecrease = {" chứng kiến sắc đỏ chiếm ưu thế hơn ", " ghi nhận sắc đỏ chiếm ưu thế "};
	private static String[] lessChanging = {" chứng kiến diễn biến giằng co "};
	
	public static String[] getLessChanging() {
		return lessChanging;
	}
	public static String[] getManyDecrease() {
		return manyDecrease;
	}
	public static String[] getFewDecrease() {
		return fewDecrease;
	}
	public static String[] getFastIncrease() {
		return fastIncrease;
	}
	public static String[] getSlowIncrease() {
		return slowIncrease;
	}
	public static String[] getManyIncrease() {
		return manyIncrease;
	}
	public static String[] getFewIncrease() {
		return fewIncrease;
	}
	public static String[] getFastDecrease() {
		return fastDecrease;
	}
	public static String[] getSlowDecrease() {
		return slowDecrease;
	}
}
