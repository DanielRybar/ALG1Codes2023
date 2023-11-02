package assignments03_homework;

public class U34StarTriangle01 {

    public static void main(String[] args) {
       int N = 8;
       for (int i = 1; i <= N; i++) {
           for (int j = 1; j <= i; j++) {
               System.out.print("* ");
           }
           System.out.println();
       }
    }
}