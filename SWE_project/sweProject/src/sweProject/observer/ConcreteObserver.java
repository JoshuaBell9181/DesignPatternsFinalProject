package sweProject.observer;

import javax.swing.JOptionPane;

public class ConcreteObserver extends Observer{

	
	public ConcreteObserver(Subject subject){
		this.subject = subject;
	      this.subject.attach(this);
	}
	
	@Override
	public void update() {
		JOptionPane.showInputDialog("The Observer has noticed a change!", null);
	}

}
