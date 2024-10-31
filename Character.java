public class Character {

    private String name;
    public int damage;
    public int HP;
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
        //CODE BELOW IS USELESS DUE TO FUNCTION WITH USING ITEMS IN THE INVENTORYSYSTEM CLASS NOT BEING FUNCTIONAL (COMMENT IN "useItem" function has a short & breif explanation)
    //public void useHealthPotion() {
    //    int amount = 50; // Fixed amount for health potion
    //    HP += amount;
    //    System.out.printf("%s used a health potion and restored %d HP. Total HP: %d\n", this.name, amount, HP);
    //}
    //public void useSword() {
    //    int damageIncrease = 5; // Default damage increase
    //    damage += damageIncrease;
    //    System.out.printf("%s used your sword! Damage increased by %d. Total damage: %d.\n", this.name, damageIncrease, damage);
    //}


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

