package assignments04_primitives;

import java.util.Scanner;

public class U02Average {
    /*
     Napište program, který načte posloupnost reálných hodnot a vypočte a vypíše jejich průměr. Na vstupu bude 
        zadáno N, X1, X2, …XN, kde N je celkový počet členů posloupnosti a Xi její jednotlivé členy
    */
    
    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.print("Zadej počet prvků: ");
        int pocetPrvku = sc.nextInt();
        int cislo;
        int suma = 0;
        
        boolean isValid = false;
        
        System.out.println("Zadej posloupnost:");
        for (int i = 0; i < pocetPrvku; i++) {
            cislo = sc.nextInt();
            suma += cislo;
            isValid = true;
        }
        
        double prumer = (double)suma / pocetPrvku;
        
        if (!isValid) {
            System.out.println("Špatně zadaná posloupnost.");
        } else {
            System.out.println("Počet prvků je: " + pocetPrvku);
            System.out.println("Součet prvků je: " + suma);
            System.out.println("Průměr je: " + prumer);
        }
    }
}