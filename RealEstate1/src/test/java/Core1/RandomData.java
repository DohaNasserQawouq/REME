package Core1;

import java.util.Random;

public class RandomData {
    public static String generateRandomEmail() {
        // Generate a random email with a combination of characters and numbers
        String emailPrefix = "user" + generateRandomString(3); // Prefix for the email
        String emailDomain = "@gmail.com"; // Change to your desired domain

        return emailPrefix + emailDomain;
    }

    public static String generateRandomPassword() {
        // Generate a random password with a combination of characters, numbers, and symbols
        return generateRandomString(6); // Change the length of the password as needed
    }

    public static String generateRandomPhoneNumber(){
        String phonePrefix="05";
        String phoneSafix=generateRandomNumber(8);
        return phoneSafix;
    }


    private static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }

    private static String generateRandomNumber(int length) {
        String characters = "0123456789";

        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }

    public static void main(String[] args) {
        String randomEmail = generateRandomEmail();
        String randomPassword = generateRandomPassword();
        String randomPhoneNumber=generateRandomPhoneNumber();

        System.out.println("Random Email: " + randomEmail);
        System.out.println("Random Password: " + randomPassword);
        System.out.println("Random phone number: "+randomPhoneNumber);
    }
}
