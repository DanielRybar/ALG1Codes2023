package zkouska;

public class Posloupnosti {

    public static void main(String[] args) {
        double[] a = {1.3, 1.5, 1.7, 1.9, 2.1};
        double[] b = {1, 2, 3, 4, 5, 6};

        double[] vysledna = new double[a.length + b.length];

        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                vysledna[k++] = a[i++];
            } else {
                vysledna[k++] = b[j++];
            }
        }

        // paklize neco zbylo
        while (i < a.length) {
            vysledna[k++] = a[i++];
        }
        while (j < b.length) {
            vysledna[k++] = b[j++];
        }

        for (double prvek : vysledna) {
            System.out.print(prvek + " ");
        }
    }
}