package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;

public class PropertiesFileReadWrite {
	private Properties prop = new Properties();
	private String propFileName = "resources/webserver.properties";
	
	public PropertiesFileReadWrite() {}
	
	public void setPropFileName(String propFile) {
		propFileName = propFile;
	}
	
	public String readFromFile(String str) throws IOException {
		FileInputStream inputStream = new FileInputStream(propFileName);
		prop.load(inputStream);
		String res = prop.getProperty(str);
		inputStream.close();
		return res;
	}
	
	public void updateFile(String propName, String rd) throws IOException{
		FileOutputStream out = new FileOutputStream(propFileName);
		prop.setProperty(propName, rd);
		prop.store(out, " last modified rootDir");
		out.close();
	}
	
	public String readRootDir() throws IOException {
		FileInputStream inputStream = new FileInputStream(propFileName);
		prop.load(inputStream);
		String rootDir = prop.getProperty("rootDir");
		inputStream.close();
		return rootDir;
	}
	
	public void updateRootDir(String rd) throws IOException{
		FileOutputStream out = new FileOutputStream(propFileName);
		prop.setProperty("rootDir", rd);
		prop.store(out, " last modified rootDir");
		out.close();
	}
	
	
	public String readPort() throws IOException {
		FileInputStream inputStream = new FileInputStream(propFileName);
		prop.load(inputStream);
		String port = prop.getProperty("port");
		inputStream.close();
		return port;
	}
	
	public void updatePort(String rd) throws IOException{
		FileOutputStream out = new FileOutputStream(propFileName);
		prop.setProperty("port", rd);
		prop.store(out, "last modified: port");
		out.close();
	}
	
	public String readState() throws IOException {
		FileInputStream inputStream = new FileInputStream(propFileName);
		prop.load(inputStream);
		String state = prop.getProperty("state");
		inputStream.close();
		return state;
	}
	
	public void updateState(String rd) throws IOException{
		FileOutputStream out = new FileOutputStream(propFileName);
		prop.setProperty("state", rd);
		prop.store(out, "last modified: state");
		out.close();
	}
	
}
