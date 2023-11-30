package assignments07_multidimensional_arrays;

public class U01TestClass {

    public static void main(String[] args) {
        double[][] mat1 = {{-1, 2, 3, 4}, {5, -6, 7, 8}, {-10, 11, 12, 13}, {100, -100, -100, 100}};
        double[][] mat2 = {{4, 3, 2, 1}, {5, 6, 7, 8}, {10, 11, 12, 13}, {12, 12, 12, 12}};

        // posledni prvek
        System.out.println(mat1[mat1.length - 1][mat1[1].length - 1]);
        System.out.println(mat1[0][mat1[0].length - 1]);

        U01MatrixTools.printMatrix(mat1);
        System.out.println();
        U01MatrixTools.printMatrix(mat2);

        System.out.println();
        System.out.println("Soucet");
        double[][] sum = U01MatrixTools.matrixSum(mat1, mat2);
        U01MatrixTools.printMatrix(sum);

        System.out.println();
        System.out.println("Soucin");
        double[][] product = U01MatrixTools.matrixProduct(mat1, mat2);
        U01MatrixTools.printMatrix(product);

        System.out.println();
        System.out.println("Normovana matice");
        double[][] normMat = U01MatrixTools.normalizeMatrix(mat1);
        U01MatrixTools.printMatrix(normMat);
        
        System.out.println();
        U01MatrixTools.normalizeMatrix2(mat1);
        U01MatrixTools.printMatrix(mat1);
    }
}