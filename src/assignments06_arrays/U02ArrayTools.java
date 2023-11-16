package assignments06_arrays;

import java.util.Random;

public final class U02ArrayTools {

    private final static Random rand = new Random();

    private U02ArrayTools() {
    }

    /**
     * vypisuje zadane pole
     *
     * @param arr pole cisel
     */
    public static void printArray(int[] arr) {
        System.out.println("Vypisuji pole");
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    /**
     * vypisuje pole hezcim zpusobem - s hranatymi zavorkami
     *
     * @param arr pole
     */
    public static void printNiceArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1]);
        System.out.println("]");
    }

    /**
     * vraci soucet hodnot v poli
     *
     * @param arr pole cisel
     * @return soucet hodnot
     */
    public static int sumOfValues(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * vraci soucin hodnot v poli
     *
     * @param arr pole cisel
     * @return soucin hodnot
     */
    public static int productOfValues(int[] arr) {
        int product = 1; // nula by byla v soucinu agresivni
        for (int i = 0; i < arr.length; i++) {
            product *= arr[i];
        }
        return product;
    }

    /**
     * vraci nejvetsi hodnotu prvku v poli
     *
     * @param arr pole cisel
     * @return nejvetsi hodnota v poli
     */
    public static int findMaxValue(int[] arr) {
        int max = arr[0]; // prip. Integer.MIN_VALUE, pak prochazet od 0
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * vraci nejmensi hodnotu prvku v poli
     *
     * @param arr pole cisel
     * @return nejmensi hodnota v poli
     */
    public static int findMinValue(int[] arr) {
        int min = arr[0]; // prip. Integer.MIN_VALUE, pak prochazet od 0
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    /**
     * vraci pocet vyskytu daneho prvku
     *
     * @param arr pole cisel
     * @param num cislo, pro ktere chci spocitat vyskyt
     * @return pocet vyskytu
     */
    public static int findOccurrences(int[] arr, int num) {
        int occ = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                occ++;
            }
        }
        return occ;
    }

    /**
     * obraci poradi prvku v poli
     *
     * @param arr pole cisel
     * @return obracene pole
     */
    public static int[] reverseValues(int[] arr) {
        int[] revArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            revArr[i] = arr[arr.length - i - 1];
        }
        return revArr;
    }

    /**
     * generuje pole zadane delky s nahodnymi hodnotami v danem rozsahu
     *
     * @param length delka pole
     * @param min minimum pro nahodne cislo
     * @param max maximum pro nahodne cislo
     * @return pole cisel
     */
    public static int[] generateArray(int length, int min, int max) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(max - min + 1) + min;
        }
        return arr;
    }

    /**
     * metoda pro bublinkove razeni pole
     *
     * @param arr pole cisel
     */
    public static void bubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * zjistuje, zda je pole prazdne
     *
     * @param arr pole cisel
     * @return pravda/nepravda, jestli je prazdne
     */
    public static boolean isArrayEmpty(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}