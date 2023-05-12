/**
 * Description: This is abstract class used by the application 
 * that contains fields and encrypt/decrypt methods 
 * to do the ceaser and vigenere encryption/decryption 
 */
package encryption;

import encryption.ciphers.CaeserCipher;
import encryption.ciphers.VigenereCipher;

/**
 * This interface contains methods and variables to encrypt or decrypt the user
 * input
 * 
 * @author abhishek
 *
 */
public abstract class EncryptionType {

	/**
	 * The START_CHAR variable represents the first character in the ASCII table
	 * that can be encrypted. In this case, it is the space character, which has a
	 * decimal ASCII value of 32.
	 */
	protected int START_CHAR = 32;

	/**
	 * The maximum ASCII value for the character to be used as the upper bound of
	 * the encryption range. In this case, it is the character 'z' with an ASCII
	 * value of 122.
	 */
	protected int END_CHAR = 122;

	/**
	 * The RANGE variable represents the range of characters that can be encrypted.
	 * It is calculated by subtracting the START_CHAR value from the END_CHAR value
	 * and adding 1.
	 */
	protected int RANGE = (END_CHAR - START_CHAR) + 1;

	/**
	 * 
	 * @param input The user input string to be encrypted
	 * @return String return string after encrypting
	 */
	public abstract String encrypt(String input);

	/**
	 * 
	 * @param input The message user wants to decrypt
	 * @return String return string after decrypting
	 */
	public abstract String decrypt(String input);

	/**
	 * This method take the character input and offset value and return a character
	 * after shifting with the offset value
	 * 
	 * @param input  The character input for encryption
	 * @param offset The shift from the input
	 * @return String The encrypted/shifted character
	 */
	public char shiftChar(char input, int offset) {

		int shifted = (int) input + offset;
		char shiftedValue = 0;

		// if-else loop to wraparound the character if it
		// is not in the required range
		if (shifted > END_CHAR) {
			shifted = shifted - RANGE;
			shiftedValue = (char) shifted;

		} else if (shifted < START_CHAR) {
			shifted = END_CHAR - (START_CHAR - shifted) + 1;
			shiftedValue = (char) shifted;

		} else if (shifted == 32) {
			shiftedValue = (char) shifted;
		} else {
			shiftedValue = (char) shifted;

		}
		// return the shifted value
		return shiftedValue;
	}

	/**
	 * Gets the encryptable method from user
	 * 
	 * @return the encryptable method selected by user
	 */
	public static EncryptionType getMethod() {
		// display the message to user
		System.out.println("Encryption method");
		String selectMethod = "  1 - Ceasar\n  2 - Vigenere\nSelect action:";
		// loop until user select valid input
		while (true) {
			int userSelectedMethod = ScannerUtils.getInt(selectMethod, 1, 2);
			// If user selects Ceasar Cipher method, prompt for shift value and
			// return a new CaeserCipher object.
			if (userSelectedMethod == 1) {

				String getShiftValue = "shift value:";
				int shiftValue = ScannerUtils.getInt(getShiftValue, 1, 90);
				CaeserCipher userMethod = new CaeserCipher(shiftValue);
				return userMethod;

				// If VigenereCipher method is selected, prompt for password and
				// return a new VigenereCipher object.
			} else if (userSelectedMethod == 2) {
				String userPassword = ScannerUtils.getString("Enter Password: ");
				VigenereCipher userMethod = new VigenereCipher(userPassword);
				return userMethod;
			}
		}
	}
}