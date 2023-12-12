package zkouska;

import java.util.Scanner;

public class ZapocetUt {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] pole = {1, 111, 3, 4, 5, 777, 11, 112, 2568, 45879};
        int sum = 0;
        int temp, cifry;
        for (int i = 0; i < pole.length; i++) {
            cifry = 0;
            temp = pole[i];
            while (temp > 0) {
                temp /= 10;
                cifry++;
            }
            if (cifry == 3) {
                sum += pole[i];
            }
        }

        System.out.println("Soucet trojcifernych cisel: " + sum);

        int[] fibonacci = {0, 1, 1, 2, 3, 5, 8, 13, 21};
        boolean jeFibonacci = jeFibonaccihoPosloupnost(fibonacci);
        System.out.println("Je Fibonacci: " + jeFibonacci);

        generujVlajku(6, 'a', 'f');

        double[][] matice = {{1, 5, 7, 2}, {2, 5, 7, 1}, {5, 2, 7, 1}, {1, 7, 5, 2}};
        boolean jeRadkoveNormovana = jeMaticeNormovana(matice);
        System.out.println("Je radkove normovana: " + jeRadkoveNormovana);

        int m = 4, n = 6;
        int[][] spirala = zapisCislaPoSpirale(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(spirala[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static boolean jeFibonaccihoPosloupnost(int[] pole) {
        if (pole[0] != 0 || pole[1] != 1) {
            return false;
        }
        for (int i = 2; i < pole.length - 2; i++) {
            if (pole[i] < 0) {
                return false;
            }
            if (pole[i] + pole[i + 1] != pole[i + 2]) {
                return false;
            }
        }
        return true;
    }

    private static void generujVlajku(int vyska, char prvni, char druhy) {
        if (vyska % 2 != 0) {
            return;
        }
        System.out.println();
        char znak = prvni;
        for (int i = 0; i < vyska; i++) {
            if (i > (vyska / 2) - 1) {
                znak = druhy;
            }
            for (int j = 0; j < vyska * 1.5; j++) {
                System.out.print(znak + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean jeMaticeNormovana(double[][] mat) {
        double[] radkoveNormy = new double[mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] < 0) {
                    return false;
                }
                radkoveNormy[i] += Math.pow(mat[i][j], 2);
            }
            radkoveNormy[i] = Math.sqrt(radkoveNormy[i]);
        }

        for (int i = 0; i < radkoveNormy.length - 1; i++) {
            if (radkoveNormy[i] != radkoveNormy[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[][] zapisCislaPoSpirale(int m, int n) {
        int[][] matice = new int[m][n];
        int hod = 1;
        int zacRad = 0;
        int konecRad = m - 1;
        int zacSl = 0;
        int konecSl = n - 1;

        while (hod <= m * n) {
            for (int i = zacSl; i <= konecSl; i++) {
                matice[zacRad][i] = hod++;
            }
            for (int i = zacRad + 1; i <= konecRad; i++) {
                matice[i][konecSl] = hod++;
            }
            for (int i = konecSl - 1; i >= zacSl; i--) {
                matice[konecRad][i] = hod++;
            }
            for (int i = konecRad - 1; i > zacRad; i--) {
                matice[i][zacSl] = hod++;
            }
            zacRad++;
            konecRad--;
            zacSl++;
            konecSl--;
        }

        return matice;
    }
}