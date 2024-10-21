import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Character {

    private String name;
    private int damage;
    private int HP;
    private int Counter;
    private int turnsToAttack;
    
    
    public void dmg(Character enemy) {
        enemy.HP -= this.damage;
    
    }



    //constructors
    Character(){

    }

    Character(String n,int dmg, int health){
        name = n;
        damage = dmg;
        HP = health;
        turnsToAttack = 0;
    }
    
    
    Character(String n,int dmg, int health,int turnsToAttack){
        name = n;
        damage = dmg;
        HP = health;
        this.turnsToAttack = turnsToAttack;
    }


//setters

    public void setTTA(int amt) {
    	turnsToAttack = amt;
    }

    public void setCounter(int Counter) {
        this.Counter = Counter;
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
    
    public int getCounter() {
        return Counter;
    }
    
    public int getTTA() {
    	return turnsToAttack;
    }
    public String getName() {
        return name;
    }

    public int getDmg() {
        return damage;
    }

    public int getHP() {
        return HP;
    }


    public String toString() {
        return "----------------\nName: " + name + "\nDamage: " + damage + "\nHealth: " + HP;
    }


}

//INVENTORY
class InventorySystem {
    private String chosenitem;
    private int slotMax = 5;
    private Scanner itemScanner = new Scanner(System.in);
    public ArrayList<String> items = new ArrayList<>();

    // Method to add an item to the inventory
    public void addItem(String item) {
        if (items.size() < slotMax) {
            items.add(item);
            System.out.printf("Added %s to inventory.\n", item);
        } else {
            System.out.println("Inventory full! Cannot add more items.");
            displayInventoryDrop();  // Ask to drop an item if inventory is full
        }
    }

    // Method to simulate picking up an item
    public void pickUpItem(String item) {
        System.out.printf("You found a %s!\n", item);
        addItem(item);
    }

    public void displayInventory() {
        System.out.println("\nYour Inventory:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("- " + items.get(i));
        }
        if(!items.isEmpty()){
        System.out.printf("\nWhat item would you like to use?: ");
        String chosenItem = itemScanner.nextLine();
            if (items.contains(chosenItem)) {
            System.out.printf("\nYou chose to use %s\n", chosenItem);
            }else {
                System.out.println("Item not found in inventory. (Check for spelling mistakes)\n");
        }
        }
        else{
            System.out.println("There is nothing in your Inventory.");
        }
    }

    public void displayInventoryDrop() {
        System.out.println("\nYour Inventory:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("- " + items.get(i));
        }

        System.out.printf("\nWhat item would you like to drop? (Enter the name): ");
        String chosenItem = itemScanner.nextLine();

        dropItem(chosenItem);  // Drop the chosen item
    }

    // Method to drop an item from the inventory
    public void dropItem(String chosenItem) {
        if (items.remove(chosenItem)) {
            System.out.printf("Dropped %s from inventory.\n", chosenItem);
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    public ArrayList<String> getItems() {
        return items;
    }
}

// MERCHANT
class MerchantSystem {
    // Class representing an item in the game
    class Item {
        String name; // Name of the item

        // Constructor to initialize the item with a name
        public Item(String name) {
            this.name = name;
        }

        // Override toString to return the name of the item
        @Override
        public String toString() {
            return name;
        }
    }

    // Class for the merchant in the game
    class Merchant {
        List<Item> inventory; // List of items available for sale

        // Constructor initializes the merchant's inventory with items
        public Merchant() {
            inventory = new ArrayList<>();
            inventory.add(new Item("Health Potion"));
            inventory.add(new Item("Sword"));
            inventory.add(new Item("Shield"));
        }

        // Display the merchant's inventory to the character
        public void displayInventory() {
            System.out.println("Welcome to the merchant! Here are the items for sale:");
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println((i + 1) + ". " + inventory.get(i)); // List each item with its index
            }
        }

        // Allows the character to buy an item from the merchant
        public Item buyItem(int index, InventorySystem characterInventory) {
            // Check if the selection is valid
            if (index < 0 || index >= inventory.size()) {
                System.out.println("Invalid selection.");
                return null;
            }

            Item itemToBuy = inventory.get(index); // Get the item selected by the character
            // Check if the character can afford the item
            if (canAfford(itemToBuy, characterInventory)) {
                removeItems(itemToBuy, characterInventory); // Remove the required items from the character
                return inventory.remove(index); // Remove the item from merchant's inventory and return it
            } else {
                System.out.println("You do not have the required items to buy " + itemToBuy.name);
                return null;
            }
        }

        // Check if the character can afford the item based on required items
        private boolean canAfford(Item item, InventorySystem characterInventory) {
            switch (item.name) {
                case "Health Potion":
                    return characterInventory.getItems().contains("Stick"); // Example requirement
                case "Sword":
                    return characterInventory.getItems().contains("Shield") && characterInventory.getItems().contains("Stick");
                case "Shield":
                    return characterInventory.getItems().contains("Health Potion") && characterInventory.getItems().contains("Stick");
                default:
                    return false; // Default case
            }
        }

        // Remove required items from the character's inventory when purchasing
        private void removeItems(Item item, InventorySystem characterInventory) {
            switch (item.name) {
                case "Health Potion":
                    characterInventory.getItems().remove("Stick"); // Remove 1 Stick
                    break;
                case "Sword":
                    characterInventory.getItems().remove("Shield"); // Remove 1 Shield
                    characterInventory.getItems().remove("Stick"); // Remove 1 Stick
                    break;
                case "Shield":
                    characterInventory.getItems().remove("Health Potion"); // Remove 1 Health Potion
                    characterInventory.getItems().remove("Stick"); // Remove 1 Stick
                    break;
            }
        }
    }
}
