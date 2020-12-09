/*
    Чича Олександр
    Завдання 5.3

    Напишить програму LongestRun.java що вводить цілі числа та виводить
    число яке зустрічається підряд наібільше разів та скільки саме разів (якщо
    таких чисел декілька виводиться найбільше з чисел). Приклад: 1 2 2 1 5 1 1 7
    7 7 7 1 1, виведення Longest run: 4 consecutive 7s.
*/

package DZ3;

import java.util.Scanner;

public class Task53 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int prev = in.nextInt();
        int count = 1;
        int best = prev;
        int bestCount = count;

        while (in.hasNextInt()) {
            int current = in.nextInt();

            if (current == prev) count++;
            else {
                prev = current;
                count = 1;
            }

            if ((count > bestCount)||((count == bestCount)&&(current > best))) {
                bestCount = count;
                best = current;
            }
        }

        System.out.format("Longest run: %d consecutive %ds", bestCount, best);

    }
}
