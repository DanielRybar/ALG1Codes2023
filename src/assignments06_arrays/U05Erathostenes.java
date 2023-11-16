package assignments06_arrays;

import java.util.Arrays;

public class U05Erathostenes {

    public static void main(String[] args) {
        int k = 100;
        
        if (k <= 1) return;

        boolean[] arr = findPrimesUpToK(k);

        System.out.println("Prvočísla od 2 do " + k + ": ");
        for (int i = 2; i <= k; i++) {
            if (arr[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean[] findPrimesUpToK(int k) {
        boolean[] isPrime = new boolean[k + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false; // 0 a 1 nejsou prvocisla

        for (int i = 2; i * i <= k; i++) { // prip. i <= Math.sqrt(k)
            if (isPrime[i]) {
                for (int j = i * i; j <= k; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}