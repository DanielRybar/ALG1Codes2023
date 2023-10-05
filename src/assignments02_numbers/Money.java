package assignments02_numbers;
import java.util.Scanner;

public class Money {

    public static void main(String[] args) {
        /*
         Zapište program, který pro zadanou celočíselnou hodnotu představující částku v korunách určí výčetku platidel, 
        tedy počet bankovek a mincí, kterými lze zadanou sumu zaplatit. Ve svém programu se omezte na bankovky 
        a mince v hodnotě 100, 50, 20, 10, 5, 2 a 1 Kč
        */
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Zadejte částku: ");
        int castka;
        while (true) {
            if (sc.hasNextInt()) {
               castka = sc.nextInt();
               if (castka < 0) {
                   System.out.print("Vstup je záporný, to přeci nejde: ");
               }
               else if (castka == 0) {
                   System.out.print("Vstup je nulový, to přeci nejde: ");
               }
               else break;
            } 
            else {
                System.out.print("Vstup není číslo, opakujte zadávání: ");
                sc.nextLine(); // jinak se dalsi radek necte, program se zacykli a odmita cist dalsi vstup
            }
        }
  
        int[] bankovky = {100, 50, 20, 10, 5, 2, 1};
        int[] pocet = new int[bankovky.length];
        
        for (int i = 0; i < bankovky.length; i++) {
            if (castka >= bankovky[i]) {
                pocet[i] = castka / bankovky[i];
                castka %= bankovky[i];
            }
        }
        
        for (int i = 0; i < bankovky.length; i++) {
            if (pocet[i] > 0)
                System.out.println(pocet[i] + "x - " + bankovky[i] + " Kč");
        }
    }
    
}