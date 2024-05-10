import java.util.ArrayList;
import java.util.Scanner;

public class MainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Deck deck = new Deck();
//		deck.shuffle();

		System.out.println("Welcome to the card dealer!" + "\nThe deck has been shuffled. Let's deal some cards."
				+ "\nChoose an option: " + "\n1. Start a Blackjack game" + "\n2. Deal a card"
				+ "\n3. Reshuffle the deck" + "\n4. Exit");

		Scanner scanner = new Scanner(System.in);
		int choice;

		while (true) {
			System.out.print("Enter your choice: ");
			String choiceStr = scanner.nextLine();
			try {
				choice = Integer.parseInt(choiceStr);
				run(scanner, choice, deck);
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				continue;
			}

		}
	}

	public static void run(Scanner scanner, int choice, Deck deck) {
		switch (choice) {
		case 1:
			System.out.print("Starting a Blackjack game..." + "\nPlease enter all player names with "
					+ "\nthe dealer being the last player: \n");
			String players = scanner.nextLine().trim();
			String[] playerNames = players.split(" ");

			while (!validSyntax(playerNames)) {
				players = scanner.nextLine();
				playerNames = players.split(" ");
			}
			Player[] playerArr = new Player[playerNames.length];
			for (int i = 0; i < playerNames.length; i++) {
				Player player = new Player(playerNames[i], deck);
				playerArr[i] = player;
			}
			Dealer dealer = new Dealer(playerArr[playerArr.length - 1], playerArr);
			dealer.playGame();
			break;

		case 2:
			System.out.println(
					"Choose how many cards you want to deal: " + "\nNote: Maximum 52 cards can be dealt at a time.");
			int numCards = scanner.nextInt();
			if (numCards > 52) {
				System.out.println("Invalid number of cards. Please choose again.");
				break;
			}
			dealCards(deck, numCards);

			break;
		case 3:
			deck.shuffle();
			break;
		case 4:
			System.out.println("Thank you for playing. Goodbye!");
			scanner.close();
			System.exit(0);
		default:
			System.out.println("Invalid choice. Please choose again.");
			break;
		}

		System.out.println("\n\nContinue playing? Choose an option: " + "\n1. Start a Blackjack game"
				+ "\n2. Deal a card" + "\n3. Reshuffle the deck" + "\n4. Exit");
	}

	public static void dealCards(Deck deck, int numCards) {

		ArrayList<Card> cards = new ArrayList<Card>();
		for (int i = 0; i < numCards; i++) {
			cards.add(deck.dealCard());
		}
		
		deck.printCard(cards);

	}

	public static boolean validSyntax(String input[]) {
		if (input.length < 2) {
			System.out.println("Please enter at least 2 player names.");
			return false;
		}
		if (input.length > 6) {
			System.out.println("Maximum number of players is 6. Please enter fewer player names.");
			return false;
		}
		return true;
	}

}
