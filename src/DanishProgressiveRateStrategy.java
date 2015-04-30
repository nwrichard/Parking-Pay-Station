public class DanishProgressiveRateStrategy extends DanishRateStrategy {
	public int calculateTime(int amount) {
		int time = 0;
		if (amount>20) {
			amount -=20;
			time=120+amount*5;
		}
		else {
			time=amount*6;
		}
		return time;
	}
}