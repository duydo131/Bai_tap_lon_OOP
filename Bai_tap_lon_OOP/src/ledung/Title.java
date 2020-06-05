package ledung;

import java.text.SimpleDateFormat;

public abstract class Title extends Sentence{
	
	protected SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public void setTag() {
		listTag.add("title");
	}

}
