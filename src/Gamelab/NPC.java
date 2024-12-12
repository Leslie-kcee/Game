package Gamelab;
import java.util.Scanner;

import javax.swing.JOptionPane;


	
	public class NPC {
		private String name; // NPC's name
		private String desc; // NPC's description
		public NPC(String name, String desc) {
		this.name = name;
		this.desc = desc;
		}
		public String getName() {
		return name;
		}
		public void setDesc(String desc) {
		this.desc = desc;
		}
		public void say(String dialog) {
		game.print(name+": "+dialog);
		}
		public void talk() {
		game.print("You can't talk to "+name+".");
		}
		public void response(int option) {
		// This method intentionally left blank.
		}
		public void getResponse(String[] options) {
			String s = "";
			for(int i=0; i<options.length; i++) {
				//game.print("Option "+(i+1)+": "+options[i]);
				s+="Option" + (i+1) + ":" + options[i]+ "\n";
		}
			s+= "Enter an option(1-" + options.length +"):";
			int option = Integer.parseInt(JOptionPane.showInputDialog(s));
			//game.print("Enter an option (1-"+options.length+"):");
			//int option = game.input.nextInt();
			//game.input.nextLine(); // Flush input buffer
			response(option);
		}
	}
		

