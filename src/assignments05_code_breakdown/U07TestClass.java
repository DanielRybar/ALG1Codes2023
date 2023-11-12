package assignments05_code_breakdown;

public class U07TestClass {

    public static void main(String[] args) {
        final double EPS = 1E-6;
        
        // sinus
        double num = 34;
        double mySin = U07MathTools.sin(num, EPS);
        double sin = Math.sin(num);
        
        System.out.println("Můj sinus: " + mySin);
        System.out.println("Sinus: " + sin);
        
        // prirozeny logaritmus
        double num1 = 1025;
        double myLog = U07MathTools.ln(num1, EPS);
        double log = Math.log(num1);
        
        System.out.println("Můj ln: " + myLog);
        System.out.println("ln: " + log);
        
        // pi
        double myPi = U07MathTools.getPi(EPS);
        double pi = Math.PI;
        
        System.out.println("Moje PI: " + myPi);
        System.out.println("PI: " + pi);
    }
}