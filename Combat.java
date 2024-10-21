import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


public class Combat {
	   static void combat(Character X, Alien Enemy) throws InterruptedException {
	        int userInp;
			InventorySystem inventory = new InventorySystem();
	        Scanner imp = new Scanner(System.in);
	        //combat loop
	        while (X.getHP() > 0 && Enemy.getHP() > 0) {
	        	//while main character HP and enemy HP arent below 0:
	            try {
	                System.out.println("\n\n\n");
	                DPO("What would you like to do?",10);
	                DPO("1 - Fight	2 - Sneak	3 - Use item\n",10);
	                TimeUnit.SECONDS.sleep(2);
	                //if user inputs 1, they fight, else 2, they sneak.
	                userInp = imp.nextInt();
	                if (userInp == 1) {
	                    Attack(X,Enemy);
	                    //if the enemy gets slain, it skips the enemy's turn and goes straight to the cutscene
	                    if (Enemy.getHP() <= 0) {
	                        continue;
	                    }
	                }

	                else if (userInp == 2) {
	                	//This is the sneak chance, 1 in 3 chance of getting away.
	                    int sneakCh = ThreadLocalRandom.current().nextInt(1,4);

	                    if (sneakCh == 1) {
	                        DPO("You've successfully snuck away from the " + Enemy.getName(),10);
	                        break;
	                    }
	                    else {
	                        DPO("Oh no! The attempt to sneak was unsuccessful!",10);

	                    }
	                }

	                else if (userInp == 3) {
	                	//should check for inventory before allowing to use item.
						inventory.displayInventory();
	                }

	                //if user inputs any other number or letter, an error is raised.
	                else {
	                    throw new ArithmeticException();
	               }

	                Thread.sleep(400);

	                //enemy's turn.
	                Attack(Enemy,X); 
	                

	                Thread.sleep(400);
	                System.out.println("\nHP: " + X.getHP());
	                System.out.println("Enemy HP: " + Enemy.getHP());
	                Thread.sleep(1000);
	            }
	            catch(Exception ArithmeticException) {
	                System.out.println("Please enter a proper number between 1 - 3");

	            }

	        }


	        //if the enemy's HP is below or equal to zero, then the cutscene plays and u get whatever the enemy drops.
	        if (Enemy.getHP() <= 0) {
	            DPO("Enemy " + Enemy.getName() + " has been slained!",10 );
	            DPO(Enemy.getName() + " has dropped a " + Enemy.getItem(),10);
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
	    
    
    static void Attack(Character X, Character Enemy) throws InterruptedException {
    	int AttackT = X.getTTA();
    	//get initial attack time 
    	System.out.println(AttackT + X.getName());
    	//if the turns to attack are 0, then they can attack.
    	if (X.getTTA() == 0) {
	    	X.dmg(Enemy);
	    	DPO(X.getName() + " attacks " + Enemy.getName() + " and deals " + X.getDmg() + " damage",10);
	    	X.setTTA(AttackT);
    	}
    	else {
             DPO("Enemy " + X.getName() + " is charging up their attack...",10);
             X.setTTA(X.getTTA() - 1);
    		}
    		//TTA--
    	
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
