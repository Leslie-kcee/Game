package Gamelab;
import java.util.ArrayList;
import java.util.Scanner;
public class game { 
	
	
	static ArrayList<Item> inventory = new ArrayList<Item>();
	static Room currentRoom ;
	
	public static void main(String[] args) {// The name on tab has to be the same name in class so the program can run.
		currentRoom = World.buildWorld();
		runGame();

	}

	public static void runGame(){
	    Scanner input = new Scanner(System.in);  // Creates a new scanner object called input from the keyboard
		String command;

	    do{
	        System.out.println(currentRoom);
	        System.out.println("Where do you want to go? ");
	        command = input.nextLine();
	        String[] word = command.split(" ");
	        String first = word[0];
	  
	        switch(first) {
	        case "e":
	        case "w":
	        case "n":
	        case "s":
	        case "u":
	        case "d":
	        if (currentRoom.getlock()== false)
	            currentRoom = currentRoom.getExit(first.charAt(0));// give character at position 0
	        else
	            System.out.println("The room is locked you need a key to enter");
	        	break;
	        case "x":
	            System.out.println("Bye! Thanks for walking through my game.");
	            break;
	        case "take"://+ item_name  :
				if(currentRoom.getItem_in_Room(word[1]) == null) {
	        		System.out.println("No item in room");
				}
	        	else {
	        		System.out.println("Yay you now have the " + word[1]);
	        		inventory.add(currentRoom.getItem_in_Room(word[1]));  
	        	}
	        	break;
	        case "i":
	        	if(inventory.isEmpty())
	        		System.out.println("You are carrying nothing");
	        	else
	        		System.out.println("You have: ");
	        		for(int i=0; i<inventory.size(); i++)
	        			System.out.println( inventory.get(i));
	        	break;
	        case "look": // + item_name
	        	if(currentRoom.getItem_in_Room(word[1])== null && inventory.isEmpty())
	        		System.out.println("You are carrying nothing");
	        	
	        	else if(currentRoom.getItem_in_Room(word[1])!=null) {
	        		Item Item_in_room = currentRoom.getItem_in_Room(word[1]);
	        		System.out.println(Item_in_room.getdescription());
	        	}
	        	else{
	        		for(Item n : inventory) {
	        			if(n.getname().equals(word[1])) {
	        				System.out.println(n.getdescription());
	        			}
	        		}
	        	}
	        	break;	
	       case "use":
	    	   if(currentRoom.getItem_in_Room(word[1])== null || inventory.isEmpty()) {
	        		System.out.println("That item is not here");
	        	
	        	}
	        	else {
	        			for(Item item : inventory) {
	        				if(item.getname().equals(word[1])) {
	        					 item.use();
	        					 break;
	        				}
	        			}
	        			
	        			
	        	}
	        	
	        	break;
	       case "open":
	    	   if(currentRoom.getItem_in_Room(word[1])== null) {
	    		   System.out.println("No such item in this room");
	    	   }
	    	   
	    	   
	    	   else {
   		   			for(Item a: inventory) {
   		   				if(a.getname().equals(word[1])) { 
   		   					a.open();
   		   					break;
   		   				}
   		   			}
   		   		
	    	   }
	                	
	        	break;
	        default:
	            System.out.println("I don't know what you mean.");
	        }

	    } while(!command.equals("x"));
	    
	    input.close();
	    }
	
	public static void print(Object obj) {
		System.out.println(obj.toString());
		
	}
	

	}

