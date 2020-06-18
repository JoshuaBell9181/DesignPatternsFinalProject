package sweProject.mediator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sweProject.builder.User;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;

public class ChatRoom {

	private JPanel contentPane;
	ArrayList<User> users = new ArrayList<User>();
	private JTextField textField;
	private User user;
	private String conversation = "";


	/**
	 * Create the frame.
	 */
	public ChatRoom(ArrayList<User> users) {
		this.users = users;
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(5, 247, 440, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblSelectAUser = new JLabel("Select a user:");
		lblSelectAUser.setBounds(18, 17, 93, 16);
		contentPane.add(lblSelectAUser);
		
		String[] names = getUserNames();
		user = users.get(0);
		JComboBox comboBox = new JComboBox(names);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    JComboBox cb = (JComboBox)e.getSource();
			    String tmpName = (String)cb.getSelectedItem();
				for(User tmpUser : users) {
					if(tmpUser.getName().equalsIgnoreCase(tmpName)) {
						user = tmpUser;
					}
				}
			}
		});
		comboBox.setBounds(123, 13, 184, 27);
		contentPane.add(comboBox);
	
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(28, 54, 354, 151);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new SendAction(editorPane,textField));
		btnSend.setBounds(327, 217, 117, 29);
		contentPane.add(btnSend);
		
		
		contentPane.add(editorPane);
		frame.setVisible(true);
		
	}
	
	
	String[] getUserNames() {
		String[] userNames = new String[users.size()];
		int index = 0;
		for(User user : users) {
			userNames[index] = user.getName();
			index++;
		}
		return userNames;
	}
	
	
	
	public class SendAction implements ActionListener{
		JEditorPane editorPane;
		public SendAction(JEditorPane editorPane,JTextField textField ) {
			this.editorPane = editorPane;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			conversation = editorPane.getText();
			conversation = conversation + " \n" + user.sendMessage(textField.getText());
			editorPane.setText(conversation);
			textField.setText("");
			
		}
		
	}
}
