package duy;

import java.util.Date;

public class VolumeHNX30 extends Volume{
	public VolumeHNX30(Date date) {
		cau1 = new Cau1HNX30(date);
		cau2 = new Cau2HNX30(date);
	}
}
