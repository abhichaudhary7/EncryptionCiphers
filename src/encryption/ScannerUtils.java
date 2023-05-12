/**
 * Description: This class contains methods to ger user input for 
 * main menu and cipher selection, and method to take user input 
 * for encryption
 */
package encryption;

import java.util.Scanner;

/**
 * This class contains method for user input and user menu selection
 * 
 * @author abhishek
 *
 */
public class ScannerUtils {
	/**
	 * private scanner for input
	 */
	private static Scanner input = new Scanner(System.in);

	/**
	 * Gets the selected menu item from a list of options
	 * 
	 * @param options Menu items available to select
	 * @return Menu item number
	 */
	public static int getMenuItem(String... options) {
		// initialize variables
		int userInput = 0;
		boolean validInput = false;

		while (!validInput) {

			// display menu items
			for (int i = 0; i < options.length; i++) {
				System.out.println("  " + (i + 1) + " - " + options[i]);
			}
			System.out.print("Select action:");

			// valid input
			if (input.hasNextInt()) {
				userInput = input.nextInt();

				if (userInput >= 1 && userInput <= 4) {
					validInput = true;
					if (userInput == 4) {
						System.out.println("Good bye");
					}

					// invalid input
				} else {
					System.out.println("\nPlease select a number in the range");

				}

				// invalid input
			} else {
				System.out.println("\nPlease enter an integer.");

				input.next();// consume the invalid input

			}
		}
		return userInput;
	}

	/**
	 * Gets a string input from the user
	 * 
	 * @param prompt The prompt to display to the user
	 * @return The string input from the user
	 */
	public static String getString(String prompt) {
		input.nextLine();
		System.out.print(prompt); // display message
		String userTextInput = input.nextLine();

		return userTextInput;

	}

	/**
	 * Get the integer input from user in specified range
	 * 
	 * @param prompt The prompt to display to the user
	 * @param min    The minimum value allowed to enter
	 * @param max    The maximum value allowed to enter
	 * @return The integer input from the user
	 */
	public static int getInt(String prompt, int min, int max) {
		// initialize variables
		int userInput = 0;
		boolean validInput = false;

		System.out.print(prompt);
		while (!validInput) {
			// valid input
			if (input.hasNextInt()) {
				userInput = input.nextInt();
				if (userInput >= min && userInput <= max) {
					validInput = true;
					// invalid input
				} else {
					System.out.println("\nPlease select a number in the range");
					System.out.print(prompt);
				}
				// invalid input
			} else {
				System.out.println("\nPlease enter an integer");
				System.out.print(prompt);
				input.next(); // consume the invalid input
			}

		}
		return userInput;
	}
}
