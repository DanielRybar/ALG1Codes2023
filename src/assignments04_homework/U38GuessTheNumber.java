package assignments04_homework;

import java.util.Random;
import java.util.Scanner;

public class U38GuessTheNumber {

    private final static Scanner sc = new Scanner(System.in);
    private final static Random rand = new Random();

    public static void main(String[] args) {
        System.out.println("Vítej v hře Hádání čísla!");

        // menu
        while (true) {
            System.out.println("\nVyber si akci:");
            System.out.println("1. Hádám číslo");
            System.out.println("2. Myslím si číslo, hádá počítač");
            System.out.println("3. Ukončit hru");
            System.out.print("Vyber akci: ");

            String choice = sc.next(); // String kvůli tomu, kdyby uživatel zadával nesmysly

            switch (choice) {
                case "1":
                    playAsGuesser();
                    break;
                case "2":
                    playAsThinker();
                    break;
                case "3":
                    System.out.println("Děkujeme za hru.");
                    sc.close();
                    return;
                default:
                    System.out.println("Neplatná volba. Zkus to znovu.");
            }
        }
    }

    private static void playAsGuesser() {
        System.out.print("Zadej dolní hranici rozsahu čísel: ");
        int minRange = sc.nextInt();

        System.out.print("Zadej horní hranici rozsahu čísel: ");
        int maxRange = sc.nextInt();

        int numberToGuess = minRange + rand.nextInt(maxRange - minRange + 1);
        int attempts = 0;

        System.out.println("Hádej číslo v rozsahu od " + minRange + " do " + maxRange);

        boolean guessed = false;
        while (!guessed) {
            System.out.print("Tvůj tip: ");
            int guess = sc.nextInt();
            attempts++;

            if (guess == numberToGuess) {
                System.out.println("Správně! Číslo " + numberToGuess + " bylo uhodnuto po " + attempts + " pokusech.");
                guessed = true;
            } else if (guess < numberToGuess) {
                System.out.println("Myšlené číslo je větší.");
            } else {
                System.out.println("Myšlené číslo je menší.");
            }
        }
    }

    private static void playAsThinker() {
        System.out.print("Zadej dolní hranici rozsahu čísel: ");
        int minRange = sc.nextInt();

        System.out.print("Zadej horní hranici rozsahu čísel: ");
        int maxRange = sc.nextInt();

        System.out.println("Myslíš si číslo v rozsahu od " + minRange + " do " + maxRange);
        System.out.println("Nyní se pokusím uhodnout číslo.");

        int attempts = 0;

        boolean guessed = false;
        while (!guessed) {
            int guessedNumber = minRange + ((maxRange - minRange) / 2); // metoda půlení intervalu
            attempts++;

            System.out.println("Myslel sis číslo " + guessedNumber + "?");
            System.out.println("1. Ano, uhodl jsi");
            System.out.println("2. Moje číslo je menší");
            System.out.println("3. Moje číslo je větší");

            System.out.print("Zvol akci: ");
            String action = sc.next(); // opět abych nemusel dlouze validovat

            switch (action) {
                case "1":
                    System.out.println("Správně! Uhodl jsem tvoje číslo " + guessedNumber + " po " + attempts + " pokusech.");
                    guessed = true;
                case "2":
                    maxRange = guessedNumber - 1;
                    break;
                case "3":
                    minRange = guessedNumber + 1;
                    break;
                default:
                    System.out.println("Neplatná volba. Zkus to znovu.");
            }
        }
    }
}