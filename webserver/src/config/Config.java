package config;

public class Config {
	private final String DEFAULT_CONFIG_FILE="WebServerConfig.ini";
	
	public Config(String configFileName) {
		
	}
	
	public Config() {
		
	}
	
	public boolean loadConfiguration(String configFile) {
		return false;
	}
	
	public boolean saveConfiguration(String configFile) {
		return false;
	}
	
	public void makeDefaultConfig() {
	
	}
	
	public boolean setRootDir(String dir) {
		return false;
	}
	
	public boolean setMaintainanceDir() {
		return false;
	}
	
	public boolean setPort(String dir) {
		return false;
	}
	
	public boolean setState() {
		return false;
	}
	
	public String getRootDir() {
		return null;
	}
	
	public String getMaintainanceDir() {
		return null;
	}
	
	public String getPort() {
		return null;
	}
	
	public String getState() {
		return null;
	}
	
}
