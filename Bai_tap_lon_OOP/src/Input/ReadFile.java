package Input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadFile {
	public static void loadData() {
		if(Data.getEmty()) {
			File folderVn30 = new File("./file/dataVn30");
			File folderHnx30 = new File("./file/datahnx30");
			
			File[] filename = null;

			STOCK stock;
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date date;
			double giaMoCua;
			double giaMax;
			double giaMin;
			double giaDongCua;
			long KL;

			int temp = 2;
			
			for(int i = 0; i < temp; i++) {
				if(i == 0) {
					filename = folderVn30.listFiles();
				}else {
					filename = folderHnx30.listFiles();
				}
				
				for (File file : filename) {
					try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
						String line ;
						while ((line = reader.readLine()) != null ) {
							Object arr[] = line.split(",");

							String name = (String)arr[0];
							if(name.equals("^VNINDEX")) {
								name = "VNINDEX";
							}else if(name.equals("^HASTC")) {
								name = "HASTC";
							}
							stock =STOCK.valueOf(name);

							String ngay = (String) arr[1];
							String create = ngay.substring(6, 8) + "/" + ngay.substring(4, 6) + "/" + ngay.substring(0, 4);
							date = format.parse(create);

							giaMoCua = Double.parseDouble((String) arr[2]);

							giaMax = Double.parseDouble((String) arr[3]);

							giaMin = Double.parseDouble((String) arr[4]);

							giaDongCua = Double.parseDouble((String) arr[5]);

							KL = Long.parseLong((String) arr[6]);

							EXCHANGES exchanges = i == 0 ? EXCHANGES.VN30 : EXCHANGES.HNX30;
							
							Data.add(stock, new DataOneDay(date, giaMoCua, giaMax, giaMin, giaDongCua, KL), exchanges);
							
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			Data.loaded();
		}
	}
}
