package com.company;

import java.util.Scanner;

public class Task2_1 {
    public Task2_1() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte n = input.nextByte();
        byte m = input.nextByte();
        int result = n ^ 1 << m;
        System.out.println(result);
        input.close();
    }
}