package assignments05_code_breakdown;

public final class VectorTools {

    /*
     Vytvořte knihovní třídu VectorTools pro manipulaci s 3D vektory – s metodami pro délku vektoru, skalární 
        součin, úhel, test rovnoběžnosti, test kolmosti dvou vektorů, délku vektorového součinu (tj. délku vektoru, který 
        je výsledkem vektorového součinu dvou vektorů). Kód metod/testů zapište bez použití logického příkazu. Při 
        testování nezapomeňte na nepřesné zobrazení reálných čísel.. Metodám doplňte dokumentační komentáře. 
        Vytvořte program, kterým otestujete implementované metody.
     */
    private VectorTools() {
    }

    /**
     * vypocita delku 3D vektoru
     *
     * @param x souradnice x vstupniho vektoru
     * @param y souradnice y vstupniho vektoru
     * @param z souradnice z vstupniho vektoru
     * @return delka vektoru (double)
     */
    public static double calculateDistance(double x, double y, double z) {
        double distance = Math.sqrt(x * x + y * y + z * z);
        return distance;
    }

    /**
     * vypocita skalarni soucin 3D vektoru
     * 
     * @param v1 prvni vektor
     * @param v2 druhy vektor
     * @return skalarni soucin vektoru
     */
    public static double calculateDotProduct(Vector v1, Vector v2) {
        return v1.getX() * v2.getX() + v1.getY() * v2.getY() + v1.getZ() * v2.getZ();
    }
}