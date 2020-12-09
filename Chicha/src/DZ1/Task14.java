/*
    Чича Олександр

    Завдання 1.4
    Ввести дійсне число градусів Цельсія C (на екрані повинна бути підказка, що
    ввести) та обчислити й вивести число F в дійсному форматі – та сама температура в
    градусах Фаренгейта за формулою F=9*C/5+32. Результат вивести в окремому
    рядку вигляду «F=*** », де замість зірок предствлення в найкоротшому вигляді з
    можливих.
*/

package DZ1;

import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input degrees in C : ");

        double degreesInC = in.nextDouble();
        double degreesInF = (9 * degreesInC)/5 + 32;

        System.out.printf("F = %.2f", degreesInF);
    }
}

