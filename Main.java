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
		DPO("EMERGENCY!!!!\nEMERGENCY!!!\nFUEL TANK LOW, PLEASE REFILL....",20);
		DPO("The system's warnings blared through the spaceship speakers, with flashing red and orange lights beginning to fill the room.",10);
		DPO("Suddenly, a human voice rings through the speaker.",10);
		DPO("'You alright man? I can see your gas tank's a little low.'",10);
		DPO("You let out a sigh of relief, realising it's your coworker Dave",10);
		DPO("'Yeah, I'm alright, just need to take a slight detour'",10);
		//DPO("The word 'detour' had become integrated slang within our workplace, ")
	}
    
    
    
//=--------------------------------------------------------------------
    //MAIN 
    
    
    
    public static void main(String[] args) throws InterruptedException {
    	//MainMenu();
        Character t1 = new Character("n",10,100);
        Alien t2 = new Alien("f",10,100,2,2,"sword");

        t1.setSPA("Ice");
        Combat.combat(t1,t2);

    }
    
    
    //-----------------------------------------------
    
    
    
    
    
    
    static void DPO(String str, long delay) throws InterruptedException {
    	//for character in string that has been turned into a list, print out the character after a certain amount of milliseconds.
        System.out.println();
        for (char ch : str.toCharArray()) {
            System.out.print(ch);
            TimeUnit.MILLISECONDS.sleep(delay);
        }
    }

}
