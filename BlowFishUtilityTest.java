package blowfish.util;

public class BlowFishUtilityTest {

	private static final String KEY = "something";

	public static void main(String ar[]) throws Exception {
		
		String valueToConvert = "Check is this working?";
		
		String encryptedValue = BlowFishUtility.encryp(KEY, valueToConvert);
		
		String decryptedValue = BlowFishUtility.decryp(KEY, encryptedValue);
		
		if(!valueToConvert.equals(decryptedValue)) {
			throw new Exception("Blowfish encryption or decryption mechanism is not working.");
		} else {
			System.out.println("Blowfish working perfectly");
		}
	}
}
