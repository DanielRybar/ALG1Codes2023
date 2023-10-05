package assignments01_introduction;

public class ToSeconds {

    public static void main(String[] args) {
        int hours = 2;
        int minutes = 48;
        int seconds = 34;
        
        int result = hours * 3600 + minutes * 60 + seconds;
        System.out.println(hours + "h " 
                + minutes + "min " 
                + seconds + "s je celkem "
                + result + "s.");
    }
}
