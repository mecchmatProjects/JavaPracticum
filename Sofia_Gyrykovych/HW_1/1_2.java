package com.company;

import java.io.PrintStream;
import java.util.Scanner;

public class Task1_2 {
    public Task1_2() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i1 = input.nextInt();
        int i2 = input.nextInt();
        System.out.println("Разраяд числа " + i1 + " = " + Math.ceil(Math.log10((double)i1)));
        System.out.println("Разраяд числа " + i2 + " = " + Math.ceil(Math.log10((double)i2)));
        double i_sr = 2.0D / (1.0D / (double)i1 + 1.0D / (double)i2);
        PrintStream var10000 = System.out;
        Object[] var10002 = new Object[]{i_sr};
        var10000.println("Среднее гармоническое = " + String.format("%.2f", var10002));
        input.close();
    }
}