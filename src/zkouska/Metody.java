package zkouska;

import java.util.Scanner;

public class Metody {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] pole = {1, 5, 8};
        int[] palindrom = vytvorPalindrom(pole);
        for (int prvek : palindrom) {
            System.out.print(prvek + " ");
        }

        int[] pole2 = {12, 2, 5, 9, 7, 7};
        boolean jeStejny = jeStejnySoucet(pole2);
        System.out.println(jeStejny);
        System.out.println();

        int m = 5;
        int n = 10;
        int[][] sachovnice = generujSachovnici(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(sachovnice[i][j] + " ");
            }
            System.out.println();
        }

        int[][] sudaMatice = {{2, 4, 10, 8, 6}, {1226, 14, 86, 12, 50}, {2, 4, 111000, 6666, 8}};
        System.out.println(jeMaticeSuda(sudaMatice));
    }

    public static int[] vytvorPalindrom(int[] pole) {
        int[] posl = new int[pole.length * 2 - 1];
        for (int i = 0; i < pole.length; i++) {
            posl[i] = pole[i];
            posl[posl.length - i - 1] = pole[i];
        }
        return posl;
    }

    public static boolean jeStejnySoucet(int[] pole) {
        int sum1, sum2;
        for (int i = 0; i < pole.length - 3; i += 2) {
            sum1 = pole[i] + pole[i + 1];
            sum2 = pole[i + 2] + pole[i + 3];

            if (sum1 != sum2) {
                return false;
            }
        }
        return true;
    }

    public static int[][] generujSachovnici(int m, int n) {
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = (i + j) % 2;
            }
        }
        return mat;
    }

    public static boolean jeMaticeSuda(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] <= 0 || mat[i][j] % 2 != 0) {
                    return false; // vsechno je zavisle na te jedne evidenci
                }
            }
        }
        return true;
    }
}