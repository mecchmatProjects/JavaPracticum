package com.company;

import java.util.Scanner;

public class task_1 {
    public static int toDecimal(String base2) {
        char[] chars = base2.toCharArray();
        int result = 0;
        int mult = 1;
        for (int i = base2.length()-1; i >= 0; i--) {
            if (chars[i]=='1') {
                result += mult;
            }
            mult*=2;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputer = sc.nextInt();
        String bin_str = Integer.toBinaryString(inputer);
        System.out.println(bin_str);
        String res = bin_str.substring(1, bin_str.length()) + bin_str.substring(0,1);
        System.out.println(res);
        System.out.println(toDecimal(res));
    }
}
