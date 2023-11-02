package assignments04_primitives;

import java.util.Scanner;

public class U05aMaxCount {
    /*
    Napište program, kterému je na vstupu zadána posloupnost celých čísel. Program má zjistit a vypsat maximální 
        hodnotu a počet výskytů této maximální hodnoty. 
    */
    
    // nejprve je zadan pocetPrvku, pak posloupnost
    
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Zadej počet prvků: ");
        int pocetPrvku = sc.nextInt();
        int cislo = 0;
        int max = Integer.MIN_VALUE;
        int pocetMax = 0;
        
        boolean isValid = false;
        
        System.out.println("Zadej posloupnost:");
        for (int i = 0; i < pocetPrvku; i++) {
            cislo = sc.nextInt();
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