

public class DeckTest{
	public static void main(String[] args){
		Deck myDeck = new Deck();
		int cards = myDeck.numCards();
		System.out.println("number of cards:"+cards);
		System.out.println("order before shuffling:");
		myDeck.printDeck();
		myDeck.shuffle();
		System.out.println("order after string:");
		myDeck.printDeck();
	}//end main
}//end class DeckTest
