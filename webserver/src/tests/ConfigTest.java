package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

import config.Config;
import exceptions.ConfigInitException;
import exceptions.InvalidPathException;

public class ConfigTest {

	Config conf= new Config();
	
	@Test(expected = ConfigInitException.class)
	public void testGetRootDirNotInit() {
		conf.getRootDir();
	}
	
	@Test(expected = ConfigInitException.class)
	public void testGetMaintenanceDirNotInit() {
		conf.getMaintainanceDir();
	}
	
	@Test(expected = ConfigInitException.class)
	public void testGetPortNumberNotInit() {
		conf.getPort();
	}
	
	@Test
	public void testGetRootDir() {
		conf.setRootDir("a/b/c");
		assertEquals("a/b/c", conf.getRootDir());
	}
	
	@Test(expected = ConfigInitException.class)
	public void testGetMaintenanceDir() {
		conf.setRootDir("a/b/c");
		assertEquals("a/b/c", conf.getMaintainanceDir());
		
	}
	
	@Test(expected = ConfigInitException.class)
	public void testGetPortNumber() {
		conf.setPort("8000");
		assertEquals("8000", conf.getPort());
	}
	
	@Test(expected = InvalidPathException.class)
	public void testValidConfigPathNoSpecialChar(){
		String configFileName = "C:/webserver/conf/webServerConfig*.ini";
	}
	
	@Test
	public void testValidConfigPathExists() throws IOException{
		String configFileName = "C:/webserver/conf/webServerConfig.ini";
		
		File f = new File(configFileName);
		f.createNewFile();
		
		FileOutputStream fos = new FileOutputStream(f);
		 assertTrue(f.isFile());
		 
		 Config c = new Config(configFileName);
		 
		 assertTrue(f.isFile());
	}
	
	@Test()
	public void testValidConfigPathNotExisting() {
		String configFileName = "C:/webserver/conf/webserverConfig.ini";
		
		File f = new File(configFileName);
		f.delete();
		assertFalse(f.isFile());
		
	}
}
