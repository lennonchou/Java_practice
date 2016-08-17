package blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackJackManager {
	private Deck deck;
	private BlackJackHand[] hands;
	private static int HIT_UNTIL = 16;
	
	public BlackJackManager(int numPlayers) {
		hands = new BlackJackHand[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
			hands[i] = new BlackJackHand();
		}
		initialDeck();
	}
	public void initialDeck() {
		deck = new Deck();
		deck.shuffle();
	}
	
	public boolean dealInitial() {
		for (Hand hand : hands) {
			Card[] cards = deck.dealHand(2);
			if (cards == null) {
				return false;
			}
			hand.addCards(cards);
		}
		return true;
	}
	
	public List<Integer> getBlackJacks() {
		List<Integer> blackJacks = new ArrayList<>();
		for (int i = 0; i < hands.length; i++) {
			if (hands[i].isBlackJack()) {
				blackJacks.add(i);
			}
		}
		return blackJacks;
	}
	
	private boolean playHand(BlackJackHand hand) {
		while (hand.score() < HIT_UNTIL) {
			Card c = deck.dealCard();
			if (c == null) {
				return false;
			}
			hand.addCards(new Card[] {c});
		}
		return true;
	}
	
	public boolean playAllHand() {
		for (BlackJackHand hand : hands) {
			if (!playHand(hand)) {
				return false;
			}
		}
		return true;
	}
	
	public List<Integer> getWinners() {
		List<Integer> winners = new ArrayList<>();
		int winningScore = 0;
		for (int i = 0; i < hands.length; i++) {
			BlackJackHand hand = hands[i];
			if (!hand.busted()) {
				if (hand.score() > winningScore) {
					winningScore = hand.score();
					winners.clear();
					winners.add(i);
				} else if (hand.score() == winningScore) {
					winners.add(i);
				}
			}
		}
		return winners;
	}
	
	public void printHandsAndScores() {
		for (int i = 0; i < hands.length; i++) {
			System.out.print("Hand" + i + "(" + hands[i].score() + "):");
			hands[i].print();
			System.out.println();
		}
	}
	
	private static void run(int playerNum) {
		BlackJackManager game = new BlackJackManager(playerNum);
		boolean success = game.dealInitial();
		if (!success) {
			System.out.println("Error, out of cards!");
		} else {
			System.out.println("\n-- Initial --");
			game.printHandsAndScores();
			List<Integer> blackJacks = game.getBlackJacks();
			if (blackJacks.size() > 0) {
				System.out.print("Black Jack at ");
				for (int i : blackJacks) {
					System.out.print(i + ",");
				}
				System.out.println();
			} else {
				success = game.playAllHand();
				if (!success) {
					System.out.println("Error, out of cards!");
				} else {
					System.out.println("--Complete game --");
					game.printHandsAndScores();
					List<Integer> winners = game.getWinners();
					if (winners.size() > 0) {
						System.out.print("Winner at ");
						for (int i : winners) {
							System.out.print(i + ",");
						}
					} else {
						System.out.println("All busted!");
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		run(4);
		run(5);
	}
}
