package sweProject.facade;

import java.io.File;
import java.io.IOException;

public class SaveAccordingly {

	
	void autoSave(String fileName,String content){
		Determine determine = new DetermineType();
		
		if(determine.determineFormat(content).equalsIgnoreCase("TEXT")) {
			File file = new File("./" + fileName + ".txt");
			
			try {
				if(file.createNewFile()){
					System.out.println("File: " + fileName + " was created.");
				} else {
					System.out.println("File already exists.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			File file = new File("./" + fileName + ".html");
			
			try {
				if(file.createNewFile()){
					System.out.println("File: " + fileName + " was created.");
				} else {
					System.out.println("File already exists.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
}