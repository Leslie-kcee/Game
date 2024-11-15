package Gamelab;

public class Key extends Item{

	public Key(String name, String description){
		super(name, description);
	}
	
	@Override
	public void use() {
		if(game.currentRoom.getlock()==false) {
			game.currentRoom.setlock(true);
			game.print(game.currentRoom.getName() + " is now unlocked");
		}
		
		else {
			game.print("The room is already open.");
		}
	}
	
}
