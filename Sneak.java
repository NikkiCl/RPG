import java.util.concurrent.ThreadLocalRandom; // Generates random numbers

public class Sneak {
    public boolean sneakChance(){ //Must return boolean so either do sneak or dont sneak
        int sneakRoll = ThreadLocalRandom.current().nextInt(1,4); //Initiating an instance of the built in method and providing it with parameters

        if (sneakRoll == 1) { //
            System.out.println("You've snuck past sucessfully");
            return true;
        } else {
            System.out.println("Oh noo! you've failed to sneak past.");
            return false;
        }
    }

            // Method to call inside main.java
    public void attemptSneak() {
        if (sneakChance()) {
            // in the if statement no conditions are needed since the method will return a boolean so either true or false
            System.out.println("You move quietly and avoid danger.");
        } else {
            // so if returned false
            System.out.println("The enemy noticed you. Prepare for battle!");
        }
        
    }
}
