/*
    Чича Олександр

    Завдання 3.3
    Ввести число от 1 до 12 та число від 1 до 31 та число від 2000 до 2100.
    Перевірити, що це коректна дата та коректний ввод. Вивести цю дату з назвою
    місяця українською.
*/

package DZ2;

import java.util.Scanner;

public class Task33 {
    static boolean checkData(int DD,int MM,int YY){
        boolean correct = true;

        if (DD <1 || MM < 1 || MM > 12)
            correct = false;
        else if (MM==2 && DD > 28)
            correct = false;
        else if ((MM==1 || MM==3 || MM==5 || MM == 7 || MM==8 || MM==10 || MM==12)&&(DD > 31))
            correct = false;
        else if ((MM==4 || MM==6 || MM==9 || MM==11) && DD > 30)
            correct = false;

        return correct;
    }

    static String getMonthStr(int MM){
        String[] seasons  = new String[]{"Січня", "Лютого", "Березня", "Квітня",
                                        "Травня", "Червня", "Липня", "Серпня",
                                        "Вересня", "Жовтня", "Листопада", "Грудня"};
        return seasons[MM-1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input month: ");
        while (!in.hasNextInt()) {
            System.out.println("That not a number!");
            in.next(); // this is important!
        }
        int month = in.nextInt();

        System.out.println("Input day: ");
        while (!in.hasNextInt()) {
            System.out.println("That not a number!");
            in.next(); // this is important!
        }
        int day = in.nextInt();

        System.out.println("Input year: ");
        while (!in.hasNextInt()) {
            System.out.println("That not a number!");
            in.next(); // this is important!
        }
        int year = in.nextInt();

        if (checkData(day, month, year))
            System.out.format("%d " + getMonthStr(month) + " %d", day, year);
        else
            System.out.println("Incorrect data");

    }
}
