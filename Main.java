import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Main{
	static InventorySystem inventory = new InventorySystem();
	static boolean startedPlaying = false;//Setting a condition to flag to later be used in the welcome method to keep player within game loop
	static void welcome() throws InterruptedException { //renamed to avoid naming conflicts  // this is the method that greets the user and first interacts with them asking to confirm if they want to play
		Scanner w = new Scanner(System.in);
		int userInp;
		DPO("Welcome to Alien Lands",10);
		System.out.println("\n\n1. Start game\n2. Quit");
		userInp = w.nextInt();
		
		if (userInp == 1) {
			intro(w);//Passing the scanner object to the function to mainstream code and reuse the object
		}else if (userInp == 2) {
			System.out.println("Quitting");
			System.exit(userInp);
		} else {
			System.out.println("Wrong input"); //just some input validation
			welcome();
		}
	}
	
	
	static void intro(Scanner uInput) throws InterruptedException {  //Recieves the scanner object as parameter and now seprated from startGame
		//user input
		DPO("Enter your name: ",35);
		String name = uInput.next();
		//uses userinput to get name 
		
		//CHARACTER CREATION HERE!!!! 
		Character X = new Character(name,10,100);
		// - -- - -  -- - - 
		
		
		//in this instance, whenever we refer to "x" we are referring to the main character aka the player.
		startGame(uInput, X);

	}

	

	static void startGame(Scanner uInput, Character X) throws InterruptedException {  //Recieves the scanner object as parameter    //This method loops infinately to keep plaayer inside of game until the player exits through the menu and calls each scene based on location of player
		
        if (!startedPlaying && Map.getCurrentLocation().contains("Start")) {// && oporater checks to see if they are both true and if startedPlaying is true means it hasnt been played before it then checks to see if the location is start then it calls the method
           SceneOne(X, uInput);
		   startedPlaying = true; //and it sets the flag to true after SceneOne plays so the next time the loop is called back the !value will be false
        }

		while (startedPlaying) {//Main game loop, keeps running until/if broken in the menu otherwise almost infinate
			
			plyrChoice(uInput,X);//passing the scanner object to the function to reuse and write less lines of code
			//also calling it after any part of the story is ran

				
			if (Map.getCurrentLocation().contains("Tiny Cave")) {
				tinyCave(X);
			} else if (Map.getCurrentLocation().contains("Soldier")) {
				weakAlienSoldierF(X); 
			} else if (Map.getCurrentLocation().contains("Alien slums")) { // Check player's current location and trigger specific scenes or fights
			AlienSlums();  // call Alien slums function
			}else if (Map.getCurrentLocation().contains("CrossRoads")) {
				mountainCrossRoads(X, uInput);  
			}else if (Map.getCurrentLocation().contains("Tunnel")) {
				DPO("You keep on wandering through the tunnel....",35);
			}else if (Map.getCurrentLocation().contains("Secret door")) {
				DPO("You arrive at a secret entrance...",35);
			}else if (Map.getCurrentLocation().contains("Mansion")) { //placed in order for efficiency
			Mansion(X,uInput);
			} else if (Map.getCurrentLocation().contains("Backyard")) {
			backYard(X,uInput);	
			}else if (Map.getCurrentLocation().contains("🌲🌲")) {
			ending(X, uInput);	
			}
		}
	}

	static void gameMenu(Scanner uInput, Character x) throws InterruptedException {

		// Display the menu options before getting user input
		System.out.println("\n\n1. View Map\n2. Show Inventory\n3. Show Stats\n4. Back\n5. Quit");
		
		// Get user input
		int choice = uInput.nextInt();
	
		// Handle menu choices using a switch statement
		switch (choice) {
			case 1:
				// Call print map method
				Map.printMap();
				 //give a way back to the student
				 if (backBtn(uInput)) { // if returned true it means input is valid
					gameMenu(uInput,x); // call gameMenu
				} else {
					return;
				}
				break;
	
			case 2:
				inventory.displayInventory();
				if (backBtn(uInput)) { // if returned true meaning input is valid
					gameMenu(uInput,x); // call gameMenu
				} else {
					return;
				}
				break;

			case 3://Print character stats 
			System.out.println(x.toString());
			if (backBtn(uInput)) { // if returned true meaning input is valid
				gameMenu(uInput,x); // call gameMenu
			} else {
				return;
			}
			break;
			
			case 4:// go back to startgame passing the players stats
			startGame(uInput, x);
				break;
			
			case 5:// Quit the game
				System.out.println("Exiting game,\n Going back to start");
				welcome(); //goes back to the start of game
				break;
	
			default:// Handle invalid input
				System.out.println("Invalid input. Please choose a valid option.");
				gameMenu(uInput, x);//call the fuction again
		}
	}
	
    static void plyrChoice(Scanner uInput, Character x) throws InterruptedException { //Recieves scanner object as a parameter
        System.out.println("\nEnter direction to move (n, e, s, w) or enter 1 to display menu:");
        
        
        if (uInput.hasNextInt()) {//Checks if the next input is an integer and if so it will execute that block 
            int input = uInput.nextInt(); //If so then put it into the scanner int object
            
            // If input is '1', open the menu
            if (input == 1) {
                System.out.println("Menu");
                gameMenu(uInput,x);
            } else {
                System.out.println("Invalid number. Only '1' is valid for menu.");
            }
        } else { // Else, treat the input as a string (for movement directions)
            String dir = uInput.next().toLowerCase(); //Cap safe
            
            // validate their input otherwise print error msg
            switch (dir) {
                case "n":
                case "e":
                case "s":
                case "w":
                    Map.locationChange(dir);
					//DPO("\n\n\n\n\nTravelling...................\n\n\n",55);
					//DPO(textBox("You have arrived at: " + map.getCurrentLocation()),25);
                    break;
                default:
                    System.out.println("Invalid direction. Please enter 'n', 'e', 's', or 'w'.");
                    break;
            }
        }
    }

	static boolean backBtn(Scanner uInput) throws InterruptedException {//gets scanner passed as parameter
		System.out.println("\nPress 1 to go back");//initially prints msg
		boolean valid = true;//set initial value to true in the outer scope

	if (uInput.hasNextInt()) { //if the user input contains an integer then go through with the next loop
		int input = uInput.nextInt();
		if (input == 1){// now is that input 1 or is it a diffrent number
		return valid;	
		} else {
		System.out.println("Invalid number.");
		return !valid;
		}
	} else { // if the user input does not contain an integer then just print that message below and return false
		System.out.println("Invalid Input, Please try again.");
		return !valid;
	}
	}
    
    
    
//=--------------------------------------------------------------------
    //MAIN 
    
    
    
    public static void main(String[] args) throws InterruptedException {
		welcome();
		//Character t1 = new Character("d",50,100,0);
    	//backYard(t1);
        
        
    }
    
    
    //-----------------------------------------------
    
	static void SceneOne(Character x, Scanner scanner) throws InterruptedException {
		int userChoice;
		//variable for user input 
		
		
		
		//All of this here is dialogue with a few loops, so the comments will be small.
		//----------------------------------
		DPO(textBox("WARNING!"),10);
		DPO("Initiating scheduled update in 3 minutes. Please ensure your system is shut off at this time....",20);
		Thread.sleep(400);
		DPO("The system's warnings blared through the spaceship speakers, with flashing red lights now beginning to fill the room.",10);
		DPO("\n" + x.getName() + ":\nOH moon DOGGIE, I completely forgot about this.",20);
		Thread.sleep(400);
		DPO("You hastily tap on the system radar, trying to view the last scan.\n",15);
		DPO(x.getName() + ":\nCmon cmon...\n\n",25);
		Thread.sleep(1000);
		DPO(textBox("INITIATING EMERGENCY LANDING"),10);
		Thread.sleep(500);
		DPO("You stare in horror as the spaceship autopilot takes control and begins to veer itself onto an unknown sphere\n",10);
		DPO(textBox("LANDING COMPLETE. SYSTEM UNABLE TO COMPLETE UPDATE. SIGNAL STRENGTH WEAK"),25);
		DPO("\n1 - search for antenna",10);
		boolean cont = false;
		//boolean value continue for a small loop where if the player doesnt pick 1, it'll keep playing until they pick 1
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
					//if user enters a number other than 1 it prompts the user to enter 1 
				}
			}
			catch (Exception e) {
			//simple try catch function, if the user enters a letter or something other than an integer, it brings an error 
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
		DPO("\nAn unknown winged creature swoops down upon you and snatches the antenna\n",25);
		
		DPO(x.getName() + ":\nHEY IM NOT A DORK!!!! YOU GIVE THAT BACK!!!!!!!.... AND YOU TAKE THAT BACK!!!",25);
		
		DPO("1 - chase after bird 		2 - Look down and ponder",25);
		userChoice = scanner.nextInt();
		if (userChoice == 2) {
			DPO("After some pondering",10);
		}
		DPO("You chase after the bird, yelling obscenities and pleading for the bird to rethink it’s decision.\nSuddenly, the bird starts circling back, dropping something towards you.\n\n",25);
		DPO(x.getName() + ":\nYES!! THANK YOU FOR MY ANTENNA",35);
		Thread.sleep(400);
		
		System.out.println("\n\n\n  _____  _      ____  _____  \n"
				+ " |  __ \\| |    / __ \\|  __ \\ \n"
				+ " | |__) | |   | |  | | |__) |\n"
				+ " |  ___/| |   | |  | |  ___/ \n"
				+ " | |    | |___| |__| | |     \n"
				+ " |_|    |______\\____/|_| ");
		Thread.sleep(1000);
		DPO("\nAn abhorrent smell reeks from the blob of brown substance on the ground before you.",25);
		DPO("You shake your first at the bird, whose figure was now barely visible, as it flew further and further away\n",25);
		DPO(x.getName() + ":\nCOSMIC PEST!!\n\n",35);
		DPO(textBox("A voice loomed in the distance"),15);
		Thread.sleep(400);
		DPO("\n?????:\nYou alright there partner? Haven’t seen a spaceship xxx999 except on the galactic screen",35);
		
		DPO("\nYou turn around and awkwardly meet a face that only a mother could love\n",25);
		
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
		
		for (int i = 2; i >= 0 ; i--) {
			DPO("1 - take a step back",25);
			
			userChoice = scanner.nextInt();
			
			//simple loop for comedy aspect. once the iteration hits 0 it continues automatically 
			if (userChoice == 1) {
				if (i == 0) {
					continue;
				}
				DPO("You are unable to take a step back, STUNNED BY UGLINESS (" + i + " turn(s)) ",25);	
			}
			else {
				DPO("Please pick the number 1.",25);
				i ++;
				//if the user picks smth other than 1, the loop keeps on playing. 
			}
		}
		
		DPO("\n\n\nYou finally regain your speech",25);
		DPO(x.getName() + ":\nYeah... Thanks...",35);
		
		DPO("\nThe ugly man noticed you slowly backing away and frowned, puzzled.",25);
		DPO("Ugly man:\nDid I say somethin to upset ye? Or is it my breath? I’ve only had fermented eggs this mornin\n",35);
		
		DPO(x.getName() + ":\nUhm.. oh no..its just.. I've had a lot on my mind recently, a large bird just took something important from me.\n",35);
		
		DPO("Ugly man:\nOh yea i saw that, that'll be Blarbazops little pet. Hes the biggest thief. \nMatter a fact the reason why everyone is poor here. He just keeps stealing our things that are valuable\n",35);
		
		DPO(x.getName() + ":\nWell whatever that 'thing' is, he stole the antenna that I need to get home so i need to find that *bleep blap* and get my antenna back from him. Sad thing is, I dont know where it went.",35);
		
		DPO("\nUgly man:\nTo find him you have to climb that mountain….uhhmm oh no this other one… orrrr umm maybe the ones back that way. You know what Ill just give you my map. I dont leave my farm anyways\n",35);
		
		DPO(textBox("NEW ITEM UNLOCKED: map"),25);
		DPO("\n\n",35);
		Map.printMap();
		
		
    }
	
	
	static void tinyCave(Character X) throws InterruptedException {
		
		DPO("You step foot into the dark cave and hear..\n\n",35);
		
		System.out.println("░▒▓███████▓▒░ ░▒▓██████▓▒░ ░▒▓██████▓▒░░▒▓███████▓▒░░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░ \r\n"
		+ "░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░ \r\n"
		+ "░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░ \r\n"
		+ "░▒▓███████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓████████▓▒░▒▓███████▓▒░░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░ \r\n"
		+ "░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░ \r\n"
		+ "░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░                   \r\n"
		+ "░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░ \r\n"
		+ "                                                                       ");

		//fight starts 
		wingedbearF(X);
	}
    
    
	static void AlienSlums() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int userChoice;
	
		DPO("You arrive in a wasteland riddled with less ugly aliens. It looks like this is their version of a market.", 25);
		DPO("1 - Go to merchant  2 - Keep on walking", 25);
		userChoice = sc.nextInt();

		if (userChoice == 1) {
			// Interact with the merchant
			MerchantSystem.Merchant merchant = new MerchantSystem.Merchant();
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
						DPO("You bought: " + boughtItem + "\n\n", 10);
					} else {
						DPO("You could not buy that item.", 10);
					}
				}
			}
		} else if (userChoice == 2) {
			// Move past the alien slums 
			DPO("You decide to keep walking, leaving the market behind.", 25);
		}
	}


	
	static void Mansion(Character X, Scanner scanner) throws InterruptedException {
    	DPO("You arrive at the frontyard of a massive mansion, surrounded by golden gates and a delectable collection of trinkets",25);

	//while loop where the loop keeps repeating until the user selects 2. There is no debugging for this since I asked the teacher and he said I didnt have to. 
    	while (true) {
        	DPO("1 - Open front door	2 - Head to backyard",25);
        	int userInp = scanner.nextInt();
        	if (userInp == 1) {
        		DPO("Your height limits you from being able to reach the door handle.",25);
        		
        	}
        	else if (userInp == 2) {
        		DPO("You head to the backyard",25);
        		Map.movePlayer(1, 2); 
        		backYard(X,scanner);
        		//travel to backyard
        		break;
        	}
    	}
    }
	


	static void backYard(Character X,Scanner scanner) throws InterruptedException {
		DPO("Upon arrival, the bird who stole your antenna notices you.",25);
		DPO("Jock Bird:\nCAW CAW. DORK, DORK\n",35);
		DPO("Blarbazop:\nWhat are you doing here!! Chris Hansen kill that stranger!!!!!\n",35);
		DPO("Chris Hansen(Previously known as Jock Bird):\nCAWWWWWW!",35);
		System.out.println("\n\n\n   _______          ______   ____   _____ _    _ _ "+
		"\n  / ____\\ \\        / / __ \\ / __ \\ / ____| |  | | |\n"
		+ " | (___  \\ \\  /\\  / / |  | | |  | | (___ | |__| | |\n"
		+ "  \\___ \\  \\ \\/  \\/ /| |  | | |  | |\\___ \\|  __  | |\n"
		+ "  ____) |  \\  /\\  / | |__| | |__| |____) | |  | |_|\n"
		+ " |_____/    \\/  \\/   \\____/ \\____/|_____/|_|  |_(_)");
		wingedCreatureMiniBoss(X);
		DPO("You hastily make a run for the antenna, before hearing a loud siren",25);
		DPO(textBox("LOCK DOWN INITIATING... INTRUDER DETECTED...."),25);
		DPO("You look up in horror as the gates, once still and devoid of life, had begun to transform itself into an impenetrable fortress, blocking each and every crevice of the area.",25);

		System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⠔⠀⠀⢀⣀⣤⣶⣴⣶⣶⣿⣿⣿⣷⣾⣷⣤⡀⠐⢄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠔⠋⠀⣀⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣍⠺⣿⣿⣤⣈⠢⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡚⠁⣀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣖⣿⣿⣿⣿⣷⣌⠢⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣊⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣬⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⣿⢿⡿⣿⣿⡿⣽⣟⣟⣿⣿⣿⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣻⣞⡿⣟⣿⣻⣿⡷⣟⣷⣿⣻⡿⢿⡿⣿⣽⣾⣿⣿⢿⣿⣿⣿⣿⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣻⣶⣿⣱⣯⣿⣾⣿⣷⠿⢟⢻⢖⣣⣟⣬⣷⣿⣿⣿⣽⣽⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣮⣷⣿⣛⣫⣤⣶⠿⣶⣟⣿⣯⢽⣽⣾⣟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣽⠾⣽⣿⣿⣷⣯⣿⣿⣟⣻⣿⣯⣿⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⡿⣟⣯⣿⣷⣿⣿⣿⣿⣯⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣟⣿⣽⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⣿⣷⣿⣿⢟⣷⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⣉⠛⣿⣿⣿⢿⣿⣿⡿⣶⣟⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡿⣫⣾⣿⣿⣿⣿⣯⣿⣿⣧⣻⢿⣟⣸⠿⢿⣿⣿⣿⣿⣿⣾⣿⠿⣿⣙⠿⡿⢃⣿⣿⣷⣺⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠯⢹⣴⣴⣿⣿⣿⣿⣻⣿⣿⣿⣿⣶⣉⠋⠙⣛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⢟⣭⣿⣻⣿⣿⣿⣿⣿⣿⣿⡷⣭⣿⣿⣿⣿⣿⣷⣽⣟⢻⡛⢭⠧⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣭⣿⣵⣿⣿⣿⣿⣿⣿⣿⣿⣿⣳⣿⣿⣿⣿⣿⣿⢿⣿⣷⣮⣽⢞⣾⣿⣿⣿⣿⡿⠁⢹⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⣿⡏⠉⠉⢻⣿⣿⡿⠿⡿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣲⡏⣻⢟⣿⣷⣆⣱⣾⣿⣿⣿⣙⣦⢻⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⠀⠸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣧⢿⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⠧⣛⡿⣿⣿⣿⣿⣿⣿⡿⠁⠀⠀⠀⠀⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⢷⣽⣿⣿⣿⣿⠿⠁⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⣿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣭⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣯⣟⣷⣿⣷⣾⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣤⠤⡀⠀⠀⠀⠀⠀⠸⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢼⡏⢲⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣼⡷⠲⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣿⣿⣿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡎⢦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢞⠋⣡⣾⣿⣿⣴⣿⣿⣿⣿⣿⣿⣿⣿⣟⡿⡟⢯⣩⢗⣯⣻⣿⢿⣟⣾⣿⣿⣿⣿⣿⡿⢿⣿⣿⣷⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡿⠖⣼⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⣿⣿⣿⣼⢫⢏⡵⢯⣶⣿⡿⣯⢾⣽⣿⣿⣿⣿⣿⣷⣿⣿⣿⣿⣿⣭⡳⠤⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠴⢶⣿⡿⢁⣽⣿⣺⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⢟⣿⣟⡾⣽⢳⣻⣿⣿⣿⣿⣿⣝⣿⣿⣿⢿⣿⣿⣿⣿⣦⠜⣿⡶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠴⢛⣤⣴⣿⠟⣠⣾⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣚⡿⣞⣾⣿⣱⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣌⠿⢿⣿⣿⣿⣿⣆⢸⣿⣿⣵⣦⣄⣀⣠⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣤⣾⣿⣿⣿⣿⡏⣩⣽⣿⣽⣯⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣯⣿⣿⣿⣶⣿⣾⣿⣿⣿⣿⣿⣿⣯⣿⣿⣿⣿⣾⣿⠿⣿⣿⣿⣆⣺⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣾⣽⣿⣿⣿⣿⣿⣿⣿⣻⣿⣿⣽⣾⣻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⣿⣿⣿⣿⣿⣽⣿⠿⣵⣿⣿⣿⣿⣿⣿⣿⣿⣼⢿⣿⣿⣿⣿⣟⡅⡾⣿⣿⣿⣽⣻⣿⣿⣶⡿⠿⠿⣿⣿⡷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣾⣿⣿⣿⣿⣯⣜⣿⣿⣿⣿⣿⣿⣯⣿⣿⣿⣿⣿⣿⣿⠟⡻⣿⣻⣿⡿⣿⠿⡇⠹⣿⣿⣿⣿⡿⢃⡾⡿⢻⠟⡛⢳⡟⢋⠻⣿⣿⣿⣿⣋⡟⢻⣿⣷⣦⣿⣿⣿⣟⣿⣿⣿⣿⣷⣀⢴⣯⣗⣷⣮⣗⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⠀⠀⢀⣠⣶⣻⣿⡿⣿⣟⣯⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⡿⣏⡿⣿⣿⣿⡷⣽⢷⣻⡵⣎⣖⣤⡐⠠⣙⢯⣝⣮⡟⣧⡟⡷⣞⣴⡿⣾⣷⣿⣿⣿⢛⡿⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣻⣿⣟⣿⣿⣯⣛⣿⣿⣝⣿⣿⣯⣳⣄⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⠀⠀⣠⣶⣿⣯⣿⢿⣿⣷⣾⣿⣯⣿⣿⣿⣿⣿⣿⣿⣿⣼⣿⣿⣿⣿⣧⢹⣏⠿⣿⣷⢿⣯⣟⣷⣿⣶⢭⢣⠝⡶⣉⠾⣞⡵⣟⣳⣽⣳⢯⣾⣷⣿⢯⣿⣿⣟⣿⡇⣾⣿⣷⣿⣯⣿⣿⣿⣿⣿⣿⣿⣿⡿⣭⣿⣭⣹⣿⣿⣿⡟⣿⣿⣿⣷⣄⡀⠀⠀⠀⠀⠀\r\n" + //
						"⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⣽⣿⣿⡇⢿⡄⣿⣿⣺⣎⣟⡻⢷⡬⢛⡷⡎⣵⢊⣿⢼⣳⢯⡾⢶⣹⣮⣿⣿⣯⢿⣿⣿⣾⡟⢉⣿⣿⣿⡼⣿⣿⣿⣿⣿⣿⣿⡿⣾⣿⣯⣿⣷⣺⣿⣿⣿⣿⣿⣿⣻⣿⣿⡙⣦⡀⠀⠀⠀\r\n" + //
						"⠀⠀⢠⡿⣿⣿⣯⣿⣿⣿⣿⣿⣯⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡷⡍⣿⣿⡏⢸⣧⣿⣿⣳⢿⣺⣽⡟⣻⣵⢢⢵⡨⢯⣽⣾⢿⣿⣋⣯⢧⣿⣿⣿⣾⢯⣿⣿⢻⣇⣼⣿⣿⣿⣇⢟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⢩⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣷⣷⣄⠀⠀\r\n" + //
						"⠀⢠⣾⣿⣿⣟⣿⣿⣿⣿⢿⣧⡻⣗⣻⣿⣿⣿⣿⣿⣿⣿⣿⣯⣿⣿⣗⢳⣿⠿⣷⢏⣿⢸⣾⡹⣏⣿⠼⡿⣅⢿⣷⡎⢷⣿⢿⡽⣳⣶⢯⠻⣿⣿⣯⢷⡿⣿⣿⣿⣫⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣛⣿⣿⣿⣿⣯⣹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀\r\n" + //
						"⠰⠺⠿⠿⠿⠯⠿⠿⠿⠿⠿⠿⠿⠿⠷⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠮⠿⠿⠿⠿⠿⠿⠿⠷⠷⠾⠿⠶⠿⠷⠿⠿⠶⠾⠾⠾⠾⠿⠶⠿⠿⠷⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠷⠿⠿⠿⠿⠿⠿⠿⠿⠷⠿⠿⠿⠿⠿⠿⠦");
		DPO("Blarbazop:\nYou have killed my favourite pet, the only creature that I viewed as an equal in this mundane hellscape of a planet.",35);
		DPO("\nYou inch away, spouting out mumbled apologies and desperately searching for a possible escape",25);
		DPO("Blarbazop:\nI hope you don't believe that you're getting away with this.",35);
		Map.movePlayer(1, 1);
		//moves the player to the mansion before beginning the boss fight due to the deadEnemies list.
		finalBoss(X);
		//after the boss fight is completed, the user gets the ending scene.
		ending(X,scanner);
		

	}
	
	
	static void mountainCrossRoads(Character X, Scanner scanner) throws InterruptedException {
		scanner.nextLine();
		DPO("The sight of a luscious green mountain coupled with an amazing waterfall greets your eyes.",25);
		DPO("Where would you like to go?\n1 - Waterfall		2 - Mountain",25);
		int userInp = scanner.nextInt();
		if (userInp == 1) {
			DPO("You walk beneath the waterfall and find a hidden tunnel, with ancient hieroglyphics scattered across the walls",25);
			DPO("You stumble across a pot of gold, with a note which contained an unknown phrase",25);
			DPO(textBox("NEW ITEM UNLOCKED: pot of gold"),25);
			DPO(X.getName() + ":\nI wonder if I can use this to trade...",35);
			//if the user picks 1, they stumble across a pot of gold which gets added to their inventory and the map moves the player to the waterfall manually
			Main.inventory.pickUpItem("pot of gold");
			Map.movePlayer(3, 0);
			
			}
		else if (userInp == 2) {
			DPO("You hike up the steep mountain...",25);
			//if the user picks 2, they hike up the mountain and fight a sloth, and the map moves the player to the mountain manually
			Map.movePlayer(2, 1);
			slothF(X);
			}
		}

	static void ending(Character x,Scanner scanner) throws InterruptedException {
		scanner.nextLine();
		DPO("You take a deep breath of relief and walk up to grab your antenna before noticing the ugly man you had met from earlier, who seemed somehow even uglier than before.",25);
		
		System.out.println("\n                _\r\n"
				+ "            ,.-\" \"-.,\r\n"
				+ "           /   ===   \\\r\n"
				+ "          /  =======  \\\r\n"
				+ "       __|  (-)   (-)  |__      \r\n"
				+ "      / _|   |.---.|   |_ \\         \r\n"
				+ "     | /.----/ O O \\----.\\ |       \r\n"
				+ "      \\/     |     |     \\/        \r\n"
				+ "      |                   |            \r\n"
				+ "      |                   |           \r\n"
				+ "      |                   |          \r\n"
				+ "      _\\   -.,_____,.-   /_         \r\n"
				+ "  ,.-\"  \"-.,_________,.-\"  \"-.,");
		DPO("Ugly man(sniffling):\nAll praise the prophet. Oh holy is the day you have freed us from that evil evil man. Please stay back and guid us back into building our society. Help us live the golden days again.",35);
		DPO("What would you like to do?\n1 - stay and rule 		2 - return back to your planet",25);
		int userInp = scanner.nextInt();
		if (userInp == 1) {
			DPO("\n'OH BLESSED THEE!'\nThe ugly man exclaimed, wrapping his wrinkly arms around you\n",25);
			DPO(x.getName() + ":\nOkay okay, that's enough...\nYou inch away from the ugly man, still trying to wrap your brain around everything that has happened over the past few days",25);
			DPO("You carefully place the crown on top of your head.",25);
			DPO("'I guess this is home now.'",35);
			System.exit(userInp);
		}
		
		else if (userInp == 2) {
			DPO("\n" + x.getName() + ":\nSorry but I can't just pick up and leave like that.",35);
			DPO("You try to avoid the ugly man's gaze, as his tears, once filled with joy were now overrun by sadness\n",25);
			DPO(x.getName() + ":\nI'll still come and visit though!",35);
			DPO("After waiting for the ugly man to calm down, you head back to the spaceship and attach the antenna onto the rooftop before finally being able to start the update",25);
			DPO(textBox("UPDATE COMPLETE"),25);
			DPO("By now, the sun had started to set and before starting up the engine, you gazed back at the planet solemnly as it finally sets in that you will have to return to your mundane life as a cog in the machine.",25);
			System.exit(userInp);
		}
	}
    
    
    //fights to gain items. 
    static void wingedbearF(Character x) throws InterruptedException {
    	//initiates the first player fight with a winged bear
    	Alien WingedBear = new Alien("Winged Bear",10,35,0,"pair of Bear Claws");
	//creates the enemy and provides the statistics
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

	static void wingedCreatureMiniBoss(Character x) throws InterruptedException{
		Alien jock = new Alien("Jock Bird",20,50,0,"Antenna");
		Combat.combat(x, jock);
	}

	static void finalBoss(Character x) throws InterruptedException{
		Alien finalBoss = new Alien("Blarbazop",30,120,2,"Crown");
		Combat.combat(x,finalBoss);
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
