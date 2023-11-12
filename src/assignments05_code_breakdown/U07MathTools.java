package assignments05_code_breakdown;

public final class U07MathTools {

    private U07MathTools() {
    }

    /**
     * podprogram pro vypocet funkce sin(x)
     *
     * @param x argument funkce sin
     * @param eps pozadovana presnost (pri jejim prekroceni je podprogram
     * ukoncen)
     * @return hodnota sin(x)
     */
    public static double sin(double x, double eps) {
        double sinX = 0;
        double term = x;
        double fact = 1;
        int n = 1;
        int sign = 1;

        while (Math.abs(term) >= eps) {
            sinX += term;
            n += 2;
            sign *= -1;
            fact *= (n - 1) * n; // faktorial je vypocitan iterativne pro kazdy novy clen
            term = sign * Math.pow(x, n) / fact;
        }
        return sinX;
    }

    /**
     * podprogram pro vypocet prirozeneho logaritmu z x
     *
     * @param x argument funkce ln()
     * @param eps pozadovana presnost (pri jejim prekroceni je podprogram
     * ukoncen)
     * @return ln(x)
     */
    public static double ln(double x, double eps) {
        if (x <= 0) {
            return Double.NaN;
        }
        double term = (x - 1) / (x + 1);
        double lnX = 2 * term;
        double power = term * term;

        for (int i = 3; Math.abs(term) >= eps; i += 2) {
            lnX += (2.0 / i) * term;
            term *= power;
        }
        return lnX;
    }

    /**
     * podprogram vraci hodnotu PI s urcitou presnosti
     *
     * @param eps presnost
     * @return PI
     */
    public static double getPi(double eps) {
        double pi = 0;
        double term = 1.0;
        int sign = 1;
        int n = 1;

        while (Math.abs(term) >= eps) {
            pi += sign * term;
            n += 2;
            sign *= -1;
            term = 1.0 / n;
        }
        return 4 * pi;
    }
}