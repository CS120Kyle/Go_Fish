/*
 *TODO
 hands are arrays not linkedLists
 */
import java.util.*;

public class DeckTest{
	public static void main(String[] args){
		Deck myDeck = new Deck();
		int cards = myDeck.numCards();
		System.out.println("number of cards:"+cards);
		System.out.println("order before shuffling:");
		myDeck.printDeck();
		myDeck.shuffle();
		System.out.println("order after shuffling:");
		myDeck.printDeck();

		//test dealHands and pickup
		int[] hand1 = new int[13];
		int[] hand2 = new int[13];
		System.out.println("hand1 before dealHands:");
		printer(hand1);
		System.out.println("hand2 before dealHands:");
		printer(hand2);
		myDeck.dealHands(hand1, hand2);
		System.out.println("hand1 after dealHands:");
		printer(hand1);
		System.out.println("hand2 after dealHands:");
		printer(hand2);
		System.out.println(myDeck.numCards());

		//testing pickup
		int theCard = (myDeck.pickup(hand1));
		System.out.println("hand1 picked up a " + theCard);
		printer(hand1);
		myDeck.printDeck();
	}//end main

	//prints an array
	private static void printer(int[] arr){
		int cardVal;
		for(int i = 0; i < arr.length; ++i){
			cardVal = i+1;
			System.out.println("Number of " + cardVal + "'s: " + arr[i]);
		}
	}
}//end class DeckTest
