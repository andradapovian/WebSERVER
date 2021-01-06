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
	
	static public boolean validateState(String state) {
		if(state.equals("running") || state.equals("maintenance") || state.equals("stopped")) {
			return true;
		}
		return false;
	}
	
	
}
