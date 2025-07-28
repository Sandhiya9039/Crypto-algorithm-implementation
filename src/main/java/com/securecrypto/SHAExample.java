package com.securecrypto;
import java.security.MessageDigest;

public class SHAExample {
    public static void main(String[] args) throws Exception {
        String text = "HelloSHA";

        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] hash = sha.digest(text.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }

        System.out.println("Original: " + text);
        System.out.println("SHA-256 Hash: " + hexString.toString());
    }
}