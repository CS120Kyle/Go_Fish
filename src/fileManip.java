import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class fileIO {
    
    public static void logNewGame(int[] pHand, int[] cHand){
    	try{
    		FileWriter writer = new FileWriter("My.txt", false);
            writer.write("------NEW GAME------");
            writer.write("\r\n");
            
            writer.write("Player's Hand:");
            for(int i=0; i < pHand.length; i++){
            	writer.write(String.valueOf(pHand[i])+" ");
            }
            writer.write("\r\n");
            writer.write("Computer's Hand:");
            for(int i=0; i < cHand.length; i++){
            	writer.write(String.valueOf(cHand[i])+" ");
            }   
            writer.write("\r\n");
            
            
            writer.close();
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    	
    }
    
    public static void logTurn(boolean turn, int guess, int correct, int[] pHand, int[] cHand){
    	
    	if(turn){
    		try{
        		FileWriter writer = new FileWriter("My.txt", true);
                writer.write("\r\n");
                writer.write("Player's turn:");
                writer.write("\r\n");
                writer.write("Guess: "+String.valueOf(guess));
                writer.write("\r\n");
                writer.write("Correct: "+String.valueOf(correct));
                
                writer.write("\r\n");
                writer.write("Player's Hand:");
                for(int i=0; i < pHand.length; i++){
                	writer.write(String.valueOf(pHand[i])+" ");
                }
                writer.write("\r\n");
                writer.write("Computer's Hand:");
                for(int i=0; i < cHand.length; i++){
                	writer.write(String.valueOf(cHand[i])+" ");
                }   
                writer.write("\r\n");  
                
                
                
                
                writer.close();
        	}catch(IOException e){
        		e.printStackTrace();
        	}
    	}
    	
    }
    
    public static void logBooks(int[] pHand, int[] cHand){
    	try{
    		FileWriter writer = new FileWriter("My.txt", true);
    		writer.write("\r\n");
            writer.write("------BOOKS------");
            writer.write("\r\n");
            
            writer.write("Player's Books:");
            writer.write(pHand.bookList.toString());
            writer.write("\r\n");
            
            writer.write("Computer's Books:");
            writer.write(cHand.bookList.toString());
            writer.write("\r\n");
            
            
            writer.close();
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
    
    
 
}
