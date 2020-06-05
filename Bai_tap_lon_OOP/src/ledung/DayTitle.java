package ledung;

import java.util.ArrayList;
import java.util.Date;

import Input.InputData;

public class DayTitle extends Title{
	
	private Date date;
	private String[] subject = {"VN30", "HNX30 "};
	private String[] verb = {"", ""};
	private String adverb;
	private String linkWord;
	
	public DayTitle(Date date) {
		super();
		super.setTag();
		this.date = date;
		this.adverb = "Thị trường chứng khoán ngày " + formats.format(date) + ": ";
	}
	
	public void setVerb() {
		
		OverAllDayStockClass VN30data= new OverAllDayStockClass(date, "VN30");
		OverAllDayStockClass HNX30data= new OverAllDayStockClass(date, "HNX30");
		int VN30counter = VN30data.increaseCounter("VN30");
		int HNX30counter = HNX30data.increaseCounter("HNX30");

		if (VN30counter >= 22) {
			this.verb[0] = InputData.getRandom(Verb.getManyIncrease());
		}
		else if(VN30counter < 8) {
			this.verb[0] = InputData.getRandom(Verb.getManyDecrease());
		}
		else if(VN30counter >= 18 && VN30counter < 22) {
			this.verb[0] = InputData.getRandom(Verb.getFewIncrease());
		}
		else if(VN30counter < 12 && VN30counter >= 8) {
			this.verb[0] = InputData.getRandom(Verb.getFewDecrease());
		} 
		else {
			this.verb[0] = InputData.getRandom(Verb.getLessChanging());
		}
		
		if (HNX30counter >= 22) {
			this.verb[1] = InputData.getRandom(Verb.getManyIncrease());
		}
		else if(HNX30counter < 8) {
			this.verb[1] = InputData.getRandom(Verb.getManyDecrease());
		}
		else if(HNX30counter >= 18 && HNX30counter < 22) {
			this.verb[1] = InputData.getRandom(Verb.getFewIncrease());
		}
		else if(HNX30counter < 12 && HNX30counter >= 8) {
			this.verb[1] = InputData.getRandom(Verb.getFewDecrease());
		} 
		else {
			this.verb[1] = InputData.getRandom(Verb.getLessChanging());
		}
	}
	
	public void setLinkWord() {
		
		OverAllDayStockClass dataVN30 = new OverAllDayStockClass(date, "VN30");
		OverAllDayStockClass dataHNX30 = new OverAllDayStockClass(date, "VN30");
		int counterVN30 = dataVN30.increaseCounter(dataVN30.getStockClass());
		int counterHNX30 = dataHNX30.increaseCounter(dataHNX30.getStockClass());
		
		if( counterVN30 >= 18 && counterHNX30 >= 18 ||
			counterVN30 <= 12 && counterHNX30 <= 12 ||
			counterVN30 >= 8 && counterVN30 < 12 && counterHNX30 >= 8 && counterHNX30 < 12 ) {
			this.linkWord = InputData.getRandom(LinkWord.getProgressiveLinkWord());
		}
		if( counterVN30 >= 18 && counterHNX30 < 12 ||
			counterVN30 < 12 && counterHNX30 >= 18 ||
			(counterVN30 < 18 || counterVN30 >= 12) && (counterHNX30 >= 18 || counterHNX30 < 12) ||
			(counterHNX30 < 18 || counterHNX30 >= 12) && (counterVN30 >= 18 || counterVN30 < 12)) {
			this.linkWord = InputData.getRandom(LinkWord.getOpposingLinkWord());
		}
	}
	
//	public void printSentence() {
//		this.setLinkWord();
//		this.setVerb();
//		System.out.println(adverb + subject[0] + verb[0] + ", " + subject[1] + linkWord + verb[1]);
//	}

	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}

	@Override
	public String get() {
		this.setLinkWord();
		this.setVerb();
		return adverb + subject[0] + verb[0] + ", " + subject[1] + linkWord + verb[1];
	}

	@Override
	public void setTag() {
		
	}
}
