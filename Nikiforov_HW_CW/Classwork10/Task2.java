package Classwork10;

import java.util.Scanner;
import java.util.Stack;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        String str = Integer.toString(n);
        Stack<Integer> number = new Stack<>();
        for (int i = 0; i < str.length(); i++){
            number.add(str.charAt(i) - '0');
        }

        while (!number.isEmpty()){
            System.out.print(number.pop());
        }

    }
}
