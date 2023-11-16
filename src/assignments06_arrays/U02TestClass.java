package assignments06_arrays;

public class U02TestClass {

    public static void main(String[] args) {
        int[] pole = {15, -7, 2, 9, 44, -9, 15, 5, 1};

        int sum = U02ArrayTools.sumOfValues(pole);
        int product = U02ArrayTools.productOfValues(pole);
        int max = U02ArrayTools.findMaxValue(pole);
        int min = U02ArrayTools.findMinValue(pole);
        int occur = U02ArrayTools.findOccurrences(pole, 15);

        U02ArrayTools.printArray(pole);
        U02ArrayTools.printNiceArray(pole);
        
        U02ArrayTools.bubbleSort(pole);
        System.out.println("Seřadíme pole");
        U02ArrayTools.printNiceArray(pole);

        System.out.println("Součet: " + sum);
        System.out.println("Součin: " + product);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Výskyt čísla 15: " + occur);

        int[] revPole = U02ArrayTools.reverseValues(pole);
        U02ArrayTools.printArray(revPole);

        int[] nahodPole = U02ArrayTools.generateArray(100, 50, 150);
        U02ArrayTools.printNiceArray(nahodPole);
    }
}