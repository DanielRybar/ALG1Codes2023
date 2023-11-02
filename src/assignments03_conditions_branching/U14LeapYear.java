package assignments03_conditions_branching;

import java.util.Scanner;

public class U14LeapYear {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /*
         Zapište program, který načte celé číslo představující rok, a určí, zda příslušný rok byl/je/bude přestupný a vypíše 
            k tomu i počet dnů v daném roce. Přestupný rok je dělitelný 4 s tou výjimkou, že roky dělitelné 100 jsou 
            přestupné pouze tehdy, pokud jsou zároveň dělitelné i 400. Přestupné tak byly například i roky 1600 a 2000. 
            Přestupné naopak nejsou například 1700, 1800, 1900, 2100, 2200 atd. 
         */
        
        System.out.print("Zadej rok: ");
        int year = sc.nextInt();
        boolean isLeap;

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            isLeap = true;
        } else {
            isLeap = false;
        }

        System.out.println("Rok " + year + (isLeap ? " je přestupný" : " není přestupný"));
        System.out.println("Počet dní je " + (isLeap ? 366 : 365));
        System.out.println();
    }
}