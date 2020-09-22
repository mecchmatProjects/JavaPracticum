package Classwork1;
import java.util.Scanner;
//num 3.2
public class Task6 {
    public static boolean checker(double y) {
        if (y > 0) {
            double x1 = Math.sqrt(y);
            double x2 = x1 * (-1);
            System.out.println(x1 + " and " + x2 + " are roots");
            return true;
        } else if (y == 0) {
            System.out.println("0 is root");
            return true;
        } else {
            return false;
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("a*x^4+b*x^2+c=0");
        System.out.print("Input a= ");
        double a = sc.nextDouble();
        System.out.print("Input b= ");
        double b = sc.nextDouble();
        System.out.print("Input c= ");
        double c = sc.nextDouble();
        double D = b * b - 4 * a * c;
        
        if (D > 0) {
            double y1 = (-b + Math.sqrt(D)) / (2 * a);
            double y2 = (-b - Math.sqrt(D)) / (2 * a);
            if (!checker(y1) && !checker(y2)) {
                System.out.println("Equation has not roots");
            }
        } else if (D == 0) {
            double y = -b / (2 * a);
            if (!checker(y)) {
                System.out.println("Equation has not roots");
            }
        } else {
            System.out.println("Equation has not roots");
        }
    }
}

