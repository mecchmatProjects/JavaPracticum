package com.company;

import java.util.Scanner;

public class Task3_3 {
    public Task3_3() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] monthdays = new String[]{"Січень", "Лютий", "Березень", "Квітень", "Травень", "Червень", "Липень", "Серпень", "Вересень", "Жовтень", "Листопад", "Грудень"};
        System.out.println("Введіть дату у числовому форматі");
        System.out.print("Введіть місяць: ");
        int mo = input.nextInt();
        System.out.print("Введіть день: ");
        int day = input.nextInt();
        System.out.print("Введіть рік: ");
        int year = input.nextInt();
        if (1 <= mo & mo <= 12 & 1 <= day & day <= 31 & 2000 <= year & year <= 2100) {
            System.out.print(day + "." + monthdays[mo - 1] + "." + year);
        } else {
            System.out.print("Error date");
        }

        input.close();
    }
}