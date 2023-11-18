package semestralProject;

import java.util.Scanner;

public class SemestralMenu {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean end = false;
        do {
            System.out.println("=====================================");
            System.out.println("Vyber si, ktery program chces spustit");
            System.out.println("[1] Soucet a soucin polynomu");
            System.out.println("[2] Vanocni uloha (snehulak)");
            System.out.println("[3] Ukoncit menu");

            System.out.print("Zvol akci: ");
            char choice = sc.next().charAt(0);

            switch (choice) {
                case '1' -> U06PolySumAndProductRybar.main(args);
                case '2' -> ChristmasSnowmanRybar.main(args);
                case '3' -> {
                    System.out.println("Ukoncuji vyber.");
                    System.out.println();
                    end = true;
                }
                default -> System.out.println("Neplatna volba. Zkus to znovu.");
            }
        } while (!end);
    }
}