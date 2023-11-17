package semestralProject;

public class Polynomial {

    private final int degree;
    private final int[] coefficients;

    /**
     * parametricky konstruktor
     *
     * @param deg stupen polynomu
     * @param coeffs koeficienty ulozene do pole
     */
    public Polynomial(int deg, int[] coeffs) {
        degree = deg;
        coefficients = coeffs;
    }

    /**
     * secte aktualni polynom s polynomem predanym v parametru
     *
     * @param other druhy polynom
     * @return vysledny polynom
     */
    public Polynomial addPolynomials(Polynomial other) {
        int resultDegree = Math.max(degree, other.degree);
        int[] resultCoefficients = new int[resultDegree + 1];

        // scitani jednotlivych koeficientu
        for (int i = 0; i <= degree; i++) {
            resultCoefficients[i] += coefficients[i];
        }

        for (int i = 0; i <= other.degree; i++) {
            resultCoefficients[i] += other.coefficients[i];
        }

        return new Polynomial(resultDegree, resultCoefficients);
    }

    /**
     * vynasobi aktualni polynom s polynomem predanym v parametru
     *
     * @param other druhy polynom
     * @return vysledny polynom
     */
    public Polynomial multiplyPolynomials(Polynomial other) {
        int resultDegree = this.degree + other.degree;
        int[] resultCoefficients = new int[resultDegree + 1];
        
        // jako pri rucnim nasobeni mnohoclenu - kazdy s kazdym
        for (int i = 0; i <= degree; i++) {
            for (int j = 0; j <= other.degree; j++) {
                resultCoefficients[i + j] += coefficients[i] * other.coefficients[j];
            }
        }

        return new Polynomial(resultDegree, resultCoefficients);
    }

    /**
     * metoda pro vypis polynomu
     *
     * @return formatovany polynom
     */
    @Override // prepisuje puvodni metodu v predkovi
    public String toString() {
        StringBuilder sb = new StringBuilder(); // rychlejsi a efektivnejsi pri opakovane konkatenaci
        int coeff;
        int absCoeff;
        for (int i = degree; i >= 0; i--) { // jedeme od nejvyssiho stupne po nejmensi
            coeff = coefficients[i];
            if (coeff != 0) { // nulove cleny nebudeme vypisovat
                if (sb.length() > 0) { // pokud uz je do builderu neco pridano
                    if (coeff > 0) {
                        sb.append(" + ");
                    } else {
                        sb.append(" - ");
                    }
                } else if (coeff < 0) { // plati pro PRVNI clen, ktery je zaporny
                    sb.append("-"); 
                }
                absCoeff = Math.abs(coeff);
                // odstraneni potizi se znamenky (napr x + -5) atd.
                if ((absCoeff != 1 || i == 0) && absCoeff >= 0) {
                    sb.append(absCoeff);
                }
                if (i > 0) {
                    if (i == 1) { // aby se nevypisovalo 1x
                        sb.append("x");
                    } else {
                        sb.append("x^").append(i);
                    }
                }
            }
        }
        return sb.toString();
    }
}