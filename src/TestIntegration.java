import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestIntegration {

	private PayStation ps;
	
	@Test 
	public void shouldIntegrateDanishLinearRateCorrectly() throws IllegalCoinException {
		ps = new PayStationImpl(new DanishPaymentStrategy(), new DanishLinearRateStrategy());
		ps.addPayment(1);
		assertEquals("Linear Rate: 1 krone should give 7 min", 7, ps.readDisplay());
	}
	
	@Test 
	public void shouldIntegrateDanishProgressiveRateCorrectly() throws IllegalCoinException {
		ps = new PayStationImpl(new DanishPaymentStrategy(), new DanishProgressiveRateStrategy());
		ps.addPayment(20); ps.addPayment(10); ps.addPayment(2);
		assertEquals("Progressive Rate: 32 krones should give 180 min", 180, ps.readDisplay());
	}
	
	@Test 
	public void shouldIntegrateUsLinearRateCorrectly() throws IllegalCoinException {
		ps = new PayStationImpl(new USPaymentStrategy(), new USLinearRateStrategy());
		addOneDollar(); addOneDollar();
		assertEquals("Linear Rate: 2$ should give 80 min", 80, ps.readDisplay());
	}
	
	@Test 
	public void shouldIntegrateUsProgressiveRateCorrectly() throws IllegalCoinException {
		ps = new PayStationImpl(new USPaymentStrategy(), new USProgressiveRateStrategy());
		addOneDollar(); addOneDollar();
		assertEquals("Linear Rate: 2$ should give 75 min", 75, ps.readDisplay());
	}
	
	private void addOneDollar() throws IllegalCoinException {
		ps.addPayment(25); ps.addPayment(25);
		ps.addPayment(25); ps.addPayment(25);
	}
}
