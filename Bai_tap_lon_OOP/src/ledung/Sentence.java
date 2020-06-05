package ledung;

public class Sentence {
	
	protected String subject;
	protected String complement;
	protected String verb;
	
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
