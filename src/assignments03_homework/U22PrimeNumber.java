package assignments03_homework;

import java.util.Scanner;

public class U22PrimeNumber {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String input;
        do {
            System.out.print("Zadejte číslo: ");
            int number = sc.nextInt();

            boolean isPrimeNumber = true;

            if (number < 2) {
                isPrimeNumber = false;
            } else {
                int i = 2;
                // zde se nemusi testovat i az do number, ale staci odmocnina z number (matematika)
                while (i <= Math.sqrt(number) && isPrimeNumber) {
                    if (number % i == 0) {
                        isPrimeNumber = false;
                    }
                    i++;
                }
            }

            System.out.println(isPrimeNumber ? number + " je prvočíslo" : number + " není prvočíslo");

            System.out.print("Chcete pokračovat? Pokud ano, zadejte A, pro ukončení cokoli jiného: ");
            input = sc.next();
        } while (input.toLowerCase().equals("a"));
    }
}