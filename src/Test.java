
/**
 * Description: The main method of the encryption application
 */
import java.util.ArrayList;
import encryption.*;

/**
 * This class tests the encryption methods
 * 
 * @author abhishek
 */
public class Test {

	/**
	 * Main method that runs the program
	 * 
	 * @param args Arguments passed to the program
	 */
	public static void main(String[] args) {
		// display the heading of program
		System.out.println("Encryption tester");
		ArrayList<String> encryptedText = new ArrayList<String>();

		String textEncryptMessage = "Please enter the text to be encrypted:";
		int userSelectedOption = ScannerUtils.getMenuItem("Encrypt text", "Decrypt text", "Display encrypted list",
				"exit");

		// while loop until user select option 4 to exit
		while (userSelectedOption != 4) {
			switch (userSelectedOption) {

			// if user select option 1
			case 1:
				// get user input
				String userInput = ScannerUtils.getString(textEncryptMessage);
				// get encrypt method
				EncryptionType encryptionMethod = EncryptionType.getMethod();
				// encrypt user input using selected method
				String encryptedUserText = encryptionMethod.encrypt(userInput);
				// save encrypted message in arraylist
				encryptedText.add(encryptedUserText);
				// print encrypted message

				System.out.printf("Encrypted value #%d is: %s\n", encryptedText.size(), encryptedUserText);
				// print new line and ask again for user input
				System.out.println();
				userSelectedOption = ScannerUtils.getMenuItem("Encrypt text", "Decrypt text", "Display encrypted list",
						"exit");
				break;
			// when user select option 2
			case 2:
				// display messag if there is nothing to decrypt and ask user to select menu
				// item again
				if (encryptedText.isEmpty()) {
					System.out.println("\nNothing to decrypt");
					userSelectedOption = ScannerUtils.getMenuItem("Encrypt text", "Decrypt text",
							"Display encrypted list", "exit");

				} else {

					String prompt3 = ("Message you want to decrypt:");
					// display message to user and
					// ask to select the message number to decrypt
					int messageNumber = ScannerUtils.getInt(prompt3, 1, encryptedText.size());
					// ask user to select decryption method
					EncryptionType decryptionMethod = EncryptionType.getMethod();
					// print decrypted message and ask user to select menu option again
					String decryptedMessage = decryptionMethod.decrypt(encryptedText.get(messageNumber - 1));
					System.out.printf("Decrypted value #%d is: %s%n", messageNumber, decryptedMessage);
					System.out.println();
					userSelectedOption = ScannerUtils.getMenuItem("Encrypt text", "Decrypt text",
							"Display encrypted list", "exit");

				}
				break;

			// if user select option 3
			case 3:
				// display message if there is nothing to display
				// and ask user to select menu item again
				if (encryptedText.isEmpty()) {
					System.out.println("\nNothing to display");
					userSelectedOption = ScannerUtils.getMenuItem("Encrypt text", "Decrypt text",
							"Display encrypted list", "exit");
					break;

					// print encrypted messages with order number if exist
				} else {
					System.out.println("---------------");
					for (int i = 0; i < encryptedText.size(); i++) {
						System.out.printf("#%d: %s%n", i + 1, encryptedText.get(i));
					}

					System.out.println("---------------\n");

				}
				// ask user to select menu item again
				userSelectedOption = ScannerUtils.getMenuItem("Encrypt text", "Decrypt text", "Display encrypted list",
						"exit");

				break;
			}
		}
	}
}

