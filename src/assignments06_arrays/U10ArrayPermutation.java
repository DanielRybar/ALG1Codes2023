package assignments06_arrays;

import java.util.Random;
import java.util.Scanner;

public class U10ArrayPermutation {

    /*
     Zapište a otestujte metodu, která bude generovat pole délky n s náhodnou permutací hodnot 1..n, kde n je celé 
        kladné číslo, jehož hodnota nepřesáhne 1000 (realizujte dvě různé verze algoritmu / dvě různé metody).
    */
    
    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random();
    
    public static void main(String[] args) {
        System.out.println("Zadej delku permutace");
        int n = sc.nextInt();
        int[] per;
        try {
            per = generatePermutation(n);
            U02ArrayTools.printNiceArray(per);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    static int[] generatePermutation(int n) {
        if (n <= 0 || n >= 1000) throw new IndexOutOfBoundsException();
        int[] perArr = new int[n];        
        for (int i = 0; i < n; i++) {
            perArr[i] = i + 1; // 1,2,3,4,...
        }    
        int j;
        for (int i = n - 1; i > 0; i--) {
            j = rand.nextInt(i + 1); // 0 <= j <= i
            int temp = perArr[i];
            perArr[i] = perArr[j];
            perArr[j] = temp;
        }
        
        return perArr;
    }
}