import static org.junit.Assert.*;

import org.junit.Test;

public class TestUnitLinearRateStrategy {
	
	@Test public void shouldDisplay120MinFor300cent(){
		RateStrategy rs = new USLinearRateStrategy();
		assertEquals(300 / 5 * 2, rs.calculateTime(300));
	}

	@Test public void shouldDisplay7MinFor1Krone(){
		RateStrategy rs = new DanishLinearRateStrategy();
		assertEquals(7, rs.calculateTime(1));
	}

}
