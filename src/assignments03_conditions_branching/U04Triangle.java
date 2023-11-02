package assignments03_conditions_branching;

import java.util.Scanner;

public class U04Triangle {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /*
         Napište program, který načte délky tří úseček a zjistí a vypíše informaci o tom, zda lze sestrojit trojúhelník 
            s odpovídajícími délkami stran. Pomůcka: „trojúhelníkové nerovnosti“: (a + b > c) a zároveň (|a – b| < c) . 
        */
        
        System.out.print("Zadejte stranu A: ");
        double a = sc.nextDouble();
                
        System.out.print("Zadejte stranu B: ");
        double b = sc.nextDouble();
                
        System.out.print("Zadejte stranu C: ");
        double c = sc.nextDouble();
        
        boolean isConstructable = false;
        
        if (a + b > c && b + c > a && c + a > b) {
            isConstructable = true;
            System.out.println("Trojúhelník lze sestavit.");
        } else {
            System.out.println("Trojúhelník nelze sestavit.");
        }
        
        if (isConstructable) {
            double perimeter = a + b + c;
            double s = perimeter / 2;
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            
            System.out.println("Obvod je: " + perimeter);
            System.out.println("Obsah je: " + area);
        }
    }
    
}
