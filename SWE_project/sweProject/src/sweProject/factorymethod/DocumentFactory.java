package sweProject.factorymethod;

public class DocumentFactory {
	
	public void createDocument(String type,String fileName){
		if(type.equalsIgnoreCase("text")) {
			TextDocument textDocument = new TextDocument();
			textDocument.createDocumentFactoryMethod(fileName);
		} 
	}
}
