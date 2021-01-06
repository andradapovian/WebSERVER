package unitTests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import file.PropertiesFileReadWrite;


public class PropertiesFileReadWriteTest {	
	static PropertiesFileReadWrite rw;

	@BeforeClass
	public static void setup() {
		rw = new PropertiesFileReadWrite();
	    rw.setPropFileName("resources/webserverTEST.properties");
	}
	
	@Test
	public void testUpdateFile1() throws IOException {
		rw.updateFile("pisica", "Bucla");
		rw.updateFile("fulgi", "mari si frumosi");
	}
	
	@Test
	public void testUpdateFile2() throws IOException {
		rw.updateFile("", "");	
	}
	
	@Test
	public void testReadFromFile() throws IOException {
		rw.updateFile("rootDir", "it's me, Mario");
		assertEquals("it's me, Mario", rw.readFromFile("rootDir"));
	}
	
	@Test
	public void testReadFromFile2() throws IOException {
		rw.updateFile("empty", "");
		assertEquals("", rw.readFromFile("empty"));
	}
	
	@Test
	public void testReadFromFile3() throws IOException {
		rw.updateFile("smth", "");
		rw.updateFile("smth", "   miau  ");
		rw.updateFile("smth", "pisicute");
		assertEquals("pisicute", rw.readFromFile("smth"));
	}
}
