/**
 * Description: This class tests Vigenere Cipher methods
 */
package testing;

import static org.junit.Assert.*;
import org.junit.Test;
import encryption.ciphers.VigenereCipher;

/**
 * The VigenereCipherTest class is used to test the VigenereCipher class methods
 * for encryption and decryption.
 * 
 * @author abhishek
 *
 */
public class VigenereCipherTest {

	/**
	 * This test method tests the encrypt method of VigenereCipher class
	 */

	public void testEncrypt() {

		// this case uses the password 'test' to encrypt the message
		VigenereCipher vigenereCipherEncrypt = new VigenereCipher("test");
		assertEquals("pRYmtSktrYmktXYf^)", vigenereCipherEncrypt.encrypt("what is your name?"));

		// this case uses the password 'word' to encrypt the message
		VigenereCipher vigenereCipherEncrypt1 = new VigenereCipher("word");
		assertEquals("imrW]a\\degr*^\\`\\dYbr", vigenereCipherEncrypt1.encrypt("my name is Abhishek."));

		// this case uses the password 'your' to encrypt the message
		VigenereCipher vigenereCipherEncrypt2 = new VigenereCipher("your");
		assertEquals("u\\[kyXirwcorbc9", vigenereCipherEncrypt2.encrypt("what do you do?"));

		// this case uses the password 'mine' to encrypt the message
		VigenereCipher vigenereCipherEncrypt3 = new VigenereCipher("mine");
		assertEquals("[iTWmOn]fcWO`b!", vigenereCipherEncrypt3.encrypt("i am a student."));

	}

	/**
	 * This test method tests the decrypt() method of VigenereCipher class using a
	 */
	@Test
	public void testDecrypt() {

		// this case uses the password 'test' to decrypt the message
		VigenereCipher vigenereCipherDecrypt = new VigenereCipher("test");
		assertEquals("what is your name?", vigenereCipherDecrypt.decrypt("pRYmtSktrYmktXYf^)"));
		
		VigenereCipher vigenereCipherDecrypt11 = new VigenereCipher("!@#$%");
		assertEquals("hello", vigenereCipherDecrypt11.decrypt("i*opt"));
		
		// this case uses the password 'word' to decrypt the message
		VigenereCipher vigenereCipherDecrypt1 = new VigenereCipher("word");
		assertEquals("my name is Abhishek.", vigenereCipherDecrypt1.decrypt("imrW]a\\degr*^\\`\\dYbr"));

		// this case uses the password 'your' to decrypt the message
		VigenereCipher vigenereCipherDecrypt2 = new VigenereCipher("your");
		assertEquals("what do you do?", vigenereCipherDecrypt2.decrypt("u\\[kyXirwcorbc9"));

		// this case uses the password 'mine' to decrypt the message
		VigenereCipher vigenereCipherDecrypt3 = new VigenereCipher("mine");
		assertEquals("i am a student.", vigenereCipherDecrypt3.decrypt("[iTWmOn]fcWO`b!"));

	}
}
