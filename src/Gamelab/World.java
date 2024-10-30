package Gamelab;

public class World {

		public static Room buildWorld() {
			Item ball = new Item("ball", " Round ball");
			Item plate = new Item("plate", " dirty plate");
			Item bag = new Item("bag", " big bag");
			Room livingRoom = new Room("You are in the living room.");
			Room Kitchen = new Room("You are in the kitchen.");
			Room hallway = new Room("You are in the hallway");
			Room attic = new Room("You are now in the Laundry room");
			Room bedRoom = new Room("You are in the bedroom");
			Room bathRoom = new Room("You are in the bathroom");
			
			bedRoom.setItem_in_Room(ball);
			livingRoom.setItem_in_Room(plate);
			Kitchen.setItem_in_Room(bag);
			livingRoom.addExit('e',Kitchen);//LivingRoom to Kitchen
			livingRoom.addExit('s', hallway);// LivingRoom to hallway 
			Kitchen.addExit('w', livingRoom);// Kitchen to livingRoom
			hallway.addExit('n', livingRoom);// hallway to laundryRoom
			hallway.addExit('e', bedRoom);// hallway to bedRoom
			hallway.addExit('n', bathRoom);// hallway to bathRoom
			hallway.addExit('u', attic);//hallway to attic
			bedRoom.addExit('w',hallway);//bedRoom to hallway
			bathRoom.addExit('s', hallway);//bathRoom to bedRoom
			attic.addExit('d', hallway);// attic to hallway
			
			
			return livingRoom;
			
		}
}

