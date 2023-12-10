package assignments08_structured_data;

import java.util.Scanner;

public class VyskytyHodnot {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] pocetVyskytu = new int[1000];

        System.out.println("Zadej cisla (ukonci zapornym cislem):");
        int cislo;
        while ((cislo = sc.nextInt()) >= 0) {
            pocetVyskytu[cislo]++;
        }

        int maxVyskyt = 0;
        int hodnotaMaxVyskytu = 0;

        for (int i = 0; i < pocetVyskytu.length; i++) {
            if (pocetVyskytu[i] > maxVyskyt) {
                maxVyskyt = pocetVyskytu[i];
                hodnotaMaxVyskytu = i;
            }
        }

        System.out.println("Vysledky:");
        for (int i = 0; i < pocetVyskytu.length; i++) {
            if (pocetVyskytu[i] > 0) {
                System.out.println("Hodnota " + i + " se vyskytuje " + pocetVyskytu[i] + "x");
            }
        }

        System.out.println("Hodnota s nejvetsim poctem vyskytu: " + hodnotaMaxVyskytu);
    }
}