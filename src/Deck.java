/*a Deck contains 52 cards (1-13)x4 at the start of the game. 
 *
 */

//imports
import java.util.*;
import java.lang.Math;
class Deck{
//fields
	LinkedList cardList = new LinkedList<int>();
//constructor
public Deck(){
	//generate 52 cards
	for(int suit = 0; suit < 4; suit++){
		for(int rank = 1; rank <=13; rank++){
			//appends rank calue to cardList
			cardlist.add(rank);
		}
	}
}
//methods

//Shuffle
	public void shuffle(){
		LinkedList tempList = new LinkedList<int>(); 
	}

//Deal hands. if deck does not contain at least 14 cards, return 0
//should pass list by reference? If it does not work, pass back list of 14 cards
	public void dealHands(LinkedList<int> hand1, LinkedList<int> hand2){
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

//return number of cards in the deck
	public int numCards(){
		return cardList.size();
	}
}
