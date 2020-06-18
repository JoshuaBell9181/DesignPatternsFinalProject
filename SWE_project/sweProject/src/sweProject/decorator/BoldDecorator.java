package sweProject.decorator;

public class BoldDecorator extends Decorator{

	
	Document document;
	String selectedText;
	
	public BoldDecorator(Document document, String selectedText) {
		 super(document, selectedText);
		 this.document = document;
		 this.selectedText = selectedText;
	}

	public void decorate() {
		document.setData(document.getData().replaceAll(selectedText, "<strong>" + selectedText + "</strong>"));
	}
	
}
