package assignments04_homeworks;

import java.util.Scanner;

public class U28PerfectNumber {
    
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /*
         Napište program, který pro každé zadané kladné číslo vypíše informaci o tom, zda se jedná o číslo dokonalé.
            Dokonalé číslo je takové přirozené číslo, které je rovné součtu všech svých kladných dělitelů (včetně 1, kromě 
            čísla samého). Dokonalá čísla jsou například 6 a 28: 6 = 1 + 2 + 3; 28 = 1 + 2 + 4 + 7 + 14. Další dokonalá čísla jsou
            i: 496, 8128, 33550336, 8589869056, 137438691328. 
        */
        
        System.out.print("Zadejte číslo: ");
        long number = sc.nextLong();
        long sum = 0;
        
        for(long i = 1; i < number; i++) {
            if(number % i == 0) {
                sum += i;
            }
        }
        
        boolean isPerfect = number == sum;
        System.out.println(isPerfect ? "Číslo je dokonalé." : "Číslo není dokonalé.");
    } 
}