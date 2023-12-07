package assignments07_multidimensional_arrays;

import java.util.Scanner;

public class U07UpperTriangular {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] mat = loadMatrix();
        boolean isUpperTr = isUpperTriangular(mat);
        System.out.println("Matice " + (isUpperTr ? "je" : "neni") + " horni trojuhelnikova.");
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
    
    public static boolean isSquare(int[][] matrix) {
        int width = matrix.length;
        for (int i = 0; i < width; i++) {
            if (matrix[i].length != width) {
                return false;
            }
        }
        return true;
    }

    public static boolean isUpperTriangular(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}