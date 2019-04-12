package sweProject.proxy;

import javax.swing.JOptionPane;

public class RealImage implements Image{
	   private String fileName;
	   boolean alreadyPresent = false;
	   int count = 0;

	   public RealImage(String fileName){
	      this.fileName = fileName;
	      loadFromDisk(fileName);
	   }

	   @Override
	   public void display() {
		   if(!alreadyPresent ) {
			   JOptionPane.showInputDialog("Display "+ count + fileName , null);
		   } else {
			   count++;
			   JOptionPane.showInputDialog("Display "+ count + fileName , null);
		   }
	   }

	   private void loadFromDisk(String fileName){
		   JOptionPane.showInputDialog("Loading " + fileName + " for the first time", null);
		   alreadyPresent = true;
	   }
}
