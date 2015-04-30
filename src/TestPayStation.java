import org.junit.*;
import static org.junit.Assert.*;
import java.util.Map;

public class TestPayStation {
	PayStation ps;

	/** Fixture for pay station testing. */
	@Before
	public void setUp() {
		ps = new PayStationImpl(new SimplePaymentStrategy(),new One2OneRateStrategy());
	}

	@Test
	public void shouldAcceptLegalUsCoins() throws IllegalCoinException {
		ps.addPayment(1);
		ps.addPayment(2);
		ps.addPayment(5);
		ps.addPayment(10);
		ps.addPayment(25);
		assertEquals("Should accept 5, 10, and 25 cents", 1 + 2 + 5 + 10 + 25,
				ps.readDisplay());
	}
	
	/**
	 * Verify that illegal coin values are rejected.
	 */
	@Test(expected = IllegalCoinException.class)
	public void shouldRejectIllegalCoin() throws IllegalCoinException {
		ps.addPayment(17);
	}

	/**
	 * Buy should return a valid receipt of the proper amount of parking time
	 */
	@Test
	public void shouldReturnCorrectReceiptWhenBuy() throws IllegalCoinException {
		ps.addPayment(5);
		ps.addPayment(10);
		Receipt receipt = ps.buy();
		assertNotNull("Receipt reference cannot be null", receipt);
		assertEquals("Receipt value must be correct.", 5 + 10,
				receipt.value());
	}

	/**
	 * Receipts must be able to store parking time values
	 */
	@Test
	public void shouldStoreTimeInReceipt() {
		Receipt receipt = new ReceiptImpl(30);
		assertEquals("Receipt can store 30 minute value", 30, receipt.value());
	}

	/**
	 * Buy for 100 cents and verify the receipt
	 */
	@Test
	public void shouldReturnReceiptWhenBuy100c() throws IllegalCoinException {
		ps.addPayment(10);
		ps.addPayment(10);
		ps.addPayment(10);
		ps.addPayment(10);
		ps.addPayment(10);
		ps.addPayment(20);
		ps.addPayment(20);

		Receipt receipt = ps.buy();
		assertEquals((5 * 10 + 2 * 20), receipt.value());
	}

	/**
	 * Verify that the pay station is cleared after a buy scenario
	 */
	@Test
	public void shouldClearAfterBuy() throws IllegalCoinException {
		ps.addPayment(20);
		ps.buy(); // I do not care about the result
		// verify that the display reads 0
		assertEquals("Display should have been cleared", 0, ps.readDisplay());
		// verify that a following buy scenario behaves properly
		ps.addPayment(10);
		ps.addPayment(20);
		assertEquals("Next add payment should display correct time", 10 + 20,
				ps.readDisplay());
		Receipt r = ps.buy();
		assertEquals("Next buy should return valid receipt", (10 + 20),
				r.value());
		assertEquals("Again, display should be cleared", 0, ps.readDisplay());
	}

	/**
	 * Verify that cancel clears the pay station
	 */
	@Test
	public void shouldClearAfterCancel() throws IllegalCoinException {
		ps.addPayment(10);
		ps.cancel();
		assertEquals("Cancel should clear display", 0, ps.readDisplay());
		ps.addPayment(20);
		assertEquals("Insert after cancel should work", 20, ps.readDisplay());
	}

	/**
	 * checks that coinsInserted is never null
	 */
	@Test
	public void shouldNotBeNull() {
		Map<Integer, Integer> result = ps.cancel();
		assertNotNull(result);
	}
}