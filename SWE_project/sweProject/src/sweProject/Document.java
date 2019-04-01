package sweProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Document {
	private String Path;
	private String data;
	
	String getPath(){
		return Path;
	}
	
	void setPath(String path) {
		File temp = new File(path);
		Path = temp.getAbsolutePath(); 
	}
	
	String getData() {
		return data;
	}
	
	
	void open() {
		
		data = "";
		try {
			File file = new File(Path);
			Scanner myReader = new Scanner(file);
			while(myReader.hasNextLine()) {
				data = data + myReader.nextLine() + "\n";
			}
			myReader.close();
		}catch(FileNotFoundException e){
			System.out.println("There was an error");
		}
		
	}
	
	
}
