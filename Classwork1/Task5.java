package Classwork1;
import java.util.InputMismatchException;
import java.util.Scanner;
//num 2.7
public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input first long value: ");
        long n = sc.nextLong();
        System.out.print("Input second long value: ");
        long m = sc.nextLong();
        try {
            long answerD = n - m;
            long answerS = n + m;
            System.out.println("Difference= " + answerD);
            System.out.println("Sum= " + answerS);
        }catch (InputMismatchException e){
            assert true;
        }

    }
}
