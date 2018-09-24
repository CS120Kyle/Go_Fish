/*a Deck contains 52 cards (1-13)x4 at the start of the game. 
 *TODO
 hands are arrays not linked lists
 */

//imports
import java.util.*;
import java.lang.Math;
public class Deck{

//fields
	private  LinkedList<Integer> cardList;


//default constructor
//creates a 52 card deck
public Deck(){
	//init cardList
	cardList = new LinkedList<Integer>();
	//generate 52 cards
	for(int suit = 0; suit < 4; suit++){
		for(int rank = 1; rank <=13; rank++){
			//appends rank calue to cardList
			cardList.add(rank);
		}
	}
}


//methods

//printDeck
//no arguments needed
//returns nothing
	public void printDeck(){
		System.out.println(cardList.toString());
	}


//Shuffles cardList
//no arguments needed
//returns nothing
	public void shuffle(){
		LinkedList<Integer> tempList = new LinkedList<Integer>();
	   	Random rand = new Random();	
		int randElement;
		while(cardList.size() > 0){
			randElement = rand.nextInt(cardList.size());
			tempList.push(cardList.remove(randElement));
		}
		cardList = tempList;
	}


//dealHands deals 7 cards each to 2 LinkedLists passed in
//requires 2 hand arrays be passed in
//returns nothing
	public void dealHands(int[] hand1, int[] hand2){
		//check if deck contains at least 14 cards
		if(numCards() >=14){

			//deal 7 cards to each hand
			for(int i = 0; i < 7; ++i){
				hand1[cardList.pop()-1]++;
				hand2[cardList.pop()-1]++;
			}
		}
	}	



//pickup removes top card from the deck and appends it to a list passed in
//requires a hand array be passed in to add card to
//returns card value if successful, otherwise returns 0
	public int pickup(int[] hand){
		int card = 0;
		if(numCards() > 0){
			card = cardList.pop();
			hand[card-1]++;
		}
		return card;
	}


//numCards returns the number of cards in cardList
//no arguments needed
//returns number of cards in the deck
	public int numCards(){
		return cardList.size();
	}
}
