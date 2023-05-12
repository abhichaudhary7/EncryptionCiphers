/**
 * Description: This class use vigenere cipher to encrypt/decrypt strings
 */
package encryption.ciphers;

import encryption.EncryptionType;

/**
 * this class contains methods for vigenere cipher
 * 
 * @author abhishek
 *
 */
public class VigenereCipher extends EncryptionType {
	/**
	 * password used to encrypt or decrypt text
	 */
	private String key;
	/**
	 * number of characters in password
	 */
	private int keyLength;

	/**
	 * Construct a VigenereCipher object with given password
	 * 
	 * @param password password used to encrypt or decrypt strings
	 */
	public VigenereCipher(String password) {
		this.key = password;
		this.keyLength = password.length();
	}

	/**
	 * Encrypts the input text using the Vigenere cipher technique with the password
	 * specified in the constructor.
	 * 
	 * @param input The text to be encrypted
	 * @return the encrypted text
	 */
	@Override
	public String encrypt(String input) {
		// string builder to append encrypted text to a string
		StringBuilder encryptStringBuilder = new StringBuilder();
		// for loop for the formula of encryption
		for (int i = 0; i < input.length(); i++) {
			int characterValueInt = (int) (input.charAt(i) - START_CHAR);
			char characterValue = (char) characterValueInt;

			char s = super.shiftChar(characterValue, key.charAt(i % keyLength));
			encryptStringBuilder.append(s);

		}
		// add the encrypted message to a string and return
		String encryptString = encryptStringBuilder.toString();
		return encryptString;
	}

	/**
	 * Decrypts the input text using the Vigenere cipher technique with the password
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
			int characterValueInt = (int) (input.charAt(i) + START_CHAR);
			char characterValue = (char) characterValueInt;
			char s = super.shiftChar(characterValue, (-key.charAt(i % keyLength)));
			decryptStringBuilder.append(s);

		}
		// add the decrypted message to a string and return
		String decryptString = decryptStringBuilder.toString();
		return decryptString;
	}

}
