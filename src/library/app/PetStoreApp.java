package library.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import library.inventory.Pet;
import library.inventory.Bird;
import library.inventory.FeedingSchedule;
import library.inventory.Fish;
import library.inventory.HabitatType;

/**
 * The {@code PetStoreApp} class provides a simple console-based application for managing a pet store inventory.
 *<p>
 * Methods available:
 * </p>
 * <ul>
 *     <li>{@link #PetStoreApp()} - Constructor</li>
 *     <li>{@link #displayAppHeading()} - Display the application heading</li>
 *     <li>{@link #deleteItem()} - Delete an item from the inventory</li>
 *     <li>{@link #addBird(String, String, String)} - Add a new bird to the inventory</li>
 *     <li>{@link #addFish(String, String, String)} - Add a new fish to the inventory</li>
 *     <li>{@link #addPet()} - Add a new pet to the inventory</li>
 *     <li>{@link #displayInventory()} - Display the inventory</li>
 *     <li>{@link #saveInventory()} - Save the inventory to a file</li>
 *     <li>{@link #loadInventory()} - Load the inventory from a file</li>
 *     <li>{@link #errorOccurred(String)} - Display an error message in red text</li>
 *     <li>{@link #mainMenu()} - Main menu for the Pet Store App</li>
 *     <li>{@link #main(String[])} - Main method for the Pet Store App</li>
 * </ul>
 * 
 * @author Brandon Berger, Ricardo Pretorius
 * @version 0.9
 * @since 2025.03.24
 * @see <a href="https://github.com/JRBerger123/Pet-Store-App">GitHub Repository</a>
 * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
 * @see <a href="https://github.com/RicardoPret">Ricardo Pretorius GitHub</a>
 * 
 */
public class PetStoreApp {

    private static final String INVENTORY_FILE = "LibraryData.txt";
    
    private static final String DOUBLE_DASH_LINE = String.format("%50s", "").replace(' ', '=');

    private static final String SINGLE_DASH_LINE = DOUBLE_DASH_LINE.replace('=', '-');

    private final List<Pet> inventory;

    /**
     * Constructor for the PetStoreApp class. <p>
     * Initializes the inventory ArrayList.
     */
    public PetStoreApp(){
        this.inventory = new ArrayList<>();
    } // end of constructor

    /**
     * Displays the application heading.
     */
    private void displayAppHeading() {

        System.out.println(DOUBLE_DASH_LINE);
        System.out.println("Welcome to the Pet Store App");
        System.out.println(DOUBLE_DASH_LINE);

    } // end of displayAppHeading method

    /**
     * Deletes an item from the Pet Store inventory.
     */
    private void deleteItem(){
        System.out.println("Delete Inventory");
        System.out.println(SINGLE_DASH_LINE);

        int id = Input.getInt("Please enter the inventory id: ");

        for (Pet item : inventory){
            System.out.println(id);
            if (item.getId() == id){
                inventory.remove(item);
                System.out.println("Successfully Deleted: " + item);
                Input.getLine("Press enter to continue...");
                return;
            }
        }

        System.out.println("Inventory ID: " + id + " NOT found!");

    } // end of deleteItem method

