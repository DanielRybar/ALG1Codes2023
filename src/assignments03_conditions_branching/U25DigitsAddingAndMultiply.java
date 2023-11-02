package assignments03_conditions_branching;

import java.util.Scanner;

public class U25DigitsAddingAndMultiply {

    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /*
         Zapište program, který pro každé zadané kladné číslo vypíše jeho ciferný součet a ciferný součin. Program nechť 
            skončí po zadání záporné hodnoty nebo 0 na vstupu.
         */
        System.out.print("Zadejte číslo: ");
        int number = sc.nextInt();
        int[] ciphers = getCipherArray(number);

        int sum = 0;
        int multiplication = 1; // nula je agresivní
        for (int i = 0; i < ciphers.length; i++) {
            sum += ciphers[i];
            multiplication *= ciphers[i];
        }
        System.out.println("Součet cifer je: " + sum);
        System.out.println("Součin cifer je: " + multiplication);
    }

    private static int[] getCipherArray(int number) {
        String numberStr = String.valueOf(number);
        int[] digits = new int[numberStr.length()];
        for (int i = 0; i < numberStr.length(); i++) {
            digits[i] = Character.getNumericValue(numberStr.charAt(i));
        }
        return digits;
    }
}