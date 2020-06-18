package sweProject.facade;

import java.io.File;
import java.io.IOException;

public class Converter {

	
	void convert(String fileName){
		if(fileName.contains(".txt")) {
			fileName = fileName.substring(0, fileName.length() - 4);
			File file = new File(fileName + ".html");
			
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
			fileName = fileName.substring(0, fileName.length() - 5);
			File file = new File(fileName + ".text");
			
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
