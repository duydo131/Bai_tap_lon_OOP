package Input;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class test3 {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(InputData.getInfo(formats.parse("20/2/2020"), formats.parse("22/2/2020")));
	}
}
