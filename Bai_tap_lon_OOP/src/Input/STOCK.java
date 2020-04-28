package Input;

public enum STOCK {
	
	//		VN30
	
	VNINDEX("Chỉ số VN-index",-1),
	
	BID("Ngân hàng cổ phần đầu tư và phát triển Viêt Nam", 4022018),
	BVH("tập đoàn bảo việt", 742322),
	CTD("Công ty cổ phần xây dựng Coteccons", 77184),
	CTG("Ngân hàng Thương mại Cổ phần Công thương Việt Nam", 3723404),
	EIB("Ngân hàng Thương mại Cổ phần Xuất nhập khẩu Việt Nam", 1229432),
	FPT("CÔng ty Cổ phần FPT", 682208),
	GAS("Tổng Công ty Khí Việt Nam - CTCP", 1913950),
	HDB("Ngân hàng Thương mại cổ phần Phát triển Thành Phố Hồ Chí Minh", 965921),
	HPG("Công ty cổ phân Tập đoàn Hòa Phát", 2761074),
	MBB("Ngân hầng thương mại Cổ phần quân dội", 2411426),
	MSN("Công ty Cổ phần Tập đoàn Masan", 1168946),
	MWG("Công ty Cổ phần đầu tư thế giới đi động", 452861),
	NVL("Công ty cổ phần Tập đoàn Đầu tư địa ốc Nova", 969540),
	PLX("Tập đoàn xăng dầu Việt Nam", 1170813),
	PNJ("Công ty Cổ phần Vàng bạc đá quý  Phú Nhuận", 225188),
	POW("Tổng Công ty Điện lực Dầu khí Việt Nam - Công ty cổ phần", 2341871),
	REE("Cồng ty Cổ phần cơ điện lạnh", 310050),
	ROS("Công ty Cổ phần xây dựng FLC Faros", 567598),
	SAB("Tổng Công ty cổ phần Bia - Rượu - Nước giải khát Sài Gòn", 641281),
	SBT("Công ty Cổ phần Thành Thành Công Biên Hòa", 225188),
	SSI("Công ty Cổ phần chứng khoán SSi", 683825),
	STB("Ngân hàng Thương mại Cổ phần Thương Tín", 1803653),
	TCB("Ngân hàng Thương mại Cổ phần Kỹ Thương Việt Nam", 3570389),
	VCB("Ngân hàng thương mại Cổ phần Ngoại thương Việt Nam", 3708877),
	VHM("Công ty Cổ phần Vinhomes", 3289513),
	VIC("Tập đoàn VINGROUP - CTCP", 3382430),
	VJC("Công ty Cổ phần hàng không VIETJET", 523838),
	VNM("Công ty Cổ phần sữa Việt Nam", 1741377),
	VPB("Ngân hàng Thương mại Cổ phần Việt Nam thịnh vượng", 2437748),
	VRE("Công ty Cổ phần Vincom Retail", 2272318),
	
	
	//		HNX30
	
	HASTC("Chỉ số HNX-index",-1),
	
	ACB("Công ty Thương Mại Cổ phần Á Châu", 1662737),
	BVS("Công ty Cổ phần chứng khoán BẢo Việt", 72218),
	CAP("Công ty Cổ phần Lâm nông sản thực phâm Yên Bái", 5236),
	CEO("Công ty Cổ phần Tập đoàn C.E.O", 257339),
	DDG("Công ty Cổ phần Đầu tư Công nghiệp Xuất nhập khẩu Đông Dương", 12000),
	DGC("Công ty Cổ phần Tập đoan Hóa chất Đức Giang", 129362),
	DHT("Công ty Cổ phần Dược phẩm Hà Tây", 21125),
	DTD("Công ty Cổ phần Đầu tư phát triển Thành Đạt", 24580),
	HUT("Công ty Cổ phần TASCO", 268631),
	KLF("Công ty Cổ phần Đầu tư Thương mại và Xuất nhập khẩu CFS", 165352),
	L14("Công ty Cổ phần Licogi 14", 18481),
	MBS("Công ty Cổ phần chứng khoán MB", 164322),
	NDN("Công ty phất triển nhà Đà Nẵng", 47932),
	NRC("Công ty Cổ phần Bất động sản NETLAND",27599),
	PVB("Công ty Cổ phần Bọc Ống Dầu khí Việt Nam", 21599),
	PVC("Tổng Công ty Hóa chất và Dịch vụ Dầu khí - CTCP (PVChem)", 47500),
	PVI("Công ty Cổ phần PVI", 231108),
	PVS("Tổng Công ty Cổ phần Dịch vụ Kỹ thuật Đầu khí Việt Nam", 477966),
	SHB("Ngân hàng Thương mại Cổ phần Sài Gòn - Hà Nội", 1755351),
	SHS("Công ty Cổ phần Chứng khoán Sài Gòn Hà Nội", 207268),
	SLS("Công ty Cổ phần Mía Đường Sơn la", 9791),
	TNG("Công ty Cổ phần Đầu tư và Thương mai TNG", 65211),
	TVC("Công ty Cổ phần Tập đoàn Quản lý Tài sản Trí Việt", 40016),
	VC3("Công ty Cổ phần xây dựng sô 3", 61015642),
	VCG("Tổng Công ty Cổ phần Xuất nhập khẩu và xây dựng Việt Nam", 441710),
	VGS("CÔng ty Cổ phần ống thép Việt Đức", 42111),
	VCS("Công ty Cổ phần VICOSTONE", 160000),
	VMC("Công ty Cổ phần VIMECO", 10000),
	
	
	;
	
	private String name;
	private long outstandingShares; 	//  x1000 cổ phiếu
	
	
	STOCK(String name, long outstandingShares) {
		this.name = name;
		this.outstandingShares = outstandingShares;
	}
	
	public String getName() {
		return name;
	}
	public long getOutstandingShares() {
		return outstandingShares;
	}
}