    /**
     * Adds a new bird to the Pet Store inventory. <p>
     * Prompts user for unique class variables and creates a new bird object.
     * @param name is the name of the pet
     * @param dateReceived is the date the pet was received
     * @param description is an optional description of the pet (can be empty)
     * @return the new bird object
     * @throws Exception if an error occurs while adding the bird
     */
    private Bird addBird(String name, String dateReceived, String description) throws Exception {
        Bird bird;
        int userInput;

        HabitatType habitat = null;
        FeedingSchedule feedingSchedule = null;
        boolean canFly;
        boolean isMigratory;

        try {
            userInput = Input.getIntRange("Can the bird fly? (0=No 1=Yes)  ", 0, 1);
            canFly = (userInput == 1) ? true : false;
        } catch (Exception e){
            throw new Exception("Invalid option! ");
        }

        try {
            userInput = Input.getIntRange("Is the bird migratory? (0=No 1=Yes)  ", 0, 1);
            isMigratory = (userInput == 1) ? true : false;
        } catch (Exception e){
            throw new Exception("Invalid option! ");
        }

        try {
            userInput = Input.getIntRange("HabitatType: 1=Cage, 2=Aquarium, 3=Terrarium, 4=OpenSpace  ", 1, 4);
            habitat = HabitatType.values()[userInput - 1];
        } catch (Exception e){
            throw new Exception("Invalid data! Pet habitat type = " + habitat);
        }

        try {
            userInput = Input.getIntRange("Feeding Schedule: 1=Once Daily, 2=Twice Daily, 3=Three Times Daily, 4=Weekly, 5=Biweekly: ", 1, 5);
            feedingSchedule = FeedingSchedule.values()[userInput - 1];
        } catch (Exception e){
            throw new Exception("Invalid data! Feeding Schedule = " + feedingSchedule);
        }

        bird = new Bird(name, dateReceived, habitat, feedingSchedule, canFly, isMigratory);
        bird.setDescription(description);

        return bird;
    } // end of addPet method

    /**
     * Add a new fish to the Pet Store inventory. <p>
     * Prompts user for unique class variables and creates a new fish object.
     * @param name is the name of the pet
     * @param dateReceived is the date the pet was received
     * @param description is an optional description of the pet (can be empty)
     * @return the new fish object
     * @throws Exception if an error occurs while adding the fish
     */
    private Fish addFish(String name, String dateReceived, String description) throws Exception {
        Fish fish;
        int userInput;

        HabitatType habitat = null;
        FeedingSchedule feedingSchedule = null;
        boolean isTropical;
        boolean usesFreshwater;

        try {
            userInput = Input.getIntRange("Is the fish tropical? (0=No 1=Yes)  ", 0, 1);
            isTropical = (userInput == 1) ? true : false;
        } catch (Exception e){
            throw new Exception("Invalid option! ");
        }

        try {
            userInput = Input.getIntRange("Does the fish use freshwater? (0=No 1=Yes)  ", 0, 1);
            usesFreshwater = (userInput == 1) ? true : false;
        } catch (Exception e){
            throw new Exception("Invalid option! ");
        }

        try {
            userInput = Input.getIntRange("HabitatType: 1=Cage, 2=Aquarium, 3=Terrarium, 4=OpenSpace  ", 1, 4);
            habitat = HabitatType.values()[userInput - 1];
        } catch (Exception e){
            throw new Exception("Invalid data! Pet habitat type = " + habitat);
        }

        try {
            userInput = Input.getIntRange("Feeding Schedule: 1=Once Daily, 2=Twice Daily, 3=Three Times Daily, 4=Weekly, 5=Biweekly: ", 1, 5);
            feedingSchedule = FeedingSchedule.values()[userInput - 1];
        } catch (Exception e){
            throw new Exception("Invalid data! Feeding Schedule = " + feedingSchedule);
        }

        fish = new Fish(name, dateReceived, habitat, feedingSchedule, isTropical, usesFreshwater);
        fish.setDescription(description);

        return fish;
    } // end of addPeriodical method

    /**
     * Adds a new pet to the Pet Store inventory. <p>
     * Prompts user for the pet type and calls the appropriate method to add the pet.
     * @throws Exception if an error occurs while adding a pet
     */
    private void addPet() throws Exception {
        System.out.println("Add Inventory");
        System.out.println(SINGLE_DASH_LINE);

        System.out.println("Please enter the following inventory information:");
        String name = Input.getString("Name: ");
        String dateReceived = Input.getDate("Date Received (MM-DD-YYYY): ");
        String description = Input.getLine("Description or press enter to continue: ");

        int inventoryType = Input.getIntRange("Type: 1=Bird, 2=Fish: ", 1, 2);

        switch(inventoryType){
            case 1:
                Bird b = addBird(name, dateReceived, description);
                inventory.add(b);
                System.out.println("Successfully Added: " + b);
                Input.getLine("Press enter to continue...");
                break;
            case 2:
                Fish p = addFish(name, dateReceived, description);
                inventory.add(p);
                System.out.println("Successfully Added: " + p);
                Input.getLine("Press enter to continue...");
                break;
            default:
                throw new Exception("Invalid Input! Inventory Type = " + inventoryType);
        } // end of switch

    } // end of addItem method

