/**
 * Description: This class tests Caeser Cipher methods
 */
package testing;

import static org.junit.Assert.*;
import org.junit.Test;
import encryption.ciphers.CaeserCipher;

/**
 * The CaeserCipher class is used to test the CaeserCipher class methods for
 * encryption and decryption.
 * 
 * @author abhishek
 *
 */
public class CaeserCipherTest {

	/**
	 * Method to Test for encryption of strings.
	 */
	@Test
	public void testEncrypt() {

		// Test for encrypting a string with key 1.
		CaeserCipher caeserCipherEncrypt = new CaeserCipher(1);
		assertEquals("bbb", caeserCipherEncrypt.encrypt("aaa"));

		// Test for encrypting a string with key 3.
		CaeserCipher caeserCipherEncrypt1 = new CaeserCipher(3);
		assertEquals("zkdw#lv#!rxu#qdphB", caeserCipherEncrypt1.encrypt("what is your name?"));

		// Test for encrypting a string with key 5.
		CaeserCipher caeserCipherEncrypt2 = new CaeserCipher(5);
		assertEquals("r#%sfrj%nx%Fgmnxmjp3", caeserCipherEncrypt2.encrypt("my name is Abhishek."));

		// Test for encrypting a string with key 3.
		CaeserCipher caeserCipherEncrypt3 = new CaeserCipher(3);
		assertEquals("zkdw#gr#!rx#grB", caeserCipherEncrypt3.encrypt("what do you do?"));

	}

	/**
	 * Method to Test for decryption of strings.
	 */
	@Test
	public void testDecrypt() {

		// Test for decrypting a string with key 1.
		CaeserCipher caeserCipherDecrypt = new CaeserCipher(1);
		assertEquals("aaa", caeserCipherDecrypt.decrypt("bbb"));

		// Test for decrypting a string with key 3.
		CaeserCipher caeserCipherDecrypt1 = new CaeserCipher(3);
		assertEquals("what is your name?", caeserCipherDecrypt1.decrypt("zkdw#lv#!rxu#qdphB"));

		// Test for decrypting a string with key 5.
		CaeserCipher caeserCipherDecrypt2 = new CaeserCipher(5);
		assertEquals("my name is Abhishek.", caeserCipherDecrypt2.decrypt("r#%sfrj%nx%Fgmnxmjp3"));

		// Test for decrypting a string with key 3.
		CaeserCipher caeserCipherDecrypt3 = new CaeserCipher(3);
		assertEquals("what do you do?", caeserCipherDecrypt3.decrypt("zkdw#gr#!rx#grB"));
	}

}
