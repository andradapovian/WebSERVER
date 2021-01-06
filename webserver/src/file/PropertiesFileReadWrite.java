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
	
	public String getPropFileName() {
		return this.propFileName;
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
	
}
