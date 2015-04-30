public class DanishLinearRateStrategy extends DanishRateStrategy {
	public int calculateTime(int amount) {
		return amount * 7;
	}
}
