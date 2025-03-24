import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Handles all user's input with validation
 * 
 * @author dejohns2
 * @since 2024.03.27
 * @version 1.0 beta
 */
public class Input {
	
    /**
     * Scanner used for all user's input
     */
    public static Scanner sc = new Scanner(System.in);

    /**
     * Display a prompt and return the entire user input line
     * 
     * @param prompt input prompt asking the user to enter something specific
     * @return the user's input line 
     */
    public static String getLine(String prompt) {
		
		System.out.print(prompt);
		return Input.sc.nextLine();
		
	} // end of getLine

    /**
     * Display a prompt and return the entire user input line, not allowing for an empty string
     *
     * @param prompt input prompt asking the user to enter something specific
     * @return the user's input line
     */
    public static String getString(String prompt) {

        String userInput = null;

        System.out.print(prompt);

        while (true) {
            userInput = Input.sc.nextLine();

            userInput = userInput.trim();

            if (userInput.isEmpty()){
                System.out.print("Invalid input! Please enter a value: ");
            } else {
                break;
            }
        }

        return userInput;

    } // end of getLine

    /**
     * Display a prompt and validate that the user entered a valid integer
     * and then return the valid value
     * 
     * @param prompt input prompt asking the user to enter something specific
     * @return the valid user's integer input
     */
    public static int getInt(String prompt) {
    	int userInput = 0;
		
		System.out.print(prompt);
		
		while (true) {
			if (Input.sc.hasNextInt()) // if the data in the buffer is a valid integer
				break;           // then break out of the validation loop
			
			System.out.printf("Invalid input! Please enter a number: ");
			Input.sc.next();  // clear the data in the input buffer
			
		} // end of while
			
		userInput = Input.sc.nextInt();
		Input.sc.nextLine(); // consume newline left-over
		
		return userInput;
		
	} // end of getInt
    
    /**
     * Display a prompt and validate that the user entered a valid integer
     * based on a low and high range inclusively
     * and then return the valid value
     * 
     * @param prompt input prompt asking the user to enter something specific
     * @param low the lowest valid value inclusively
     * @param high the highest valid value inclusively
     * @return the valid user's integer input
     */
    public static int getIntRange(String prompt, int low, int high) {
    	int userInput;
		
		System.out.print(prompt);
		
		while (true) {
			if (Input.sc.hasNextInt()) {         // if the data in the buffer is a valid integer
				userInput = Input.sc.nextInt();  // then store the integer in userInput
				
				// if the userInput is within the valid range
				// then break out of the validation loop
				if (userInput >= low && userInput <= high) {
					break;
				} // end of if

    		} else {
    			Input.sc.next();  // clear the data in the input buffer
    		} // end of if-else

			System.out.printf("Invalid input! Please enter a number between (%d - %d): ", low, high);

		} // end of while
		
		Input.sc.nextLine(); // consume newline left-over

		return userInput;
		
	} // end of getIntRange

    /**
     * Display a prompt and validate that the user entered a valid date MM-DD-YYYY
     * and then return the valid value
     *
     * @param prompt input prompt asking the user to enter something specific
     * @return the valid user's date input
     */
    public static String getDate(String prompt) {
        String userInput = null;

        System.out.print(prompt);

        while (true) {

            userInput = Input.sc.nextLine();

            try{
                LocalDate.parse(userInput, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
                break;
            } catch (Exception e){
                System.out.print("Invalid input! Please enter a valid date (MM-DD-YYYY): ");
            }
        }

        return userInput;

    } // end of getInt


} // end of library.app.Input class
