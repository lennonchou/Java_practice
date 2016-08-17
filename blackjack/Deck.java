package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
	private final Random random = new Random();
	
	private final List<Card> cards = new ArrayList<>();
	private int dealtIndex = 0;
	
	public Deck() {
		for (int i = 1; i <= 13; i++) {
			for (Suit suit : Suit.values()) {
				cards.add(new Card(i, suit));
			}
		}
	}
	
	public void shuffle() {
		for (int i = cards.size() - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			Card c1 = cards.get(i);
			Card c2 = cards.get(j);
			cards.set(i, c2);
			cards.set(j, c1);
		}
	}
	
	private int remaining() {
		return cards.size() - dealtIndex;
	}
	
	public Card[] dealHand(int number) {
		if (remaining() < number) {
			return null;
		}
		Card[] cards = new Card[number];
		for (int i = 0; i < number; i++) {
			cards[i] = dealCard();
		}
		return cards;
	}
	
	Card dealCard() {
		return remaining() == 0 ? null : cards.get(dealtIndex++);
	}
}
