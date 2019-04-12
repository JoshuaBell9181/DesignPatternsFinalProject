package sweProject.singleton;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class HelpWindowSingleton {

	private static HelpWindowSingleton instance = new HelpWindowSingleton();
	


	/**
	 * Create the application.
	 */
	private HelpWindowSingleton() {
	}
	
	public static HelpWindowSingleton getInstance() {
		return instance;
	}
	
	public void buildHelp() {
		JFrame frame;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHelpAndFaq = new JLabel("Help and FAQ");
		lblHelpAndFaq.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblHelpAndFaq.setBounds(20, 16, 187, 34);
		frame.getContentPane().add(lblHelpAndFaq);
		
		JLabel lblNewLabel = new JLabel("Note that the search find only looks for words.");
		lblNewLabel.setBounds(20, 62, 317, 55);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
	
}
