import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {
	
	
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
			DPO(textBox("LANDING COMPLETE. SYSTEM UNABLE TO COMPLETE UPDATE. SIGNAL STRENGTH WEAK"),10);
			DPO("\n1 - search for antenna",10);
			boolean cont = false;
			while (!cont) {
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
				DPO("You pop open the spaceship’s hood and place the antenna",25);
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
			
			DPO("1 - take a step back",25);
			
			userChoice = inp.nextInt();
			if (userChoice == 1) {
				DPO("You are unable to take a step back, STUNNED BY UGLINESS (2 turns) ",25);
			}
			
	}
    
    
    
//=--------------------------------------------------------------------
    //MAIN 
    
    
    
    public static void main(String[] args) throws InterruptedException {
    	//MainMenu();
        Character t1 = new Character("n",10,100);
        Alien t2 = new Alien("f",10,100,2,2,"sword");

		Scanner scanner = new Scanner(System.in);
		Map map = new Map();
		map.printMap();
		System.out.println("Enter direction");
		String dir = scanner.nextLine();
		map.locationChange(dir);
		map.printMap();
        t1.setSPA("Ice");
        Combat.combat(t1,t2);

    }
    
    
    //-----------------------------------------------
    
    
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
