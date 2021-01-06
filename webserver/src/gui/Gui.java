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
	private static JButton startButton;
	private static JLabel success;
	
    
    public static void main(String[] args) {    
        
        JFrame frame = new JFrame("WEBSERVER");      
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        startButton = new JButton("start");
        startButton.setBounds(10, 80, 80, 25);
        startButton.addActionListener(new Gui());
        panel.add(startButton);
        
        success = new JLabel("");
        success.setBounds(10,110,300,25);
        panel.add(success);       
        
        frame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String rootDir = rootDirText.getText();
		String port = portText.getText();
		System.out.println(rootDir + " " + port);		
		
		Config config = null;
		try {
			config = Config.getInstance();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		if(!port.trim().isEmpty())
			try {
				config.setPort(port);
			} catch (Exception e1) {
				System.out.println("encountered error with introduced port");
				e1.printStackTrace();
				return;
			}
		
		if(!rootDir.trim().isEmpty())
			try {
				config.setRootDir(rootDir);
			} catch (Exception e1) {
				System.out.println("encountered error with introduced root dir");
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
}
