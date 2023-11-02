package assignments02_numbers;

public class U04BirthNumber {

    public static void main(String[] args) {
        /*
         Zapište program, který pro zadané rodné číslo určí datum narození příslušné osoby (rok narození určete pouze 
            jako poslední dvojčíslí letopočtu).
        */
        
        String bn = "040114/3534";
        String[] parts = bn.split("/");
        
        String birthYear = parts[0].substring(0,2);
        String birthMonth = parts[0].substring(2, 4);
        String birthDay = parts[0].substring(4, 6);
        
        int birthMonthInt = Integer.parseInt(birthMonth);
        Gender gender = Gender.Male;
        if (birthMonthInt > 12) {
            birthMonthInt -= 50;
            gender = Gender.Female;
        }
        
        System.out.println("Datum narození: " + String.join(".", birthDay, Integer.toString(birthMonthInt), birthYear));
        System.out.println("Jste " + (gender == Gender.Male ? "muž" : "žena"));
    }
    
    public enum Gender {
        Male,
        Female,
        Other
    }
}
