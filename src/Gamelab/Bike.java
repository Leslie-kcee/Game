package Gamelab;

public class Bike extends Item {

	public Bike(String name, String description) {
		super(name, description);
	}
	
	@Override
	public void use() {
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
				//game.currentRoom.addExit('n', World.getbathroom3());//takes player stariht to bathRoom3 where the safe is found
				game.currentRoom= World.getbathroom3();
				
			}
			else {
				game.print("Your bike does not have fuel to run. You need to find the coin"); 
			}
			
		}
	
}
