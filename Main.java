import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Main {
	static InventorySystem inventory = new InventorySystem();
	Map map = new Map();
	static void MainMenu() throws InterruptedException {
		Scanner w = new Scanner(System.in);
		int userInp;
		DPO("Welcome to RPG game name here idk",10);
		System.out.println("\n\n1. Start game\n2. Quit");
		userInp = w.nextInt();
		
		if (userInp == 1) {
			startGame();
		}
	}
	
	static void startGame() throws InterruptedException {
		Scanner Uinput = new Scanner(System.in);
		//user input
		DPO("Enter your name: ",35);
		String name = Uinput.next();
		//uses userinput to get name 
		Character x = new Character(name,10,100);
		//in this instance, whenever we refer to "x" we are referring to the main character aka the player.
		SceneOne(x,Uinput);
		//mayeb use while statement 
		//put the map and move functions here
		
		//add an if (at this location) statement for the map thingy.
		
		//if map location == alien slums:
		AlienSlums();
		
		//if map location == bear Fight:
		wingedbearF(x);
		
		//if map location == weak alien soldier fight:
		weakAlienSoldierF(x);
		
		//if map location == mountain:
		mountainCrossRoads(x,Uinput);
		
		}
	
    
    
    
//=--------------------------------------------------------------------
    //MAIN 
    
    
    
    public static void main(String[] args) throws InterruptedException {
    	MainMenu();
        //Combat.combat(t1,t2);
        startGame();
    	
        
        
    }
    
    
    //-----------------------------------------------
    
    static void SceneOne(Character x, Scanner scanner) throws InterruptedException {
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
			try {
				userChoice = scanner.nextInt();
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
				System.out.println("Please enter a number");
				scanner.next();
				continue;
			}
		}
		DPO("1 - place antenna on roof		2 - place antenna on hood",10);
		userChoice = scanner.nextInt();
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
		userChoice = scanner.nextInt();
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
		
		for (int i = 2; i <= 1 ; i--) {
			DPO("1 - take a step back",25);
			
			userChoice = scanner.nextInt();
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

		
		
		
		
    }
    
    
    static void mountainCrossRoads(Character x, Scanner scanner) throws InterruptedException {
    	DPO("You arrive and take in the scenery, as a mountain filled with lush greenery and a waterfall that cascaded down into a lagoon appeared before you.",25);
    	DPO("What would you like to do?\n1 - Climb up the mountain	2 - Search the waterfall",25);
    	int userinp = scanner.nextInt();
    	if (userinp == 1) {
    		//go to mountain and sloth fight happens
    		slothF(x);
    		
    	}
    	else if (userinp == 2) {
    		// go to waterfall
    		DPO("You travel through a hidden tunnel wedged beneath the waterfall and stumble across a pot of gold",25);
    		DPO(textBox("You have received: 50 gold coins"),25);
    		DPO("\n 'I wonder if I can use trade this for something....'",35);
    		
    	}
    	
    }

    
    static void Mansion(Character X, Scanner scanner) throws InterruptedException {
    	DPO("You arrive at the frontyard of a massive mansion, surrounded by golden gates and a delectable collection of trinkets",25);
    	while (true) {
        	DPO("1 - Open front door	2 - Head to backyard",25);
        	int userInp = scanner.nextInt();
        	if (userInp == 1) {
        		DPO("Your height limits you from being able to reach the door handle.",25);
        		
        	}
        	else if (userInp == 2) {
        		DPO("You head to the backyard",25);
        		//travel to backyard
        		break;
        	}
    	}
    }
    
	static void AlienSlums() throws InterruptedException { 
		Scanner sc = new Scanner(System.in);
		int userChoice;
		MerchantSystem merchantSystem = new MerchantSystem();
		
		DPO("You arrive in a wasteland riddled with less ugly aliens. It looks like this is their version of a market.", 25);
		DPO("1 - Go to merchant  2 - Keep on walking", 25);
		userChoice = sc.nextInt();
		
		if (userChoice == 1) {
			// Interact with the merchant
			MerchantSystem.Merchant merchant = merchantSystem.new Merchant();
			boolean shopping = true;
			while (shopping) {
				merchant.displayInventory();
				DPO("Which item would you like to buy? (Enter the item number or 0 to exit)", 10);
				int itemChoice = sc.nextInt();
				
				if (itemChoice == 0) {
					shopping = false; // Exit shopping
				} else {
					MerchantSystem.Item boughtItem = merchant.buyItem(itemChoice - 1, inventory);
					if (boughtItem != null) {
						inventory.addItem(boughtItem.toString());
						DPO("You bought: " + boughtItem, 10); // Notify the player of the purchase
					} else {
						DPO("You could not buy that item.", 10); // Notify the player of a failed purchase
					}
				}
			}
		} else if (userChoice == 2) {
			// Move past the alien slums 
			DPO("You decide to keep walking, leaving the market behind.", 25);
		}
	}
    
    
    
    //fights to gain items. 
    static void wingedbearF(Character x) throws InterruptedException {
    	//initiates the first player fight with a winged bear
    	Alien WingedBear = new Alien("Winged Bear",10,35,0,"pair of Bear Claws");
    	Combat.combat(x,WingedBear);
    }
    
    static void weakAlienSoldierF(Character x) throws InterruptedException {
    	Alien soldier = new Alien("Weak Alien Soldier",10,25,0,"Rusty Sword");
    	Combat.combat(x, soldier);
    }
    
    static void slothF(Character x) throws InterruptedException {
    	Alien sloth = new Alien("Sloth",50,50,3,"pair of Sloth Claws");
    	Combat.combat(x, sloth);
    }
    
    
    
    //put this dialogue before reaching a location 
    static void travelDialogue(String location) throws InterruptedException {
		DPO("\n\n\n\n\nTravelling...................\n\n\n",55);
		DPO(textBox("You have arrived at: " + location),25);
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
}