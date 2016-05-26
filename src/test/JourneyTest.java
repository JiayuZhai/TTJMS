package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import software.Driver;
import software.Journey;
import software.Route;
import software.Train;

public class JourneyTest {
	Train trainID2;
	Driver driverID2;
	String[] stationName2 = {"CS", "A", "B"};
	int[] stationInterval2 = {20,15};
	Route routeID;
	Date d;
	int i;
	Journey j;
	
	@Before
	public void setUp() throws Exception {
		trainID2 = new Train(100, "Train100");
		driverID2 = new Driver(10, "jack");
		routeID = new Route(1, true, stationName2, stationInterval2);
		d = new Date();
		i = 40;
		j = new Journey(trainID2, driverID2, routeID, d, i);
	}

	@Test
	public void testJourney() {
		assertNotNull(j);
	}

	@Test
	public void testLog() {
		Journey.log(j);
	}

	@Test
	public void testGetTimeTable() {
		assertNotNull(j.getTimeTable());
	}

	@Test
	public void testGetTimeTableBoolean() {
		assertNotNull(j.getTimeTable(true));
	}

}
