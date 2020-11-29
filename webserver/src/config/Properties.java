package config;

import java.io.File;

public class Properties {
	
	public int getPort() {
		return 0;
	}
	
	public void setPort(int portNumber) {
		
	}
	
	public boolean validatePort(int portNumber) {
		return false;
	}
	
	static String getExtension(File file) {
        String extension = "";
        String filename = file.getName();
        int dotPos = filename.lastIndexOf(".");
        if (dotPos >= 0) {
            extension = filename.substring(dotPos);
        }
        return extension.toLowerCase();
    }
}
