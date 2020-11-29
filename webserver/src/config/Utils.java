package config;


import java.io.File;

public class Utils {
	/** 
	 * Work out the filename extension.  If there isn't one, we keep it as the empty string ("").
	 * @param file
	 * @return the file's extension, or an empty string otherwise
	 */
	static public String getExtension(File file) {
        String extension = "";
        String filename = file.getName();
        int dotPos = filename.lastIndexOf(".");
        if (dotPos >= 0) {
            extension = filename.substring(dotPos);
        }
        return extension.toLowerCase();
    }
	
	public boolean validatePort(int portNumber) {
		return false;
	}
}
