package ledung;

import Input.InputData;

public class Verb {
	
	private static String[] fastIncrease = {" tăng biến động"," tăng bùng nổ","tăng đột biến"," tăng bứt phá"," tăng ấn tượng", 
							 		 		" tăng bật"," tăng mạnh"," tăng giá mạnh"};
	private static String[] slowIncrease = {" tăng nhẹ"," nhích thêm"," nhích nhẹ"," tăng giá nhẹ"};
	private static String[] fastDecrease = {" giảm mạnh"," tụt dốc"," giảm sâu"," giảm giá mạnh"};
	private static String[] slowDecrease = {" giảm nhẹ"," mất giá nhẹ"," giảm khá nhẹ nhàng"};
	private static String[] manyIncrease = {" đồng loạt tăng", " tràn ngập trong sắc xanh", " đồng loạt bứt phá", "ngập tràn trong sắc xanh",
											" có một phiên giao dịch vô cùng khả quan"};
	private static String[] fewIncrease = { " ghi nhận sắc xanh chiếm ưu thế "," ghi nhận sắc xanh chiếm ưu thế", " ghi nhận một số tín hiệu tích cực",
											" ghi nhận một vài dấu hiệu tích cực", " ghi nhận diễn biến khá khả quan", " có những bước tiến thận trọng",
											" ghi nhận một vài cổ phiếu tăng điểm"};
	private static String[] manyDecrease = {" ngập chìm trong sắc đỏ"," đồng loạt giảm điểm"," đồng loạt tụt dốc"};
	private static String[] fewDecrease = {" chứng kiến sắc đỏ chiếm ưu thế "," chứng kiến sắc đỏ chiếm ưu thế"};
	private static String[] lessChanging = {" chứng kiến diễn biến giằng co"};
	
	public static String getVerb(String imple, String adj) {
		if (adj == "increase") {
			if (imple == "fast") {
				return InputData.getRandom(fastIncrease);
			}
			else if (imple == "slow") {
				return InputData.getRandom(slowIncrease);
			}
			else if (imple == "few") {
				return InputData.getRandom(fewIncrease);
			}
			else if (imple == "many") {
				return InputData.getRandom(manyIncrease);
			}
		}
		else if (adj == "decrease") {
			if (imple == "fast") {
				return InputData.getRandom(fastDecrease);
			}
			else if (imple == "slow") {
				return InputData.getRandom(slowDecrease);
			}
			else if (imple == "few") {
				return InputData.getRandom(fewDecrease);
			}
			else if (imple == "many") {
				return InputData.getRandom(manyDecrease);
			}
		}
		return null;
	}
	
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
