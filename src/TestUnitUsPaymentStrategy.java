import static org.junit.Assert.*;

import org.junit.Test;

public class TestUnitUsPaymentStrategy {

	@Test public void shouldAccept1Cent(){
		PaymentStrategy ps = new USPaymentStrategy();
		assertEquals(1, ps.validCoinTest(1));
	}
	@Test public void shouldAccept5Cents(){
		PaymentStrategy ps = new USPaymentStrategy();
		assertEquals(1, ps.validCoinTest(5));
	}
	@Test public void shouldAccept10Cents(){
		PaymentStrategy ps = new USPaymentStrategy();
		assertEquals(1, ps.validCoinTest(10));
	}
	@Test public void shouldAccept25cents(){
		PaymentStrategy ps = new USPaymentStrategy();
		assertEquals(1, ps.validCoinTest(25));
	}
	@Test public void shouldNotAccept17Cents(){
		PaymentStrategy ps = new USPaymentStrategy();
		assertEquals(0, ps.validCoinTest(17));
	}
}
