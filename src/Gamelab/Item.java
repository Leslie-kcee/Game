package Gamelab;
import java.io.Serializable;

public class Item implements Serializable {
		private String item_name;
		private String description;
		
		
		
		public Item(String name, String desc) {
			item_name = name;
			description = desc;
			
		}
		
		public String getname() {
			return item_name;
		}
		
		public String getdescription() { // was not asked to include this
			return description;
		}
		
		public String setname(String item) {
			return item_name;
			}
			
		
		public String toString() {
			return item_name;
		}
		
		
		public void open() {
			game.print("You can't open that!");
		}
		
	
		public void use() {
			game.print("You can't use that!");
		}
		
		
	}
