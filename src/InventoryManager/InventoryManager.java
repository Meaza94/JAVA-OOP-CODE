package InventoryManager;

public class InventoryManager {

	 // findItemIndex searches the inventory for an item by name.
    // It takes a 2D array representing the inventory and a string for the item name as arguments.
    // The method returns the index of the item if found, or -1 if the item is not found.
	    public static int findItemIndex(String[][] inventory, String itemName) {
	        for (int i = 0; i < inventory.length; i++) {
	            if (inventory[i][0].equalsIgnoreCase(itemName)) {
	                return i;
	            }
	        }
	        return -1;
	    }

	    
	    public static void updateInventory(String[][] inventory, int itemIndex, int quantity) {
	        int currentQuantity = Integer.parseInt(inventory[itemIndex][1]);
	        currentQuantity -= quantity;
	        inventory[itemIndex][1] = String.valueOf(currentQuantity);
	    }

	    
	    public static void restockItem(String[][] inventory, int itemIndex, int quantity) {
	        int currentQuantity = Integer.parseInt(inventory[itemIndex][1]);
	        currentQuantity += quantity;
	        inventory[itemIndex][1] = String.valueOf(currentQuantity);
	    }
	}
	 
	
	
	

