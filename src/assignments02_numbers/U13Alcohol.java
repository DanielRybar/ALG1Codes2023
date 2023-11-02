package assignments02_numbers;

import java.util.Scanner;

public class U13Alcohol {

    public static void main(String[] args) {

        // konstanty
        final double rho = 0.8; // hustota ethanolu g/cm3
        final double r; // podíl vody v organismu
        final double beta; // rychlost odbourávání alkoholu v g/hod

        Scanner sc = new Scanner(System.in);

        // zjištění, zda počítáme pro muže/ženu
        System.out.print("Zvolte, zda budeme počítat pro muže [1], nebo ženu [2]: ");
        while (true) {
            String gender = sc.nextLine();
            if (gender.contains("1") && !gender.contains("2")) {
                r = 0.7;
                beta = 0.1;
                System.out.println("Zvolili jste muže.");
                break;
            } else if (gender.contains("2") && !gender.contains("1")) {
                r = 0.6;
                beta = 0.085;
                System.out.println("Zvolili jste ženu.");
                break;
            } else {
                System.out.print("Nezvolili jste ani jedno. Opakujte: ");
            }
        }

        System.out.print("Zadejte objem vypitého nápoje (v ml): ");
        double volumeQ; // objem vypitého nápoje (ml)
        while (true) {
            try {
                volumeQ = sc.nextDouble();
                if (volumeQ <= 0) {
                    System.out.print("Neplatná hodnota. Opakujte: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.print("Hodnota není číslo. Opakujte: ");
                sc.nextLine();
            }
        }

        System.out.print("Zadejte podíl alkoholu ve vypitém nápoji: ");
        double alcoholProportion; // podíl alkoholu ve vypitém nápoji
        while (true) {
            try {
                alcoholProportion = sc.nextDouble();
                if (alcoholProportion < 0) {
                    System.out.print("Neplatná hodnota. Opakujte: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.print("Hodnota není číslo. Opakujte: ");
                sc.nextLine();
            }
        }

        System.out.print("Zadejte hmotnost konzumenta (v kg): ");
        double consumentWeight; // hmotnost konzumenta (kg)
        while (true) {
            try {
                consumentWeight = sc.nextDouble();
                if (consumentWeight <= 0) {
                    System.out.print("Neplatná hodnota. Opakujte: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.print("Hodnota není číslo. Opakujte: ");
                sc.nextLine();
            }
        }

        // Widmarkovy vzorce
        // hmotnost vypitého ethanolu
        double ethanolWeight = (volumeQ * alcoholProportion * rho) / 100; // v gramech

        // promile alkoholu v krvi bezprostředně po konzumaci
        double prom = ethanolWeight / (consumentWeight * r); // v g/kg

        // rychlost odbourávání alkoholu v těle konzumenta
        double speed = consumentWeight * beta; // v g/hod

        System.out.format("Hmotnost vypitého ethanolu je %.2f g.%n", ethanolWeight);
        System.out.format("Promile alkoholu v krvi bezprostředně po konzumaci je %.3f g/kg.%n", prom);
        System.out.format("Rychlost odbourávání alkoholu v těle je %.2f g/hod.%n", speed);
    }
}