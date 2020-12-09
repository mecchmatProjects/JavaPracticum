package com.company;

import java.util.Scanner;

public class Task4_2 {
    public Task4_2() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int summ = 0;

        for(int i = 0; i > -1; ++i) {
            System.out.print("a[" + i + "]= ");
            int n = input.nextInt();
            if (n == 0) {
                break;
            }

            summ += n;
        }

        System.out.print("Summ = " + summ);
        input.close();
    }
}