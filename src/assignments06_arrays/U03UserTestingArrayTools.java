package assignments06_arrays;

import java.util.Scanner;

public class U03UserTestingArrayTools {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int pocet;
        do {
            System.out.println("=======================");
            System.out.println("Zadej pocet hodnot:");
            pocet = sc.nextInt();

            if (pocet == 0) {
                System.out.println("Pole ma nulovou velikost.");
            } else if (pocet > 0) {
                int[] pole = new int[pocet];
                System.out.println("Zadej hodnoty:");
                for (int i = 0; i < pocet; i++) {
                    pole[i] = sc.nextInt();
                }

                U02ArrayTools.printArray(pole);
                U02ArrayTools.printNiceArray(pole);

                System.out.println("Zadej parametr, pro ktery se spocita pocet vyskytu:");
                int occParam = sc.nextInt();

                int max = U02ArrayTools.findMaxValue(pole);
                int min = U02ArrayTools.findMinValue(pole);
                int sum = U02ArrayTools.sumOfValues(pole);
                int product = U02ArrayTools.productOfValues(pole);
                int occ = U02ArrayTools.findOccurrences(pole, occParam);
                boolean isAsc = U02ArrayTools.isAscending(pole);
                boolean isDesc = U02ArrayTools.isDescending(pole);
                boolean isEmpty = U02ArrayTools.isArrayEmpty(pole);

                System.out.println("Maximum: " + max);
                System.out.println("Minimum: " + min);
                System.out.println("Soucet: " + sum);
                System.out.println("Soucin: " + product);
                System.out.println("Vyskyty cisla " + occParam + ": " + occ);
                if (isAsc) {
                    System.out.println("Pole je serazene vzestupne.");
                } else if (isDesc) {
                    System.out.println("Pole je serazene sestupne.");
                } else {
                    System.out.println("Pole neni serazene");
                }
                System.out.println("Je pole prazdne? " + (isEmpty ? "Ano" : "Ne"));

                U02ArrayTools.bubbleSort(pole);
                System.out.println("Radim pomoci BubbleSort");
                U02ArrayTools.printNiceArray(pole);

                int[] reversed = U02ArrayTools.reverseValues(pole);
                System.out.println("Obracene pole");
                U02ArrayTools.printNiceArray(reversed);

                System.out.println("Zadej pocet, minimum a maximum pro generaci nahodneho pole");
                int rndLength = sc.nextInt();
                if (rndLength <= 0) {
                    System.out.println("Pole ma nulovou velikost nebo je zaporne.");
                } else {
                    int rndMin = sc.nextInt();
                    int rndMax = sc.nextInt();
                    int[] rndArr = U02ArrayTools.generateArray(rndLength, rndMin, rndMax);
                    System.out.println("Nahodne pole");
                    U02ArrayTools.printNiceArray(rndArr);
                }
            }

        } while (pocet >= 0);
        System.out.println("Konec programu");
    }
}