/*
 * a hand holds the cards a player interacts with. hand checks for books, and returns a list of valid asks
*/
//libs
import java.util.*

public class Hand{
	//fields
	int[13] hand;//
	LinkedList<Integer> bookList;
	//methods
	
	//default constructor
	public void Hand(){
		for(int i = 0; i < 13; ++i){
			hand[i] = 0;
		}
	}

}//end Hand class
