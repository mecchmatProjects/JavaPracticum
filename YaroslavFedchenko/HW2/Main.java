package HW2;

import java.util.Scanner;
// task 4.6(г) Fedchenko Yaroslav Маємо дійсні числа . Обчислити з точністю нескінченну суму і
//вказати кількість врахованих доданків.
public class Main {
    static int fact(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    static double[] sum(double x, double e) {
        double sum = x / 6;
        double el;
        double counter = 1.0;

        for (int k = 1; ; k++) {
            el = (Math.pow(-1, k) * Math.pow(x, 2 * k + 1)) / (fact(k) * fact(2 * k + 1));
            System.out.printf("sum = %f \n", el);
            if (Math.abs(el) < e) {
                break;
            }
            sum += el;
            counter += 1;
        }

        double[] ans = new double[2];
        ans[0] = sum;
        ans[1] = counter;
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("E:");
        double e = in.nextDouble();

        System.out.println("x:");
        double x = in.nextDouble();

        double[] res = sum(x, e);
        double sum = res[0];
        double counter = res[1];

        System.out.printf("sum = %f \n", sum);
        System.out.printf("counter = %f \n", counter);
    }
}