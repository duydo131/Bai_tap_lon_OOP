package JavaGUI;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class ParagraphFileWriter {
	
	public ParagraphFileWriter() {
		
	}
	
	public static void fileWriter() throws IOException 
	{
		String stnc = "abc";
	    BufferedWriter writer = new BufferedWriter(new FileWriter("Users/levietdung/Desktop/Paragraph.txt"));
	    writer.write(stnc);
	    writer.close();
	}
}
