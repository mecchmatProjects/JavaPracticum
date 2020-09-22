package Classwork1;
import java.util.Scanner;
//num 1.2
public class Task2 {
    public static void main(String[] args) {
        int a, b;
        int ln_str;
        int ln_log;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input first number: ");
        a = scanner.nextInt();
        System.out.println("Input second number: ");
        b = scanner.nextInt();
        ln_str = String.valueOf(Math.abs(a)).length();
        if (b == 0) {
            ln_log = 1;
        }
        else {
            ln_log = (int) Math.ceil(Math.log10(Math.abs(b) + 0.5));
        }
        double harmonic = 2 / (1.0/a + 1.0/b);
        System.out.println("Logarithm for number "+ a+": " +ln_log);
        System.out.println("String for number "+ b+": "+ ln_str);
        System.out.println("Harmonic: "+ harmonic);
    }
}
