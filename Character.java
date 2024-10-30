public class Character {

    private String name;
    private int damage;
    private int HP;
    private int Counter;
    private int turnsToAttack;
    
    
    public void dmg(Character enemy) {
        enemy.HP -= this.damage;
    
    }



    //constructors
    Character(){

    }

    Character(String n,int dmg, int health){
        name = n;
        damage = dmg;
        HP = health;
        turnsToAttack = 0;
    }
    
    
    Character(String n,int dmg, int health,int turnsToAttack){
        name = n;
        damage = dmg;
        HP = health;
        this.turnsToAttack = turnsToAttack;
    }


//setters

    public void setTTA(int amt) {
    	turnsToAttack = amt;
    }

    public void setCounter(int Counter) {
        this.Counter = Counter;
    }

    public void setName(String n) {
        name = n;
    }

    public void setDmg(int dmg) {
        damage = dmg;
    }

    public void setHP(int health) {
        HP = health;
    }

    //getters
    
    public int getCounter() {
        return Counter;
    }
    
    public int getTTA() {
    	return turnsToAttack;
    }
    public String getName() {
        return name;
    }

    public int getDmg() {
        return damage;
    }

    public int getHP() {
        return HP;
    }


    public String toString() {
        return "----------------\nName: " + name + "\nDamage: " + damage + "\nHealth: " + HP;
    }


}

