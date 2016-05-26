package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import software.Driver;

public class DriverTest {
	Driver d;
	@Before
	public void setUp() throws Exception {
		d = new Driver(10, "jack");
	}

	@Test
	public void testDriver() {
		assertNotNull(d);
	}

	@Test
	public void testToString() {
		assertNotNull(d.toString());
	}
}
