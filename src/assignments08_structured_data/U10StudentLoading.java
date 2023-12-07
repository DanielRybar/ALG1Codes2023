package assignments08_structured_data;

import java.util.Scanner;

public class U10StudentLoading {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Zadej pocet zpracovavanych studentu:");
        int count = sc.nextInt();
        U09TestResult st;
        for (int i = 0; i < count; i++) {
            System.out.println("Zadej studenta (jmeno, prijmeni, osobni cislo, pocet bodu): ");
            st = new U09TestResult(sc.next(), sc.next(), sc.next(), sc.nextDouble());
            System.out.println(st);
            System.out.println("Známka: " + st.getGrade());
            System.out.println();
        }
    }
}