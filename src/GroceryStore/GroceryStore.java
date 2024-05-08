package GroceryStore;

import java.util.Scanner;
 
import InventoryException.InventoryException;
import InventoryManager.InventoryManager;

public class GroceryStore {
	 // Scanner object for reading input from the console.
	  Scanner scanner = new Scanner(System.in);
	// 2D array to store inventory items and their quantities.
    String[][] inventory = new String[5][2];

    // Constructor initializes the inventory with predefined items and quantities.
    public GroceryStore() {
        this.inventory[0][0] = "Broccoli";
        this.inventory[0][1] = "14";
        

        this.inventory[1][0] = "Sausages";
        this.inventory[1][1] = "35";
        

        this.inventory[2][0] = "Bread";
        this.inventory[2][1] = "20";
        

        this.inventory[3][0] = "Tortilla";
        this.inventory[3][1] = "40";

        
        this.inventory[4][0] = "Eggs";
        this.inventory[4][1] = "48";
    }

    public void displayInventory() {
        for (int i = 0; i < inventory.length; i++) {
            System.out.println("Item: " + inventory[i][0] + ", Quantity: " + inventory[i][1]);
        }
    }

 // Method to handle the purchase of items by the user.
    public void purchaseItems() {
    	
    	
    	while (true) {
            System.out.println("Enter item name to purchase or 'exit' to exit:");
            String itemName = scanner.nextLine();

            if (itemName.equalsIgnoreCase("exit")) {
                break;
            }

            int itemIndex = InventoryManager.findItemIndex(inventory, itemName);
            if (itemIndex == -1) {
                System.out.println("Invalid item name. Please try again.");
                continue;
            }

            System.out.println("Enter the quantity to purchase:");
            int quantity;
            try {
                quantity = Integer.parseInt(scanner.nextLine());
                validateQuantity(quantity);
                InventoryManager.updateInventory(inventory, itemIndex, quantity);
                System.out.println("Purchase successful! Updated Inventory:");
                displayInventory();
                break;
                
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                
                
            } catch (InventoryException e) {
                System.out.println(e.getMessage());
            }
        }
    }
  
    // Method to handle restocking of items in the inventory.
    public void restockItems() {
       
    	while (true) {
            System.out.println("Enter the name of the item you want to restock or type 'exit' to return:");
            String itemName = scanner.nextLine();

            if (itemName.equalsIgnoreCase("exit")) {
                break;
            }

            int itemIndex = InventoryManager.findItemIndex(inventory, itemName);
            if (itemIndex == -1) {
                System.out.println("Invalid item name. Please try again.");
                continue;
            }

            System.out.println("Enter the quantity to restock:");
            int quantity;
            
            
            
            try {
                quantity = Integer.parseInt(scanner.nextLine());
                validateQuantity(quantity);
                InventoryManager.restockItem(inventory, itemIndex, quantity);
                System.out.println("Restock successful! Updated Inventory:");
                displayInventory();
                break;
                
                
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (InventoryException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Private method to validate the input quantity.
    
    private void validateQuantity(int quantity) throws InventoryException {
        if (quantity <= 0) {
            throw new InventoryException("Quantity must be greater than zero.");
        }
    }

    
    // Method to manage inventory actions like purchasing and restocking.
    public void manageInventory() {
    	 
    	
    	
    	int choice;

        while (true) {
        	
            System.out.println(" Menu:");
            System.out.println("1. Purchase items");
            System.out.println("2. Restock items");
            System.out.println("3. Exit");

            System.out.print("Choose an option : ");

            try {
                choice = Integer.parseInt(scanner.nextLine()); 
                if(choice == 1) {
                	
                	 purchaseItems();	
                }
                
                else if(choice == 2) {
                	
                	restockItems();
                }
                
                
                else {
                	
                	break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input: Please enter a valid number.");
            }
        }
    }	
    	
    	
    	
    
 // Method to initiate the inventory management process and handle user decisions to continue or exit.
public void operationsMenu() {
    


	manageInventory();
	
	

scanner.close();

}
}





