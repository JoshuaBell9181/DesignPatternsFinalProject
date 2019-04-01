package sweProject;

public class UI {

	
	public void newDocument(String type, String fileName) {
		DocumentFactory documentFactory = new DocumentFactory();
		documentFactory.createDocument(type, fileName);
	};
	
	public void openDocument(Document document) {
		Command command = new OpenDocumentCommand(document);
		command.execute();
	}
	
}
