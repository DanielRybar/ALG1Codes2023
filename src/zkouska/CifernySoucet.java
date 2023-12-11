package zkouska;

import java.util.Scanner;

public class CifernySoucet {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int cislo1, cislo2;
        int soucet1, soucet2;
        System.out.print("Zadej cisla:");
        while ((cislo1 = sc.nextInt()) > 0) {
            cislo2 = sc.nextInt();
            soucet1 = 0;
            soucet2 = 0;
            while (cislo1 > 0) {
                soucet1 += cislo1 % 10;
                cislo1 /= 10;
            }
            while (cislo2 > 0) {
                soucet2 += cislo2 % 10;
                cislo2 /= 10;
            }
            boolean jsouStejne = soucet1 == soucet2;
            System.out.println("Soucty " + (jsouStejne ? "stejne" : "ruzne"));
            System.out.print("Zadej cisla:");
        }
        System.out.println("Konec");
    }
}