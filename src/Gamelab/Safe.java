package Gamelab;

public class Safe  extends Item{
	
	public Safe(String name, String description) {
		super(name,description);
	}

	@Override
	public void open() {
		boolean found = false;
		for(Item item :  game.inventory ) {
			if(item.getname().equals("Combination")) {
					found = true;
					break;
			}
		}
		
		if(found) {
			       	game.print("Using the combination, you open the safe and find a diamond inside! Naturally, you pocket the diamond.");
			       	
			       	Item diamond = new Item("Diamond", "Bright and light");
			       	game.inventory.add(diamond); // no class needed cause user won't need to open it
			}
		
		else {
				game.print("The safe is locked and you don't have the combination");
			}
		}
	
}
