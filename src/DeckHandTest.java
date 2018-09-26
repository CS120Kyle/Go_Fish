import java.util.*;

public class DeckHandTest{
	public static void main(String[] args){
		//init hands and deck
		Deck myDeck = new Deck();
		Hand myHand = new Hand();
		
		myDeck.shuffle();
		
		/*
		//deal 7 cards to each hand. what dealHands did from Deck
		for(int i = 0; i < 7; ++i){
			myHand.addCard(myDeck.getCard());
		}
		*/
		while(myDeck.numCards() > 0){
			System.out.println("hit me, I have " + myHand.numCards() + " cards");
			myHand.addCard(myDeck.getCard());
			myHand.printHand();
		}

		myHand.printBooks();
		System.out.println("there are " + myHand.numBooks() + " books in the hand");


	}



}//end DeckHandTest
