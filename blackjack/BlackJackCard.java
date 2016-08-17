package blackjack;

public class BlackJackCard extends Card{
	
	public BlackJackCard(int value, Suit suit) {
		super(value, suit);
	}
	@Override
	public int[] value() {
		if (value > 1) {
			return new int[] {1, 11};
		} else {
			return new int[] {Math.min(value, 10)};
		}
	}
}
