package sweProject.facade;

public class Facade {

	private SaveAccordingly  saveAccordingly = new SaveAccordingly();
	private Converter converter = new Converter();
	
	public void autoSave(String fileName, String content){
		saveAccordingly.autoSave(fileName, content);
	}
	
	public void export(String fileName) {
		converter.convert(fileName);
	}
	
}
