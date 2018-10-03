import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class MainMenu {

	public static void main(String[] args) {
		
		boolean playGame = true;
		boolean memory = false;
		Deck pubDeck = new Deck();
		Hand myHand = new Hand();
		Hand opHand = new Hand();
		double difficulty = 1;
		LinkedList<Integer> opMemory = new LinkedList<Integer>(); 
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
				memory = true;
				difficulty = .75;
				break;
			}
		 }
		 
		
		if (playGame){	 
			 //Deal deck
			firstDeal(pubDeck, myHand, opHand);
			
			int numBooks = 0;
			//determine turn order
			int turn;
			Random r = new Random();
			double turnSeed = r.nextDouble();
			if(turnSeed > 0.5){
				turn = 1;
			}else{
				turn = 0;
			}
			//game loop
			while (numBooks < 13){
				
				if(turn%2 == 0){
					//player turn
					playerTurn(myHand, opHand, pubDeck, difficulty);
				}else{
					//comp turn
					opTurn(opHand, myHand, pubDeck, memory, opMemory);
					//System.out.println(opMemory.toString());
				}
				//System.out.println(willLie(difficulty));
				//myHand.printHand();
				//myHand.printBooks();
				numBooks = myHand.numBooks() + opHand.numBooks();
				++turn;
			}
			//game is over. print results
			System.out.println("-----Game Over-----");
			System.out.println("player score:\t" + myHand.numBooks());
			System.out.println("computer score:\t" + opHand.numBooks());
			logFinalScore(myHand, opHand);
			
		 }
		 
	}//end main


	
	
	
	
	public static int Menu(){
	
		Scanner menuRead = new Scanner(System.in);
		
		System.out.println("Welcome to Go Fish!");
		System.out.println("Created by Liam, Kyle, Andrew and Andrew for CS 205");
		while(true){

		System.out.println("Menu Controls:: press D to choose difficulty:: press P to play game (Standard difficulty):: press Q to quit:: 	");
		String menu01 = menuRead.nextLine();
		if (menu01.equals("Q") || menu01.equals("q")){
			return -1;
				
		} else if (menu01.equals("P")|| menu01.equals("p")){
			return 1;
		} else if (menu01.equals("D")|| menu01.equals("d")){
			int menu02 = 0;
			while(true) {
			System.out.println("Choose Difficulty:: press 1 for easy:: press 2 for hard");
			try{
				menu02 = menuRead.nextInt();
			}
			catch (Exception e){
				System.out.println("Invalid entry, try again!");
				menuRead.next();
			}
			if (menu02 == 1){
				return 1;
			} else if(menu02 == 2){
				return 2;
			} 
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
				System.out.println("Do you have any Aces?");
				return 1;
			} else {
				System.out.println("You can't ask for that card, it isnt in your hand.");
			}
			
		} else if(choice.equals("2") ) {
			if (playerHand.inHand(2)){
				System.out.println("Do you have any Twos?");
				return 2;
			}  else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}
			
		} else if(choice.equals("3") ) {
			if (playerHand.inHand(3)){
				System.out.println("Do you have any Threes?");
				return 3;
			}  else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}
		} else if(choice.equals("4") ) {
				if (playerHand.inHand(4)){
					System.out.println("Do you have any Fours?");
					return 4;
				} else {
					System.out.println("You cant ask for that card, it isnt in your hand.");
				}
		} else if(choice.equals("5") ) {
			if (playerHand.inHand(5)){
				System.out.println("Do you have any Fives?");
				return 5;
			} else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}
		} else if(choice.equals("6") ) {
			if (playerHand.inHand(6)){
				System.out.println("Do you have any Sixes?");
				return 6;
			} else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}
		} else if(choice.equals("7") ) {
			if (playerHand.inHand(7)){
				System.out.println("Do you have any Sevens?");
				return 7;
			} else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}	
		} else if(choice.equals("8") ) {
			if (playerHand.inHand(8)){
				System.out.println("Do you have any Eights?");
				return 8;
			} else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}
		} else if(choice.equals("9") ) {
			if (playerHand.inHand(9)){
				System.out.println("Do you have any Nines?");
				return 9;
			} else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}
		} else if(choice.equals("10") ) {
			if (playerHand.inHand(10)){
				System.out.println("Do you have any Tens?");
				return 10;
			} else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}	
		
		} else if(choice.equals("j") || choice.equals("J")) {
			if (playerHand.inHand(11)){
				System.out.println("Do you have any Jacks?");
				return 11;
			} else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}
		} else if(choice.equals("q") || choice.equals("q")) {
			if (playerHand.inHand(12)){
				System.out.println("Do you have any Queens?");
				return 12;
			} else {
				System.out.println("You cant ask for that card, it isnt in your hand.");
			}
		} else if(choice.equals("K") || choice.equals("k")) {
			if (playerHand.inHand(13)){
				System.out.println("Do you have any Kings?");
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

	//TODO
	//needs to check if player has at least 1 card before continuing their turn, othersiwe pick up a card
	//if no cards are available to pick up, forfit the turn
	public static void playerTurn(Hand playerHand, Hand opHand, Deck mainDeck, double difficulty){
		boolean opHasCard = false;
		System.out.println("Players turn");
		//check if player has at least 1 card in hand
		if(playerHand.numCards() == 0){
			System.out.println("No cards in hand. pick one up if possible or forfit turn");
			int inCard = mainDeck.getCard();
			if(inCard != 0){
				//deck is not empty, pick up card and continue game
				playerHand.addCard(inCard);
			}else{
				//forfit turn
				return;
			}
		}


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
			//System.out.println(x);
			System.out.println("Opponent has "+ x + " Cards");
			for (int j = 0;  j < x; j++){
				if(playerHand.addCard(i)){
					System.out.println("made a book with card from ops hand");
				}
			}
			
		}  else {
		//if op doesnt have card
		//TODO
		//should get extra turn for correct picked up card
			System.out.println("Go Fish!");
			int card = mainDeck.getCard();
			playerHand.addCard(card);
			if(card == i){
				//player gets a free turn
				System.out.println("player gets a free turn");
				int books = playerHand.numBooks()+opHand.numBooks();
				if(books < 13){
					playerTurn(playerHand, opHand, mainDeck, difficulty);
				}
			}
			
		}
		
	}
	
	
	public static String opControl(int choice){
		String s = "";
		if (choice == 1){
			s = "Aces";
		} else if (choice ==2){
			s ="Twos";
		}else if (choice ==3){
			s ="Threes";
		} else if (choice ==4){
			s ="Fours's";
		} else if (choice ==5){
			s ="Fives";
		} else if (choice ==6){
			s ="Sixes";
		} else if (choice ==7){
			s ="Sevens";
		} else if (choice ==8){
			s ="Eights";
		} else if (choice ==9){
			s ="Nines";
		} else if (choice ==10){
			s ="Tens";
		} else if (choice ==11){
			s ="Jacks";
		} else if (choice ==12){
			s ="Queens";
		} else if (choice ==13){
			s ="Kings";
		}
		
		return s;
	}
	public static void opTurn(Hand opHand, Hand playerHand, Deck mainDeck, boolean mem, LinkedList<Integer> opMemory){
		Random r = new Random();
		
		System.out.println("Oponents turn:");
		
		//check if player has at least 1 card in hand
		if(opHand.numCards() == 0){
			System.out.println("No cards in hand. pick one up if possible or forfit turn");
			int inCard = mainDeck.getCard();
			if(inCard != 0){
				//deck is not empty, pick up card and continue game
				opHand.addCard(inCard);
			}else{
				//forfit turn
				return;
			}
		}
		opHand.printHand();
		LinkedList<Integer> valid = opHand.validAsks();
		//error is caused when opHand has no cards
		int randomGuess;
		if(valid.size() > 0){
			randomGuess =  r.nextInt(valid.size());
		}else{
			randomGuess = 0;
		}
		int guess = valid.get(randomGuess);
		if (mem){
			for(int i = 0; i < opMemory.size(); i++){
				if (guess == opMemory.get(i)){
					randomGuess =  r.nextInt(valid.size() );
					 guess = valid.get(randomGuess);
				}
			}
		}
		
		
		
		System.out.println("Do you have any " + opControl(valid.get(randomGuess))+ "?");
		if (playerHand.inHand(guess)){
			int x = playerHand.give(guess);
			//System.out.println(x);
			System.out.println("Player has "+ x + " Cards");
			for (int j = 0;  j < x; j++){
				if(opHand.addCard(guess)){
					//op got book
					logBooks(playerHand,opHand);
				}
			}
			logTurn(false,guess,true,playerHand,opHand);
		} else {
			if (mem) {
				opMemory.add(guess);
			}
			System.out.println("Go Fish");
			int card = mainDeck.getCard();
			opHand.addCard(card);
			if(card == guess){
				//free turn
				System.out.println("computer gets a free turn");
				int books = opHand.numBooks()+playerHand.numBooks();
				if(books < 13){
					opTurn(opHand, playerHand, mainDeck, mem, opMemory);
				}
			}
			logTurn(false,guess,false,playerHand,opHand);
		}
		
		
	}
	public static void firstDeal(Deck d, Hand h1, Hand h2){
		d.shuffle();
		for (int i = 0; i < 7; i++){
			h1.addCard(d.getCard());
			h2.addCard(d.getCard());
			
			}
			
	}
	public static void logNewGame(Hand myHand, Hand opHand, double diff){
    	try{
    		FileWriter writer = new FileWriter("log.txt", false);
            writer.write("------NEW GAME------");
            writer.write("\r\n");
            writer.write("\r\n");
            writer.write("Difficulty: "+String.valueOf(diff));
            writer.write("\r\n");
            
            writer.write("Player's Hand:");
            for(int i=0; i < myHand.getHandArray().length; i++){
            	writer.write(String.valueOf(myHand.getHandArray()[i])+" ");
            }
            writer.write("\r\n");
            writer.write("Computer's Hand:");
            for(int i=0; i < opHand.getHandArray().length; i++){
            	writer.write(String.valueOf(opHand.getHandArray()[i])+" ");
            }   
            writer.write("\r\n");
            
            
            writer.close();
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    	
    }
    
    public static void logTurn(boolean turn, int guess, boolean correct, Hand myHand, Hand opHand){
    	
    	
		try{
    		FileWriter writer = new FileWriter("log.txt", true);
            writer.write("\r\n");
            if(turn){
            	writer.write("Player's turn:");
            }else{
            	writer.write("Computer's turn:");
            }
            writer.write("\r\n");
            writer.write("Guess: "+String.valueOf(guess));
            writer.write("\r\n");
            if(correct){
            	writer.write("Guess was correct");
            }else{
            	writer.write("Guess was incorrect");
            }
            
            
            writer.write("Player's Hand:");
            for(int i=0; i < myHand.getHandArray().length; i++){
            	writer.write(String.valueOf(myHand.getHandArray()[i])+" ");
            }
            writer.write("\r\n");
            writer.write("Computer's Hand:");
            for(int i=0; i < opHand.getHandArray().length; i++){
            	writer.write(String.valueOf(opHand.getHandArray()[i])+" ");
            }   
            writer.write("\r\n");
            
            
            
            
            writer.close();
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
    
    public static void logBooks(Hand myHand, Hand opHand){
    	try{
    		FileWriter writer = new FileWriter("log.txt", true);
    		writer.write("\r\n");
            writer.write("------BOOKS------");
            writer.write("\r\n");
            
            writer.write("Player's Books:");
            writer.write(String.valueOf(myHand.getBookList()));
            writer.write("\r\n");
            
            writer.write("Computer's Hand:");
            writer.write(String.valueOf(opHand.getBookList()));
            writer.write("\r\n");
            
            
            writer.close();
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
    
    public static void logFinalScore(Hand myHand, Hand opHand){
    	try{
    		FileWriter writer = new FileWriter("log.txt", false);
            writer.write("------Game Over------");
            writer.write("\r\n");
            writer.write("-----Final Stats-----");
            writer.write("\r\n");
            writer.write("\r\n");
            
            writer.write("Player's Books:");
            writer.write(String.valueOf(myHand.getBookList()));
            writer.write("\r\n");
            
            writer.write("Computer's Hand:");
            writer.write(String.valueOf(opHand.getBookList()));
            writer.write("\r\n");
            
            writer.close();
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    	
    }
}

