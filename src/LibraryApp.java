import library.inventory.Book;
import library.inventory.BookGenre;
import library.inventory.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Library App that allows adding, deleting, displaying, saving, and loading inventory for Books, CDs, and DVDs.
 *  @author PUT_YOUR_NAMES_HERE
 *  @since PUT_THE_CURRENT_DATE_HERE
 *  @version 1.0 beta
 *  @see <a href="PUT_YOUR_URL_HERE">GitHub Repository URL</a>
 *
 */
public class LibraryApp {

    /** The file name when saving using serialized for writing objects */
    private static String dataFileName_option1 = "LibraryDat.ser";
    
    /** The file name when saving the data as a text file */
    private static String dataFileName_option2 = "LibraryData.txt";

    /**
     * Standard double dash line.
     */
    private final static String DOUBLE_LINE = "==========================================================";

    /**
     * Standard single dash line.
     */
    private final static String SINGLE_LINE = "---------------------------------------------------------";

    /**
     * List to store all types of inventory items (Book, Cd, Dvd).
     */
    private List<Item> inventory;

    /**
     * Default constructor instantiates the ArrayList for storing items.
     */
    public LibraryApp(){
        this.inventory = new ArrayList<Item>();
    } // end of constructor

    /**
     * Display the program's title.
     */
    private void displayAppHeading() {

        System.out.println(DOUBLE_LINE);
        System.out.println("Welcome to the Library App");
        System.out.println(DOUBLE_LINE);

    } // end of displayAppHeading method

    /**
     * Allows the user to enter an inventory id to be deleted.
     */
    private void deleteItem(){
        int id = 0;

        System.out.println("Delete Inventory");
        System.out.println(SINGLE_LINE);

        id = Input.getInt("Please enter the inventory id: ");

        for (Item item : inventory){
            System.out.println(id);
            if (item.getId() == id){
                inventory.remove(item);
                System.out.println("Successful Delete: " + item);
                Input.getLine("Press enter to continue...");
                return;
            }
        }

        System.out.println("ERROR: Inventory ID:" + id + " NOT found!");

    } // end of deleteItem method

    /**
     * Add a book to the Library's inventory. Allows the user to enter the book's author and genre.
     *
     * @param title The item's title.
     * @param dateReceived The item's date received into inventory.
     * @param description The item's description which is not a required field.
     * @return The newly created book.
     * @throws Exception Any exception thrown to addBook will be back to the calling method.
     */
    private Book addBook(String title, String dateReceived, String description) throws Exception {

        Book book;
        int userInput = 0;
        String author = null;
        BookGenre genre = null;

        author = Input.getString("Author: ");

        try {
            userInput = Input.getIntRange("Genre 1=Fiction, 2=Children, 3=Poetry: ", 1, 3);
            genre = BookGenre.values()[userInput - 1];
        } catch (Exception e){
            throw new Exception("Invalid data! Book Genre = " + genre);
        }

        book = new Book(title, dateReceived, author, genre);
        book.setDescription(description);

        return book;
    } // end of addBook method

    /**
     * Add an item to inventory. Allow's the user to enter the item's title, description,
     * date received into inventory and then will call the appropriate item's type (Book, CD, DVD) for additional
     * user's input.
     * @throws Exception All exceptions will be thrown back to the main menu for handling.
     */
    private void addItem() throws Exception {

        String title = null;
        String description = null;
        String dateReceived = null;
        int inventoryType = 0;

        System.out.println("Add Inventory");
        System.out.println(SINGLE_LINE);

        System.out.println("Please enter the following inventory information:");
        title = Input.getString("Title: ");
        dateReceived = Input.getDate("Date Received (MM-DD-YYYY): ");
        description = Input.getLine("Description or press enter to continue: ");

        inventoryType = Input.getIntRange("Type 1=Book, 2=CD, 3=DVD: ", 1, 3);

        switch(inventoryType){
            case 1:
                Book book = addBook(title, dateReceived, description);
                inventory.add(book);
                System.out.println("Successful Add: " + book);
                Input.getLine("Press enter to continue...");
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                throw new Exception("Invalid Input! Inventory Type = " + inventoryType);
        } // end of switch

    } // end of addItem method

    /**
     * Display the Library's inventory's detail group by inventory type.
     */
    private void displayInventory(){
        System.out.println("Book Inventory");
        System.out.println(SINGLE_LINE);
        System.out.println("ID  Title           Date Rec'd Author          Genre");
        System.out.println("--- --------------- ---------- --------------- ----------");
        for (Item item : inventory) {
            if (item instanceof Book){
                item.displayItem();
            }
        }
        System.out.println();

        //TO-DO: ADD LOGIC FOR DISPLAYING OTHER INVENTORY TYPES

        Input.getLine("Press enter to continue...");
    } // end of displayInventory


