import java.util.ArrayList;

public class Player {

	Hand hand;
	Deck deck;
	int handValue;
	int handSize = 2;
	String name;
	boolean isDealer = false;

	public Player(String name, Deck deck) {
		this.name = name;
		this.deck = deck;
		hand = new Hand(deck);
	}
	
	public void dealHand() {
		hand.dealHand();
		handValue = hand.getHandValue();
	}

	public void hit() {
		hand.dealCard();
		handValue = hand.getHandValue();	
	}

	public void stand() {
		System.out.println("Player stands.");
	}
	
	public int getHandValue() {
        return handValue;
    }
	
	public ArrayList<Card> getHand() {
		return hand.getHand();
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isBusted() {
		return handValue > 21;
	}
	
	public void setDealer(boolean isDealer) {
		this.isDealer = isDealer;
	}
	
	public boolean isDealer() {
		return isDealer;
	}
}
