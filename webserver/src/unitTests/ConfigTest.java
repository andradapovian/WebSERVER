package unitTests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import config.Config;
import exceptions.InvalidPathException;
import exceptions.InvalidPortNumberException;
import exceptions.InvalidStateException;

public class ConfigTest {
	
	static Config config;
	
	@BeforeClass
	public static void setup() throws FileNotFoundException {
		config = Config.getInstance();
		config.setPropFileName("resources/webserverTEST.properties");
	}

	@Test
	public void testGetPropFileName() {
		assertEquals("resources/webserverTEST.properties", config.getPropFileName());
	}
	
	@Test(expected = InvalidPathException.class)
	public void testSetRootDir() throws InvalidPathException, IOException {
		config.setRootDir("pisici");	
	}
	
	@Test(expected = InvalidPathException.class)
	public void testSetRootDir2() throws InvalidPathException, IOException {
		config.setRootDir("pisici/cu/catei");	
	}
	
	@Test
	public void testSetRootDir3() throws InvalidPathException, IOException {
		config.setRootDir("C:/Users/andra/Downloads");	
		assertEquals("C:/Users/andra/Downloads", config.getRootDir());
	}
	
	@Test(expected = NumberFormatException.class)
	public void testSetPort1() throws Exception {
		config.setPort("pisi");
	}
	
	@Test(expected = InvalidPortNumberException.class)
	public void testSetPort2() throws Exception {
		config.setPort("-1");
	}
	
	@Test(expected = InvalidPortNumberException.class)
	public void testSetPort3() throws Exception {
		config.setPort("1000");
	}
	
	@Test
	public void testSetPort4() throws Exception {
		config.setPort("8080");
		assertEquals("8080", config.getPort());
	}
	
	@Test(expected = InvalidStateException.class)
	public void testSetState1() throws IOException, InvalidStateException {
		config.setState("pisici");
	}
	
	@Test(expected = InvalidStateException.class)
	public void testSetState2() throws IOException, InvalidStateException {
		config.setState("run");
	}
	
	@Test
	public void testSetState3() throws IOException, InvalidStateException {
		config.setState("running");
		assertEquals("running", config.getState());
	}
	
	@Test
	public void testSetState4() throws IOException, InvalidStateException {
		config.setState("maintenance");
		assertEquals("maintenance", config.getState());
	}
	
	@Test
	public void testSetState5() throws IOException, InvalidStateException {
		config.setState("stopped");
		assertEquals("stopped", config.getState());
	}

}
