package Gamelab;

public class World {
    public static Room bathRoom3 = new Room("bathRoom3");

    public static Room buildWorld() {
        // Creating items
        Item ball = new Item("ball", "Round ball");
        Item plate = new Item("plate", "Three old day plate in the sink");
        Item bag = new Item("bag", "A school bag with diamond motif");
        Item comb = new Item("comb", "Wooden comb");
        Item bowl = new Item("bowl", "You are in the bathroom");
        Item trashcan = new Item("trashcan", "This is the house trash");
        Safe safe = new Safe("safe", "It's an impressive safe!");
        Combination combination = new Combination("combination", "Combination for the safe");
        Bike bike = new Bike("bike", "A bike fueled by a coin");
        Chestboard chestboard = new Chestboard("chestboard", "An ordinary chest board with a hidden treasure");
        Key key = new Key("key", "impressive you now have the key");
        Item paper = new Item("paper", "This paper might interest you!");
        Item cooker = new Item("cooker", "Nothing special about this cooking stove");
        NPC puppy = new Puppy("puppy", "A hideous puppy wags his tail.");
        NPC magician = new NPC("magician", "A wise old Magician.");

        // Creating rooms
        Room livingRoom = new Room("livingRoom");
        Room Kitchen = new Room("Kitchen");
        Room Hallway1 = new Room("Hallway1");
        Room bedRoom1 = new Room("bedRoom1");
        Room bathRoom1 = new Room("bathRoom1");
        Room Garden = new Room("Garden");
        Room MovieRoom = new Room("MovieRoom");
        Room StorageRoom = new Room("StorageRoom");
        Room Stairs = new Room("Stairs");
        Room Hallway2 = new Room("Hallway2");
        Room bedRoom2 = new Room("bedRoom2");
        Room bathRoom2 = new Room("bathRoom2");
        
        // Adding exits
        livingRoom.addExit('n', StorageRoom);
        livingRoom.addExit('w', Garden);
        livingRoom.addExit('s', MovieRoom);
        livingRoom.addExit('e', Hallway1);
        Hallway1.addExit('w', livingRoom);
        Hallway1.addExit('n', Kitchen);
        Hallway1.addExit('s', bedRoom1);
        Hallway1.addExit('e', Stairs);
        Stairs.addExit('d', bathRoom2);
        Stairs.addExit('u', Hallway2);
        Hallway2.addExit('n', bathRoom3);
        Hallway2.addExit('e', bedRoom2);
        Kitchen.addExit('s', Hallway1);
        Kitchen.addExit('w', StorageRoom);
        StorageRoom.addExit('w', Garden);
        StorageRoom.addExit('e', Kitchen);
        StorageRoom.addExit('s', livingRoom);
        Garden.addExit('s', bathRoom2);  // add item to take you straight to 2nd bathroom
        Garden.addExit('e', livingRoom);
        MovieRoom.addExit('n', livingRoom);
        MovieRoom.addExit('e', bathRoom1);
        bathRoom1.addExit('w', MovieRoom);
        bedRoom1.addExit('n', Hallway1);
        bathRoom2.addExit('n', Stairs);
        bedRoom2.addExit('w', Hallway2);
        Hallway2.addExit('d', Stairs);
        bathRoom3.addExit('s', Hallway2);
        bathRoom3.setlock(true);
        livingRoom.setlock(false);

        // Set items in rooms
        bathRoom2.setItem_in_Room(key, "key");
        bathRoom3.setItem_in_Room(safe, "safe");
        Garden.setItem_in_Room(bike, "bike");
        Garden.setItem_in_Room(trashcan, "trashcan");
        MovieRoom.setItem_in_Room(chestboard, "chestboard");
        Kitchen.setItem_in_Room(cooker, "cooker");
        Kitchen.setItem_in_Room(plate, "plate");
        bedRoom1.setItem_in_Room(bag, "bag");
        bedRoom2.setItem_in_Room(comb, "comb");
        bedRoom2.setItem_in_Room(bowl, "bowl");
        Garden.setItem_in_Room(combination, "combination");
        MovieRoom.setNPC_in_Room("puppy", puppy);
        StorageRoom.setNPC_in_Room("Magician", magician);

        
        // Return the starting room
        return livingRoom;
    }

    public static Room getbathroom3() {
        return bathRoom3;
    }
}
