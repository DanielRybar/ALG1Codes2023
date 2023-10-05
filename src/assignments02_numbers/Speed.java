package assignments02_numbers;

import java.util.Scanner;

public class Speed {

    public static void main(String[] args) {
        /*
        Zapište program pro výpočet úsekové rychlosti vozidla (průměrné rychlosti vozidla ve sledovaném úseku). 
        Vypisujte jak dosaženou průměrnou rychlost, tak i o kolik byla překročena maximální povolená rychlost v daném 
        úseku. Vstupem budou: maximální povolená rychlost v daném úseku, délka úseku a časové údaje (hh mm sec 
        set) průjezdu vozidla začátkem a koncem sledovaného úseku.
        
         S využitím ternárního operátoru doplňte předchozí program o výpis výše pokuty za překročení povolené rychlosti 
            (uvažujte například, že se jedná o měření úsekové rychlosti v obci)
        */
        
        Scanner sc = new Scanner(System.in);
        
        // 30
        System.out.print("Zadejte maximální povolenou rychlost (v km/h): ");
        double maxSpeedLimit = sc.nextDouble(); // km/h
        
        // 100
        System.out.print("Zadejte délku úseku (v metrech): ");
        double length = sc.nextDouble(); // m
                
        System.out.println("Nyní zadejte 4 po sobě následující hodnoty (čas průjezdu ZAČÁTKEM úseku) - hh mm sec set: ");
        // 14:30:25
        int hoursIn = sc.nextInt();
        int minutesIn = sc.nextInt();
        int secondsIn = sc.nextInt();
        int msIn = sc.nextInt();
        
        System.out.println("Nyní zadejte 4 po sobě následující hodnoty (čas průjezdu KONCEM úseku) - hh mm sec set: ");
        // 14:30:57
        int hoursOut = sc.nextInt();
        int minutesOut = sc.nextInt();
        int secondsOut = sc.nextInt();
        int msOut = sc.nextInt();
        
        double timeIn = convertToSec(hoursIn, minutesIn, secondsIn, msIn); // seconds
        double timeOut = convertToSec(hoursOut, minutesOut, secondsOut, msOut); // seconds
        
        double time = timeOut - timeIn;
        System.out.format("Čas strávený v úseku (sekundy): %.2f\n", time);
        
        // v = s * t
        double speed = (length / time) * 3.6; // km/h
        System.out.format("Rychlost (km/h): %.2f\n", speed);
   
        boolean wasExceeded = (speed > maxSpeedLimit);
        if (wasExceeded) {
            double exceeding = speed - maxSpeedLimit;
            System.out.println("Rychlost byla překročena o " + exceeding + " km/h");
            int penalty = (exceeding <= 19 ? 1000 : (exceeding <= 39 ? 2500 : Integer.MAX_VALUE));
            System.out.println("Pokuta je: " + penalty + " Kč.");
        }
        else {
           System.out.println("Rychlost nebyla překročena.");
        }  
    }
    
    // podprogram pro převod na sekundy
    public static double convertToSec(int hours, int minutes, int secs, int ms) {
        return hours * 3600 + minutes * 60 + secs + (double)ms / 1000;
    }  
}