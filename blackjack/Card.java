package blackjack;

public class Card {
	protected final int value;
	protected final Suit suit;
	public Card(int value, Suit suit) {
		this.value = value;
		this.suit = suit;
	}
	
//	public int value() {
//		return value;
//	}
	public int[] value() {
		return new int[] {value};
	}
	public Suit suit() {
		return suit;
	}
}
