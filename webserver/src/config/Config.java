package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import exceptions.InvalidPathException;
import exceptions.InvalidPortNumberException;
import file.PropertiesFileReadWrite;


public class Config {
	private PropertiesFileReadWrite rw;
	private String rootDir=null;
	private String port=null;
	private String state=null;
	
	private static Config config_instance = null; 
	
	
	private Config() throws FileNotFoundException {
		rw = new PropertiesFileReadWrite();
	}
	
	public static Config getInstance() throws FileNotFoundException {
		 if (config_instance == null) 
			 config_instance  = new Config(); 
	  
	        return config_instance ; 
	}
	
	public void setPropFileName(String str) {
		rw.setPropFileName(str);
	}
	
    public void setRootDir(String rd) throws InvalidPathException, IOException {
    	File dir = new File(rd);
		if(! dir.isDirectory()) {
			throw new InvalidPathException();
		}
    	this.rootDir = rd;
    	rw.updateFile("rootDir",rd);
    }
       
	public String getRootDir() throws IOException {
		if(this.rootDir==null) {
			this.rootDir=rw.readFromFile("rootDir");
			System.out.println("root dir is "+this.rootDir);
		}
		
		return this.rootDir;
	}
	
	public void setPort(String port) throws Exception {
    	this.port = port;
    	if(Utils.validatePort(port))
    		rw.updateFile("port", port);
    	else throw new InvalidPortNumberException();
	}
	
	public String getPort() throws IOException {
		if (this.port==null) {
			this.port=rw.readFromFile("port");
			System.out.println("port is: "+ this.port);
		}
		return this.port;
	}
	
	public void setState(String state) throws IOException {
		this.state = state;
    	rw.updateFile("state",state);
	}
	
	public String getState() throws IOException {
		if (this.state==null) {
			this.state=rw.readFromFile("state");
			System.out.println("state is: "+ this.state);
		}
		return this.state;
	}
	
}
