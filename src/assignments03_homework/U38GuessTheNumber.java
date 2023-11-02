package assignments03_homework;

import java.util.Random;
import java.util.Scanner;

public class U38GuessTheNumber {

    private final static Scanner sc = new Scanner(System.in);
    private final static Random rand = new Random();

    public static void main(String[] args) {
        System.out.println(ConsoleColors.PURPLE_BOLD + "===============================");
        System.out.println(ConsoleColors.PURPLE_BOLD + "Vítej v hře Hádání čísla!");
        System.out.println(ConsoleColors.PURPLE_BOLD + "===============================");

        // menu
        while (true) {
            System.out.println("\n" + ConsoleColors.BLUE + "Vyber si akci:");
            System.out.println(ConsoleColors.BLUE + "1. Hádám číslo");
            System.out.println(ConsoleColors.BLUE + "2. Myslím si číslo, hádá počítač");
            System.out.println(ConsoleColors.BLUE + "3. Ukončit hru");
            System.out.print(ConsoleColors.GREEN + "Zvol akci: ");

            char choice = sc.next().charAt(0);

            switch (choice) {
                case '1':
                    playAsGuesser();
                    break;
                case '2':
                    playAsThinker();
                    break;
                case '3':
                    System.out.println(ConsoleColors.PURPLE_BOLD + "===============================");
                    System.out.println(ConsoleColors.PURPLE_BOLD + "Děkujeme za hru.");
                    System.out.println(ConsoleColors.PURPLE_BOLD + "===============================");
                    System.out.println();
                    sc.close();
                    return;
                default:
                    System.out.println(ConsoleColors.RED_BOLD + "Neplatná volba. Zkus to znovu.");
            }
        }
    }

    private static void playAsGuesser() {
        int minRange = validateNumber("Zadej dolní hranici rozsahu čísel: ");
        int maxRange = validateNumber("Zadej horní hranici rozsahu čísel: ");
        
        // pokud uzivatel zada max <= min; k probehnuti cyklu nemusi vubec dojit, proto while
        while (maxRange <= minRange) {
            System.out.println(ConsoleColors.RED_BOLD + "Horní hranice nemůže být menší nebo rovna dolní hranici!");
            maxRange = validateNumber("Zadej horní hranici rozsahu čísel: ");
        }
        
        int numberToGuess = minRange + rand.nextInt(maxRange - minRange + 1);
        int attempts = 0;

        System.out.println(ConsoleColors.BLUE + "Hádej číslo v rozsahu od " + minRange + " do " + maxRange);

        boolean guessed = false;
        while (!guessed) {
            int guess = validateNumber("Tvůj tip: ");
            attempts++;

            if (guess == numberToGuess) {
                System.out.println(ConsoleColors.PURPLE_UNDERLINED + "Správně! Uhodl jsi číslo " + numberToGuess + " po " + attempts + " pokusech.");
                guessed = true;
            } else if (guess < numberToGuess) {
                System.out.println(ConsoleColors.BLUE + "Myšlené číslo je větší.");
            } else {
                System.out.println(ConsoleColors.BLUE + "Myšlené číslo je menší.");
            }
        }
    }

    private static void playAsThinker() {
        int minRange = validateNumber("Zadej dolní hranici rozsahu čísel: ");
        int maxRange = validateNumber("Zadej horní hranici rozsahu čísel: ");
        
        // pokud uzivatel zada max <= min; k probehnuti cyklu nemusi vubec dojit, proto while
        while (maxRange <= minRange) {
            System.out.println(ConsoleColors.RED_BOLD + "Horní hranice nemůže být menší nebo rovna dolní hranici!");
            maxRange = validateNumber("Zadej horní hranici rozsahu čísel: ");
        }

        System.out.println(ConsoleColors.BLUE + "Myslíš si číslo v rozsahu od " + minRange + " do " + maxRange);
        System.out.println(ConsoleColors.BLUE + "Nyní se pokusím uhodnout číslo.");

        int attempts = 0;

        boolean guessed = false;
        while (!guessed) {
            int guessedNumber = minRange + ((maxRange - minRange) / 2); // metoda půlení intervalu
            attempts++;

            System.out.println("Myslel sis číslo " + guessedNumber + "?");
            System.out.println("1. Ano, uhodl jsi");
            System.out.println("2. Moje číslo je menší");
            System.out.println("3. Moje číslo je větší");

            System.out.print(ConsoleColors.GREEN + "Zvol akci: ");
            char action = sc.next().charAt(0);

            switch (action) {
                case '1':
                    System.out.println(ConsoleColors.PURPLE_UNDERLINED
                            + "Správně! Uhodl jsem tvoje číslo " + guessedNumber + " po " + attempts + " pokusech.");
                    guessed = true;
                case '2':
                    maxRange = guessedNumber - 1;
                    break;
                case '3':
                    minRange = guessedNumber + 1;
                    break;
                default:
                    System.out.println(ConsoleColors.RED + "Neplatná volba. Zkus to znovu.");
            }
        }
    }

    // pomocný podprogram pro validaci cisel
    private static int validateNumber(String inputMessage) {
        int num = 0;
        boolean isValid = false;

        do {
            System.out.print(ConsoleColors.GREEN + inputMessage);
            sc.nextLine(); // posuneme skener na dalsi radek
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                isValid = true;
            } else {
                System.out.println(ConsoleColors.RED_BOLD + "Zadal jsi neplatnou hodnotu. Zkus to znovu."); // zde by se dala predat i errormessage jako parametr
            }
        } while (!isValid);

        return num;
    }
}