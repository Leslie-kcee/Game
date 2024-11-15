package Gamelab;

public class World {
	public static Room bathRoom3 = new Room("bathRoom3", "You are in the second floor's third bathroom");

		public static Room buildWorld() {
			Item ball = new Item("ball", " Round ball");
			Item plate = new Item("plate", "Three old day plate in the sink");
			Item bag = new Item("bag", "A school bag with diamond motif");
			Item comb = new Item("comb", "Wooden comb");
			Item bowl = new Item("bowl", "You are in the bathroom");
			Item trashcan = new Item("trashcan", "This is the house trash");
			Safe safe = new Safe("safe", "It's an impressive safe!");
			Combination combination= new Combination("combination", "Combination for the safe"); 
			Bike bike = new Bike("bike", "A bike fueled by a coin");
			Chestboard chestboard = new Chestboard("chestboard", "An ordinary chest board with a hidde treasure");
			Key key = new Key("key","impressive you now have the key");
			Item paper = new Item("paper", "This paper might interest you!"); // paper has key information for game advancement
			Item cooker = new Item("cooker", "Nothing special about this cooking stove"); // drawer will have a paper
			Room livingRoom = new Room("living Room", "You are in the living room.");
			Room Kitchen = new Room("Kitchen", "You are in the kitchen."); // has a special drawer with a paper in it
			Room hallway1 = new Room("hallway", "You are in the hallway");
			Room attic = new Room("attic", "You are now in the Laundry room");
			Room bedRoom1 = new Room("bedroom","You are in the bedroom");
			Room bathRoom1 = new Room("bathroom","You are in the first floor's bathroom");
			Room Garden = new Room("Garden", " You are now in the Garden");  //has a bike that takes you straight to bathroom 2 where the key is at
			Room MovieRoom = new Room("MovieRoom","You are now in the movie room");
			Room StorageRoom = new Room("Storage Room", "You are now in the storage room");
			Room Stairs = new Room("Stairs", " You are now in the stairs");
			Room hallway2 = new Room("Hallway", " you are on the second floor's hallway");
			Room bedRoom2 = new Room("bedroom","You are in the bedroom on the second floor"); //has the key
			Room bathRoom2 = new Room("bathroom","You are on the second floor's bathroom, close to the stairs");
			
			livingRoom.addExit('n', StorageRoom);
			livingRoom.addExit('w',Garden);
			livingRoom.addExit('s', MovieRoom);
			livingRoom.addExit('e', hallway1);
			hallway1.addExit('w', livingRoom);
			hallway1.addExit('n', Kitchen);
			hallway1.addExit('s', bedRoom1);
			hallway1.addExit('e', Stairs);
			Stairs.addExit('d', bathRoom2);
			Stairs.addExit('u', hallway2);
			hallway2.addExit('n', bathRoom3);
			hallway2.addExit('e', bedRoom2);
			Kitchen.addExit('s', hallway1);
			Kitchen.addExit('w', StorageRoom);
			StorageRoom.addExit('w', Garden);
			StorageRoom.addExit('e', Kitchen);
			StorageRoom.addExit('s', livingRoom);
			Garden.addExit('s', bathRoom2);  // add item to take you straight to 2nd bathroom
			Garden.addExit('e', livingRoom);
			MovieRoom.addExit('n', livingRoom);
			MovieRoom.addExit('e', bathRoom1);
			bathRoom1.addExit('w', MovieRoom);
			bedRoom1.addExit('n', hallway1);
			bathRoom2.addExit('n', Stairs);
			bedRoom2.addExit('w', hallway2);
			hallway2.addExit('d', Stairs);
			bathRoom3.addExit('s', hallway2);
			bathRoom3.setlock(true);
			livingRoom.setlock(false);
			bathRoom2.setItem_in_Room(key, "key");
			bathRoom3.setItem_in_Room(safe, "safe");
			Garden.setItem_in_Room(bike, "bike");
			Garden.setItem_in_Room(trashcan, "trashcan");
			MovieRoom.setItem_in_Room(chestboard, "chestboard");
			Kitchen.setItem_in_Room(cooker, "cooker"); 
			Kitchen.setItem_in_Room(plate,"plate" );
			bedRoom1.setItem_in_Room(bag, "bag");
			bedRoom2.setItem_in_Room(comb, "comb");
			bedRoom2.setItem_in_Room(bowl, "bowl");
			//StorageRoom.setItem_in_Room(combination, "combination");
			Garden.setItem_in_Room(combination, "combination");

			return livingRoom;
			
		
		}
		public static Room getbathroom3() {
			return bathRoom3;
		}
		
}

