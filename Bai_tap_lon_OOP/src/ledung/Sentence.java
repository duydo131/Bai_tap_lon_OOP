package ledung;

import java.util.ArrayList;

import gui.Tag;

public abstract class Sentence implements Tag {
	
	protected String subject;
	protected String complement;
	protected String verb;
	protected ArrayList<String> listTag = new ArrayList<>();
	
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}
	
	public void setVerb(String verb) {
		this.verb = verb;
	}
	
	public void printSentence() {
		System.out.println(subject + verb + complement);
	}
}
