package Gamelab;

public class Bike extends Item {

	public Bike(String name, String description) {
		super(name, description);
	}
	
	@Override
	public void use() {     //After taking the bike in the garden the player uses coin to get straight to the Room with the key
		boolean foundcoin = false;
		for(Item item : game.inventory) {
			String a = item.getname();
			if(a.equals("coin")) {
				foundcoin = true;
				break;
			}
		}
		if(foundcoin) { 
				game.print("You will get staright to the room that contains the Safe");
				//takes player straight to bathRoom3 where the safe is found
				game.currentRoom= World.getbathroom3();
				
			}
			else {
				game.print("Your bike does not have fuel to run. You need to find the coin"); 
			}
			
		}
	
}
