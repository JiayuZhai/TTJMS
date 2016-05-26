package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import software.Route;

public class RouteTest {
	Route r;
	@Before
	public void setUp() throws Exception {
		String[] stationName2 = {"CS", "A", "B"};
		int[] stationInterval2 = {20,15};
		r = new Route(1, true, stationName2, stationInterval2);
	}

	@Test
	public void testRoute() {
		assertNotNull(r);
	}

	@Test
	public void testToString() {
		assertNotNull(r.toString());
	}

}
