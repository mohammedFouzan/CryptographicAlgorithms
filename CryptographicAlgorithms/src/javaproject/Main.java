package javaproject;

import java.util.Scanner;

public class Main {

    String plainText, cipherText;
    int choice1, choice2; 

    void getPlainText() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your message = ");
        plainText = sc.nextLine();
        cipherText = "";
    }

    void getCipherText() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your cipher = ");
        cipherText = sc.nextLine();
        plainText = "";
    }

    void displayMenu() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("\n---|-------------------------------|---");
            System.out.println("---|------ Choice any method ------|---");
            System.out.println("---|-------------------------------|---");
            System.out.println("---| 1. Caesar Cipher   \t\t\t|---");
            System.out.println("---| 2. Monoalphabetic Cipher   \t|---");
            System.out.println("---| 3. Vigenere Cipher \t\t\t|---");
            System.out.println("---| 4. Go back    \t\t\t\t\t|---");

            System.out.println("Enter your choice to encrypt data (1-4) : ");
            choice2 = sc.nextInt();
            sc.nextLine();

            switch (choice2) {
                case 1:
                    CaesarCipher c = new CaesarCipher();
                    System.out.println("Enter key shift value = ");
                    int shiftKey = sc.nextInt();
                    sc.nextLine();

                    if (choice1 == 1) {
                        this.getPlainText();
                        cipherText = c.encrypt(plainText, shiftKey);
                        System.out.println("Ciphertext = " + cipherText);
                    } else {
                        this.getCipherText();
                        plainText = c.decrypt(cipherText, shiftKey);
                        System.out.println("Plaintext = " + plainText);
                    }

                    break;
                case 2:
                    MonoalphabeticCipher m = new MonoalphabeticCipher();
                    if (choice1 == 1) {
                        this.getPlainText();
                        cipherText = m.encrypt(plainText);
                        System.out.println("Ciphertext = " + cipherText);
                    } else {
                        this.getCipherText();
                        plainText = m.decrypt(cipherText);
                        System.out.println("Plaintext = " + plainText);
                    }
                    break;
                case 3:
                    System.out.println("Enter key: ");
                    String keyword = sc.nextLine();
                    keyword = keyword.toUpperCase();
                    String key = "";
                    if (choice1 == 1) {
                        this.getPlainText();
                        key = Vigenere.generateKey(plainText.toUpperCase(), keyword);
                        cipherText = Vigenere.encrypt(plainText.toUpperCase(), key);
                        System.out.println("Ciphertext = " + cipherText);
                    } else {

                        this.getCipherText();
                        key = Vigenere.generateKey(cipherText.toUpperCase(), keyword);
                        plainText = Vigenere.decrypt(cipherText, key);
                        System.out.println("Plaintext = " + plainText);
                    }
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }

        }
    }

    void displayMainMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n-----------------------------------");
            System.out.println("------------- MAIN MENU -------------");
            System.out.println("-------------------------------------\n");
            System.out.println("1. Encrypt Message");
            System.out.println("2. Decrypt Cipher");
            System.out.println("3. Exit");

            System.out.println("Enter your choice (1-3) : ");
            choice1 = sc.nextInt();
            sc.nextLine();
            switch (choice1) {
                case 1:
                case 2:
                    this.displayMenu();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
    public static void main(String[] args) {
        Main ob = new Main();
        ob.displayMainMenu();
    }

}
