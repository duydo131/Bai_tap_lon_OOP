package TestInput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class StopWord {
	private ArrayList<String> stopWord = new ArrayList<>();
	
	private StopWord() {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("file/vietnamese-stopwords.txt"))){
			String line ;
			while((line = bufferedReader.readLine()) != null) {
				stopWord.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> getStopWord(){
		return SingletonStopWord.STOP_WORD.stopWord;
	}
	
	private static class SingletonStopWord{
		private static final StopWord STOP_WORD = new StopWord();
	}
}
