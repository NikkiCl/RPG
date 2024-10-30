import java.util.ArrayList;
import java.util.Scanner;
class InventorySystem {
	private int slotMax = 4;
	private Scanner itemScanner = new Scanner(System.in);
	public ArrayList<String> items = new ArrayList<>();

	// Method to add an item to the inventory
	public void addItem(String item) {
		if (items.size() < slotMax) {
			items.add(item);
			System.out.printf("Added %s to inventory.\n", item);
		} else {
			System.out.println("Inventory full! Cannot add more items.");
			displayInventoryDrop(); // Ask to drop an item if inventory is full
		}
	}

	public void pickUpItem(String item) {
		System.out.printf("You found a %s!\n", item);
		addItem(item);
	}

	public void displayInventory() {
		System.out.println("\nYour Inventory:");
		for (String item : items) {
			System.out.println("- " + item);
		}

		if (!items.isEmpty()) {
			System.out.printf("\nWhat item would you like to use?: ");
			String chosenItem = itemScanner.nextLine();
			useItem(chosenItem);
		} else {
			System.out.println("There is nothing in your Inventory.");
		}
	}

	private void useItem(String chosenItem) {
		if (items.contains(chosenItem)) {
			System.out.printf("You used %s!\n", chosenItem);
			items.remove(chosenItem); // Remove the item after use, if applicable
		} else {
			System.out.println("Item not found in inventory. (Check for spelling mistakes)\n");
		}
	}

	public void displayInventoryDrop() {
		System.out.println("\nYour Inventory:");
		for (String item : items) {
			System.out.println("- " + item);
		}

		System.out.printf("\nWhat item would you like to drop? (Enter the name): ");
		String chosenItem = itemScanner.nextLine();

		dropItem(chosenItem);
	}

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
