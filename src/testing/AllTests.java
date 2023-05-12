/**
 * Description: This jUnit test suit tests Vigenere/Cipher test classes
 */
package testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * This class test classes fro caeser and vigenere
 * @author abhishek
 *
 *this class does not return anything
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ CaeserCipherTest.class, VigenereCipherTest.class })

public class AllTests {
	
	
}