    private void displayInventory(){
        if (inventory.isEmpty()){
            System.out.println("\033[33mInventory is empty!\033[37m");
            Input.getLine("Press enter to continue...");
            return;
        }

        System.out.println("\nBird Inventory");
        System.out.println(SINGLE_DASH_LINE);
        System.out.println("ID  Name            Date Rec'd Habitat         Feeding Schedule  ");
        System.out.println("--- --------------- ---------- --------------- ----------        ");
        for (Pet item : inventory) {
            if (item instanceof Bird){
                item.displayItem();
            }
        }
        System.out.println();

        System.out.println("Fish Inventory");
        System.out.println(SINGLE_DASH_LINE);
        System.out.println("ID  Name            Date Rec'd Habitat         Feeding Schedule  ");
        System.out.println("--- --------------- ---------- --------------- ----------        ");
        for (Pet item : inventory) {
            if (item instanceof Fish){
                item.displayItem();
            }
        }
        System.out.println();

        Input.getLine("Press enter to continue...");
    } // end of displayInventory

    /**
     * Saves the Pet Store inventory to a file
     * @throws Exception if an error occurs while saving the inventory
     */
    public void saveInventory(){
        System.out.println("Saving data! Please wait...");

        /*
        Try-With-Resources: shortcut way to declare and initialize in one step
        when you use this way of opening the file as part of the try statement
        Java will automatically close the file so there is no need to write a close statement
        NOTE: Java doesn't automatically close the file if the file is opened inside the block
        */
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PetStoreApp.INVENTORY_FILE))) {

            for (Pet item : inventory) {
                bw.write(item.getClass().getSimpleName() + "|"); // Dynamically write the class type (Bird or Fish)
    
                bw.write(item.getId() + "|" + item.getName() + "|" + item.getDateAdded() + "|" + item.getDescription() + "|" + item.getHabitatType() + "|" + item.getFeedingSchedule() + "|");
    
                if (item instanceof Bird) {
                    Bird bird = (Bird) item;
                    bw.write(bird.canFly() + "|" + bird.isMigratory() + "\n");
                } else if (item instanceof Fish) {
                    Fish fish = (Fish) item;
                    bw.write(fish.isTropical() + "|" + fish.usesFreshwater() + "\n");
                }
            }

            bw.flush();
            // No explicit close needed - automatically handled when using Try-With-Resources

        } catch (Exception e) {
            errorOccurred("Error saving inventory: " + e.getMessage());
        }

        System.out.println(inventory.size() + " Inventory records successfully written to " + PetStoreApp.INVENTORY_FILE);
        Input.getLine("Please any key to continue...");

    }

    /**
     * Loads the Pet Store inventory from a file
     * @throws Exception if an error occurs while loading the inventory
     * @throws IOException if an error occurs while reading the file
     */
    public void loadInventory() {
        boolean canFly;
        boolean isMigratory;
        boolean isTropical;
        boolean usesFreshwater;

        System.out.println("Loading data! Please wait...");
    
        inventory.clear(); // Empty the ArrayList before loading data
    
        try (BufferedReader br = new BufferedReader(new FileReader(PetStoreApp.INVENTORY_FILE))) {
            String inLine;
            int lineCount = -1;
    
            while ((inLine = br.readLine()) != null) {
                lineCount++;

                String[] data = inLine.split("[|]"); // Split by pipe character
    
                if (data.length < 6) { 
                    errorOccurred("Skipping malformed line(" + lineCount + "):" + inLine);
                    continue; 
                }
    
                String type = data[0];  
                int id = Integer.parseInt(data[1]);
                String name = data[2];
                String dateReceived = data[3];
                String description = data[4];
                HabitatType habitat = HabitatType.valueOf(data[5]);
                FeedingSchedule feedingSchedule = FeedingSchedule.valueOf(data[6]);
    
                switch (type) {
                    case "Bird": 
    
                        try {
                            canFly = Boolean.parseBoolean(data[7]);
                            isMigratory = Boolean.parseBoolean(data[8]);
                        } catch (Exception e) {
                            errorOccurred("Invalid unique data for Bird: " + inLine);
                            continue;
                        }
                        
                        try {
                            Bird bird = new Bird(id, name, dateReceived, habitat, feedingSchedule, canFly, isMigratory);
                            bird.setDescription(description);
                            inventory.add(bird);
                            break;
                        } catch (Exception e) {
                            errorOccurred("Error when creating Bird object: " + e.getMessage());
                            continue;
                        }
    
                    case "Fish":
    
                        try {
                            isTropical = Boolean.parseBoolean(data[7]);
                            usesFreshwater = Boolean.parseBoolean(data[8]);
                        } catch (Exception e) {
                            errorOccurred("Invalid unique data for Fish: " + inLine);
                            continue;
                        }
    
                        try {
                            Fish fish = new Fish(id, name, dateReceived, habitat, feedingSchedule, isTropical, usesFreshwater);
                            fish.setDescription(description);
                            inventory.add(fish);
                            break;
                        } catch (Exception e) {
                            errorOccurred("Error when creating Fish object: " + e.getMessage());
                            continue;
                        }
    
                    default:
                        errorOccurred("Unknown inventory type: " + type);
                }
            }
    
            if (!inventory.isEmpty()) {
                Pet.setLastId(inventory.get(inventory.size() - 1).getId());
            }
    
        } catch (Exception e) {
            errorOccurred("Error reading inventory file: " + e.getMessage());
            return;
        }
    
        System.out.println(inventory.size() + " Inventory records successfully loaded from " + PetStoreApp.INVENTORY_FILE);
        Input.getLine("Press any key to continue...");
    }

    /**
    * Display an error message in red text
    * @param message the error message to display
    */
    private void errorOccurred(String message){
        System.err.println("\033[31" + message + "\033[0m");
        Input.getLine("Press enter to continue...");
    }

    /**
     * Main menu for the Pet Store App
     * @throws Exception if any error occurs
     */
    private void mainMenu() throws Exception {

        boolean keepRunning = true;

        while (keepRunning) {

            System.out.println(SINGLE_DASH_LINE);
            System.out.println("Main Menu");
            System.out.println(SINGLE_DASH_LINE);

            System.out.println("0 = End Program");
            System.out.println("1 = Add Item");
            System.out.println("2 = Delete Item");
            System.out.println("3 = Display Inventory");
            System.out.println("4 = Save Inventory");
            System.out.println("5 = Load Inventory");

            System.out.println(SINGLE_DASH_LINE);
            int userInput = Input.getIntRange("Menu Choice: ", 0, 5);
            System.out.println(SINGLE_DASH_LINE);

            switch (userInput) {
                case 0:
                    keepRunning = false;
                    break;
                case 1:
                    try {
                        this.addPet();
                    } catch (Exception e){
                        errorOccurred(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        this.deleteItem();
                    } catch (Exception e){
                        errorOccurred(e.getMessage());
                    }
                    break;
                case 3:
                    displayInventory();
                    break;
                case 4:
                    saveInventory();
                    break;
                case 5:
                    loadInventory();
                    break;
                default:
                    throw new Exception("Invalid menu choice: " + userInput);

            } // end of switch
        } // end of while loop
    } // end of mainMenu

    /**
     * Main method for the Pet Store App
     * @param args
     */
    public static void main(String[] args) {

        PetStoreApp app = new PetStoreApp();

        app.displayAppHeading();

        try {
            app.mainMenu();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Sorry but this program ended with an error. Please contact Princess Debbie!");
        }

        Input.sc.close();

    } // end of main method

} // end of PetStoreApp class