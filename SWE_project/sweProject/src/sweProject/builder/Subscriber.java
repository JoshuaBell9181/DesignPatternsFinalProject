package sweProject.builder;

public class Subscriber extends User{


	String name;
	String email;
	boolean subscriber;
	
	public Subscriber(String name, String email) {
		super(name, email);
	}

	@Override
	public User buildPart(boolean subscriber) {
		this.subscriber = subscriber;
		super.subscriber = subscriber;
		this.name = super.name;
		this.email = super.email;
		return this;
	}


	
}