package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import config.Check;
import exceptions.InvalidPortNumberException;

public class CheckTest {
	
	Check check = new Check();

	@Test(expected = InvalidPortNumberException.class)
	public void testInvalid() {
		check.setPort(65540);
	}
	
	@Test
	public void testValidatePortMax() {
		check.validatePort(49151);
	}
	
	@Test
	public void testValidatePortMin() {
		check.validatePort(1024);
	}
	
	@Test(expected = InvalidPortNumberException.class)
	public void testValidatePortInvalidLow() {
		check.validatePort(1023);
	}
	
	@Test(expected = InvalidPortNumberException.class)
	public void testValidatePortInvalidHigh() {
		check.validatePort(49152);
	}
	
	@Test
	public void testGetPort() {
		check.setPort(8000);
		assertEquals(8000, check.getPort());
	}

}
