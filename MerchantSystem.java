import java.util.ArrayList;
import java.util.List;
// MERCHANT
class MerchantSystem {
    // Class representing an item in the game
    static class Item {
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
    static class Merchant {
        List<Item> inventory; // List of items available for sale

        // Constructor initializes the merchant's inventory with items
        public Merchant() {
            inventory = new ArrayList<>();
            inventory.add(new Item("Health Potion"));
            inventory.add(new Item("Sword"));
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
                    return characterInventory.getItems().contains("pot of gold"); // requirements
                case "Sword":
                    return characterInventory.getItems().contains("pair of Bear Claws");
                default:
                    return false; // Default case
            }
        }

        // Remove required items from the character's inventory when purchasing
        private void removeItems(Item item, InventorySystem characterInventory) {
            switch (item.name) {
                case "Health Potion":
                    characterInventory.getItems().remove("Pot of Gold"); // Remove 1 Stick
                    break;
                case "Sword":
                    characterInventory.getItems().remove("pair of Bear Claws"); // Remove 1 Shield
                    break;
            }
        }
    }
}

