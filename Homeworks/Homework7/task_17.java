package Homework7;

import java.util.Scanner;

public class task_17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A;
        char s, c;
        System.out.println("Input line: ");
        A = scanner.nextLine().strip();
        System.out.println("Input s and c: ");
        char[] params = scanner.nextLine().toCharArray();
        s = params[0];
        c = params[2];

        char[] res = A.toCharArray();
        for (int i = 0; i < A.length(); i++) {
            if (res[i] == s && i != res.length-1){
                res[i+1] = c;
            }
        }

        System.out.println(res);
    }
}
