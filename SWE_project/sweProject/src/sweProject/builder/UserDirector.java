package sweProject.builder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserDirector {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private ArrayList<User> users = new ArrayList<User>();
	private String name;
	private String email;
	private boolean subscriber = false;


	/**
	 * Create the frame.
	 */
	public UserDirector() {
		JFrame frame;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(67, 34, 78, 16);
		contentPane.add(lblUserName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(67, 64, 61, 16);
		contentPane.add(lblEmail);
		
		JRadioButton rdbtnMale = new JRadioButton("Subscribe");
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subscriber = rdbtnMale.isSelected();
			}
		});
		rdbtnMale.setBounds(146, 113, 141, 23);
		contentPane.add(rdbtnMale);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = textField.getText();
			}
		});
		textField.setBounds(157, 29, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				email = textField_1.getText();
			}
		});
		textField_1.setBounds(157, 59, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Create User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(subscriber) {
					users.add(new Subscriber(name,email).buildPart(subscriber));
				} else {
					users.add(new NonSubscriber(name,email).buildPart(subscriber));
				}
			}
		});
		btnNewButton.setBounds(87, 177, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblBuildUser = new JLabel("Build User");
		lblBuildUser.setBounds(185, 6, 93, 16);
		contentPane.add(lblBuildUser);
		
		JLabel lblPressTheEnter = new JLabel("Note: Press the Enter Key after entering text in text feilds");
		lblPressTheEnter.setBounds(34, 229, 381, 16);
		contentPane.add(lblPressTheEnter);
		
		JButton btnGetUsers = new JButton("Get Users");
		btnGetUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String listUsers = "";
				for(User user : users) {
					listUsers = listUsers + "Name: " + user.name + " \n" + "Email: " + user.email + " \n" + "Subscriber: " + user.subscriber + " \n";
				}
				
				JOptionPane.showInputDialog(frame, listUsers);
			}
		});
		btnGetUsers.setBounds(240, 177, 117, 29);
		contentPane.add(btnGetUsers);
		frame.setVisible(true);
	}
	
	
	
	
	
	
	
	
}