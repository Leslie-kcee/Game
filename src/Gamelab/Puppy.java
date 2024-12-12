package Gamelab;

public class Puppy extends NPC{
	
	private int dialogue=0;

	public Puppy(String name, String description) {
		super("puppy", "A hideous puppy wags his tail");
		}
	
		@Override
		public void talk() {
			dialogue+=1;
			
			if(dialogue ==1) {
			say("Hi! I'm an adorable puppy!");
			String[] options = {
					"Yes you are! Who's a good boy?",
					"Ew, no. You're actually kinda hideous."
	
			};
		
			getResponse(options);
		}
			if(dialogue ==2) {
				say("Hey! Wanna play fetch? Say yes! Say yes!");
				String[] options = {
						"Yes! I love fetch",
						"No. I am a horrible personand don't like playing with pets"
				};
				getResponse(options);
			}
			
			else {
				say("yip! *wags tail*");
			}
		}
		
		@Override
		public void response(int option) {
			if(dialogue==1) {
			switch(option) {
				case 1:
					say("I am! I'm a good boy!");
				break;
				
				case 2:
					say("I am adorable! Why are you so mean?");
					game.print("The puppy bites you. You deserve it.");
				break;
				
			}
		}
			else if(dialogue ==2) { // Player plays with puppy
				switch(option) {
				case 1:
					say("Yay! Fetch");
					game.print("The puppy runs off and returns with a ball. The player receives the ball");
					Item tenisball = new Item("Ball", "A purple tennis ball");
					game.inventory.add(tenisball);
				break;
				
				case 2:
					say("You're a bad person! I don't like you");
					game.print("The puppy runs away and doesn't come back");
				break;
				}
		}
			else {
				say("Yip! *wags tail*");
			}
		
}

}