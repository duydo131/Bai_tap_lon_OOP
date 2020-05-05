package duy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import GUI.DataLoad;
import Input.Format;
import Input.ReadFile;
import Input.STOCK;

public class test {
	public static void main(String[] args) throws ParseException {
		ReadFile.loadData();
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formats.parse("24/01/2020");
		Date date1 = Format.getDate(date, -20);
		
		
		
//		System.out.println((new Phien()).setInfo(date1, STOCK.VNINDEX).get());
//		System.out.println((new Phien()).setInfo(date1, STOCK.HASTC).get());
//		System.out.println();
//		// ngày phải là cuối tuần
//		System.out.println((new Week()).setInfo(date, STOCK.VNINDEX).get());
//		System.out.println((new Week()).setInfo(date, STOCK.HASTC).get());
//		
//		System.out.println();
//		
//		
//		System.out.println((new VolumeVN30(date1)).get());
//		System.out.println();
//		System.out.println((new VolumeHNX30(date1)).get());
//		
//		System.out.println();
//		System.out.println((new Cau3TangVN30(date1)).get());
//		System.out.println((new Cau3TangHNX30(date1)).get());
//		System.out.println((new Cau3GiamVN30(date1)).get());
//		System.out.println((new Cau3GiamHNX30(date1)).get());
//		
//		System.out.println();
//		System.out.println((new Cau4VN30(date1)).get());
//		System.out.println((new Cau4HNX30(date1)).get());
		

		
		DataLoad dataLoad = new DataLoad(date1);
		System.out.println(dataLoad.get());
		
	
		
	}
}
