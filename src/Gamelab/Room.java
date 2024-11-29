package Gamelab;

import java.util.ArrayList;

import java.util.HashMap;
import java.io.Serializable;

public class Room implements Serializable {
	//object variables - usually private
	//private String description;//private Item item_name;
	private String name;
	HashMap<String , Item>  items;  // item_objects and Item_keys.
	HashMap<String, NPC> Npc;
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
	public Room(String n) {
		name = n;
		items = new HashMap<>();
		Npc = new HashMap<>();
		
		game.rooms.put(name, this);
	
		
	}
	
	public String getdescription(){
		return game.roomsdesc.get(name);
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
	//update of todays lab
	public String toString() {
		return name;
		
	}
	
	public Item getItem_in_Room(String name) {
		for(String item_name : items.keySet()) { 
				Item a = items.get(item_name);
				if(a.getname().equals(name))
					return a;
		}
		return null;

}
	public void setItem_in_Room(Item name, String item_key) {
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
	
	public void setNPC_in_Room(String NPC_key, NPC name) {
		Npc.put(NPC_key, name);

	}
	
	public NPC getNPC_in_Room(String name) {
		for(String Npc_name : Npc.keySet()) { 
				NPC b = Npc.get(Npc_name);
				if(b.getName().equals(name))
					return b;
		}
		return null;
	
	}		
}
