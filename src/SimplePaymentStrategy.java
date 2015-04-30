public class SimplePaymentStrategy implements PaymentStrategy {
	public int validCoinTest(int coinValue) {
		switch ( coinValue ) {
		case 1:
		case 2:
		case 5:
		case 10:
		case 20:
		case 25:
			return 1;
			default:
				return 0;
		}
	}
}
