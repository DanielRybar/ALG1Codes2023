package assignments04_primitives;

import java.util.Scanner;

public class U04aMinMax {
    /*
     Napište program, kterému je na vstupu zadána posloupnost celých kladných čísel. Program má vypsat minimální 
        a maximální zadanou hodnotu a počet sudých členů posloupnosti. Program modifikujte pro oba způsoby 
        zadávání posloupnosti
    */
    
    // nejprve je zadan pocetPrvku, pak posloupnost
    
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Zadej počet prvků: ");
        int pocetPrvku = sc.nextInt();
        int cislo = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int pocetSud = 0;
        
        boolean isValid = false;
        
        System.out.println("Zadej posloupnost:");
        for (int i = 0; i < pocetPrvku; i++) {
            cislo = sc.nextInt();
            if (cislo < min) min = cislo;
            if (cislo > max) max = cislo;
            if (cislo % 2 == 0) pocetSud++;
            isValid = true;
        }
        if (!isValid) {
            System.out.println("Špatně zadaná posloupnost.");
        } else {
            System.out.println("Minimum je: " + min);
            System.out.println("Maximum je: " + max);
            System.out.println("Počet sudých čísel je: " + pocetSud);
        }
    }    
}