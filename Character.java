import java.util.HashMap;

public class Character {

    private String status;
    private String name;
    private String SPA;
    private int damage;
    private int HP;
    private int Counter;



    //hashmap for specialattacks
    private HashMap<String, Integer> SpecialAttacks = new HashMap<String, Integer>(){
        {
           put("Poison", 5);
           put("Ice", 2);
        }
    };

    public void fight(Character enemy) {
        enemy.HP -= this.damage;
    }

    public void StartSPA(Character enemy) {
        if (this.SPA.equals("Poison")) {
            enemy.Counter = 3;
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

    public int getCounter() {
        return Counter;
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