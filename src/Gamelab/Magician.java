package Gamelab;

public class Magician extends NPC{

	public Magician(String name, String description) {
		super(name, description);
	}
	
	@Override
	public void talk() {
		say("Welcome friend, I have a surprise for you.");
		String[] options = {
				"Yay, I love surprises.",
				"No, don't waste my time."
		};
		getResponse(options);
	}
	
	@Override
	public void response(int option) {
		switch(option){
		case 1:
			say("Okay, so it's not a surprise. I just need you to find my puppy.");
			break;
		
		case 2:
			say("You're not very nice my friend");
			break;
		}
}
}