/*
    Домашня робота №2. Цикли та функції
    Завдання 4.6в

    Обчислити з точністю нескінченну суму і вказати кількість врахованих доданків.
    x^(2k)/2^(k)k!
*/

package Homework2;

import java.util.Scanner;

public class Task1 {
    static int calculateFactorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    static double calculateSum(double x, double e) {
        double sum = x / 2;
        double el;

        for (int k = 1; ; k++) {
            el = Math.pow(x, 2 * k) / (Math.pow(2, k) * calculateFactorial(k));
            if (el < e) {
                break;
            }
            sum += el;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input E:");
        double e = in.nextDouble();

        System.out.println("Input x:");
        double x = in.nextDouble();

        double sum = calculateSum(x, e);

        System.out.printf("Sum=%f", sum);
    }
}
