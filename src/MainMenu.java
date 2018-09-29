import java.util.*;


public class MainMenu {

	public static void main(String[] args) {
		boolean playGame = true;
		Deck pubDeck = new Deck();
		Hand myHand = new Hand();
		Hand opHand = new Hand();
		double difficulty = 1;
		Scanner read = new Scanner(System.in);
		
		 while(true){
			 //Init menu
			int menuI = Menu();
			if (menuI == -1){
				System.out.println("Quitting game");
				playGame = false;
				break;
			} else if(menuI == 1){
				System.out.println("Starting game with standard difficulty");
				difficulty = 1;
				break;
			} else if (menuI == 2){
				System.out.println("Starting game with hard difficulty");
				difficulty = .75;
				break;
			}
		 }
		 
		
		if (playGame){	 
			 //Deal deck
			firstDeal(pubDeck, myHand, opHand);
			
			//System.out.print("Your hand:	");
			//myHand.printHand();
			opHand.printHand();
			//game loop
			while (pubDeck.numCards() > 0){
				
				
				playerTurn(myHand, opHand, pubDeck, difficulty);
				//System.out.println(willLie(difficulty));
					
				//playerTurn(myHand, opHand, pubDeck, difficulty);
				//myHand.printHand();
				//myHand.printBooks();
			}
			System.out.println("game over");	
		 }		
	}//end main

	
	
	
	
	public static int Menu(){
	
		Scanner menuRead = new Scanner(System.in);
		
		System.out.println("Welcome to Go Fish!");
		System.out.println("Created by X for CS 205");
		while(true){
			System.out.println("Menu Controls:: press D to chose difficulty:: press P to play game (Standard difficulty):: press Q to quit:: 	");
			String menu01 = menuRead.nextLine();
			if (menu01.equals("Q") || menu01.equals("q")){
				return -1;
				
			} else if (menu01.equals("P")|| menu01.equals("p")){
				return 1;
			} else if (menu01.equals("D")|| menu01.equals("d")){
			
				System.out.println("Choose Difficulty:: press 1 for easy:: press 2 for hard");
				int menu02 = menuRead.nextInt();
				if (menu02 == 1){ 
					return 1;
				} else if(menu02 == 2){
					return 2;
				} 
			
			} 
			System.out.println("Incorrect command");
		}
	}//end Menu

	//function allows player to choose cards from their hand and returns an int of the card;
	public static int handControl(Hand playerHand){
		Scanner s = new Scanner(System.in);
		//int numList[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		//add if (13 or king, 1 or a, so that it works correctly)
		System.out.print("player's hand:  ");
		playerHand.printHand();
		System.out.println("Choose Card: ");
		String choice = s.nextLine();
		if(choice.equals("a") || choice.equals("A")) {
			if (playerHand.inHand(1)){
				return 1;
			} else {
				System.out.println("You can't ask for that card, it isnt in your hand.");
			}
			
		} else if(choice.equals("2") ) {
			if (playerHand.inHand(2)){
				return 2;
			}  else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}
			
		} else if(choice.equals("3") ) {
			if (playerHand.inHand(3)){
				return 3;
			}  else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}
		} else if(choice.equals("4") ) {
				if (playerHand.inHand(4)){
					return 4;
				} else {
					System.out.println("You cant ask for that card, it isnt in your hand.");
				}
		} else if(choice.equals("5") ) {
			if (playerHand.inHand(5)){
				return 5;
			} else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}
		} else if(choice.equals("4") ) {
			if (playerHand.inHand(4)){
				return 4;
			} else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}
		} else if(choice.equals("5") ) {
			if (playerHand.inHand(5)){
				return 5;
			} else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}
		} else if(choice.equals("6") ) {
			if (playerHand.inHand(6)){
				return 6;
			} else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}
		} else if(choice.equals("7") ) {
			if (playerHand.inHand(7)){
				return 7;
			} else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}	
		} else if(choice.equals("8") ) {
			if (playerHand.inHand(8)){
				return 8;
			} else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}
		} else if(choice.equals("9") ) {
			if (playerHand.inHand(9)){
				return 9;
			} else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}
		} else if(choice.equals("10") ) {
			if (playerHand.inHand(10)){
				return 10;
			} else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}	
		
		} else if(choice.equals("j") || choice.equals("J")) {
			if (playerHand.inHand(11)){
				return 11;
			} else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}
		} else if(choice.equals("q") || choice.equals("q")) {
			if (playerHand.inHand(12)){
				return 12;
			} else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}
		} else if(choice.equals("K") || choice.equals("k")) {
			if (playerHand.inHand(13)){
				return 13;
			} else {
				System.out.println("You can't ask for that card, it isn't in your hand.");
			}
		}else{
			System.out.println("Not a valid choice");
		}
		return -1;
		
	}
	public static boolean willLie(double difficulty){
		Random r = new Random();
		double x = r.nextDouble();
		if (x > difficulty){
			return true;
			
		} else {
			return false;
		}
		
	}
	public static void playerTurn(Hand playerHand, Hand opHand, Deck mainDeck, double difficulty){
		boolean opHasCard = false;
		System.out.println("Players turn");
		int i = -1;
		while (i == -1){
			i = handControl(playerHand);
		}
		//System.out.println("out of the loop");
		if(opHand.inHand(i)){
			opHasCard = true;
			System.out.println("op has card");
		}else{
			System.out.println("op does not have card");
		}
		
		//choose card from players hand and check if op has card
		//if op has card and does not lie, it will give card
		if (opHasCard && !willLie(difficulty)){
			int x = opHand.give(i);
			System.out.println("op has " + x + " " + i + "'s");
			for (int j = 0;  j < x; j++){
				if(playerHand.addCard(i)){
					System.out.println("made a book with card from ops hand");
				}
			}
			
		}  else {
		//if op doesnt have card
		//TODO
		//should get extra turn for correct picked up card
			if(playerHand.addCard(mainDeck.getCard())){
				System.out.println("made a book with a card from the deck");
			}
		}
		
	}
	public static void opTurn(Hand opHand, Hand playerHand, Deck mainDeck){
		System.out.println("Oponents turn");
		opHand.printHand();
		//choose random card
		//oponent has memory add guessed cards to an array, if there arent any valid guesses ignore list 
		
	}
	public static void firstDeal(Deck d, Hand h1, Hand h2){
		d.shuffle();
		for (int i = 0; i < 7; i++){
			h1.addCard(d.getCard());
			h2.addCard(d.getCard());
			
			}
			
	}
}

