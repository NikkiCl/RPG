import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Combat {
	
	   static void combat(Character X, Alien Enemy) throws InterruptedException {
	        int userInp;
	        Scanner imp = new Scanner(System.in);

	        //combat loop
	        while (X.getHP() > 0 && Enemy.getHP() > 0) {
	        	//while main character HP and enemy HP arent below 0:
	            try {
	                System.out.println("\n\n\n");
	                DPO("What would you like to do?",10);
	                DPO("1. Fight	2. Special Attack	3. Sneak	4. Use item\n",10);
	                TimeUnit.SECONDS.sleep(2);
	                //if user inputs 1, they fight, else 2, they sneak.
	                userInp = imp.nextInt();
	                if (userInp == 1) {
	                    Attack(X,Enemy);
	                    //if the enemy gets slain, it skips the enemy's turn and goes straight to the cutscene
	                    if (Enemy.getHP() < 0) {
	                        continue;
	                    }
	                }

	                else if (userInp == 2) {
	                    X.StartSPA(Enemy);
	                    if (X.getSPA().equals("Poison")) {
	                    	DPO("You poison " + Enemy.getName() + " with your magic and deal " + X.getSpecialAttacks().get(X.getSPA()) + " damage.",10);
	                    	}
	                    else if (X.getSPA().equals("Ice")) {
	                    	DPO("You freeze " + Enemy.getName() + " with your alien powers for " + X.getSpecialAttacks().get(X.getSPA()) + " turns",10);
	                    	Enemy.setFrozen(true);
	                    }
	                    if (Enemy.getHP() < 0) {
	                        continue;
	                    }
	                }

	                else if (userInp == 3) {
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

	                else if (userInp == 4) {
	                	//should check for inventory before allowing to use item.
	                }

	                //if user inputs any other number or letter, an error is raised.
	                else {
	                    throw new ArithmeticException();
	               }

	                Thread.sleep(400);

	                //enemy's turn.
	                Attack(Enemy,X);
	                

	                if(Enemy.getCounter() > 0) {
	                	SpecialAttack(X,Enemy);
	                }

	                Thread.sleep(400);
	                System.out.println("\nHP: " + X.getHP());
	                System.out.println("Enemy HP: " + Enemy.getHP());
	                Thread.sleep(1000);
	            }
	            catch(Exception ArithmeticException) {
	                System.out.println("f");

	            }

	        }


	        //if the enemy's HP is below or equal to zero, then the cutscene plays and u get whatever the enemy drops.
	        if (Enemy.getHP() <= 0) {
	            DPO("Enemy " + Enemy.getName() + " has been slained!",10 );
	            DPO(Enemy.getName() + " has dropped a " + Enemy.getItem(),10);
	        }
	    }
	    
    
    static boolean Attack(Character X, Character Enemy) throws InterruptedException {
    	if (X.getTTA() == 0) {
	    	X.dmg(Enemy);
	    	DPO(X.getName() + " attacks " + Enemy.getName() + " and deals " + X.getDmg() + " damage",10);
	    	return true;
    	}
    	else {
    		if (X.isFrozen()) {
	    		DPO(X.getName() + " is currently frozen for " + X.getTTA() + " turn(s)",10);
	    	}
    		else if (X.getTTA() > 0) {
                DPO("Enemy " + Enemy.getName() + " is charging up their attack...",10);
    		}
            X.setTTA(X.getTTA() - 1);
    	}
    	return false;
    	
    }
    
    static void SpecialAttack(Character X, Character Enemy) throws InterruptedException {
        	if (X.getSPA().equals("Poison")) {
            DPO(Enemy.getName() + " is poisoned... take 5 damage",10);
            Enemy.setHP(Enemy.getHP() - X.getSpecialAttacks().get(X.getSPA()));

        	}
        	else if (X.getSPA().equals("Frozen")) {
        		DPO(Enemy.getName() + " is frozen for " + X.getSpecialAttacks().get(X.getSPA()) + " turns",10);
        		
        	}
        	
            Enemy.setCounter(Enemy.getCounter() - 1);
        	//This is the special attack function, enemy -= 5 if poison 
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
