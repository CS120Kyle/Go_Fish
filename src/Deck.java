/*a Deck contains 52 cards (1-13)x4 at the start of the game. 
 *
 */

//imports
import java.util.*;
import java.lang.Math;
public class Deck{
//fields
	public LinkedList<Integer> cardList;

//constructor
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


//Deal hands. if deck does not contain at least 14 cards, return 0
//should pass list by reference? If it does not work, pass back list of 14 cards
	public void dealHands(LinkedList<Integer> hand1, LinkedList<Integer> hand2){
		//check if deck contains at least 14 cards
		if(numCards() >=14){

			//deal 7 cards to each hand
			for(int i = 0; i < 7; ++i){
				hand1.add(cardList.pop());
				hand2.add(cardList.pop());
			}
		}
	}	


//pick up one card from the top of the deck. If deck is empty, return 0
	public int pickup(){
		int card = 0;
		if(numCards() > 0){
			card = cardList.pop();
		}
		return card;
	}


//numCards
//returns number of cards in the deck
	public int numCards(){
		return cardList.size();
	}
}
