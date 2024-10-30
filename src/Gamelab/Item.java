package Gamelab;

public class Item {
		private String item_name;
		private String description;
		
		
		
		public Item(String name, String desc) {
			item_name = name;
			description = desc;
			
		}
		
		public String getname() {
			return item_name;
		}
		
		public String setname(String item) {
			return item_name;
			}
			
		
		public String toString() {
			return item_name;
		}
		
		
	}
