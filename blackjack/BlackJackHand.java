package blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackJackHand extends Hand {

//	private int[] getScore(Card c) {
//		if (c.value() > 1) {
//			return new int[] { Math.min(c.value(), 10) };
//		}
//		return new int[] { 1, 11 };
//	}

	private List<Integer> possibleScore() {
		List<Integer> scores = new ArrayList<>();
		for (Card card : hand) {
			updateScore(card, scores);
		}
		return scores;
	}

//	private void updateScore(Card card, List<Integer> scores) {
//		if (scores.isEmpty()) {
//			for (int score : getScore(card)) {
//				scores.add(score);
//			}
//		} else {
//			int length = scores.size();
//			for (int i = 0; i < length; i++) {
//				int old = scores.get(i);
//				int[] values = getScore(card);
//				scores.set(i, old + values[0]);
//				for (int j = 1; j < values.length; j++) {
//					scores.add(old + values[j]);
//				}
//			}
//		}
//	}
	
	private void updateScore(Card card, List<Integer> scores) {
		if (scores.isEmpty()) {
			for (int score : card.value()) {
				scores.add(score);
			}
		} else {
			int length = scores.size();
			for (int i = 0; i < length; i++) {
				int old = scores.get(i);
				int[] values = card.value();
				scores.set(i, old + values[0]);
				for (int j = 1; j < values.length; j++) {
					scores.add(old + values[j]);
				}
			}
		}
	}

	@Override
	public int score() {
		// TODO Auto-generated method stub
		List<Integer> scores = possibleScore();
		int maxUnder = Integer.MIN_VALUE;
		int minOver = Integer.MAX_VALUE;
		for (Integer score : scores) {
			if (score > 21) {
				minOver = Math.min(minOver, score);
			} else {
				maxUnder = Math.max(maxUnder, score);
			}
		}
		return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
	}
	
	public boolean is21() {
		return score() == 21;
	}
	
	public boolean busted() {
		return score() > 21;
	}
	
	public boolean isBlackJack() {
		if (size() != 2) {
			return false;
		} 
		Card first = hand.get(0);
		Card second = hand.get(1);
		return (isAce(first) && isFace(second)) || (isAce(second) && isFace(first));
	}
//	private boolean isAce(Card c) {
//		return (c.value() == 1);
//	}
//	private boolean isFace(Card c) {
//		return (c.value() > 10 && c.value() <= 13);
//	}
	
	private boolean isAce(Card c) {
		return (c.value()[0] == 1);
	}
	private boolean isFace(Card c) {
		return (c.value()[0] > 10 && c.value()[0] <= 13);
	}

}
