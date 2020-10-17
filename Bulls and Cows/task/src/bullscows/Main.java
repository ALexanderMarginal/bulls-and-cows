package bullscows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static final String[] symbols = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "g", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static String secret = "";
    private static final ArrayList<String> secretArray = new ArrayList<>();
    private static int step = 1;

    public static void main(String[] args) {
        createSecretNumber();
        System.out.println("Okay, let's start a game!");
        startGame();
    }

    private static void createSecretNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        String secretLengthTemp = sc.nextLine();
        int secretLength = 0;

        try {
            secretLength = Integer.parseInt(secretLengthTemp);
        } catch (NumberFormatException e) {
            System.out.println("Error: " + secretLengthTemp + " isn't a valid number.");
            System.exit(0);
        }

        if (secretLength == 0) {
            System.out.println("Error");
            System.exit(0);
        }

        System.out.println("Input the number of possible symbols in the code:");
        int symbolsArrayLength = sc.nextInt();

        if (symbolsArrayLength > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        }

        if (symbolsArrayLength < secretLength) {
            System.out.printf("Error: it's not possible to generate a code with a length of %s with %s unique symbols.\n", secretLength, symbolsArrayLength);
            System.exit(0);
        }

        ArrayList<String> arr = new ArrayList<String>(Arrays.asList(symbols).subList(0, symbolsArrayLength));
        Collections.shuffle(arr);
        StringBuilder secretNumber = new StringBuilder();
        for (int i = 0; i < secretLength; i++) {
            secretNumber.append(arr.get(i));
            secretArray.add(arr.get(i));
        }
        secret = secretNumber.toString();

        System.out.print("The secret is prepared: ");
        for (int i = 0; i < secretLength; i++) {
            System.out.print("*");
        }
        System.out.print(" ");
        System.out.print("(0-9");
        if (symbolsArrayLength > 10) {
            System.out.print(", a-" + symbols[symbolsArrayLength - 1]);
        }
        System.out.print(").\n");
    }

    private static void startGame() {
        System.out.printf("Turn %s:\n", step);
        String[] guesses = getGuesses();
        int bulls = getCount(guesses, true);
        int cows = getCount(guesses, false);
        System.out.print("Grade: ");
        if (bulls == 0 && cows == 0) {
            System.out.print("None");
        }

        if (bulls > 0) {
            System.out.print(bulls + " bull(s)");
        }

        if (bulls > 0 && cows > 0) {
            System.out.print(" and ");
        }

        if (cows > 0) {
            System.out.print(cows + " cow(s)");
        }

        if (bulls > 0) {
            System.out.print(bulls + " bull(s)");
        }

        if (bulls == secret.length()) {
            System.out.println("Congratulations! You guessed the secret code.");
            System.exit(0);
        }

        System.out.print("\n");
        step++;
        startGame();
    }

    private static String[] getGuesses() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().split("");
    }

    private static int getCount(String[] guesses, Boolean isBullCounter) {
        int count = 0;
        int l = secretArray.size();
        for (int i = 0; i < l; i++) {
            String secretChar = secretArray.get(i);
            if (isBullCounter && secretChar.equals(guesses[i])) {
                count++;
            }
            if (!isBullCounter) {
                for (int j = 0; j < guesses.length; j++) {
                    if (i != j && guesses[j].equals(secretChar)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
