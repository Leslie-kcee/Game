package Gamelab;

public class Magician extends NPC{

	public Magician(String name, String description) {
		super(name, description);
	}
	
	@Override
	public void talk() { // Player talks to magician, who gives him a hint as to where the key is found.
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
			say("So, there is a key in one of the bathrooms that could be of help to you. I can't tell where it is though");
			break;
		
		case 2:
			say("You're not very nice my friend");
			break;
		}
}
}