/*
    6) Інверсія рядка A - це рядок B, записаний тими ж символами у зворотньому порядку.
     Інверсія порожнього рядка за означенням – порожній рядок. Побудувати інверсію рядка.
 */

package Homework8;

import java.util.Scanner;

public class Task1 {
    public static String reverse(String str) {
        String rightPart;
        String leftPart;

        int length = str.length();

        if (length <= 1) {
            return str;
        }

        leftPart = str.substring(0, length / 2);

        rightPart = str.substring(length / 2, length);

        return reverse(rightPart) + reverse(leftPart);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        System.out.println(reverse(str));
    }
}
