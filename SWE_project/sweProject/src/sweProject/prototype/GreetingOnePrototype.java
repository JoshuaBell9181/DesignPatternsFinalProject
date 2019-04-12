package sweProject.prototype;

public class GreetingOnePrototype extends Prototype{
	
	private String greetingOne = "";
	
	@Override
	public Prototype clone() {
		GreetingOnePrototype tmp = new GreetingOnePrototype();
		tmp.greeting = super.greeting + "!!! This is prototype 1.";
		return tmp;
	}

}
