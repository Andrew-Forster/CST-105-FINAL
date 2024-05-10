import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnitTest {
	
	Deck deck = new Deck();
	Hand hand = new Hand(deck);
	
	
	
	@Test
	void testHandValue() {
		hand.dealHand();
		assertEquals(5, hand.getHandValue());
	}

}
