package semestralProject;

import java.util.Scanner;

/**
 * Uloha 06 - program vyhodnocuje soucet a soucin dilcich polynomu
 *
 * @author Daniel Rybar
 * @version 1.1 07/12/2023
 */
public class U06PolySumAndProductRybar {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /*
        // testovani metod
        // -6x^4 + 2x^3 + 9x^2 - 20x - 19
        Polynomial testPoly1 = new Polynomial(4, new int[] {-19, -20, 9, 2, -6});
        // 99x^8 + 12x^5 + 2x^2 - 91x + 3997
        Polynomial testPoly2 = new Polynomial(8, new int[] {3997, -91, 2, 0, 0, 12, 0, 0, 99});
        
        //for(int item : testPoly1.coefficients) System.out.print(item + " ");
        
        System.out.println("Prvni polynom: " + testPoly1);
        System.out.println("Druhy polynom: " + testPoly2);
        
        System.out.println("Soucet polynomu: " + testPoly1.addPolynomials(testPoly2));
        System.out.println("Soucin polynomu: " + testPoly1.multiplyPolynomials(testPoly2));
         */
        boolean end = false;
        do {
            System.out.println("===================================");
            System.out.println("Stupen prvniho polynomu:");
            int degree1 = validateNumber();
            if (degree1 < 0) {
                System.out.println("Zadal jsi zaporny stupen polynomu. Konec programu.");
                end = true;
            } else {
                int[] coefficients1 = readCoefficients(degree1, "prvniho");
                
                System.out.println("Stupen druheho polynomu:");
                int degree2 = validateNumber();
                if (degree2 < 0) {
                    System.out.println("Zadal jsi zaporny stupen polynomu. Konec programu.");
                    end = true;
                } else {
                    int[] coefficients2 = readCoefficients(degree2, "druheho");
                    
                    // vytvoreni instanci jednotlivych polynomu
                    Polynomial poly1 = new Polynomial(degree1, coefficients1);
                    Polynomial poly2 = new Polynomial(degree2, coefficients2);

                    System.out.println("Prvni polynom: " + poly1);
                    System.out.println("Druhy polynom: " + poly2);

                    Polynomial sum = poly1.addPolynomials(poly2);
                    Polynomial product = poly1.multiplyPolynomials(poly2);

                    System.out.println("Soucet polynomu: " + sum);
                    System.out.println("Soucin polynomu: " + product);
                }
            }
        } while (!end);
    }

    /**
     * podprogram pro cteni jednotlivych koeficientu
     *
     * @param degree stupen polynomu
     * @param order informace o poradi polynomu
     * @return nactene polynom ve forme pole cisel
     */
    private static int[] readCoefficients(int degree, String order) {
        System.out.println("Koeficienty " + order + " polynomu:");
        int[] coefficients = new int[degree + 1]; // napr. pro 3st jsou 4 koeficienty
        for (int i = degree; i >= 0; i--) { // ukladani do pole v obracenem poradi
            coefficients[i] = validateNumber();
        }
        return coefficients;
    }

    /**
     * pomocny podprogram pro validaci cisel
     *
     * @return nactene cislo
     */
    private static int validateNumber() {
        int num = 0;
        boolean isValid = false;
        do {
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Neplatna hodnota (" + sc.next() + "). Opakuj zadavani."); // zde by se dala predat errormessage jako parametr
            }
        } while (!isValid);

        return num;
    }
}