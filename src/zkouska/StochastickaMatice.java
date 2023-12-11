package zkouska;

import java.util.Scanner;

public class StochastickaMatice {

    private static final Scanner sc = new Scanner(System.in);
    private static final double EPS = 1E-5;

    public static void main(String[] args) {
        System.out.println("Zadej rozmer: ");
        int rozmer = sc.nextInt();
        double[][] matice = nactiCtvercovouMatici(rozmer);
        boolean jeStochasticka = jeStochasticka(matice);
        System.out.println("Matice " + (jeStochasticka ? "je stochasticka" : "neni stochasticka"));
    }

    private static double[][] nactiCtvercovouMatici(int rozmer) {
        System.out.println("Zadej matici: ");
        double[][] mat = new double[rozmer][rozmer];
        for (int i = 0; i < rozmer; i++) {
            for (int j = 0; j < rozmer; j++) {
                mat[i][j] = sc.nextDouble();
            }
        }

        return mat;
    }

    private static boolean jeStochasticka(double[][] matice) {
        double sum;
        for (int i = 0; i < matice.length; i++) {
            sum = 0;
            for (int j = 0; j < matice[i].length; j++) {
                if (matice[i][j] < 0) { // staci nam jedna jedina evidence
                    return false;
                }
                sum += matice[i][j];
            }
            if (Math.abs(sum - 1) > EPS) {
                return false;
            }
        }
        return true;
    }
}