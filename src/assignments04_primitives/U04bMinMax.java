package assignments04_primitives;

import java.util.Scanner;

public class U04bMinMax {
    /*
     Napište program, kterému je na vstupu zadána posloupnost celých kladných čísel. Program má vypsat minimální 
        a maximální zadanou hodnotu a počet sudých členů posloupnosti. Program modifikujte pro oba způsoby 
        zadávání posloupnosti
    */
    
    // posloupnost je ukoncena pomoci 0
    
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int cislo = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int pocetSud = 0;
        
        boolean isValid = false;
        
        System.out.println("Zadej posloupnost, ukonči nulou:");   
        while ((cislo = sc.nextInt()) != 0) {
            if (cislo < min) min = cislo;
            if (cislo > max) max = cislo;
            if (cislo % 2 == 0) pocetSud++;
            isValid = true; // dela se v kazde iteraci cyklu, neni optimalni
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