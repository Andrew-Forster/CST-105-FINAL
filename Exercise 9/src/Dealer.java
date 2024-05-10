import java.util.ArrayList;
import java.util.Scanner;

public class Dealer {

	Player[] players;
	Player dealer;
	int turn = 0;
	Deck deck = new Deck();

	public Dealer(Player player, Player[] players) {
		this.dealer = player;
		player.setDealer(true);
		this.players = players;
	}

	public void deal() {
		for (int i = 0; i < players.length; i++) {
			players[i].dealHand();
		}
	}

	public void play() {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < players.length; i++) {
			String borderLength = "═";
			for (int j = 0; j < players[i].getName().length(); j++) {
				borderLength += "═";
			}

			System.out.println("\n\n\n╔═════════" + borderLength + "╗");
			System.out.println("║ " + players[i].getName() + "'s turn. ║");
			System.out.println("╚═════════" + borderLength + "╝\n");

			while (!players[i].isBusted()) {
				ArrayList<Card> hand = players[i].getHand();
				int handValue = players[i].getHandValue();
				System.out.println(players[i].getName() + "'s hand dealt. Value: " + handValue);
				// Show hand & value

				deck.printCard(hand);
				if (handValue < 17 && players[i].isDealer()) {
					System.out.println("\n\nChoose an option: " 
							+ "\nNote: Dealer must hit until hand value is 17 or higher."
							+ "\n1. Hit"
							);
				} else {
					System.out.println("\n\nChoose an option: " + "\n1. Hit" + "\n2. Stand");
				}
				
				int choice = scanner.nextInt();
				if (!players[i].isDealer()) {
					if (choice == 1) {
						players[i].hit();
					} else {
						players[i].stand();
						break;
					}
				} else {
					if (handValue < 17) {
						players[i].hit();
					} else if (choice == 1) {
						players[i].hit();
					} else{
						players[i].stand();
						break;
					}
				}

			}
			if (players[i].isBusted()) {
				ArrayList<Card> hand = players[i].getHand();
				int handValue = players[i].getHandValue();
				System.out.println("[BUSTED] Value: " + handValue);
				// Show hand & value

				deck.printCard(hand);
			}

		}
//		scanner.close();
	}

	public void compareHands() {
		int dealerHandValue = dealer.getHandValue();
		System.out.println("\n\n═══════════════════\n" + "Game Over, Summary:" + "\n═══════════════════\n\n" + dealer.getName()
				+ "'s Hand [Dealer] : " + dealerHandValue);
		deck.printCard(dealer.getHand());
		for (int i = 0; i < players.length - 1; i++) {
			int playerHandValue = players[i].getHandValue();
			System.out.println("\n");
			if (playerHandValue > 21) {
				System.out.println(players[i].getName() + "'s hand: " + playerHandValue + " [Busted]");
			} else if (dealerHandValue > 21) {
				System.out.println(players[i].getName() + "'s hand: " + playerHandValue + " [WON - Dealer Busted]");
			} else if (dealerHandValue > playerHandValue) {
				System.out.println(players[i].getName() + "'s hand: " + playerHandValue + " [Lost]");
			} else if (dealerHandValue < playerHandValue) {
				System.out.println(players[i].getName() + "'s hand: " + playerHandValue + " [WON]");
			} else {
				System.out.println(players[i].getName() + "'s hand: " + playerHandValue + " [Tie]");
			}
			deck.printCard(players[i].getHand());
		}
		System.out.println("\n═══════════════════════════════\n"
					       + "Thank you for playing. Goodbye!"
						 + "\n═══════════════════════════════\n");
	}
	
	public void playGame() {
		deal();
		play();
		compareHands();
	}

	public int getTurn() {
		return turn;
	}

}
