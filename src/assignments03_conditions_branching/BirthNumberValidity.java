package assignments03_conditions_branching;

import java.util.Scanner;

public class BirthNumberValidity {
    
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /*     
         Zapište program, který načte dvě celá čísla (do proměnných celočíselného typu) představující první a druhou část 
            rodného čísla, a otestuje, zda se jedná o platné rodné číslo. Jednoduchý test na platnost rodného čísla je 
            dělitelnost 11. Rodná čísla jsou zpravidla dělitelná číslem 11. Nicméně, toto neplatí pro všechna přidělená rodná 
            čísla. Ve skutečnosti je algoritmus přidělování rodných čísel následující: 
            (1) vypočti zbytek po dělení prvních devíti číslic a čísla 11; 
            (2) je-li zbytek 10, poslední číslice musí být 0; 
            (3) jinak je poslední číslice rovna zbytku. 
            780123/3540 je tak platné rodné číslo, přestože není dělitelné 11.
         */

        System.out.print("Zadejte první část RČ: ");
        String first = sc.next(); // 040114
        System.out.print("Zadejte druhou část RČ: ");
        String second = sc.next(); // 3534

        boolean isDayValid = false;
        boolean isMonthValid = false;
        boolean isSecondPartValid = false;

        int birthYear = Integer.parseInt(first.substring(0, 2));
        int birthMonth = Integer.parseInt(first.substring(2, 4));
        int birthDay = Integer.parseInt(first.substring(4, 6));

        // jednoduchá validace měsíce a dne narození
        if ((birthMonth >= 1 && birthMonth <= 12) || (birthMonth >= 51 && birthMonth <= 62)) {
            System.out.println("Měsíc je v RČ validní (" + birthMonth + ")");
            isMonthValid = true;
        } else {
            System.out.println("Měsíc není v RČ validní.");
        }
        if (birthDay >= 1 && birthDay <= 31) {
            System.out.println("Den je v RČ validní (" + birthDay + ")");
            isDayValid = true;
        } else {
            System.out.println("Den není v RČ validní.");
        }

        String concBn = first + second; // spojené RČ
        int birthNumber = Integer.parseInt(concBn.substring(0, 9)); // prvních 9 číslic
        int divisionRest = birthNumber % 11; // zbytek po deleni    
        int lastDigit = Integer.parseInt(concBn.substring(9)); // poslední číslice

        if (divisionRest == 10) {
            isSecondPartValid = lastDigit == 0;
        } else {
            isSecondPartValid = divisionRest == lastDigit;
        }
        
        System.out.println("============================");
        // výpis
        if (isDayValid && isMonthValid && isSecondPartValid) {
            System.out.println("RČ je validní.");
        } else {
            System.out.println("RČ není validní.");
        }
        System.out.println();
    }
}