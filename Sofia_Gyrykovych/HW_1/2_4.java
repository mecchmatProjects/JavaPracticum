
package com.company;

import java.util.Scanner;

public class Task2_4 {
    public Task2_4() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte n = input.nextByte();
        byte i = input.nextByte();
        int mask = (1 << i) - 1;
        int result = (n & ~mask << 1) >>> 1 | n & mask;
        System.out.println(result);
        input.close();
    }
}