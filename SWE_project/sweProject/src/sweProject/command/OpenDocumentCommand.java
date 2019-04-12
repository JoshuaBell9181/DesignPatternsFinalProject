package sweProject.command;

import sweProject.decorator.Document;

public class OpenDocumentCommand implements Command {

	private Document document;
	
	@Override
	public void execute() {
		
	}
	
	public OpenDocumentCommand(Document document){
		this.document = document;
		document.open();
	}
	
}
