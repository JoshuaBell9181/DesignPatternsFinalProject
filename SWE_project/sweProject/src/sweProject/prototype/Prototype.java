package sweProject.prototype;

public abstract class Prototype {

	String greeting = "Hello world";
	
	public abstract Prototype clone();
	
	public String getGreeting(){
		return greeting;
	}
	
	
}
