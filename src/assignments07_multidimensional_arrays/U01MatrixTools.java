package assignments07_multidimensional_arrays;

public final class U01MatrixTools {

    private U01MatrixTools() {
    }

    /**
     * vypise 2D pole
     *
     * @param matrix vstupni 2D pole
     */
    public static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * provede soucet 2 matic
     *
     * @param mat1 prvni matice
     * @param mat2 druha matice
     * @return matice - soucet prvni a druhe matice
     */
    public static int[][] matrixSum(int[][] mat1, int[][] mat2) {
        int width = mat1.length;
        int height = mat1[0].length;
        int[][] sum = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                sum[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        return sum;
    }

    /**
     * provede soucin 2 matic (nikoli prvkovy, ale klasicky)
     *
     * @param mat1 prvni matice
     * @param mat2 druha matice
     * @return matice - soucin prvni a druhe matice
     */
    public static int[][] matrixProduct(int[][] mat1, int[][] mat2) {
        int rows1 = mat1.length;
        int cols1 = mat1[0].length;
        int rows2 = mat2.length;
        int cols2 = mat2[0].length;

        if (cols1 != rows2) {
            throw new IllegalArgumentException("Neni splnena podminka pro nasobeni (pocet sloupcu mat1 se musi rovnat poctu radku mat2)");
        }

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }

        return result;
    }
}