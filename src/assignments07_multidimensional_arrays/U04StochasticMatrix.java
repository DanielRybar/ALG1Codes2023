package assignments07_multidimensional_arrays;

import java.util.Scanner;

public class U04StochasticMatrix {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] mat = loadMatrix();
        boolean isSt = isStochastic(mat);
        System.out.println("Matice " + (isSt ? "je" : "neni") + " stochasticka.");
    }

    private static boolean isStochastic(int[][] mat) {
        int sum;
        for (int i = 0; i < mat.length; i++) {
            sum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] < 0) {
                    return false;
                }
                sum += mat[i][j];
            }
            if (sum != 1) {
                return false;
            }
        }

        return true;
    }

    private static int[][] loadMatrix() {
        System.out.println("Zadej pocet radku matice:");
        int rows = sc.nextInt();
        System.out.println("Zadej pocet sloupcu matice");
        int cols = sc.nextInt();

        // if (rows != cols) ...
        int[][] mat = new int[rows][cols];
        System.out.println("Zadej prvky matice:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        return mat;
    }
}