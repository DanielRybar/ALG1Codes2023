package assignments07_multidimensional_arrays;

public final class U01MatrixTools {

    private U01MatrixTools() {
    }

    /**
     * vypise 2D pole
     *
     * @param matrix vstupni 2D pole
     */
    public static void printMatrix(double[][] matrix) {
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
    public static double[][] matrixSum(double[][] mat1, double[][] mat2) {
        int width = mat1.length;
        int height = mat1[0].length;
        double[][] sum = new double[width][height];

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
    public static double[][] matrixProduct(double[][] mat1, double[][] mat2) {
        int rows1 = mat1.length;
        int cols1 = mat1[0].length;
        int rows2 = mat2.length;
        int cols2 = mat2[0].length;

        if (cols1 != rows2) {
            throw new IllegalArgumentException("Neni splnena podminka pro nasobeni (pocet sloupcu mat1 se musi rovnat poctu radku mat2)");
        }

        double[][] result = new double[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return result;
    }

    /**
     * prevede matici do normovaneho tvaru, tj. kazdy jeji prvek vydeli
     * absolutni hodnotou prvku matice s maximalni absolutni hodnotou
     *
     * @param mat vstupni matice
     * @return normovana matice
     */
    public static double[][] normalizeMatrix(double[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        double maxValue = findMaxAbsValue(mat);

        double[][] normMat = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                normMat[i][j] = mat[i][j] / maxValue;
            }
        }
        return normMat;
    }

    /**
     * prevede matici do normovaneho tvaru, tj. kazdy jeji prvek vydeli
     * absolutni hodnotou prvku matice s maximalni absolutni hodnotou
     *
     * @param mat vstupni matice
     */
    public static void normalizeMatrix2(double[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        double maxValue = findMaxAbsValue(mat);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] /= maxValue;
            }
        }
    }

    /**
     * najde v matici prvek s nejvetsi absolutni hodnotou
     *
     * @param mat vstupni matice
     * @return nejvetsi prvek s absolutni hodnotou
     */
    private static double findMaxAbsValue(double[][] mat) {
        double max = 0; // v pripade absolutni hodnoty staci 0

        for (double[] row : mat) {
            for (double value : row) {
                double abs = Math.abs(value);
                if (max < abs) {
                    max = abs;
                }
            }
        }
        return max;
    }
}