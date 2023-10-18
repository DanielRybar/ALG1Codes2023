package assignments04_homeworks;

public class U33aSquare {
    public static void main(String[] args) {
        /*
         Zapište program, který načte celé číslo N a program vypíše „čtverec z ’*’ “ velikosti N (případně obdélník velikosti 
            NxM), ve tvaru (pro N = 3):
            * * *
            * * *
            * * *
        */
        
        int N = 5;
        /*
        String row = "";
        for(int i = 0; i < N; i++) {
            row += "* ";
        }
        for(int i = 0; i < N; i++) {
            System.out.println(row);
        }
        */
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print("* ");
            }
            System.out.println(" ");
        } 
    }  
}