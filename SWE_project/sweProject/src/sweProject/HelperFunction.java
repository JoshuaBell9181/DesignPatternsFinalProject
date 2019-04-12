package sweProject;


import javax.swing.JOptionPane;

import sweProject.command.Command;
import sweProject.command.OpenDocumentCommand;
import sweProject.decorator.Document;
import sweProject.factorymethod.DocumentFactory;
import sweProject.prototype.GreetingOnePrototype;
import sweProject.prototype.GreetingTwoPrototype;
import sweProject.prototype.Prototype;

public class HelperFunction {

	
	public void newDocument(String type, String fileName) {
		DocumentFactory documentFactory = new DocumentFactory();
		documentFactory.createDocument(type, fileName);
	};
	
	public void openDocument(Document document) {
		Command command = new OpenDocumentCommand(document);
		command.execute();
	}
	
	public String greeting(boolean showPrototypeOne) {
		
		if(showPrototypeOne) {
			GreetingOnePrototype prototype = new GreetingOnePrototype();
			Prototype test = prototype.clone();
			return test.getGreeting();
		} else {
			GreetingTwoPrototype prototype = new GreetingTwoPrototype();
			Prototype test = prototype.clone();
			return test.getGreeting();
		}
	}
}
