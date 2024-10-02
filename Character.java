import java.util.HashMap;

public class Character {

    private Boolean frozen;
    private String name;
    private String SPA;
    private int damage;
    private int HP;
    private int Counter;
    private int turnsToAttack;



    //hashmap for specialattacks
    private HashMap<String, Integer> SpecialAttacks = new HashMap<String, Integer>(){
        {
           put("Poison", 5);
           put("Ice", 2);
        }
    };
    
    
    public void dmg(Character enemy) {
        enemy.HP -= this.damage;
    
    }

    public void StartSPA(Character enemy) {
        if (this.SPA.equals("Poison")) {
            enemy.Counter = 3;
        }
        else if (this.SPA.equals("Ice")) {
        	enemy.Counter = 2;
        }
    }




    //constructors
    Character(){

    }

    Character(String n,int dmg, int health){
        name = n;
        damage = dmg;
        HP = health;
        SPA = null;
        turnsToAttack = 0;
    }
    
    
    Character(String n,int dmg, int health,int turnsToAttack){
        name = n;
        damage = dmg;
        HP = health;
        SPA = null;
        this.turnsToAttack = turnsToAttack;
    }


//setters

    public void setSPA(String AT) {
//checks to  see if the string AT is inside the hashmap.
        if (SpecialAttacks.get(AT) != null){
            SPA = AT;
        }
        else {
            System.out.println("Oops, check if you mispelled anything.");
        }
    }
    
    public void setTTA(int amt) {
    	turnsToAttack = amt;
    }

    public void setCounter(int Counter) {
        this.Counter = Counter;
    }

    public HashMap<String, Integer> getSpecialAttacks() {
        return SpecialAttacks;
    }

    public void setSpecialAttacks(HashMap<String, Integer> specialAttacks) {
        SpecialAttacks = specialAttacks;
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
    
    public boolean isFrozen() {
    	return frozen;
    }
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

    public String getSPA() {
        return SPA;
    }

    public String toString() {
        return "----------------\nName: " + name + "\nDamage: " + damage + "\nHealth: " + HP;
    }


}
