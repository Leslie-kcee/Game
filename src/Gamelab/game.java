package Gamelab;
import java.util.ArrayList;
import java.util.Scanner;
public class game { 
	
	static ArrayList<Item> inventory = new ArrayList<Item>();
	
	public static void main(String[] args) {// The name on tab has to be the same name in class so the program can run.
	    runGame();

	}

	public static void runGame(){
	    Room currentRoom = World.buildWorld();// This calls the class Room to this progra.
	    Scanner input = new Scanner(System.in);
	    String command;
	    do{
	        System.out.println(currentRoom);
	        System.out.print("Where do you want to go? ");
	        command = input.nextLine();
	        
	        switch(command) {
	        case "e":
	        case "w":
	        case "n":
	        case "s":
	        case "u":
	        case "d":
	            currentRoom = currentRoom.getExit(command.charAt(0));// give character at position 0
	            break;
	        case "x":
	            System.out.println("Bye! Thanks for walking through my game.");
	            break;
	        case "take":
	        	if(currentRoom.getItem_in_Room() == null) 
	        		System.out.println("No item found");
	  
	        	else	   
	        		inventory.add(currentRoom.getItem_in_Room());  
	        	break;
	        case "i":
	        	if(inventory == null)
	        		System.out.println("You are carrying nothing");
	        	else
	        		System.out.println("You have: ");
	        		for(int i=0; i<inventory.size(); i++)
	        			System.out.println( inventory.get(i));
	        	break;
	        default:
	            System.out.println("I don't know what you mean.");
	        }

	    } while(!command.equals("x"));
	    
	    input.close();
	    }
	}

