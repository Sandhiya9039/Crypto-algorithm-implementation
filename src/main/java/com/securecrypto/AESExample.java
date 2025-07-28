package com.securecrypto;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESExample {
    public static void main(String[] args) throws Exception {
        String text = "HelloSecureWorld";

        // Generate AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // 128-bit AES
        SecretKey secretKey = keyGen.generateKey();

        // Encrypt
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = aesCipher.doFinal(text.getBytes());
        String encryptedText = Base64.getEncoder().encodeToString(encrypted);

        // Decrypt
        aesCipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypted = aesCipher.doFinal(Base64.getDecoder().decode(encryptedText));
        String decryptedText = new String(decrypted);

        System.out.println("Original: " + text);
        System.out.println("Encrypted: " + encryptedText);
        System.out.println("Decrypted: " + decryptedText);
    }
}
