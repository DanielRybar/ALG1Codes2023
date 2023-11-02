package assignments03_homework;

public class U37Flag {

    public static void main(String[] args) {
        int a = 15;
        int b = 60;

        char z1 = '/';
        char z2 = '%';
        char z3 = '*';

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (i == 0 || i == a - 1) {
                    System.out.print(z1);
                } else if (j == 0 || j == b - 1) {
                    System.out.print(z1);
                } else if (i == j - i && i <= a / 2) {
                    System.out.print(ConsoleColors.BLUE + z2 + ConsoleColors.RESET);
                } else if (j == ((a - i) * 2) - 1 && i > a / 2) {
                    System.out.print(ConsoleColors.BLUE + z2 + ConsoleColors.RESET);
                } else if (i == a / 2 && j >= b / 3) {
                    System.out.print(ConsoleColors.RED + z3 + ConsoleColors.RESET);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}