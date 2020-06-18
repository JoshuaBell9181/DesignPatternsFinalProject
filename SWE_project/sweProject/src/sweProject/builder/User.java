package sweProject.builder;

import sweProject.mediator.ChatRoomMediator;

public abstract class User implements Builder{

	String name;
	String email;
	boolean subscriber;
	
	User(String name, String email){
		this.name = name;
		this.email = email;
	}
	
	@Override
	abstract public User buildPart(boolean subscriber);
	
	public String getName() {
		return name;
	}

	public String sendMessage(String message){
	      return ChatRoomMediator.showMessage(this,message);
	}
}
