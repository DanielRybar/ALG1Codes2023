package assignments05_code_breakdown;

public class U03TestClass {

    public static void main(String[] args) {
        // instance a vypis vektoru (toString metoda)
        Vector v = new Vector(1, 1, 1);
        System.out.println("Vektor je " + v);
        
        // vypocet delky vektoru
        double distance = U03VectorTools.calculateDistance(v.getX(), v.getY(), v.getZ());
        System.out.println("Vzdálenost je " + distance);

        System.out.println();
        
        Vector v1 = new Vector(2, 3, 4);
        System.out.println("Vektor1 je " + v1);
        Vector v2 = new Vector(5.7, 8.6, 1.5);
        System.out.println("Vektor2 je " + v2);
        
        // vypocet skalarniho soucinu vektoru
        double dotProduct = U03VectorTools.calculateDotProduct(v1, v2);
        System.out.println("Skalární součin je " + dotProduct);
    }
}