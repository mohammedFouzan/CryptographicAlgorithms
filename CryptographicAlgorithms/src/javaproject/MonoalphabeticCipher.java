package javaproject;

public class MonoalphabeticCipher {

    public static char normalChar[]
            = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static char codedChar[]
            = {'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'Q', 'W',
                'E', 'R', 'P', 'A', 'S',
                'D', 'C', 'V', 'T', 'Y',
                'U', 'I', 'O', 'B', 'N', 'M'};

    public String encrypt(String plainText) {

        String cipherText = "";

        for (int i = 0; i < plainText.length(); i++) {
            for (int j = 0; j < 26; j++) {

                if (plainText.charAt(i) == normalChar[j]) {
                    cipherText += codedChar[j]; //cipherText= cipherText+codedChar[j] 
                    break;
                }
//comparing the character and adding the corresponding char to the cipher text
                if (plainText.charAt(i) < 'a' || plainText.charAt(i) > 'z') {
                    cipherText += plainText.charAt(i);
                    break;
                }
            }
        }

        return cipherText;
    }

    public String decrypt(String cipherText) {

        String plainText = "";

        for (int i = 0; i < cipherText.length(); i++) {
            for (int j = 0; j < 26; j++) {

                if (cipherText.charAt(i) == codedChar[j]) {
                    plainText += normalChar[j];
                    break;
                }

                if (cipherText.charAt(i) < 'A' || cipherText.charAt(i) > 'Z') {
                    plainText += cipherText.charAt(i);
                    break;
                }
            }
        }
        return plainText;
    }



}
