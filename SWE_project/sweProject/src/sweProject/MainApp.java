package sweProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import javax.swing.JToolBar;

import sweProject.Iterator.FindIterator;
import sweProject.Iterator.Iterator;
import sweProject.builder.Subscriber;
import sweProject.builder.User;
import sweProject.builder.UserDirector;
import sweProject.decorator.BoldDecorator;
import sweProject.decorator.Document;
import sweProject.facade.Facade;
import sweProject.mediator.ChatRoom;
import sweProject.memento.CareTaker;
import sweProject.memento.Originator;
import sweProject.observer.ConcreteObserver;
import sweProject.observer.Subject;
import sweProject.proxy.Image;
import sweProject.proxy.ProxyImage;
import sweProject.singleton.HelpWindowSingleton;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Font;

public class MainApp {

	private JFrame frame;
	private Document document = new Document();
	private boolean toggleGreeting = true;
	private CareTaker careTaker = new CareTaker();
	private Originator originator = new Originator();
	private Subject subject = new Subject();
	private String observerState = "Original";
	private ArrayList<User> users = new ArrayList<User>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("New...");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmText = new JMenuItem("Text Document");
		mntmText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = JOptionPane.showInputDialog(frame, "Please enter file name:", null);
				HelperFunction helperFunction = new HelperFunction();
				helperFunction.newDocument("text", fileName);
				document.setPath("./" +fileName + ".txt");
			}
		});
		mnNewMenu_1.add(mntmText);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JButton btnNewButton = new JButton("Update Path:");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		panel_3.add(btnNewButton);
		
		JLabel lblHjwhj = new JLabel("");
		panel_3.add(lblHjwhj);
		btnNewButton.addActionListener(new PathUpdateAction(lblHjwhj));
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setContentType("text/html");
		frame.getContentPane().add(editorPane, BorderLayout.CENTER);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new DataUpdateAction(editorPane));
		mnNewMenu.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new SaveAction(editorPane));
		mnNewMenu.add(mntmSave);
		
		JMenuItem mntmConvert = new JMenuItem("Convert");
		mntmConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(document.getPath() != null) {
					Facade facade = new Facade();
					facade.export(document.getPath());
				}
				
			}
		});
		mnNewMenu.add(mntmConvert);
		
		JMenuItem mntmGreeting = new JMenuItem("Greeting");
		mnNewMenu.add(mntmGreeting);
		
		JMenuItem mntmCreateUser = new JMenuItem("Create User");
		mnNewMenu.add(mntmCreateUser);
		
		JMenuItem mntmProxyImage = new JMenuItem("Proxy Image");
		mntmProxyImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Image image = new ProxyImage("./FakeImage.png");
				image.display();
				
				image.display();
				
			}
		});
		mnNewMenu.add(mntmProxyImage);
		mntmCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDirector userDirector = new UserDirector();
			}
		});
		mntmGreeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelperFunction helperFunction = new HelperFunction();
				toggleGreeting = !toggleGreeting;
				JOptionPane.showInputDialog(frame,helperFunction.greeting(toggleGreeting));
			}
		});
		
		JMenu mnSearch = new JMenu("Search");
		menuBar.add(mnSearch);
		
		JMenuItem mntmFind = new JMenuItem("Find");
		mntmFind.addActionListener(new FindAction(editorPane));
		mnSearch.add(mntmFind);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Help can be where the documentation is stored
				HelpWindowSingleton window = HelpWindowSingleton.getInstance();
				window.buildHelp();
			}
		});
		
		JMenuItem mntmChat = new JMenuItem("Chat");
		mntmChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User josh = new Subscriber("Josh Bell", "jbell5@unb.ca");
				User joel = new Subscriber("Joel Bell", "jbell6@unb.ca");
				users.add(josh);
				users.add(joel);
				ChatRoom chatRoom = new ChatRoom(users );
			}
		});
		menuBar.add(mntmChat);
		menuBar.add(mntmHelp);
		
		JButton btnB = new JButton("B");
		btnB.addActionListener(new BoldAction(editorPane));
		
		JButton btnMementoSave = new JButton("Memento Save");
		btnMementoSave.addActionListener(new MementoAction(editorPane));
		
		JButton btnObserver = new JButton("Observer");
		btnObserver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConcreteObserver(subject);
				if(observerState.equalsIgnoreCase("Original")) {
					observerState = "new";
					subject.setState(observerState);
				}else {
					observerState = "Original";
					subject.setState(observerState);
				}
			}
		});
		panel_1.add(btnObserver);
		panel_1.add(btnMementoSave);
		
		JButton btnUndo = new JButton("undo");
		btnUndo.addActionListener(new UndoAction(editorPane));
		panel_1.add(btnUndo);
		btnB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel_1.add(btnB);
		
		frame.pack();
		frame.setSize(507, 323);
	}
	
	
	//Helper classes Begin here
	public class PathUpdateAction implements ActionListener{
		JLabel label;
		public PathUpdateAction(JLabel label) {
			this.label = label;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			label.setText(document.getPath());
			
		}
	}
	
	public class DataUpdateAction implements ActionListener{
		JEditorPane editorPane;
		public DataUpdateAction(JEditorPane editorPane) {
			this.editorPane = editorPane;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();
	        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	        int result = fileChooser.showOpenDialog(null);
	        if (result == JFileChooser.APPROVE_OPTION) {
	            File selectedFile = fileChooser.getSelectedFile();
	            document.setPath(selectedFile.getAbsolutePath());
	            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
	        }
			
			HelperFunction helperFunction = new HelperFunction();
			helperFunction.openDocument(document);
			editorPane.setText(document.getData());
		}
	}
	
	public class FindAction implements ActionListener{
		JEditorPane editorPane;
		public FindAction(JEditorPane editorPane) {
			this.editorPane = editorPane;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String searchText = JOptionPane.showInputDialog(frame, "Please enter text to search:", null);
			String[] list = document.getData().split(" ");
			Iterator find = new FindIterator(list);
			String results = "";
			while(!find.isDone()) {
				boolean addedOnce = false;
				if(find.currentItem().contains(searchText)) {
					results = results+ " " + "<span style=\"background-color: #FFFF00\">" +find.currentItem() +  "</span>";
					addedOnce = true;
				}
				if(!addedOnce) {
					results = results + " " + find.currentItem();
				}
				find.next();
				if(find.isDone()) {
					if(find.currentItem().contains(searchText)) {
						results = results + " " + "<span style=\"background-color: #FFFF00\">" +find.currentItem() + "</span>";
					} else {
						results = results + " " + find.currentItem();
					}
				} 
				document.setData(results);
			}
			editorPane.setText(document.getData());
		}
		
	}
	
	public class BoldAction implements ActionListener{
		JEditorPane editorPane;
		public BoldAction(JEditorPane editorPane) {
			this.editorPane = editorPane;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			document.setData(editorPane.getText());
			BoldDecorator boldDecorator = new BoldDecorator(document,editorPane.getSelectedText());
			boldDecorator.decorate();
			editorPane.setText(document.getData());
		}
		
	}
	
	public class SaveAction implements ActionListener{
		JEditorPane editorPane;
		public SaveAction(JEditorPane editorPane) {
			this.editorPane = editorPane;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String fileName = JOptionPane.showInputDialog(frame, "Please enter file name:", null);
			Facade facade = new Facade();
			editorPane.selectAll();
			String content = editorPane.getSelectedText();
			facade.autoSave(fileName, content);
		    //Write content to file
		}
		
	}
	
	public class MementoAction implements ActionListener{
		JEditorPane editorPane;
		public MementoAction(JEditorPane editorPane) {
			this.editorPane = editorPane;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			editorPane.selectAll();
			String content = editorPane.getSelectedText();
			originator.setState(content);
			careTaker.add(originator.saveStateToMemento());
		    //Write content to file
		}
		
	}
	
	public class UndoAction implements ActionListener{
		JEditorPane editorPane;
		public UndoAction(JEditorPane editorPane) {
			this.editorPane = editorPane;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(careTaker.getLength() > 0) {
				originator.getStateFromMemento(careTaker.get(careTaker.getLength() - 2));
				editorPane.setText(originator.getState());
			}
		}
		
	}
	

}
