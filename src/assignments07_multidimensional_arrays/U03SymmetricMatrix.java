package assignments07_multidimensional_arrays;

import java.util.Scanner;

public class U03SymmetricMatrix {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //int mat[][] = loadMatrix();
        int[][] mat = {{1, 2, 3}, {2, 5, 6}, {3, 6, 9}};
        int[][] mat1 = {{1, 2, 3}, {4, 5, 2}, {7, 4, 1}};
        int[][] mat2 = {{1, 2, 1}, {4, 5, 4}, {7, 4, 7}};
        int[][] mat3 = {{1, 2, 1}, {4, 5, 4}, {1 ,2, 1}};
        boolean mdSym = isSymetric(mat, SymType.HLAVNI_DIAGONALA);
        boolean sdSym = isSymetric(mat1, SymType.VEDLEJSI_DIAGONALA);
        boolean vaSym = isSymetric(mat2, SymType.VERTIKALNI_OSA);
        boolean haSym = isSymetric(mat3, SymType.HORIZONTALNI_OSA);
        System.out.println(mdSym);
        System.out.println(sdSym);
        System.out.println(vaSym);
        System.out.println(haSym);
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

    private static boolean isSymetric(int[][] mat, SymType type) {
        if (type != null) switch (type) {
            case HLAVNI_DIAGONALA -> {
                for (int i = 0; i < mat.length - 1; i++) {
                    for (int j = i + 1; j < mat[i].length; j++) {
                        if (mat[i][j] != mat[j][i]) {
                            return false;
                        }
                    }
                }
            }
            case VEDLEJSI_DIAGONALA -> {
                for (int i = 0; i < mat.length - 1; i++) {
                    for (int j = 0; j < mat[i].length - i - 1; j++) {
                        if (mat[i][j] != mat[mat.length - j - 1][mat[i].length - i - 1]) {
                            return false;
                        }
                    }
                }
            }
            case VERTIKALNI_OSA -> {
                for (int i = 0; i < mat.length; i++) {
                    for (int j = 0; j < mat[i].length / 2; j++) {
                        if (mat[i][j] != mat[i][mat[i].length - j - 1]) {
                            return false;
                        }
                    }
                }
            }
            case HORIZONTALNI_OSA -> {
                for (int i = 0; i < mat.length / 2; i++) {
                    for (int j = 0; j < mat[i].length; j++) {
                        if (mat[i][j] != mat[mat.length - i - 1][j]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private enum SymType {
        HLAVNI_DIAGONALA, VEDLEJSI_DIAGONALA, VERTIKALNI_OSA, HORIZONTALNI_OSA
    }
}
