package blowfish.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class BlowFishUtility {
	
	private static final String BLOWFISH = "Blowfish";


	public static String encryp(String key, String toBeEncrypted) throws Exception {
		final byte[] keyBytes = key.getBytes();
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, BLOWFISH);
		Cipher cipher = Cipher.getInstance(BLOWFISH);

		cipher.init(Cipher.ENCRYPT_MODE, keySpec);
		byte[] encoding = cipher.doFinal(toBeEncrypted.getBytes());

		final String encryptedData = DatatypeConverter.printBase64Binary(encoding);

		return encryptedData;

	}

	public static String decryp(String key, String toBeDecrypted) throws Exception {
		final byte[] keyBytes = key.getBytes();
		Cipher cipher = Cipher.getInstance(BLOWFISH);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, BLOWFISH);

		byte[] ciphertext = DatatypeConverter.parseBase64Binary(toBeDecrypted);

		cipher.init(Cipher.DECRYPT_MODE, keySpec);
		byte[] message = cipher.doFinal(ciphertext);

		final String decrypted = new String(message);


		return decrypted;
	}

}
