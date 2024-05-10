import java.util.ArrayList;

public class Deck {

	String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
	String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	
	Card[] cards = new Card[52];
	
	int shuffleIterations = 1000;
	int currentCardIndex = 0;
	
	public Deck() {
		int index = 0;
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < values.length; j++) {
				cards[index] = new Card(suits[i], values[j]);
				index++;
			}
		}
	}
	
	public void shuffle() {
		currentCardIndex = 0;
		System.out.println("Shuffling deck...");
		for (int i = 0; i < shuffleIterations; i++) {
			int randomIndex1 = (int) (Math.random() * 52);
			int randomIndex2 = (int) (Math.random() * 52);
			Card temp = cards[randomIndex1];
			cards[randomIndex1] = cards[randomIndex2];
			cards[randomIndex2] = temp;
		}
		System.out.println("Deck shuffled.");
	}
	
	public Card dealCard() {
		if (currentCardIndex < 52) {
			return cards[currentCardIndex++];
		} else {
			System.out.println("Deck is empty. Reshuffling..");
			shuffle();

			return cards[currentCardIndex++];
		}
	}
	
	public Card[] getCards() {
		return cards;
	}
	
	public int getCurrentCardIndex() {
		return currentCardIndex;
	}
	
	public void setCurrentCardIndex(int currentCardIndex) {
		this.currentCardIndex = currentCardIndex;
	}
	
	public void printCard(ArrayList<Card> cards) {
		String topBorder = "╔═════╗";
		String bottomBorder = "╚═════╝";
		String space = "║     ║";

		int numCards = cards.size();
		int groups = (int) Math.ceil((double) numCards / 5);

		for (int group = 0; group < groups; group++) {

			System.out.println();
			for (int j = group * 5; j < Math.min(group * 5 + 5, cards.size()); j++) {
				System.out.print(topBorder);
			}
			System.out.println();
			for (int j = group * 5; j < Math.min(group * 5 + 5, cards.size()); j++) {
				String valueRight = String.format("║%2s   ║", cards.get(j).getValue());
				System.out.print(valueRight);
			}
			System.out.println();
			for (int j = group * 5; j < Math.min(group * 5 + 5, cards.size()); j++) {
				String suit = "║  " + cards.get(j).getSuitSymbol() + "  ║";
				System.out.print(suit);
			}
			System.out.println();
			for (int j = group * 5; j < Math.min(group * 5 + 5, cards.size()); j++) {
				String valueLeft = String.format("║   %-2s║", cards.get(j).getValue());
				System.out.print(valueLeft);
			}
			System.out.println();
			for (int j = group * 5; j < Math.min(group * 5 + 5, cards.size()); j++) {
				System.out.print(space);
			}
			System.out.println();
			for (int j = group * 5; j < Math.min(group * 5 + 5, cards.size()); j++) {
				System.out.print(bottomBorder);
			}
			System.out.println();

		}
	}
	
}
