import java.util.Scanner;

public class Pr2 {
    public static void main(String[] args){
        int x;

        System.out.println("Введіть число: ");

        Scanner scan = new Scanner(System.in);
        x = scan.nextInt();

        for ( int i=2; i < x; i++) {
            if ( x%i == 0) {
                System.out.println("Це число не натуральне");
                return;
            }
        }

        System.out.println("Факторіал рекурсивно: " + factorial_rec(x));
        System.out.println("Факторіал циклом: " + factorial_loop(x));
    }

    static int factorial_rec(int x){
        if (x == 0)
            return 1;
        else
            return(x * factorial_rec(x-1));
    }

    static int factorial_loop(int x){
        int fact = 1;

        for(int i = 1; i <= x; i++)
        {
            fact = fact * i;
        }

        return fact;
    }
}