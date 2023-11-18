package javaproject;

public class Vigenere {

    static String generateKey(String str, String key) {
        int x = str.length();
        for (int i = 0;; i++) {
            if (x == i) {
                i = 0;
            }
            if (key.length() == str.length()) {
                break;
            }
            key += (key.charAt(i));
        }
        return key;
    }

    static String encrypt(String str, String key) {
        String cipherText = "";
        for (int i = 0; i < str.length(); i++) {
            int x = (str.charAt(i) + key.charAt(i)) % 26;
            x += 'A';
            cipherText += (char) (x);
        }
        return cipherText;
    }

    static String decrypt(String cipherText, String key) {
        String orgText = "";
        for (int i = 0; i < cipherText.length() && i < key.length(); i++) {
            int x = (cipherText.charAt(i) - key.charAt(i) + 26) % 26;
            x += 'A';
            orgText += (char) (x);
        }
        return orgText;
    }

}
