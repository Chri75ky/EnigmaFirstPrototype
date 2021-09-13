package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to encryption central, where we take care of all your encryption needs!");
        System.out.println("Do you wish to encrypt or decode something? (E/D)");
        String encodeOrDecode = in.nextLine();

        if (encodeOrDecode.equals("E")) {
            System.out.println("You have chosen to encode, please enter a text: ");
            String messageToBeEncoded = in.nextLine();
            System.out.println("Here is your encoded text: ");
            System.out.print(Arrays.toString(getNumberArray(messageToBeEncoded)));


        }
        if (encodeOrDecode.equals("D")) {
            System.out.println("You have chosen to decode, please enter a list of numbers: ");
            //int messageToBeDecoded = in.next();
            String[] messageToBeDecoded; //TODO Lad bruger indtaste sin egen string og konverter det til array for at decode sin egen kode
            messageToBeDecoded = new String[]{"7", "15", "4", "20", "0", "7", "29", "5", "20", "0", "4", "21", "0", "5", "18", "0", "6", "15", "18", "0", "19", "5", "10"};


            System.out.println(getCharArray(messageToBeDecoded));


        }
    }
    public static int[] getNumberArray(String messageToBeEncoded){
        int messageLength = messageToBeEncoded.length();
        String bigMessageToBeEncoded = messageToBeEncoded.toUpperCase();

        //  Konverter string til char array
        char[] messageToChar = bigMessageToBeEncoded.toCharArray();

        // Skab et int array med længden af koden der skal krypteres
        int[] numbers = new int[messageLength];

        // Få værdien af de enkelte tal i hele stringen
        for (int i = 0; i < messageToChar.length ; i++) {
            numbers[i] = bigMessageToBeEncoded.codePointAt(i);
        }
        // Tjek de forskellige værdier, hvis bogstavet er indenfor de første 26,
        // skal der trækkes 64 fra for at få værdierne til at passe med 0-26
        // ÆØÅ og mellemrum har andre værdier som skal tages hånd om
        for (int i = 0; i < numbers.length ; i++) {
            if(numbers[i] == 32){
                numbers[i] -= 32;
            }if(numbers[i] == 198){
                numbers[i] -= 107;
            }if(numbers[i] == 216){
                numbers[i] -= 124;
            }if(numbers[i] == 197){
                numbers[i] -= 104;
            }if(numbers[i] == 0){
                numbers[i] = 0;
            }else{
                numbers[i] -= 64;
            }
        }

        return numbers;

    }
    public static char[] getCharArray(String[] encryptedNumbers) {
        // Skab et char array med længden af de krypterede numre
        int[] encryptedNumberArray = new int[encryptedNumbers.length];
        for (int i = 0; i < encryptedNumbers.length; i++) {
            encryptedNumberArray[i] = Integer.parseInt(encryptedNumbers[i]);

        }

        int size = encryptedNumberArray.length;
        int[] encryptedArray = new int[size];
        for (int i = 0; i < size; i++) {
            encryptedArray[i] = Integer.parseInt(String.valueOf(encryptedNumberArray[i]));

        }
        char[] decryptedMessage = new char[encryptedNumberArray.length];
        for (int i = 0; i < encryptedNumberArray.length; i++) {

            if (encryptedNumberArray[i] == 27) {
                encryptedNumberArray[i] += 107;
            }
            if (encryptedNumberArray[i] == 28) {
                encryptedNumberArray[i] += 124;
            }
            if (encryptedNumberArray[i] == 29) {
                encryptedNumberArray[i] += 104;
            }
            if (encryptedNumberArray[i] == 0) {
                encryptedNumberArray[i] += 32;
            } else {
                encryptedNumberArray[i] += 64;
            }
            for (int j = 0; j < encryptedNumberArray.length; j++) {
                decryptedMessage[j] = (char) encryptedNumberArray[j];

            }


        }


        return decryptedMessage;

    }
}
