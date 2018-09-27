/*
 * a hand holds the cards a player interacts with. hand checks for books, and returns a list of valid asks
*/
//libs
import java.util.*;

public class Hand{
	//fields
	private int[] handArray;
	private LinkedList<Integer> bookList;

	//methods
	
	//default constructor
	public Hand(){
		//init handArray
		handArray = new int[13];
		//I would init hand array like this here: handArray = new int[13];
		for(int i = 0; i < handArray.length; ++i){
			handArray[i] = 0;
		}

		//init bookList
		bookList = new LinkedList<Integer>();
	}//end Hand constructor


//findBooks searches the array for values of 4, if found it appends an element that = index+1 of array
	public void findBooks(){
		for(int i = 0; i < handArray.length; ++i){
			if(handArray[i] == 4){
				//book fond at handArray[i]
				handArray[i] = 0;
				bookList.add(i+1);
			}
		}
	}//end findBooks


//printHand prints the contents of the hand
	public void printHand(){
		for(int i = 0; i < handArray.length; ++i){
			//print the number of cards represented by the cell
			for(int j = 0; j < handArray[i]; ++j){
				//check if value is a face card or ace
				switch (i){
					case 0: //print A
						System.out.print("A ");
						break;
					case 9: //printing 10 does not need an extra space
						System.out.print("10");
						break;
					case 10://print J
						System.out.print("J ");
						break;
					case 11://print Q
						System.out.print("Q ");
						break;
					case 12://print K
						System.out.print("K ");
						break;
					default://print i+1
						int temp = i+1;
						System.out.print(temp + " ");
				}
				System.out.print(" ");
			}
		}
		System.out.println("");
	}//end printHand


//printBooks prints the rank of each book in the hand
	public void printBooks(){
		System.out.println(bookList.toString());
	}//end printBooks


//numBooks returns the number of books the hand has
	public int numBooks(){
		return bookList.size();
	}//end numBooks


//numCards returns the number of cards in a the hand
	public int numCards(){
		int sum = 0;
		for(int i = 0; i < handArray.length; ++i){
			sum += handArray[i];
		}
		return sum;
	}//end numCards


//addCard adds a card to the hand and checks for books
//returns true if addition was successful
	public Boolean addCard(int card){
		//validate card
		if(card > 13 || card < 1){
			return false;
		}else{
			int i = card-1;
			++handArray[i];
			findBooks();
			return true;
		}
	}//end addCard


//validAsks returns an array of card values that appear at least once in handArray
	public LinkedList<Integer> validAsks(){
		LinkedList<Integer> asks = new LinkedList<Integer>();
		for(int i = 0; i < handArray.length; ++i){
			if(handArray[i] != 0)
				for(int j = 0; j < handArray[i]; ++j){
					asks.add(i);
				}
		}
		return asks;
	}//end validAsks

//give removes card values from handArray and returns the number of occurences of that card value
	public int give(int card){
		int numOf = 0;
		//validate card
		if(card > 13 || card < 1){
			int i = card-1;
			numOf = handArray[i];
			handArray[i] = 0;
		}
		return numOf;
	}//end give

}//end Hand class
