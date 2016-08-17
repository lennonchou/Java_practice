package blackjack;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected final List<Card> hand = new ArrayList<>();
	
	public abstract int score();
	
	public void addCards(Card[] cards) {
		for (int i = 0; i < cards.length; i++) {
			hand.add(cards[i]);
		}
	}
	
	public int size() {
		return hand.size();
	}
	
//	public void print() {
//		for (Card c : hand) {
//			System.out.print(c.suit().toString() + " " + c.value() + ",");
//		}
//	}
	public void print() {
		for (Card c : hand) {
			System.out.print(c.suit().toString() + " " + c.value()[0] + ",");
		}
	}
}
