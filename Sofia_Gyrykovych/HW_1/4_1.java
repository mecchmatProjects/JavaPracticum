package com.company;

import java.io.PrintStream;
import java.util.Scanner;

public class Task4_1 {
    public Task4_1() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int fact = 1;
        System.out.print("Input natural number: ");
        int nat = input.nextInt();
        if (nat == nat & nat >= 1) {
            for(int i = 1; i <= nat; ++i) {
                fact *= i;
            }

            System.out.println("Cycle factorial = " + fact);
            Factorial f = new Factorial();
            PrintStream var10000 = System.out;
            int var10001 = f.fact(nat);
            var10000.print("Recursive factorial = " + var10001);
        } else {
            System.out.println("Not Natural");
        }

        input.close();
    }
}