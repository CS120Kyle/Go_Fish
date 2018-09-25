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
	public void Hand(){
		//init handArray
		handArray = new int[13];
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
				bookList.push(i+1);
				found = true;
			}
		}
		return found;
	}//end findBooks


//setHand sets handArray to an array passed in
//requires an array of length 13 to be passed in
//returns true if inArr is the same length as handArray
	public Boolean setHand(int[] inArr){
		if(inArr.length == handArray.length){
			for(int i = 0; i < handArray.length; ++i){
				handArray[i] = inArr[i];
			}
			return true;
		}else{
			return false;
		}
	}//end setHand


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
						System.out.print("A");
						break;
					case 10://print J
						System.out.print("J");
						break;
					case 11://print Q
						System.out.print("Q");
						break;
					case 12://print K
						System.out.print("K");
					default://print i+1
						int temp = i+1;
						System.out.print(temp);
				}
				System.out.print(" ");
			}
		}
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

}//end Hand class
