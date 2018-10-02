/*a Deck contains 52 cards (1-13)x4 at the start of the game.
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
	}//end Deck constructor


//methods

//printDeck
//no args needed
//returns nothing
	public void printDeck(){
		System.out.println(cardList.toString());
	}//end printDeck


//Shuffles cardList
//no args needed
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
	}//end shuffle
 


//getCard removes top card from the deck and returns it 
//no reqs needed
//returns card value if successful, otherwise returns 0
	public int getCard(){
		int card = 0;
		if(numCards() > 0){
			card = cardList.pop();
		}
		return card;
	}//end getCard


//numCards returns the number of cards in cardList
//no args needed
//returns number of cards in the deck
	public int numCards(){
		return cardList.size();
	}//end numCards




}//end Deck class
