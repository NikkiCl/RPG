public class Alien extends Character {
	private int attackTime;
	private String itemDropped;
	//subclass
	public Alien(String name, int damage,int HP, int attackTime, int turnsToAttack, String itemDropped) {
		super(name,damage,HP,turnsToAttack);
		this.attackTime = attackTime;
		this.itemDropped = itemDropped;
	}
	
	
	
	
	public String getItem() {
		return itemDropped;
	}
	
	public int getAttackTime() {
		return attackTime;
	}
	
}

	
	

