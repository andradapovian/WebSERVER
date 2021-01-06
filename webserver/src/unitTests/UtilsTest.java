package unitTests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import config.Utils;

public class UtilsTest {

	@Test
	public void testGetExtensionInValid() {
		assertEquals("", Utils.getExtension(new File("pisici")));
	}
	
	@Test
	public void testGetExtensionInValid2() {
		assertEquals(".hm", Utils.getExtension(new File(".hm")));
	}
	
	@Test
	public void testGetExtensionValid1() {
		assertEquals(".txt", Utils.getExtension(new File("pisici.txt")));
	}
	
	@Test
	public void testGetExtensionValid2() {
		assertEquals(".html", Utils.getExtension(new File("pisici.cu.catei.html")));
	}
	
	@Test
	public void testValidatePortTrue1() {
		assertEquals(true, Utils.validatePort("1024"));
	}
	
	@Test
	public void testValidatePortTrue2() {
		assertEquals(true, Utils.validatePort("49150"));
	}
	
	@Test
	public void testValidatePortTrue3() {
		assertEquals(true, Utils.validatePort("8080"));
	}
	
	@Test
	public void testValidatePortTrue4() {
		assertEquals(true, Utils.validatePort("8000"));
	}
	
	@Test
	public void testValidatePortFalse1() {
		assertEquals(false, Utils.validatePort("1023"));
	}
	
	@Test
	public void testValidatePortFalse2() {
		assertEquals(false, Utils.validatePort("49151"));
	}

	@Test(expected = Exception.class)
	public void testValidatePortFalse3() {
		Utils.validatePort("dkfbms");
	}
	
	@Test
	public void testValidateState1() {
		assertEquals(true, Utils.validateState("running"));
	}
	
	@Test
	public void testValidateState2() {
		assertEquals(true, Utils.validateState("maintenance"));
	}
	
	@Test
	public void testValidateState3() {
		assertEquals(true, Utils.validateState("stopped"));
	}
	
	@Test
	public void testValidateState4() {
		assertEquals(false, Utils.validateState("maintanance"));
	}
	
	@Test
	public void testValidateState5() {
		assertEquals(false, Utils.validateState("395280"));
	}
	
	@Test
	public void testValidateState6() {
		assertEquals(false, Utils.validateState("run"));
	}

}
