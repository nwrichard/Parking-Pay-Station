import java.util.Map;
import java.util.HashMap;

/** Implementation of the pay station.

   Responsibilities:

   1) Accept payment;
   2) Calculate parking time based on payment;
   3) Know earning, parking time bought;
   4) Issue receipts;
   5) Handle buy and cancel events.
   */

public class PayStationImpl implements PayStation {
	private int countNickels;
	private int countDimes;
	private int countQuarters;
	private int insertedSoFar;
	private int timeBought;
	private RateStrategy rateStrategy;
	private PaymentStrategy paymentStrategy;
	private Map<Integer, Integer> coinsInserted = new HashMap<Integer, Integer>();

	public PayStationImpl(PaymentStrategy paymentStrategy, RateStrategy rateStrategy){
		this.rateStrategy = rateStrategy;
		this.paymentStrategy = paymentStrategy;
	}
	
	public void addPayment( int coinValue ) throws IllegalCoinException {
		int validCoinTest = paymentStrategy.validCoinTest(coinValue);
		switch ( validCoinTest ) {
		case 1:
			//adds or updates a key-value pair based on the type of coin inserted.
			//if the map contains the coinValue key, we increment the current value
			//and put it back in the map, otherwise we set the value to 1 and put it in the map
			coinsInserted.put( coinValue, coinsInserted.containsKey(coinValue) ?
				                          coinsInserted.get(coinValue)+1 : 1 );
			break;
		default:
			throw new IllegalCoinException("Invalid coin: "+coinValue);
		}
		insertedSoFar += coinValue;
		timeBought = rateStrategy.calculateTime(insertedSoFar);
	}
	
	public int readDisplay() {
		return timeBought;
	}
	
	public Receipt buy() {
		Receipt r = new ReceiptImpl(timeBought);
		reset();
		return r;
	}
	
	public Map<Integer, Integer> cancel() {
		Map <Integer, Integer> map2 = new HashMap<Integer, Integer>();
		coinsInserted.put(5,  countNickels);
		coinsInserted.put(10, countDimes);
		coinsInserted.put(25, countQuarters);
		map2.putAll( coinsInserted);
	    reset();
	    return map2;
	  }
	
	private void reset() {
		timeBought = insertedSoFar = 0;
		coinsInserted.clear();
	}
}