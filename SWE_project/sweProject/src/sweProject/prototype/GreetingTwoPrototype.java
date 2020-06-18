package sweProject.prototype;

public class GreetingTwoPrototype extends Prototype{
	
	private String greetingOne = "";
	
	@Override
	public Prototype clone() {
		GreetingTwoPrototype tmp = new GreetingTwoPrototype();
		tmp.greeting = super.greeting + "!!! This is prototype 2.";
		return tmp;
	}

}