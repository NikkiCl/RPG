
public class Alien extends Character {
	private int attackTime,turnsToAttack;
	private String itemDropped;
	//subclass
	public Alien(String name, int damage,int HP, int attackTime, String itemDropped) {
		super(name,damage,HP);
		this.attackTime = attackTime;
		this.itemDropped = itemDropped;
		this.turnsToAttack = attackTime;
	}
	
	
	
	
	public String getItem() {
		return itemDropped;
	}
	
	public boolean Afight(Character enemy) {
		if (turnsToAttack == 1) {
			this.fight(enemy);
			turnsToAttack = attackTime;
			return true;
		}
		turnsToAttack -= 1;
		return false;
		
		
		
		
	}
}


