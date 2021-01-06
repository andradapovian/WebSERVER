package unitTests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;

import config.Config;

public class ConfigTest {
	
	static Config config;
	
	@BeforeClass
	public static void setup() throws FileNotFoundException {
		config = Config.getInstance();
		config.setPropFileName("resources/webserverTEST.properties");
	}

	@Test
	public void test() {
		assertEquals(1,1);
	}

}
