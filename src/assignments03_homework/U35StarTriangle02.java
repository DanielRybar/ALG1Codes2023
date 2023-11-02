package assignments03_homework;

public class U35StarTriangle02 {

    public static void main(String[] args) {
        int N = 8;
        for (int i = 1; i <= N; i++) {
            // mezery
            for (int j = 1; j <= N - i; j++) {
                System.out.print(" ");
            }
            // hvezdicky
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}