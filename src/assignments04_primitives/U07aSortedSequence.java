package assignments04_primitives;

import java.util.Scanner;

public class U07aSortedSequence {

    /*
     Napište program, který načte posloupnost reálných čísel a vypíše, zda zadaná posloupnost je vzestupně setříděná 
        (opět modifikujte pro oba způsoby načtení posloupnosti).
     */
    private static final Scanner sc = new Scanner(System.in);

    // zada se pocet prvku a pak posloupnost
    public static void main(String[] args) {
        System.out.println("Zadejte počet prvků:");
        int pocetPrvku = sc.nextInt();  
        int cislo;
        
        System.out.println("Zadejte posloupnost:");
        int cisloPred = sc.nextInt();
        boolean jeVzestup = true;
        boolean jeSestup = true;

        for (int i = 1; i < pocetPrvku && (jeVzestup || jeSestup); i++) {
            cislo = sc.nextInt();
            if (cisloPred > cislo) {
                jeVzestup = false;
            }
            if (cisloPred <= cislo) {
                jeSestup = false;
            }
            cisloPred = cislo;
        }

        if (jeVzestup && !jeSestup) {
            System.out.println("Posloupnost je vzestupná");
        } else if (!jeVzestup && jeSestup) {
            System.out.println("Posloupnost je sestupná");
        } else {
            System.out.println("Co to je za nesmysly");
        }
    }
}