package prack;

import java.util.Scanner;
import java.util.Stack;

public class Pr2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String number = in.nextLine();

        Stack<Character> dStack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            dStack.push(number.charAt(i));
        }
        while (!dStack.isEmpty()) {
            System.out.print(dStack.pop());
        }
    }
}
