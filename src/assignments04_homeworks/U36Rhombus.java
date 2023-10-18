package assignments04_homeworks;

public class U36Rhombus {

    public static void main(String[] args) {
        int N = 8;
        for (int i = 1; i <= N; i++) {
            // mezery
            for (int j = 1; j <= N - i; j++) {
                System.out.print(" ");
            }

            if (i == 1 || i == N) {
                for (int j = 1; j <= N; j++) {
                    System.out.print("*");
                }
            } else {
                for (int j = 1; j <= N; j++) {
                    if (j == 1 || j == N) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}