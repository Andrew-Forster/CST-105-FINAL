
public class Card {

	private String suit;
	private String value;
	
	public Card(String suit, String value) {
		this.suit = suit;
		this.value = value;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public String getValue() {
		return value;
	}
	
	 public String getSuitSymbol() {
	        switch (this.suit) {
	            case "Spades":
	                return "\u2660"; // Unicode for Spade
	            case "Hearts":
	                return "\u2665"; // Unicode for Heart
	            case "Diamonds":
	                return "\u2666"; // Unicode for Diamond
	            case "Clubs":
	                return "\u2663"; // Unicode for Club
	            default:
	                return "?"; // Unknown suit
	        }
	    }
	
}
