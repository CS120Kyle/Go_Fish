import java.util.*;

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

		//test dealHands and pickup
		LinkedList<Integer> hand1 = new LinkedList<Integer>();
		LinkedList<Integer> hand2 = new LinkedList<Integer>();
		System.out.println("hand1 before dealHands:" + hand1.toString());
		System.out.println("hand2 before dealHands:" + hand2.toString());
		myDeck.dealHands(hand1, hand2);
		System.out.println("hand1 after dealHands:" + hand1.toString());
		System.out.println("hand2 after dealHands:" + hand2.toString());
		System.out.println(myDeck.numCards());
	}//end main
}//end class DeckTest
