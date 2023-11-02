package assignments04_primitives;

import java.util.Scanner;

public class U05bMaxCount {
    /*
    Napište program, kterému je na vstupu zadána posloupnost celých čísel. Program má zjistit a vypsat maximální 
        hodnotu a počet výskytů této maximální hodnoty. 
    */
    
    // posloupnost je ukoncena pomoci 0
    
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Zadej počet prvků: ");
        int cislo = 0;
        int max = Integer.MIN_VALUE;
        int pocetMax = 0;
        
        boolean isValid = false;
        
        System.out.println("Zadej posloupnost:");
        while ((cislo = sc.nextInt()) != 0) {
            if (cislo > max) {
                max = cislo;
                pocetMax = 1;
            } else if (cislo == max) {
                pocetMax++;
            }
            isValid = true;
        }
        
        if (!isValid) {
            System.out.println("Špatně zadaná posloupnost.");
        } else {
            System.out.println("Maximum je: " + max);
            System.out.println("Počet maxim je: " + pocetMax);
        }
    }    
}