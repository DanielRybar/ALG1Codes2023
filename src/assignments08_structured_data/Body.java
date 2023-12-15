package assignments08_structured_data;

public class Body {

    public static void main(String[] args) {
        // OBVOD
        // pomoci linearniho pole
        int[] x = {4, 5, 8, 12, -8, -10};
        int[] y = {1, 7, 10, -8, 0, 30};
        double obvod = 0;
        for (int i = 0; i < x.length - 1; i++) {
            obvod += Math.hypot(x[i + 1] - x[i], y[i + 1] - y[i]);
        }
        obvod += Math.hypot(x[0] - x[x.length - 1], y[0] - y[y.length - 1]);
        System.out.println("Obvod: " + obvod);

        // pomoci 2d pole
        int[][] poleBodu = {{4, 1}, {5, 7}, {8, 10}, {12, -8}, {-8, 0}, {-10, 30}};
        obvod = 0;
        for (int i = 0; i < poleBodu.length - 1; i++) {
            obvod += Math.hypot(poleBodu[i][0] - poleBodu[i + 1][0], poleBodu[i][1] - poleBodu[i + 1][1]);
        }
        obvod += Math.hypot(poleBodu[0][0] - poleBodu[poleBodu.length - 1][0], poleBodu[0][1] - poleBodu[poleBodu.length - 1][1]);
        System.out.println("Obvod: " + obvod);

        // OBSAH
        double obsah = 0;
        for (int i = 0; i < x.length - 1; i++) {
            obsah += x[i] * y[i + 1] - x[i + 1] * y[i];
        }
        obsah += x[x.length - 1] * y[0] - x[0] * y[y.length - 1];
        obsah = 0.5 * Math.abs(obsah);
        System.out.println("Obsah: " + obsah);

        // NEJVETSI VZDALENOST 2 BODU
        double max = Double.MIN_VALUE;
        double vzdalenost;
        for (int i = 0; i < x.length - 1; i++) {
            vzdalenost = Math.hypot(x[i + 1] - x[i], y[i + 1] - y[i]);
            if (vzdalenost > max) {
                max = vzdalenost;
            }
        }
        vzdalenost = Math.hypot(x[0] - x[x.length - 1], y[0] - y[y.length - 1]);
        if (vzdalenost > max) {
            max = vzdalenost;
        }
        System.out.println("Nejvetsi vzdalenost: " + max);
    }
}