    /**
    Saving the inventory as objects using serialized to a binary file.
    */
    public void saveInventory_option1(){
        System.out.println("Saving data! Please wait...");

        try{
            FileOutputStream writeData = new FileOutputStream(dataFileName_option1);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(inventory);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(inventory.size() + " Inventory records successfully written to " + dataFileName_option1);
        Input.getLine("Please any key to continue...");
    }

    /**
    Loading the inventory as objects using serialized to a binary file.
    */
    public void loadInventory_option1(){
        System.out.println("Loading data! Please wait...");

        inventory.clear();

        try{
            FileInputStream readData = new FileInputStream(dataFileName_option1);
            ObjectInputStream readStream = new ObjectInputStream(readData);

            inventory = (ArrayList<Item>) readStream.readObject();
            readStream.close();

        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(inventory.size() + " Inventory records successfully written to " + dataFileName_option1);
        Input.getLine("Please any key to continue...");
    }

    /**
    Saving the inventory in a readable text file.
    */
    public void saveInventory_option2(){
        System.out.println("Saving data! Please wait...");

        // shortcut way to declare and initialize in one step
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(LibraryApp.dataFileName_option2))) {

            for(Item item : inventory){

                // The file will be piped delimited so each field is separated by a |
                if (item instanceof Book)
                    bw.write("BOOK|");

                bw.write(item.getId() + "|" + item.getTitle() + "|" + item.getDateReceived() + "|" + item.getDescription() + "|");

                if (item instanceof Book)
                    bw.write(((Book) item).getAuthor() + "|" + ((Book) item).getGenre() + "\n");
            }

            bw.flush();
            bw.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println(inventory.size() + " Inventory records successfully written to " + LibraryApp.dataFileName_option2);
        Input.getLine("Please any key to continue...");

    }

    /**
    Loading the inventory from a readable text file that is piped delimited. 
    */
    public void loadInventory_option2(){
        System.out.println("Loading data! Please wait...");

        inventory.clear(); //empty the ArrayList so we can load the data from the file

        try (BufferedReader br = new BufferedReader(new FileReader(LibraryApp.dataFileName_option2))) {

            String inLine;

            while ((inLine = br.readLine()) != null) {  // exclude newline

                String[] data = inLine.split("[|]"); // [|] is a regex for splitting by the pipe character

                //0=item 1=id, 2=title, 3=date, 4=description, 5=author, 6=genre
                switch(data[0]){
                    case "BOOK":
                        Book book = new Book(Integer.parseInt(data[1]), data[2], data[3], data[5], BookGenre.valueOf(data[6]));
                        book.setDescription(data[4]);
                        inventory.add(book);
                        break;
                    default:
                        throw new Exception("Invalid inventory type: " + data[0]);
                }
            }

            br.close();

            Item.setLastId(inventory.get(inventory.size() - 1).getId());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println(inventory.size() + " Inventory records successfully written to " + LibraryApp.dataFileName_option2);
        Input.getLine("Please any key to continue...");
    }

    /**
     * The main menu that allows the user to add, delete, display, load, and save inventory.
     * @throws Exception All exceptions will be displayed or thrown back to the main method.
     */
    private void mainMenu() throws Exception {

        boolean keepRunning = true;
        int userInput = 0;

        while (keepRunning) {

            System.out.println(SINGLE_LINE);
            System.out.println("Main Menu");
            System.out.println(SINGLE_LINE);

            System.out.println("0 = End Program");
            System.out.println("1 = Add Item");
            System.out.println("2 = Delete Item");
            System.out.println("3 = Display Inventory");
            System.out.println("4 = Save Inventory");
            System.out.println("5 = Load Inventory");

            System.out.println(SINGLE_LINE);
            userInput = Input.getIntRange("Menu Choice: ", 0, 6);
            System.out.println(SINGLE_LINE);

            switch (userInput) {
                case 0:
                    keepRunning = false;
                    break;
                case 1:
                    try {
                        this.addItem();
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                        Input.getLine("Press enter to continue...");
                    }
                    break;
                case 2:
                    try {
                        this.deleteItem();
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                        Input.getLine("Press enter to continue...");
                    }
                    break;
                case 3:
                    displayInventory();
                    break;
                case 4:
                    //saveInventory_option1();
                    saveInventory_option2();
                    break;
                case 5:
                    //loadInventory_option1();
                    loadInventory_option2();
                    break;
                default:
                    throw new Exception("Invalid menu choice: " + userInput);

            } // end of switch
        } // end of while loop
    } // end of mainMenu

    /**
     * Main method to keep the Library App running
     * @param args Not used
     * @throws Exception Any type of exceptions thrown back to main will be displayed and end the program.
     */
    public static void main(String[] args) throws Exception {

        LibraryApp app = new LibraryApp();

        app.displayAppHeading();

        try {
            app.mainMenu();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Sorry but this program ended with an error. Please contact Princess Debbie!");
        }

        Input.sc.close();

    } // end of main method

} // end of LibraryApp class