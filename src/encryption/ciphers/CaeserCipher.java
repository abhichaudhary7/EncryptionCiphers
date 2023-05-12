/**
 * Description: This class use ceaser cipher to encrypt/decrypt strings
 */
package encryption.ciphers;

import encryption.EncryptionType;

/**
 * this class contains methods for ceaser cipher
 * 
 * @author abhishek
 *
 */
public class CaeserCipher extends EncryptionType {
	/**
	 * instance variable key
	 */
	private int key; // amount of shift between encrypted and decrypted characters

	/**
	 * Create a caeser cipher with the given shift
	 * 
	 * @param shift The shift number to perform ceaser cipher
	 */
	public CaeserCipher(int shift) {
		this.key = shift;

	}

	/**
	 * Encrypts the input text using the ceaser cipher technique with the password
	 * specified in the constructor.
	 * 
	 * @param input the text to be encrypted
	 * @return The encrypted string after encryption test
	 */
	@Override
	public String encrypt(String input) {
		// string builder to append encrypted text to a string
		StringBuilder encryptStringBuilder = new StringBuilder();
		// for loop for the formula of encryption
		for (int i = 0; i < input.length(); i++) {
			char characterValue = input.charAt(i);
			// call method in parent class to shift characters one by one
			char s = super.shiftChar(characterValue, key);

			encryptStringBuilder.append(s);

		}
		// add the encrypted message to a string and return
		String encryptString = encryptStringBuilder.toString();
		return encryptString;
	}

	/**
	 * Decrypts the input text using the ceaser cipher technique with the password
	 * specified in the constructor.
	 * 
	 * @param input the text to be decrypted
	 * @return the decrypted text
	 */
	@Override
	public String decrypt(String input) {
		// string builder to append decrypted text to a string
		StringBuilder decryptStringBuilder = new StringBuilder();
		// for loop for the formula of decryption
		for (int i = 0; i < input.length(); i++) {
			char characterValue = input.charAt(i);

			// call method in parent class to shift characters one by one
			char s = super.shiftChar(characterValue, (-key));

			decryptStringBuilder.append(s);
		}
		// add the decrypted message to a string and return
		String decryptString = decryptStringBuilder.toString();
		return decryptString;
	}

}
