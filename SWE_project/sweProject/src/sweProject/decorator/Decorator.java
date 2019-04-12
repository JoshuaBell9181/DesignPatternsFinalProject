package sweProject.decorator;

public abstract class Decorator extends Document{

	Document document;
	
	public Decorator(Document document,String selectedText) {
		this.document = document;
	}

	public abstract void decorate();
	
	
}
