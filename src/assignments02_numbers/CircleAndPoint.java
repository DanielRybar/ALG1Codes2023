package assignments02_numbers;

import java.util.Scanner;

// program na výpočet vzájemné polohy bodu a kružnice
public class CircleAndPoint {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final double PRESNOST = 0.001; // přesnost

        System.out.print("Zadejte poloměr kružnice: ");
        double r = sc.nextDouble(); // poloměr kce
        if (r <= 0) {
            System.out.println("Neplatná hodnota. Ukončuji program.");
            return;
        }

        System.out.print("Zadejte souřadnice středu: ");
        double sx = sc.nextDouble(); // souřadnice X středu kce
        double sy = sc.nextDouble(); // souřadnice Y středu kce

        System.out.print("Zadejte souřadnice bodu: ");
        double bx = sc.nextDouble(); // souřadnice X bodu
        double by = sc.nextDouble(); // souřadnice Y bodu

        double vzdalenost = Math.hypot(sx - bx, sy - by);
        System.out.println("Vzdálenost je " + vzdalenost);

        Poloha poloha;
        if (Math.abs(vzdalenost - r) < PRESNOST) {
            poloha = Poloha.na;
        } else if (vzdalenost < r) {
            poloha = Poloha.uvnitr;
        } else {
            poloha = Poloha.vne;
        }

        switch (poloha) {
            case uvnitr -> {
                System.out.println("Bod leží uvnitř kružnice.");
            }
            case vne -> {
                System.out.println("Bod leží mimo kružnici.");
            }
            case na -> {
                System.out.println("Bod leží na kružnici.");
            }
        }
    }

    private enum Poloha {
        uvnitr,
        vne,
        na
    }
}

/*
Testovací data:
r = 10
sx = -2
sy = 0

mimo:
[-12, 8]
[9, -8]

na:
[-8, -8]
[6, 6]

uvnitr:
[-4, 2]
[-8, -4]
*/