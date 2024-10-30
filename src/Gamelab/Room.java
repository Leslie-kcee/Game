package Gamelab;

import java.util.ArrayList;

public class Room {
	//object variables - usually private
	private String description; // room decription to display to player
	private Item item_name;
	
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
	public Room(String desc) {
		description = desc;
		
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
			return null;
		
	}
	//Formats the object's data as a string
	// Returns the string.
	@Override
	public String toString() {
		return description;
		
	}
	
	public Item getItem_in_Room() {
		      return  item_name;
}
	public void setItem_in_Room(Item name ) {
	      item_name= name;
}
	
	
	
	
		
	}

