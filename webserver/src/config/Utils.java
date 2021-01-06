package config;


import java.io.File;

public class Utils {
	
	static public String getExtension(File file) {
        String extension = "";
        String filename = file.getName();
        int dotPos = filename.lastIndexOf(".");
        if (dotPos >= 0) {
            extension = filename.substring(dotPos);
        }
        return extension.toLowerCase();
    }
	
	static public boolean validatePort(String port) {
		int portNumber = Integer.parseInt(port);
		if (portNumber > 1023 && portNumber < 49151) {
			return true;
		}
		return false;
	}
	
	
}
