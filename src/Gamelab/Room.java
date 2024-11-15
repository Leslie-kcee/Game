package Gamelab;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
	//object variables - usually private
	private String description;//private Item item_name;
	private String name;
	HashMap<String , Item>  items;  // item_objects and Item_keys.
	//private String Item_name;
	//Item in the hashmap consist of "item_name" and "description" 
	private boolean lock;
	
	
	// Object references - set to null by default
	private Room east; // Reference to room to the east
	private Room West; // Reference to room to the west
	private Room North;
	private Room South;
	private Room up;
	private Room down;
	
	//Construct method - initialize room description.
	// Does not initialize Room variables because they default
	// to null and that is what we want
	public Room(String n, String desc) {
		description = desc;
		name = n;
		items = new HashMap<>();
	
		
	}
	//object methods
	
	//Updates one of the Room variables.
	// Character parameter identifies which variable 
	//to update one of the room variables 
	// The variable is updated to refer to a room r.
	public  void addExit(char dir, Room r) {
		//doesn't have to know what to return because it's a void
		if (dir =='e')
			east = r;
		else if (dir == 'w')
			West = r;
		else if (dir == 'n')
			North = r;
		else if (dir == 's')
			South = r;
		else if (dir == 'u')
			up = r;
		else if (dir == 'd')
			down = r;
		
		
	}
	
	public Room getExit(char dir) { // it needs to know what to return 
		if(dir =='e')
			return east;
		else if (dir == 'w')
			return West;
		else if (dir == 'n')
			return North;
		else if (dir == 's')
			return South;
		else if (dir == 'u')
			return up;
		else if (dir == 'd')
			return down;
		else 
			return  null;
		
	}
	//Formats the object's data as a string
	// Returns the string.
	@Override
	public String toString() {
		return description;
		
	}
	
	public Item getItem_in_Room(String name) {
		for(String item_name : items.keySet()) { 
				Item a = items.get(item_name);
				if(a.getname().equals(name))
					return a;
		}
		return null;

}
	public void setItem_in_Room(Item name, String item_key) { //b4 Item name
	      //b4 item_name= name;
			 items.put(item_key, name );
}
	
	public void removeItem(Item name) {
		items.remove(name);
	}
	public void setlock(Boolean lock) { // Game Lab Locking Rooms update
		this.lock = lock;
	}
	
	public Boolean getlock() { //Game Lab locking rooms update
		return lock;
	}
	
	public void setName(String name) { // Game Lab locking rooms update
		this.name = name;
	}
	
	public String getName() {// Game Lab locking rooms update 
		return name;
	}
	
	
	
	// the game always keep track of your current room
	// you have to get to the closet before you can get the key
	// 
	// To restrict acces to the closet 
	//WE add a boolean variable to the room 
	// add a get and set method to set the variable in room
	// 
	
	
	}

