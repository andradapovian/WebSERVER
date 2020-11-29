package webserver;


import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import config.Config;
import exceptions.InvalidPathException;
import file.PropertiesFileReadWrite;

public class SimpleWebServer extends Thread {
    
    private ServerSocket serverSocket;
    private boolean _running = true;
    private Config config=Config.getInstance();
    public static String state=null;
    
    public SimpleWebServer() throws IOException, InvalidPathException {   
    	state = config.getState();
        serverSocket = new ServerSocket(Integer.parseInt(config.getPort()));
        start();      
    }
    

    public void stopServer() {
    	try {
    		serverSocket.close();
    		interrupt();
    	} catch (Exception e) {}
    }
    
    public void run() {
        while (_running) {
        	System.out.println("Waiting for Connection");
            try {
                Socket socket = serverSocket.accept();
                RequestThread requestThread = new RequestThread(socket, new File(config.getRootDir()));
                requestThread.start();
            } catch (Exception e) {
            	System.err.println("Accept failed.");
            	System.out.println(e);
                System.exit(1);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
    	
    	try {
            new SimpleWebServer();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}