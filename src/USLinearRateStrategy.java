public class USLinearRateStrategy extends USRateStrategy {
	public int calculateTime(int amount){
		return amount * 2 / 5;
	}
}