import java.awt.ItemSelectable;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main{
    static void MainMenu() throws InterruptedException {
        DPO("Welcome to RPG game name here idk", 10);
        System.out.println("\n\n1. Start game\n2. Quit");
    }

    static void combat(Character X, Alien Enemy, InventorySystem inventory) throws InterruptedException {
        int userInp = 0;
        
        //combat loop
        while (X.getHP() > 0 && Enemy.getHP() > 0) {
            //while main character HP and enemy HP arent below 0:
            try {
                Scanner imp = new Scanner(System.in);
                System.out.println("\n\n\n");
                DPO("What would you like to do?", 10);
                DPO("1. Fight  2. Special Attack  3. Sneak  4. Use item\n", 10);
                TimeUnit.SECONDS.sleep(2);
                //if user inputs 1, they fight, else 2, they sneak.
                userInp = imp.nextInt();
                if (userInp == 1) {
                    X.fight(Enemy);
                    //if the enemy gets slain, it skips the enemy's turn and goes straight to the cutscene
                    DPO("You slash " + Enemy.getName() + " with your sword and deal " + X.getDmg() + " damage.", 10);
                    if (Enemy.getHP() <= 0) {
                        continue;
                    }
                } else if (userInp == 2) {
                    X.StartSPA(Enemy);
                    DPO("You poison " + Enemy.getName() + " with your magic and deal " + X.getSpecialAttacks().get(X.getSPA()) + " damage.", 10);
                    Enemy.setHP(Enemy.getHP() - X.getSpecialAttacks().get(X.getSPA()));
                    if (Enemy.getHP() <= 0) {
                        continue;
                    }
                } else if (userInp == 3) {
                    //This is the sneak chance, 1 in 3 chance of getting away.
                    int sneakCh = ThreadLocalRandom.current().nextInt(1, 4);
                    if (sneakCh == 1) {
                        DPO("You've successfully snuck away from the " + Enemy.getName(), 10);
                        break;
                    } 
                    else {
                        DPO("Oh no! The attempt to sneak was unsuccessful!", 10);
                    
                    }
                } 
                
                else if (userInp == 4) {
                    //should check for inventory before allowing to use item.
                    inventory.displayInventory();
                } 
                
                //if user inputs any other number or letter, an error is raised.
                else {
                    throw new ArithmeticException();
                }

                Thread.sleep(400);

                //enemy's turn.
                if(Enemy.Afight(X)) {
                    DPO("Enemy " + Enemy.getName() + " has dealt " + Enemy.getDmg() + " damage",10);
                }
                else {
                    DPO("Enemy " + Enemy.getName() + " is charging up their attack...",10);
                }

                if(Enemy.getCounter() > 0) {
                	SpecialAttack(X,Enemy);
                }

                Thread.sleep(400);
                System.out.println("\nHP: " + X.getHP());
                System.out.println("Enemy HP: " + Enemy.getHP());
                Thread.sleep(1000);
            } 
            catch (Exception e) {
                System.out.println("Please enter a number from 1-4.");
            
            }

        }


        //if the enemy's HP is below or equal to zero, then the cutscene plays and u get whatever the enemy drops.
        if (Enemy.getHP() <= 0) {
            DPO("Enemy " + Enemy.getName() + " has been slain!", 10);
            DPO(Enemy.getName() + " has dropped a " + Enemy.getItem(), 10);
        
            Scanner playerItem = new Scanner(System.in);
            System.out.println("\n1. Pick Up\n2. Leave Item\n\nWhat would you like to do? : ");
            int playerInp = playerItem.nextInt();
        
            if (playerInp == 1) {
                if (inventory.items.size() < 4) {
                    inventory.addItem(Enemy.getItem());
                } 
                else if(inventory.items.size() > 4) {
                    inventory.addItem(Enemy.getItem());
                    inventory.addItem(Enemy.getItem());
                }
            } else {
                System.out.println("You left " + Enemy.getItem() + " on the ground.");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MainMenu();
        Character t1 = new Character("n",10,100);
        Alien t2 = new Alien("f",10,100,2,"sword");
        
        InventorySystem inventory = new InventorySystem();

        // Simulate picking up items
        inventory.pickUpItem("Sword");
        inventory.pickUpItem("Health Potion");
        inventory.pickUpItem("Stick");
        inventory.pickUpItem("Shield");
        inventory.pickUpItem("Rock");
        inventory.pickUpItem("Phone");
        inventory.pickUpItem("Phone");
        t1.setSPA("Poison");

        combat(t1, t2, inventory);
    }
    static void SpecialAttack(Character X, Alien Enemy) throws InterruptedException {
        if (X.getSPA() == "Poison") {
        DPO("Enemy is poisoned... take 5 damage",10);
        Enemy.setHP(Enemy.getHP() - X.getSpecialAttacks().get(X.getSPA()));
        Enemy.setCounter(Enemy.getCounter() - 1);
    
        }
        //This is the special attack function, enemy -= 5
        //enemycounter -- 
    }
    static void DPO(String str, long delay) throws InterruptedException {
    	//for character in string that has been turned into a list, print out the character after a certain amount of milliseconds.
        System.out.println();
        for (char ch : str.toCharArray()) {
            System.out.print(ch);
            TimeUnit.MILLISECONDS.sleep(delay);
        }
    }
}
