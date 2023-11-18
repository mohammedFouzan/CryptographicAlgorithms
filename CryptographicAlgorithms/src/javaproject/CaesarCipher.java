package javaproject;

public class CaesarCipher {

    public String encrypt(String text,int shiftKey) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i)
                        + shiftKey - 65) % 26 + 65);
                result += ch;
            } else {
                char ch = (char) (((int) text.charAt(i)
                        + shiftKey - 97) % 26 + 97);
                result += ch;
            }
        }
        return result;
    }

    public String decrypt(String text,int shiftKey) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i)
                        - shiftKey - 65) % 26 + 65);
                result += ch;
            } else {
                char ch = (char) (((int) text.charAt(i)
                        - shiftKey - 97) % 26 + 97);
                result += ch;
            }
        }
        return result;
    }

}
