package sweProject.decorator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Document {
	private String Path;
	private String data;
	
	public String getPath(){
		return Path;
	}
	
	public void setPath(String path) {
		File temp = new File(path);
		Path = temp.getAbsolutePath(); 
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	
	public void open() {
		
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
