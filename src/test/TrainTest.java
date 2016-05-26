package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import software.Train;

public class TrainTest {
	Train t;
	@Before
	public void setUp() throws Exception {
		t = new Train(20, "Train20");
	}

	@Test
	public void testTrain() {
		assertNotNull(t);
	}

	@Test
	public void testToString() {
		assertNotNull(t.toString());
	}

}
