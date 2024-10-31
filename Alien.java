public class Alien extends Character {
	private String itemDropped;
	
	//subclass


	//constructor
	public Alien(String name, int damage,int HP, int turnsToAttack, String itemDropped) {
		super(name,damage,HP,turnsToAttack);
		//inherits all the variables from the character class 
		this.itemDropped = itemDropped;
	}
	
	
	
	//getters 
	public String getItem() {
		return itemDropped;
	}
	
}

	
	
