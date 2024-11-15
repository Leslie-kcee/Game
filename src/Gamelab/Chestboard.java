package Gamelab;

public class Chestboard extends Item{

	public Chestboard(String name, String description) {
		super(name, description);
	}
	@Override
	public void open() {
		Item coin ;
		game.inventory.add(new Item("coin","Congrats you just got the magic coin"));
		game.print("Wow look what you found! An old coin!");
		game.print("You will use this coin for your bike. This will take you to the Room where the safe is found");
	}
}
