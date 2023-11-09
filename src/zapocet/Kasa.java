package zapocet;

import java.util.Scanner;

public class Kasa {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // vse je zabaleno v cyklu pro pokracovani
        do {
            System.out.println("=======================");
            System.out.println("Nový nákup");
            System.out.println("=======================");
            System.out.println("Zadejte cenu položky, množství a typ (potraviny [1] nebo drogérie [2])");
            System.out.println("Např. 12,50  4  1");
            System.out.println();

            double cena = 0;
            int mnozstvi = 0;
            double celkovySoucet = 0; // celková cena nakupu
            int typ = 0;
            int pocetPotravin = 0; // celkové množství položek typu potravin
            int pocetDrogerie = 0;
            double cenaZaPotraviny = 0; // celková cena za položky typu potraviny 
            double cenaZaDrogerii = 0;

            double min = Double.MAX_VALUE;

            while ((cena = sc.nextDouble()) != 0) {
                if (cena < min) {
                    min = cena;
                }
                mnozstvi = sc.nextInt();
                celkovySoucet += (mnozstvi * cena);
                System.out.println("Průběžný součet je: " + celkovySoucet);
                typ = sc.nextInt();
                if (typ == 1) {
                    pocetPotravin += mnozstvi;
                    cenaZaPotraviny += mnozstvi * cena;
                } else if (typ == 2) {
                    pocetDrogerie += mnozstvi;
                    cenaZaDrogerii += mnozstvi * cena;
                }
            }

            System.out.println("Nákup ukončen");

            int celkoveMnozstvi = pocetPotravin + pocetDrogerie; // celkove mnozstvi

            int zaokrSoucet = (int) Math.round(celkovySoucet); // zaokrouhlena celkova cena

            boolean maNarok = celkovySoucet >= 200;
            int pocetSamolepek = maNarok ? (int) (celkovySoucet / 200) : 0;

            System.out.println("Celková cena: " + celkovySoucet + " Kč");
            System.out.println("Celková cena zaokrouhleně: " + zaokrSoucet + " Kč");
            System.out.println("Počet položek - potraviny: " + pocetPotravin);
            System.out.println("Počet položek - drogerie: " + pocetDrogerie);
            System.out.println("Počet všech položek: " + celkoveMnozstvi);
            System.out.println("Celková cena za potraviny: " + cenaZaPotraviny + " Kč");
            System.out.println("Celková cena za drogerii: " + cenaZaDrogerii + " Kč");
            System.out.println("Cena minimální položky je: " + min + " Kč");
            System.out.println("Zákazník "
                    + (maNarok ? "má nárok na " + pocetSamolepek + " samolepek"
                            : "nemá nárok na samolepky"));

            System.out.println("------------------");
            System.out.println("Chcete platit kartou [K] nebo stravenkami [S]?");
            char volba = Character.toUpperCase(sc.next().charAt(0));
            final char KARTA = 'K';
            final char STRAVENKY = 'S';
            final int LIMIT = 5;
            double nazpet = 0;
            if (volba == KARTA) {
                nazpet = 0.02 * celkovySoucet;
                System.out.println("Dostanete nazpět: " + nazpet + ", tedy " + Math.round(nazpet) + " Kč.");
            } else if (volba == STRAVENKY) {
                System.out.println("Zadejte hodnotu stravenky");
                int hodnotaStrav = sc.nextInt();
                System.out.println("Stravenky lze použít jen na nákup potravin.");
                System.out.println("Cena za potraviny je: " + cenaZaPotraviny);
                int maxSleva = hodnotaStrav * LIMIT;
                if (maxSleva >= cenaZaPotraviny) {
                    System.out.println("Stravenky pokryly všechny výdaje za potraviny.");
                    int pocetStr = (int) Math.round((double) cenaZaPotraviny / hodnotaStrav);
                    System.out.println("Bylo uplatněno: " + pocetStr + " stravenek");
                } else {
                    double doplatek = (double) celkovySoucet - maxSleva;
                    System.out.println("Musíte doplatit ještě: " + doplatek);
                }
            }

            System.out.println("Chcete zadat další nákup? [A]no, cokoli jiného pro ukončení");
        } while (Character.toUpperCase(sc.next().charAt(0)) == 'A');
    }
}