package Gamelab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class game { 
	
	
	String Game;
	public static Scanner input = new Scanner(System.in);  // Creates a new scanner object called input from the keyboard
	static HashMap<String , Room >  rooms = new HashMap<>();
	static HashMap<String , String >  roomsdesc = new HashMap<>();
	static ArrayList<Item> inventory = new ArrayList<Item>();
	static Room currentRoom ;
	private static GUI gui;
	
	public static void main(String[] args) {// The name on tab has to be the same name in class so the program can run.
		loadRoomdesc(); // load description for rooms. It causes the program to be a little slow to start
		currentRoom = World.buildWorld();
		gui = new GUI();  
		print(currentRoom); 
				
		
	}
	
	public static void processCommand(String command) {
	
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
	            game.print("The room is locked you need a key to enter");
	        	break;
	        case "x":   // to exit game
	            game.print("Bye! Thanks for walking through my game.");
	            break;
	        case "take"://+ item_name  :  // take object from room
				if(currentRoom.getItem_in_Room(word[1]) == null) {
	        		game.print("No such item in this room");
				}
	        	else {
	        		game.print("Yay you now have the " + word[1]);
	        		inventory.add(currentRoom.getItem_in_Room(word[1]));  
	        	}
	        	break;
	        case "i":   // see what is found in inventory
	        	if(inventory.isEmpty())
	        		game.print("You are carrying nothing");
	        	else
	        		System.out.println("You have: ");
	        		for(int i=0; i<inventory.size(); i++)
	        			game.print( inventory.get(i));
	        	break;
	        case "look": // + item_name   // Looks up object in room
	        	if(currentRoom.getItem_in_Room(word[1])== null && inventory.isEmpty())        
	        		game.print("You are carrying nothing");
	        	
	        	else if(currentRoom.getItem_in_Room(word[1])!=null) {
	        		Item Item_in_room = currentRoom.getItem_in_Room(word[1]);
	        		game.print(Item_in_room.getdescription());
	        	}
	        	else{
	        		for(Item n : inventory) {
	        			if(n.getname().equals(word[1])) {
	        				game.print(n.getdescription());
	        			}
	        		}
	        	}
	        	break;	
	       case "use":   // to use an object
	    	   if(currentRoom.getItem_in_Room(word[1])== null || inventory.isEmpty()) {
	        		game.print("That item is not here");
	        	
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
	       case "open":   // Open object
	    	   if(currentRoom.getItem_in_Room(word[1])== null) {
	    		   game.print("No such item in this room");
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
	       case "talk":    // NPC object interaction
	    	   	if(currentRoom.getNPC_in_Room(word[1]) == null) {
	    	   		game.print("No NPC in this room");
	    	   	}
	    	   	
	    	   	else {
	    	   		NPC a = currentRoom.getNPC_in_Room(word[1]);
	    	   		a.talk();	
	    	  }
	    	   	
	    	  break;
	       case "save":      //Save room description
	    	   saveGame();
	    	   break;
	       case "load":  // load room description from text file 
	    	   loadGame();
	    	   break;
	        default:
	            game.print("I don't know what you mean.");
	        }

	    }
	

	public static void loadRoomdesc() {
		try {
			Scanner input = new Scanner(new File("Gameroom"));
			String Roomname  = "";
			String Roomdesc = "";
			while(input.hasNextLine()){
				Thread.sleep(1000);//sleep for 1 second
				String line = input.nextLine().trim();
				
				if(line.charAt(0)=='Y') {
					Roomdesc = line;
					roomsdesc.put(Roomname, Roomdesc);
				}
				
				if(line.charAt(0)!='#' && line.charAt(0)!='Y') {
					Roomname = line;
					roomsdesc.put(Roomname, Roomdesc);
				}	
				
			}		
		input.close();
	}catch(FileNotFoundException e) {
		System.out.println("File not found!!!");	
	}catch (InterruptedException ex) {
		System.out.println("Bummer. ");
	}

	}
	
	public static void saveGame() {
		try {
			FileOutputStream fileOut = new FileOutputStream("Gameroom");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(currentRoom);  // Saving current room
            out.writeObject(inventory);
            out.writeObject(rooms);
            out.close();
            fileOut.close();
            System.out.println("Game saved successfully!");
        } catch (IOException i) {
            i.printStackTrace();
        }
	}
	
	
	public static void loadGame() {
        try {
            FileInputStream fileIn = new FileInputStream("Gameroom");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            currentRoom = (Room) in.readObject();
            inventory = (ArrayList<Item>) in.readObject();
            rooms = (HashMap<String, Room>) in.readObject();
            in.close();
            fileIn.close();
            
            System.out.println("Game loaded successfully!");
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
	}
	
	
	
	
	
	public static void runGame(){
		Scanner input = new Scanner(System.in); 
		String command;

	    do{
	        System.out.println(currentRoom);
	        System.out.println((currentRoom.getdescription()));
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
	        		System.out.println("No such item in this room");
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
	       case "talk":
	    	   	if(currentRoom.getNPC_in_Room(word[1]) == null) {
	    	   		System.out.println("No NPC in this room");
	    	   	}
	    	   	
	    	   	else {
	    	   		NPC a = currentRoom.getNPC_in_Room(word[1]);
	    	   		a.talk();
	    	   	
	    	  }
	    	   	
	    	  break;
	       case "save":
	    	   saveGame();
	    	   break;
	       case "load":
	    	   loadGame();
	    	   break;
	        default:
	            System.out.println("I don't know what you mean.");
	        }

	    } while(!command.equals("x"));
	    
	    input.close();
	    }
	
	public static void print(Object obj) {
		gui.print(obj.toString()+ "\n");
		//gui.TextArea.append(obj.toString()+ "\n");
		
	}
	

	}

