/*
 * a hand holds the cards a player interacts with. hand checks for books, and returns a list of valid asks
*/
//libs
import java.util.*;

public class Hand{
	//fields
	//I cannot init handArray in constructor so it must be done here. why?
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
//no arguments needed
//returns true if at least 1 deck is found, otherwise returns false
	public Boolean findBooks(){
		Boolean found = false;
		for(int i = 0; i < handArray.length; ++i){
			if(handArray[i] == 4){
				//book fond at handArray[i]
				handArray[i] = 0;
				bookList.add(i+1);
				found = true;
			}
		}
		return found;
	}//end findBooks


//printHand prints the contents of the hand
//no arguments needed
//returns nothing
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
//no args needed
//returns nothing
	public void printBooks(){
		System.out.println(bookList.toString());
	}//end printBooks


//numBooks returns the number of books the hand has
//no args needed
//returns number of cards in the book
	public int numBooks(){
		return bookList.size();
	}//end numBooks


//numCards returns the number of cards in a the hand
//no args
//returns and int
	public int numCards(){
		int sum = 0;
		for(int i = 0; i < handArray.length; ++i){
			sum += handArray[i];
		}
		return sum;
	}//end numCards


//addCard adds a card to the hand and checks for books
//requires and int 
//returns true if addition was successful
	public Boolean addCard(int card){
		int i  = card-1;
		if(i > 13 || i < 0){
			return false;
		}else{
			++handArray[i];
			findBooks();
			return true;
		}
	}//end addCard

}//end Hand class
