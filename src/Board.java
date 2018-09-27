/*Board contains 2 hands and a deck
 * deals cards
 * chooses turns
 */

public class Board{
	//fields
	Hand playerhand;
	Hand compHand;
	Deck d;
	int turnCount = 0;
	//playerClass player;
	//playerClass computer;
	
	//default constructor
	public Board(){
		//intits
		//playerClass player = new PlayerClass()
		//playerClass computer = new PlayerClass()
		playerHand = new Hand();
		compHand = new Hand();
		d = new Deck();
		//shuffle deck and deal hands
		d.shuffle();
		for(int i = 0; i < 13; ++i){
			playerHand.addCard(d.getCard());
			compHand.addCard(d.getCard());
		}
	}//end Board constructor

	//methods
	
	

}//end Board class
