import java.util.Scanner;

public class Pr4 {
    public static void main(String[] args){
        double x=100.0;

        Scanner scan = new Scanner(System.in);

        while (x > 20 || x < -20){
            System.out.println("Введіть число -20<x<20: ");
            x = scan.nextDouble();
        }

        System.out.println("Результат бібліотечним методом: " + Math.exp(x) + "\nРезультат через функцію: " + ex(x));

    }

    static double ex(double x){
        double sx = 0, a=1.0;
        long i = 1;
        while (sx != sx + a){
            sx+= a;
            a = a*x/i;
            i++;
        }
        return sx;
    }
}
