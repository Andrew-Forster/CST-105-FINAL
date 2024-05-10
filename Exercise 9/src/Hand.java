import java.util.ArrayList;

public class Hand {
	int currentCardIndex;
	Deck deck;
	ArrayList<Card> hand = new ArrayList<Card>();
	int handSize = 2; // Starting hand size for each player
	Card[] cards;
	
	public Hand(Deck deck) {
		this.deck = deck;
		cards = deck.getCards();
		currentCardIndex = deck.getCurrentCardIndex();
	}
	
	public ArrayList<Card> dealHand() {
		currentCardIndex = deck.getCurrentCardIndex();
		for (int i = 0; i < handSize; i++) {
			if (currentCardIndex < 52) {
				hand.add(cards[currentCardIndex++]);
            } else {
                System.out.println("Deck is empty. Reshuffling..");
                deck.shuffle();
                
                hand.add(cards[currentCardIndex++]);
            }
		}
		deck.setCurrentCardIndex(currentCardIndex);
		return hand;
	}
	
	public ArrayList<Card> dealCard() {
		currentCardIndex = deck.getCurrentCardIndex();
		if (currentCardIndex < 52) {
			hand.add(cards[currentCardIndex++]);
		} else {
			System.out.println("Deck is empty. Reshuffling..");
			deck.shuffle();
			hand.add(cards[currentCardIndex++]);
		}
		deck.setCurrentCardIndex(currentCardIndex);
		return hand;
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	public void setCards(Card[] cards) {
		this.cards = cards;
	}
	
	
	public int getHandValue() {
		int handValue = 0;
		int aceCount = 0;
		for (int i = 0; i < hand.size(); i++) {
			String value = hand.get(i).getValue();
			if (value.equals("J") || value.equals("Q") || value.equals("K")) {
				handValue += 10;
			} else if (value.equals("A")) {
				handValue += 11;
				aceCount++;
			} else {
				handValue += Integer.parseInt(value);
			}
			
			if (handValue > 21 && aceCount > 0) {
				handValue -= 10;
				aceCount--;
			}
		}
		return handValue;
	}
	
	
	
}
