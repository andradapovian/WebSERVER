package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import config.Config;
import exceptions.InvalidPathException;
import webserver.SimpleWebServer;


public class Gui implements ActionListener{
	
	private static JLabel rootDirLabel;
	private static JTextField rootDirText;
	private static JLabel portLabel;
	private static JTextField portText;	
	
	private static JLabel stateLabel;
	private static JTextField stateText;
	
	private static JButton startButton;
	private static JLabel success;
	
	private String dbPort = new String();
	private String dbRoot = new String();
	private String dbState = new String();
	
	Config config = null;
    
    public static void main(String[] args) {    
        
        JFrame frame = new JFrame("WEBSERVER");      
        frame.setSize(350, 200);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();    
        frame.add(panel);       
        
        panel.setLayout(null);       
        
        rootDirLabel = new JLabel("root directory");      
        rootDirLabel.setBounds(10,20,80,25);
        panel.add(rootDirLabel);      
        rootDirText = new JTextField(20);
        rootDirText.setBounds(100,20,165,25);
        panel.add(rootDirText);
        
        portLabel = new JLabel("port number");
        portLabel.setBounds(10,50,80,25);
        panel.add(portLabel);        
        portText = new JTextField(20);
        portText.setBounds(100,50,165,25);
        panel.add(portText);
        
        stateLabel = new JLabel("state");
        stateLabel.setBounds(10,80,80,25);
        panel.add(stateLabel);       
        stateText = new JTextField(20);
        stateText .setBounds(100,80,165,25);
        panel.add(stateText);
        
        startButton = new JButton("start");
        startButton.setBounds(10, 120, 80, 25);
        startButton.addActionListener(new Gui());
        panel.add(startButton);
        
        success = new JLabel("");
        success.setBounds(10,150,370,25);
        panel.add(success);       
        
        frame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String rootDir = rootDirText.getText();
		String port = portText.getText();
		String state = stateText.getText();
		
		System.out.println(rootDir + " " + port + " " + state);		
		
		try {
			config = Config.getInstance();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			dbRoot = config.getRootDir();
			dbPort = config.getPort();
			dbState = config.getState();
		} catch (Exception e2) {
			System.out.println("variable init issue");
			e2.printStackTrace();
		}
		
		
		if(!port.trim().isEmpty() && !rootDir.trim().isEmpty() && !state.trim().isEmpty())
			try {
				config.setPort(port);
			} catch (Exception e1) {
				System.out.println("encountered error with introduced port");
				e1.printStackTrace();
				return;
			}
		
		if(!port.trim().isEmpty() && !rootDir.trim().isEmpty() && !state.trim().isEmpty())
			try {
				config.setRootDir(rootDir);
			} catch (Exception e1) {
				try {
					this.reset();
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				System.out.println("encountered error with introduced root dir");
				e1.printStackTrace();
				return;
			}
		
		if(!port.trim().isEmpty() && !rootDir.trim().isEmpty() && !state.trim().isEmpty())
			try {
				config.setState(state);
			} catch (Exception e1) {
				try {
					this.reset();
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				System.out.println("encountered error with introduced state");
				e1.printStackTrace();
				return;
			}
		
		try {
			SimpleWebServer.main(new String[2]);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void reset() throws Exception {
		config.setPort(dbPort);
		config.setRootDir(dbRoot);
		config.setState(dbState);
	}
}
