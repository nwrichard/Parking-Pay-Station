import static org.junit.Assert.*;
import org.junit.Test;

public class TestUnitProgressiveRateStrategy {

	@Test public void shouldDisplay6MinFor1Krone() throws IllegalCoinException{
		RateStrategy rs = new DanishProgressiveRateStrategy();
		assertEquals(6, rs.calculateTime(1));
	}

	@Test public void shouldDisplay180MinFor32Krones() throws IllegalCoinException{
		RateStrategy rs = new DanishProgressiveRateStrategy();
		assertEquals(180, rs.calculateTime(32));
	}

	@Test public void shouldDisplay60MinFor150cent() throws IllegalCoinException{
		RateStrategy rs = new USProgressiveRateStrategy();
		assertEquals(60, rs.calculateTime(150));
	}

	@Test public void shouldDisplay120MinFor350cent() throws IllegalCoinException{
		RateStrategy rs = new USProgressiveRateStrategy();
		assertEquals(2 * 60, rs.calculateTime(350));
	}

	@Test public void shouldDisplay180MinFor650cent() throws IllegalCoinException{
		RateStrategy rs = new USProgressiveRateStrategy();
		assertEquals(180, rs.calculateTime(650));
		}
}
