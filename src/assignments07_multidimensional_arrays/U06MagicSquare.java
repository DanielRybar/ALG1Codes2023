package assignments07_multidimensional_arrays;

import java.util.Scanner;

public class U06MagicSquare {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] mat = loadMatrix();
        U01MatrixTools.printMatrix(mat);

        boolean isMagic = isMagicSquare(mat);
        System.out.println("Matice " + (isMagic ? "je" : "neni") + " magickym ctvercem");
    }

    private static int[][] loadMatrix() {
        System.out.println("Zadej pocet radku matice:");
        int rows = sc.nextInt();
        System.out.println("Zadej pocet sloupcu matice");
        int cols = sc.nextInt();

        int[][] mat = new int[rows][cols];
        System.out.println("Zadej prvky matice:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        return mat;
    }

    private static boolean isMagicSquare(int[][] mat) {
        int size = mat.length; // predpoklad, ze matice je ctvercova

        int sumd1 = 0, sumd2 = 0;

        for (int i = 0; i < size; i++) {
            sumd1 += mat[i][i]; // diagonala vlevo nahore -> vpravo dole
            sumd2 += mat[i][size - 1 - i]; // diagonala vpravo nahore -> vlevo dole
        }

        System.out.println("Diagonala 1: " + sumd1);
        System.out.println("Diagonala 2: " + sumd2);

        if (sumd1 != sumd2) {
            System.out.println("Ukoncuji testovani, soucty se nerovnaji");
            return false;
        }

        int rowSum, colSum;
        for (int i = 0; i < size; i++) {
            rowSum = 0;
            colSum = 0;

            for (int j = 0; j < size; j++) {
                rowSum += mat[i][j]; // soucet radku
                colSum += mat[j][i]; // soucet sloupce
            }

            System.out.println("Sloupec " + (i + 1) + ": " + colSum);
            System.out.println("Radek " + (i + 1) + ": " + rowSum);

            if (rowSum != colSum || colSum != sumd1) {
                System.out.println("Ukoncuji testovani, soucty se nerovnaji");
                return false;
            }
        }

        return true;
    }
}
