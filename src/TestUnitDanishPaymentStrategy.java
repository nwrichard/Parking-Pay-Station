import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestUnitDanishPaymentStrategy {
	
	//One Danish Krone
	@Test public void shouldAccept1Krone(){
		PaymentStrategy ps = new DanishPaymentStrategy();
		assertEquals(1,ps.validCoinTest(1));
	}
	
	//Two Danish Krones
	@Test public void shouldAccept2Krone(){
		PaymentStrategy ps = new DanishPaymentStrategy();
		assertEquals(1,ps.validCoinTest(2));
	}
	
	//Five Danish Krones
	@Test public void shouldAccept5Krone(){
		PaymentStrategy ps = new DanishPaymentStrategy();
		assertEquals(1,ps.validCoinTest(5));
	}
	
	//Ten Danish Krones
	@Test public void shouldAccept10Krone(){
		PaymentStrategy ps = new DanishPaymentStrategy();
		assertEquals(1,ps.validCoinTest(10));
	}
	
	//Twenty Danish Krones
	@Test public void shouldAccept20Krone(){
		PaymentStrategy ps = new DanishPaymentStrategy();
		assertEquals(1,ps.validCoinTest(20));
	}
	
	//Should not accept 25 Krones.
	@Test public void shouldNotAccept25Krone(){
		PaymentStrategy ps = new DanishPaymentStrategy();
		assertEquals(0,ps.validCoinTest(25));
	}
}
