package sweProject.mediator;

import java.util.Date;

import javax.swing.JOptionPane;

import sweProject.builder.User;

public class ChatRoomMediator {
	
	 public static String showMessage(User user, String message){
		  //JOptionPane.showInputDialog(new Date().toString() + " [" + user.getName() + "] : " + message, null);
	      return new Date().toString() + " [" + user.getName() + "] : " + message;
	   }
	 
}
