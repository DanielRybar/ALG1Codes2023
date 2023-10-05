package assignments01_introduction;

public class NumberSwapping {

    public static void main(String[] args) {
        int a = 34;
        int b = 89;
        
        // bez vymeny v pameti
        System.out.println(b + ", " + a);
        
        // s prohozem s pomocnou promennou
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a + ", " + b);
        
        // s prohozem bez pomocne promenne
        a = 34;
        b = 89;
        
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a + ", " + b);
    }
}