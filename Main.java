import java.awt.ItemSelectable;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;



static Map map = new Map(); // static making it available by every method

static void gameMenu() throws InterruptedException{
	Scanner inpt = new Scanner(System.in); //initilaise scanner object

	System.out.println("\n\n1. View Map\n2. Show Inventory\n4. Quit");
	int choice = inpt.nextInt();//grab input after prompt
	switch(choice) {
		case 1:
		map.printMap();//Call print map method
		break;
		//The inventory case needs to be written by minh
		case 2:
		System.out.println("Exiting game");
		welcome(); //goes back to the start of the game
		break;
		default:
		System.out.println("Invalid input");//handles invalid input
		break;
	}



}
	static void welcome() throws InterruptedException { //arvin renamed function for code clarity
		Scanner w = new Scanner(System.in);
		int userInp;
		DPO("Welcome to RPG game name here idk",10);
		System.out.println("\n\n1. Start game\n2. Quit");
		userInp = w.nextInt();
		
		if (userInp == 1) {
			startGame();
		}else if (userInp == 2) {
			System.out.println("Quitting");
		} else {
			System.out.println("Wrong input"); //just some input validation
			welcome();
		}
	}
	
	static void startGame() throws InterruptedException {
		Scanner Uinput = new Scanner(System.in);
		DPO("Enter your name: ",35);
		String name = Uinput.next();
		//uses userinput to get name 
		Character x = new Character(name,10,100);
		//SceneOne();
		//mayeb use while statement 
		//put the map and move functions here
		
		//add an if (at this location) statement for the map thingy.
		
		//if map location == alien slums:
		AlienSlums();
		
		//if map location == bear Fight:
		wingedbearF(x);
		
		
		}
	
    
    
        
    static void SceneOne() throws InterruptedException {
		Scanner inp = new Scanner(System.in);
		int userChoice;
		DPO(textBox("WARNING!"),10);
		DPO("Initiating scheduled update in 3 minutes. Please ensure your system is shut off at this time....",20);
		Thread.sleep(400);
		DPO("The system's warnings blared through the spaceship speakers, with flashing red lights now beginning to fill the room.",10);
		DPO("\n'OH moon DOGGIE, I completely forgot about this.'",20);
		Thread.sleep(400);
		DPO("You hastily tap on the system radar, trying to view the last scan.\n",15);
		DPO("'Cmon cmon...'\n\n",25);
		Thread.sleep(1000);
		DPO(textBox("INITIATING EMERGENCY LANDING"),10);
		Thread.sleep(500);
		DPO("The spaceship began to veer itself onto an unknown sphere\n",10);
		DPO(textBox("LANDING COMPLETE. SYSTEM UNABLE TO COMPLETE UPDATE. SIGNAL STRENGTH WEAK"),25);
		DPO("\n1 - search for antenna",10);
		boolean cont = false;
		while (!cont) {
            //while cont = false
			try {
				userChoice = inp.nextInt();
				if (userChoice == 1) {
					DPO("You rummage through a pile of old junk before finally obtaining the antenna.\n",25);
					DPO(textBox("NEW ITEM UNLOCKED: antenna"),10);
					cont = true;
				}
				else {
					DPO("Please enter 1",10);
				}
			}
			catch (Exception e) {
                //if the user enters something other than an integer
				System.out.println("Please enter a number");
				inp.next();
				continue;
			}
		}
		DPO("1 - place antenna on roof		2 - place antenna on hood",10);
		userChoice = inp.nextInt();
		if (userChoice == 1) {
			DPO("You head up to the roof and carefully place the antenna onto the tip of the spaceship",25);
		}
		else if (userChoice == 2) {
			DPO("You pop open the spaceship’s hood and attempt to place the antenna",25);
		}
		
		System.out.println("\n\n\n   _______          ______   ____   _____ _    _ _ "+
				"\n  / ____\\ \\        / / __ \\ / __ \\ / ____| |  | | |\n"
				+ " | (___  \\ \\  /\\  / / |  | | |  | | (___ | |__| | |\n"
				+ "  \\___ \\  \\ \\/  \\/ /| |  | | |  | |\\___ \\|  __  | |\n"
				+ "  ____) |  \\  /\\  / | |__| | |__| |____) | |  | |_|\n"
				+ " |_____/    \\/  \\/   \\____/ \\____/|_____/|_|  |_(_)");
		Thread.sleep(1000);
		
		System.out.print("\n\n\nJock Bird:");
		DPO("CAW CAW!! Dork.",25);
		Thread.sleep(400);
		DPO("\nan unknown winged creature swoops down upon you and snatches the antenna",25);
		
		DPO("\n'HEY IM NOT A DORK!!!! YOU GIVE THAT BACK!!!!!!!.... AND YOU TAKE THAT BACK!!!'",25);
		
		DPO("1 - chase after bird 		2 - Look down and ponder",25);
		userChoice = inp.nextInt();
		if (userChoice == 2) {
			DPO("After some pondering",10);
		}
		DPO("You chase after the bird, yelling obscenities and pleading for the bird to rethink it’s decision.\nSuddenly, the bird starts circling back, dropping something towards me.\n\n",25);
		DPO("'YES. THANK YOU FOR MY ANTENNA'",35);
		Thread.sleep(400);
		
		System.out.println("\n\n\n  _____  _      ____  _____  \n"
				+ " |  __ \\| |    / __ \\|  __ \\ \n"
				+ " | |__) | |   | |  | | |__) |\n"
				+ " |  ___/| |   | |  | |  ___/ \n"
				+ " | |    | |___| |__| | |     \n"
				+ " |_|    |______\\____/|_| ");
		Thread.sleep(1000);
		DPO("\nAn abhorrent smell reeks from the blob of brown substance on the ground before you.",25);
		DPO("I shake my first at the bird, who’s appearance now seemed like a blur as it flew further and further away",25);
		DPO("'COSMIC PEST!!'\n\n",35);
		DPO(textBox("A voice loomed in the distance"),15);
		Thread.sleep(400);
		System.out.print("\n\n ?????:");
		DPO("'You alright there partner? Haven’t seen a spaceship xxx999 except on the galactic screen'",35);
		
		DPO("\nYou turn around and awkwardly meet a person who has a face that only a mother could love\n",25);
		
		System.out.println("\n                _\r\n"
				+ "            ,.-\" \"-.,\r\n"
				+ "           /   ===   \\\r\n"
				+ "          /  =======  \\\r\n"
				+ "       __|  (o)   (0)  |__      \r\n"
				+ "      / _|    .---.    |_ \\         \r\n"
				+ "     | /.----/ O O \\----.\\ |       \r\n"
				+ "      \\/     |     |     \\/        \r\n"
				+ "      |                   |            \r\n"
				+ "      |                   |           \r\n"
				+ "      |                   |          \r\n"
				+ "      _\\   -.,_____,.-   /_         \r\n"
				+ "  ,.-\"  \"-.,_________,.-\"  \"-.,");
		
		for (int i = 2; i > 1 ; i--) {
			DPO("1 - take a step back",25);
			
			userChoice = inp.nextInt();
			if (userChoice == 1) {
				DPO("You are unable to take a step back, STUNNED BY UGLINESS (" + i + " turn(s)) ",25);	
			}
		}
		
		DPO("\n\n\nYou finally regain your speech",25);
		DPO("'Yeah... Thanks...'",35);
		
		DPO("\nThe ugly man notices you slowly backing away and frowns, puzzled.",25);
		DPO("'Ugly man:\nDid I say somethin to upset ye? Or is it my breath? I’ve only had fermented eggs this mornin'",35);
		
		DPO("\n“Uhm.. oh no..its just.. I've had a lot on my mind recently, a large bird just took something important from me.\n",35);
		
		DPO("Ugly man:\n'Oh yea i saw that, that'll be blarbazops little pet. Hes the biggest thief. \nMatter a fact the reason why everyone is poor here. He just keeps stealing our things that are valuable'",35);
		
		DPO("\n'Well that thing he took was my only way to get back home so i need to find that *bleep blap* and get my antenna back from him. Sad thing is i dont know where it went.'",35);
		
		DPO("\nUgly man:\n'To find him you have to climb that mountain….uhhmm oh no this other one… orrrr umm maybe the ones back that way. You know what Ill just give you my map. I dont leave my farm anyways'\n",35);
		
		DPO(textBox("NEW ITEM UNLOCKED: map"),25);
		map.printMap();
		
		
    }


    static void wingedbearF(Character x) throws InterruptedException {
    	//initiates the first player fight with a winged bear
    	Alien WingedBear = new Alien("Winged Bear",10,35,0,0,"Sword");
    	Combat.combat(x,WingedBear);
    }
    
    
    static void AlienSlums() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int userChoice;
		DPO("\n\n\n\n\nTravelling...................",55);
		DPO(textBox("You've arrived at: Alien Slums"),25);
		DPO("You arrive in a wasteland riddled with less ugly aliens. It looks like this is their version of a market.",25);
		DPO("1 - go to merchant 	2 - keep on walking",25);
		userChoice = sc.nextInt();
		if (userChoice == 1) {
			//put ur merchant dialogue and stuff here
		}
		else if (userChoice == 2) {
			//move past the alien slums 
		}
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

        static String textBox(String str) {
    	//function for a framed word 
    	String d = "";
    	int i = 0;
    	int len = str.length();
    	for (i = 0; i < len + 12;i++ ) {
    		//the length of the string + 12 more "-"
    		d += "-";
    	}
    	d += "\n|";
    	//add the second line "|"
    	for (i = 0; i < (len + 10 - str.length()) / 2; i++) {
    		//the length of the string + 10 - the str.length divided by 2 to get the number for centering the word
    		d += " ";
    	}
    	d += str;
    	
    	for (i = 0; i < (len + 10 - str.length())/ 2 ; i ++) {
    		//the second part after we add the strings, same algorithm
    		d += " ";
    	}
    	d += "|\n";
    	//add ending "|" and start new line
    	
    	for (i = 0;i < len + 12; i++) {
    		d += "-";
    		//same algo as first one 
    	}
    	
    	return d;
    }
    static void DPO(String str, long delay) throws InterruptedException {
    	//for character in string that has been turned into a list, print out the character after a certain amount of milliseconds.
        System.out.println();
        for (char ch : str.toCharArray()) {
            System.out.print(ch);
            TimeUnit.MILLISECONDS.sleep(delay);
        }
    }
