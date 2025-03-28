package library.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


/**
 * The {@code Input} class provides methods for obtaining user input from the console.
 * Input validation is performed based on the method used.
 * <p>
 * Methods available:
 * </p>
 * <ul>
 *     <li>{@link #getLine(String)} - Retrieves a line of input from the user.</li>
 *     <li>{@link #getString(String)} - Retrieves a non-empty string from the user.</li>
 *     <li>{@link #getInt(String)} - Retrieves an integer value from the user.</li>
 *     <li>{@link #getIntRange(String, int, int)} - Retrieves an integer within a specified range.</li>
 *     <li>{@link #getDate(String)} - Retrieves a valid date in the MM-DD-YYYY format.</li>
 * </ul>
 *
 * @author Brandon Berger, Ricardo Pretorius
 * @version 1.0
 * @since 2025.03.24
 * @see <a href="https://github.com/JRBerger123/Pet-Store-App">GitHub Repository</a>
 * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
 * @see <a href="https://github.com/RicardoPret">Ricardo Pretorius GitHub</a>
 */
public class Input {
	
    public static Scanner sc = new Scanner(System.in);

    public static String getLine(String prompt) {
		
		System.out.print(prompt);
		return Input.sc.nextLine();
		
	} // end of getLine

    /**
     * This method prompts for the user's input and verifies that the user input is not empty.
     * @param prompt is the message to display to the user when prompting for input
     * @return the string value entered by the user
     */
    public static String getString(String prompt) {

        String userInput;

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
     * This method prompts for the user's input and verifies that the user input is a valid integer.
     * @param prompt is the message to display to the user when prompting for input
     * @return the integer value entered by the user
     */
    public static int getInt(String prompt) {
    	int userInput;
		
		System.out.print(prompt);

        // if the data in the buffer is a valid integer
        // then break out of the validation loop
        while (!Input.sc.hasNextInt()) {

            System.out.print("Invalid input! Please enter a number: ");
            Input.sc.next();  // clear the data in the input buffer

        } // end of while
			
		userInput = Input.sc.nextInt();
		Input.sc.nextLine(); // consume newline left-over
		
		return userInput;
		
	} // end of getInt
    
    /**
     * This method prompts for the user's input and verifies that the user input is a valid integer within a specified range.
     * @param prompt is the message to display to the user when prompting for input
     * @param low is the lower bound of the valid range, inclusive
     * @param high is the upper bound of the valid range, inclusive
     * @return the integer value entered by the user
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
     * This method prompts for the user's input and verifies that the user input is a valid date using the MM-DD-YYYY format.
     * @param prompt is the message to display to the user when prompting for input
     * @return the date value entered by the user
     */
    public static String getDate(String prompt) {
        String userInput;

        System.out.print(prompt);

        while (true) {

            userInput = Input.sc.nextLine();

            try{
                LocalDate.parse(userInput, DateTimeFormatter.ofPattern("MM-DD-YYYY"));
                break;
            } catch (Exception e){
                System.out.print("Invalid input! Please enter a valid date (MM-DD-YYYY): ");
            }
        }

        return userInput;

    } // end of getInt

} // end of library.app.Input class
