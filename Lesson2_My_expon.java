import java.util.Scanner;

public class Lesson2_My_expon{
    public static void main(String[] args) { 
        Scanner in = new Scanner(System.in);  
        
        double sum  = 0.0;
        double xx = 1.0;
        System.out.print("Input x: ");
        double x = in.nextDouble();
        
        for (int i = 1; sum != sum + xx; i++) {
            sum  = sum + xx;
            xx = xx * x / i;
        }
        System.out.print(sum);
        System.out.print("\n");
        System.out.print(Math.exp(x));
   }
}