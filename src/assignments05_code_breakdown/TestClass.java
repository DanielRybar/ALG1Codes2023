package assignments05_code_breakdown;

public class TestClass {

    public static void main(String[] args) {
        Vector v = new Vector(1, 1, 1);
        System.out.println("Vektor je " + v);
        double distance = VectorTools.calculateDistance(v.getX(), v.getY(), v.getZ());
        System.out.println("Vzdálenost je " + distance);

        System.out.println();
        
        Vector v1 = new Vector(2, 3, 4);
        System.out.println("Vektor1 je " + v1);
        Vector v2 = new Vector(5.7, 8.6, 1.5);
        System.out.println("Vektor2 je " + v2);
        double dotProduct = VectorTools.calculateDotProduct(v1, v2);
        System.out.println("Skalární součin je " + dotProduct);
    }
}