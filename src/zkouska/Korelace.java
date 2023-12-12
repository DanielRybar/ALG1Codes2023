package zkouska;

import java.util.Scanner;

public class Korelace {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Zadej pocet bodu: ");
        int pocet = sc.nextInt();
        double[] souradniceX = new double[pocet];
        double[] souradniceY = new double[pocet];

        double sumX = 0, sumY = 0;
        for (int i = 0; i < pocet; i++) {
            souradniceX[i] = sc.nextDouble();
            souradniceY[i] = sc.nextDouble();

            sumX += souradniceX[i];
            sumY += souradniceY[i];
        }

        double prumerX = sumX / pocet;
        double prumerY = sumY / pocet;

        double citatel = 0;
        double jmenovatelA = 0, jmenovatelB = 0;
        for (int i = 0; i < pocet; i++) {
            citatel += (souradniceX[i] - prumerX) * (souradniceY[i] - prumerY);
            jmenovatelA += Math.pow((souradniceX[i] - prumerX), 2);
            jmenovatelB += Math.pow((souradniceY[i] - prumerY), 2);
        }

        double jmenovatel = Math.sqrt(jmenovatelA * jmenovatelB);

        double r = citatel / jmenovatel;
        System.out.println("Korelacni koeficient: " + r);
    }
}