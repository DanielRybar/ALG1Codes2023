package assignments03_homework;

public class U33bRectangle {

    public static void main(String[] args) {       
        int M = 20;
        int N = 10;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(ConsoleColors.BLUE + "* ");
            }
            System.out.println(" ");
        }
    }
}