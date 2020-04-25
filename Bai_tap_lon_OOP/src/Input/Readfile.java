package Input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Readfile {
	public static void loadData() {
		File folder = new File("D:\\20192\\OOP\\BaiTapLon\\data");
		
		File[] filename = folder.listFiles();

		String name;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		double giaMoCua;
		double giaMax;
		double giaMin;
		double giaDongCua;
		long KL;

		for (File file : filename) {
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				
				int i = 0;
				
				String line = "";
				reader.readLine();
				line = reader.readLine();
				while ((line = reader.readLine()) != null && i <10) {
					
					i++;
					
					Object arr[] = line.split(",");

					name = (String) arr[0];

					String ngay = (String) arr[1];
					String create = ngay.substring(6, 8) + "/" + ngay.substring(4, 6) + "/" + ngay.substring(0, 4);
					date = format.parse(create);

					giaMoCua = Double.parseDouble((String) arr[2]);

					giaMax = Double.parseDouble((String) arr[3]);

					giaMin = Double.parseDouble((String) arr[4]);

					giaDongCua = Double.parseDouble((String) arr[5]);

					KL = Long.parseLong((String) arr[6]);

					data.add(name, new DataNgay(date, giaMoCua, giaMax, giaMin, giaDongCua, KL));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
